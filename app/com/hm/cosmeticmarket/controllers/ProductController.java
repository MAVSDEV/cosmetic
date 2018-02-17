package com.hm.cosmeticmarket.controllers;


import com.hm.cosmeticmarket.controllers.parsers.ProductBodyParser;
import com.hm.cosmeticmarket.models.Product;
import com.hm.cosmeticmarket.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import play.mvc.BodyParser;
import play.mvc.Http.*;
import play.mvc.Result;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.File;
import java.io.IOException;

/**
 * Product Controller.
 */
@Slf4j
@Singleton
public class ProductController extends AbstractController<Product> {

    private static final String DEFAULT_PRODUCT_IMAGE = "default-store-350x350.jpg";
    private static final String PRODUCT_IMAGE_PATH = "/assets/images/products/";
    private static final String STORAGE_OF_PRODUCT_IMAGES = "/app/public/images/products";

    private static final String IMAGE_FILE_NAME = "image";

    private final ProductService productService;

    @Inject
    public ProductController(ProductService productService) {
        super(productService, Product.class);
        this.productService = productService;
    }

    @BodyParser.Of(ProductBodyParser.class)
    public Result save() {
        Product product = request().body().as(Product.class);
        product.setMainImage(PRODUCT_IMAGE_PATH + DEFAULT_PRODUCT_IMAGE);
        return super.save(product);
    }

    @BodyParser.Of(ProductBodyParser.class)
    public Result update() {
        return super.update();
    }

    public Result updateImage(String id) {
        log.warn("Start upload image!");
        MultipartFormData.FilePart<Object> image = request().body().asMultipartFormData().getFile(IMAGE_FILE_NAME);
        if (image != null) {
            String imageName = image.getFilename();
            try {
                FileUtils.moveFile((File) image.getFile(), new File(STORAGE_OF_PRODUCT_IMAGES, imageName));
                log.warn("Image " + image.getFilename() + " for product id: " + id + " was saved!");

                Product product = productService.getById(id);
                product.setMainImage(PRODUCT_IMAGE_PATH + imageName);
                productService.update(product);

                return ok("Image " + imageName + " was updated!");
            } catch (IOException e) {
                log.error("Image " + image.getFilename() + " for product id: " + id + " wasn't stored on file system!", e);
            }
        } else {
            flash("error", "Missing file!");
        }
        return internalServerError("Image wasn't uploaded by some reason!");
    }
}
