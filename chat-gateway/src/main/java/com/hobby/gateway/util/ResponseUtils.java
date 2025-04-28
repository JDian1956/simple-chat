package com.hobby.gateway.util;

import com.hobby.core.enums.HttpStatusEnums;
import com.hobby.core.pojo.ResponseResult;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Mono;

/**
 * @author Harris
 */
public class ResponseUtils {

    public static Mono<Void> webFluxResponse(ServerHttpResponse response, HttpStatusEnums httpStatusEnums) {
        return webFluxResponse(response, HttpStatus.OK, httpStatusEnums.getMsg(), httpStatusEnums.getCode());
    }

    public static Mono<Void> webFluxResponse(ServerHttpResponse response, String msg) {
        return webFluxResponse(response, HttpStatus.OK, msg, HttpStatusEnums.OTHERS_ERROR.getCode());
    }

    public static Mono<Void> webFluxResponse(ServerHttpResponse response, String msg, int code) {
        return webFluxResponse(response, HttpStatus.OK, msg, code);
    }

    public static Mono<Void> webFluxResponse(ServerHttpResponse response, HttpStatus status, String msg, int code) {
        response.setStatusCode(status);
        response.getHeaders().add(HttpHeaders.CONTENT_TYPE, "application/json;charset=UTF-8");
        ResponseResult<Object> result = ResponseResult.error(code, msg);
        DataBuffer buffer = response.bufferFactory().wrap(result.toString().getBytes());
        return response.writeWith(Mono.just(buffer));
    }
}
