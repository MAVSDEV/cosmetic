package com.hm.cosmeticmarket.controllers;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.List;


/**
 * Created by c5231481 on 3/29/18.
 */
public class Main {

    private static final String SUFFIX = "/";

    public static void main(String[] args) {


//        AWSCredentials credentials = new BasicAWSCredentials("AKIAJ3EJET7YPGN22TOQ", "b3Am8wVyUvmcLnl3KbIZyQTCCOPHot97QXKYV3SC");
//        ClientConfiguration clientConfig = new ClientConfiguration();
//        clientConfig.setProtocol(Protocol.HTTP);
//        AmazonS3 conn = new AmazonS3Client(credentials, clientConfig);
//        conn.setEndpoint("/s3/buckets/cosmeticmarket/");
//        Bucket bucket = conn.createBucket("example-bucket");
//        ObjectListing objects = conn.listObjects(bucket.getName());
//        do {
//            for (S3ObjectSummary objectSummary : objects.getObjectSummaries()) {
//                System.out.println(objectSummary.getKey() + "\t" +
//                        objectSummary.getSize() + "\t" +
//                        StringUtils.fromDate(objectSummary.getLastModified()));
//            }
//            objects = conn.listNextBatchOfObjects(objects);
//        } while (objects.isTruncated());




        // credentials object identifying user for authentication
        // user must have AWSConnector and AmazonS3FullAccess for
        // this example to work
        AWSCredentials credentials = new BasicAWSCredentials(
                "AKIAJ3EJET7YPGN22TOQ",
                "b3Am8wVyUvmcLnl3KbIZyQTCCOPHot97QXKYV3SC");


        // create a client connection based on credentials
        AmazonS3 s3client = new AmazonS3Client(credentials);
        s3client.setEndpoint("http://127.0.0.1:63899");
//
//        // create bucket - name must be unique for all S3 users
        String bucketName = "example-bucket";
        s3client.createBucket(bucketName);
//
//        // list buckets
        for (Bucket bucket : s3client.listBuckets()) {
            System.out.println(" - " + bucket.getName());
        }
//
//        // create folder into bucket
        String folderName = "testfolder";
        createFolder(bucketName, folderName, s3client);
//
//        // upload file to folder and set it to public
        String fileName = folderName + SUFFIX + "testvideo.mp4";
        s3client.putObject(new PutObjectRequest(bucketName, fileName,
                new File("/images/products/default-store-350x350.jpg"))
                .withCannedAcl(CannedAccessControlList.PublicRead));

        deleteFolder(bucketName, folderName, s3client);
//
//        // deletes bucket
        s3client.deleteBucket(bucketName);
    }

    public static void createFolder(String bucketName, String folderName, AmazonS3 client) {
        // create meta-data for your folder and set content-length to 0
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(0);
        // create empty content
        InputStream emptyContent = new ByteArrayInputStream(new byte[0]);
        // create a PutObjectRequest passing the folder name suffixed by /
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,
                folderName + SUFFIX, emptyContent, metadata);
        // send request to S3 to create folder
        client.putObject(putObjectRequest);
    }
    /**
     * This method first deletes all the files in given folder and than the
     * folder itself
     */
    public static void deleteFolder(String bucketName, String folderName, AmazonS3 client) {
        List<S3ObjectSummary> fileList =
                client.listObjects(bucketName, folderName).getObjectSummaries();
        for (S3ObjectSummary file : fileList) {
            client.deleteObject(bucketName, file.getKey());
        }
        client.deleteObject(bucketName, folderName);
    }
}
