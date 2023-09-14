package com.git.zxxxd.spi.impl;

import com.git.zxxxd.spi.UploadCDN;

public class QiyiCDN implements UploadCDN {
    @Override
    public void upload(String url) {
        //上传爱奇艺cdn
        System.out.println("upload to qiyi cdn");
    }
}
