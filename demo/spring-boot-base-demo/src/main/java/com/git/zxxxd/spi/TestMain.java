package com.git.zxxxd.spi;

import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.ServiceLoader;

public class TestMain {
    public static void main(String[] args) {
        ServiceLoader<UploadCDN> uploadCDN = ServiceLoader.load(UploadCDN.class);
        for (UploadCDN u : uploadCDN) {
            u.upload("filePath");
        }
    }
}
