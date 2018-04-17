package com.hm.cosmeticmarket.providers;

import com.google.inject.ImplementedBy;
import com.hm.cosmeticmarket.providers.impl.S3ProviderImpl;
import play.mvc.Http;

/**
 * AWS S3 provider.
 */
@ImplementedBy(S3ProviderImpl.class)
public interface S3Provider {

    String uploadFile(Http.MultipartFormData.FilePart<Object> image);
}
