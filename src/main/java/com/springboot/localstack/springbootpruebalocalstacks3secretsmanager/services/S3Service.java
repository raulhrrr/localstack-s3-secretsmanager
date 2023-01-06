package com.springboot.localstack.springbootpruebalocalstacks3secretsmanager.services;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class S3Service {

    private static final String BUCKET_NAME = "jrxml-java-jasperreport";
    private static final String IMAGE_PATH = "C:\\Users\\raulh\\Localstack\\springboot-prueba-localstack-s3-secretsmanager\\src\\main\\resources\\images\\dog.jpg";


    private final AmazonS3 amazonS3;

    public Boolean addObject() {

        File image = new File(IMAGE_PATH);
        amazonS3.putObject(BUCKET_NAME, Paths.get(IMAGE_PATH).getFileName().toString(), image);

        return true;
    }

    public void listObjects() {

        ListObjectsV2Result result = amazonS3.listObjectsV2(BUCKET_NAME);
        List<S3ObjectSummary> objects = result.getObjectSummaries();
        for (S3ObjectSummary os : objects) {
            System.out.println("* " + os.getKey());
        }

    }

}
