package com.hm.cosmeticmarket.providers.impl;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.google.inject.Singleton;
import com.hm.cosmeticmarket.providers.S3Provider;
import lombok.extern.slf4j.Slf4j;
import play.mvc.Http;

import java.io.File;

/**
 * Implementation of {@link S3Provider}
 */
@Slf4j
@Singleton
public class S3ProviderImpl implements S3Provider {

    private static final String BUCKET_NAME = "cosmeticmarket";
    private static final String BASE_IMAGE_URL = "https://s3.amazonaws.com/" + BUCKET_NAME + "/";

    @Override
    public String uploadFile(Http.MultipartFormData.FilePart<Object> image) {
        AWSCredentials credentials = new BasicAWSCredentials(
                "AKIAJ3EJET7YPGN22TOQ",
                "b3Am8wVyUvmcLnl3KbIZyQTCCOPHot97QXKYV3SC");


        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_1)
                .disableChunkedEncoding()
                .build();

        s3client.putObject(new PutObjectRequest(BUCKET_NAME, image.getFilename(), (File) image.getFile()));
        String imageUrl = BASE_IMAGE_URL + image.getFilename();
        log.warn("---Image saved!!! "  + imageUrl);
        return imageUrl;
    }
}
