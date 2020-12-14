package com.git.zxxxd.controller;

import com.git.zxxxd.entity.Demo;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "/hello", description = "Operations about hello")
public class HelloController {
    //option的value的内容是这个method的描述，notes是详细描述，response是最终返回的json model。其他可以忽略

    /**
     * ApiImplicitParams
     * name：参数名，对应方法中单独的参数名称。
     * value：参数中文说明。
     * required：是否必填。
     * paramType：参数类型，取值为 path、query、body、header、form。
     * dataType：参数数据类型。
     * defaultValue：默认值。
     */
    @ApiImplicitParams({@ApiImplicitParam(
            name = "swagger",
            value = "获取swagger页面地址",
            required = true,
            paramType = "query",
            dataType = "Demo",
            defaultValue = "1"
    )})
    @RequestMapping(value = "/swagger",
            produces = {"application/xml", "application/json"},
            consumes = {"application/json", "application/xml"},
            method = RequestMethod.POST)
    public String index(@ApiParam(value = "Pet object that needs to be added to the store", required = true)
                        @RequestBody Demo d) {
        /**
         * http://localhost:8080/swagger-ui.html
         * 如果项目是一个webservice，通常设定home / 指向这里：
         */
        System.out.println("swagger-ui.html");
        return "redirect:swagger-ui.html";
    }

    @ApiOperation(value = "Add a new pet to the store", notes = "详细描述", response = String.class,
            authorizations = {@Authorization(value = "petstore_auth", scopes = {
                    @AuthorizationScope(scope = "write:pets", description = "write "),
                    @AuthorizationScope(scope = "read:pets", description = "read ")
            })}, tags = {"hello"})
    //这里是显示你可能返回的http状态，以及原因。比如404 not found, 303 see other
    @ApiResponses(value = {@ApiResponse(code = 405, message = "Invalid input", response = String.class)})
    @GetMapping("/hello")
    public String hello() {
        return "hello,swagger!";
    }

}
