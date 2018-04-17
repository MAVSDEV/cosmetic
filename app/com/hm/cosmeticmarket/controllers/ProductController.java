package com.hm.cosmeticmarket.controllers;


import com.hm.cosmeticmarket.controllers.parsers.ProductBodyParser;
import com.hm.cosmeticmarket.models.Product;
import com.hm.cosmeticmarket.models.sql.FilterType;
import com.hm.cosmeticmarket.models.sql.OrderType;
import com.hm.cosmeticmarket.models.sql.SortType;
import com.hm.cosmeticmarket.providers.S3Provider;
import com.hm.cosmeticmarket.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.*;

import static com.hm.cosmeticmarket.utils.CommonUtils.getOrDefault;

/**
 * Product Controller.
 */
@Slf4j
@Singleton
public class ProductController extends AbstractController<Product> {

//    private static final String PAGE_PARAM = "page";
    private static final String FILTER_PARAM = "filter";
    private static final String SORT_PARAM = "sort";
    private static final String SEARCH_TERM_QUERY_PARAM = "term";

    private static final String IMAGE_FILE_ATTR = "imageFile";

    private static final String DEFAULT_PRODUCT_IMAGE_URL = "https://s3.amazonaws.com/cosmeticmarket/default-store-350x350.jpg";

    private final ProductService productService;
    private final S3Provider s3Provider;

    @Inject
    public ProductController(ProductService productService, S3Provider s3Provider) {
        super(productService, Product.class);
        this.productService = productService;
        this.s3Provider = s3Provider;
    }

    public Result search() {
        String searchTerm = getOrDefault(request().getQueryString(SEARCH_TERM_QUERY_PARAM), "");
        SortType sortType = parseSortName(request().getQueryString(SORT_PARAM));
        OrderType sortOrder = parseSortOrder(request().getQueryString(SORT_PARAM));
        Map<String, String> filterMap = buildFilterMap(request().getQueryString(FILTER_PARAM));

        List<Product> products = productService.search(searchTerm, sortType, sortOrder, filterMap);
        return ok(Json.toJson(products));
    }

    @BodyParser.Of(ProductBodyParser.class)
    public Result save() {
        Product product = request().body().as(Product.class);
        product.setMainImage(DEFAULT_PRODUCT_IMAGE_URL);
        product.setCreationDate(new Date());
        product.setUrl(product.getName().replace(" ", "-"));
        Product savedProduct = productService.getByParamName("url", product.getUrl());

        if (savedProduct != null) {
            productService.update(savedProduct);
        } else {
            log.warn("------ product to save: == " + product);
            productService.save(product);
        }
        savedProduct = productService.getByParamName("url", product.getUrl());
        return ok(Json.toJson(savedProduct));
    }

    @BodyParser.Of(BodyParser.AnyContent.class)
    public Result updateImage(String id) {
        Http.MultipartFormData.FilePart<Object> image = request().body().asMultipartFormData().getFile(IMAGE_FILE_ATTR);
        if (image != null) {
            String imageUrl = s3Provider.uploadFile(image);
            log.warn("----image url before saving: " + imageUrl);

            Product product = productService.getById(id);
            if (product != null && imageUrl != null) {
                product.setMainImage(imageUrl);
                productService.update(product);
                return ok("Image " + imageUrl + " was updated!");
            }
        } else {
            flash("error", "Missing file!");
        }
        return internalServerError("Image wasn't uploaded by some reason!");
    }

    @BodyParser.Of(ProductBodyParser.class)
    public Result update() {
        return super.update();
    }

    /**
     * Parses sort name from query parameter
     */
    private SortType parseSortName(String sortParameter) {
        SortType sortType;

        if (sortParameter != null) {
            sortType = SortType.getByName(sortParameter.substring(0, sortParameter.indexOf('[')));
        } else {
            sortType = SortType.NEWEST;
        }

        return sortType;
    }

    /**
     * Parses sort order from query parameter
     */
    private OrderType parseSortOrder(String sortParameter) {
        if (sortParameter != null) {
            OrderType sortOrder;
            try {
                sortOrder = OrderType.valueOf(
                        sortParameter.substring(sortParameter.indexOf('[') + 1, sortParameter.length() - 1).toUpperCase()
                );
            } catch (IllegalArgumentException e) {
                sortOrder = OrderType.DESC;
                log.debug(String.format("Can't parse \'%s\' to SortOrder", sortParameter), e);
            }
            return sortOrder;
        }
        return OrderType.DESC;
    }

    /**
     * Builds filter map from query parameter
     */
    private Map<String, String> buildFilterMap(String filterParameter) {
        Map<String, String> result = new HashMap<>();
        if (filterParameter != null) {
            Arrays.asList(filterParameter.split("~"))
                    .forEach(filter -> {
                        String filterValue = filter.substring(filter.indexOf('[') + 1, filter.length() - 1).trim();
                        if (!filterValue.isEmpty()) {
                            Optional<FilterType> filterTypeOptional = FilterType.getByName(filter.substring(0, filter.indexOf('[')));
                            filterTypeOptional.ifPresent(filterType -> result.put(
                                    filterType.getName(),
                                    filterValue
                            ));
                        }
                    });
        }
        return result;
    }
}
