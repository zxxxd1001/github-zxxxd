package com.git.zxxxd.handler;

import com.git.zxxxd.modle.CommonResult;
import org.springframework.core.MethodParameter;
import org.springframework.core.ReactiveAdapterRegistry;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.codec.HttpMessageWriter;
import org.springframework.web.reactive.HandlerResult;
import org.springframework.web.reactive.accept.RequestedContentTypeResolver;
import org.springframework.web.reactive.result.method.annotation.ResponseBodyResultHandler;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class GlobalResponseBodyResultHandler extends ResponseBodyResultHandler {

    public GlobalResponseBodyResultHandler(List<HttpMessageWriter<?>> writers, RequestedContentTypeResolver resolver) {
        super(writers, resolver);
    }

    public GlobalResponseBodyResultHandler(List<HttpMessageWriter<?>> writers, RequestedContentTypeResolver resolver, ReactiveAdapterRegistry registry) {
        super(writers, resolver, registry);
    }

    static {
        try {
            // 获得 METHOD_PARAMETER_MONO_COMMON_RESULT 。其中 -1 表示 `#methodForParams()` 方法的返回值
            METHOD_PARAMETER_MONO_COMMON_RESULT = new MethodParameter(GlobalResponseBodyResultHandler.class.getDeclaredMethod("methodForParams"), -1);
        } catch (NoSuchMethodException e) {
            System.out.println("[static][获取 METHOD_PARAMETER_MONO_COMMON_RESULT 时，找不都方法");
            throw new RuntimeException(e);
        }
    }

    private static MethodParameter METHOD_PARAMETER_MONO_COMMON_RESULT;

    private static final CommonResult COMMON_RESULT_SUCCESS = CommonResult.success(null);

    @Override
    @SuppressWarnings("unchecked")
    public Mono handleResult(ServerWebExchange exchange, HandlerResult result) {
        Object returnValue = result.getReturnValue();
        Object body;
        //   处理返回结果为 Mono 的情况
        if (returnValue instanceof Mono) {
            body = ((Mono) result.getReturnValue())
                    .map(GlobalResponseBodyResultHandler::wrapCommonResult)
                    .defaultIfEmpty(COMMON_RESULT_SUCCESS);
            //   处理返回结果为 Flux 的情况
        } else if (returnValue instanceof Flux) {
            body = ((Flux) result.getReturnValue())
                    .collectList()
                    .map(GlobalResponseBodyResultHandler::wrapCommonResult)
                    .defaultIfEmpty(COMMON_RESULT_SUCCESS);
            //   处理结果为其它类型
        } else {
            body = wrapCommonResult(returnValue);
        }
        HttpHeaders headers = exchange.getResponse().getHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return writeBody(body, METHOD_PARAMETER_MONO_COMMON_RESULT, exchange);
    }

    private static Mono methodForParams() {
        return null;
    }

    private static CommonResult wrapCommonResult(Object body) {
        // 如果已经是 CommonResult 类型，则直接返回
        if (body instanceof CommonResult) {
            return (CommonResult) body;
        }
        // 如果不是，则包装成 CommonResult 类型
        return CommonResult.success(body);
    }

}
