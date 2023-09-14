package com.git.zxxxd.spi.impl;

import com.git.zxxxd.spi.UploadCDN;

public class ChinaNetCDN implements UploadCDN {
    @Override
    public void upload(String url) {
        //上传网宿cdn
        System.out.println("upload to chinaNet cdn");
    }
}
