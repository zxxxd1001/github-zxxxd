package com.git.zxxxd.rest.controller;

import com.git.zxxxd.rest.service.WechatTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1")
public class WechatTemplateController {

    @Autowired
    private WechatTemplateService wechatTemplateService;

    @RequestMapping(value = "/report")
    public String dataReported() {
        wechatTemplateService.templateReported();
        return "success";
    }

}
