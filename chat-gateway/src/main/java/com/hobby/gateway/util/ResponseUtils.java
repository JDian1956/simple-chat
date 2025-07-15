package com.hobby.gateway.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hobby.core.enums.HttpStatusEnums;
import com.hobby.core.util.ResponseResult;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Mono;

/**
 * @author Harris
 */
public class ResponseUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Mono<Void> webFluxResponse(ServerHttpResponse response, HttpStatusEnums httpStatusEnums) {
        return webFluxResponse(response, HttpStatus.OK, httpStatusEnums.getMsg(), httpStatusEnums.getCode());
    }

    public static Mono<Void> webFluxResponse(ServerHttpResponse response, String msg) {
        return webFluxResponse(response, HttpStatus.OK, msg, HttpStatusEnums.OTHERS_ERROR.getCode());
    }

    public static Mono<Void> webFluxResponse(ServerHttpResponse response, String msg, HttpStatusEnums httpStatusEnums) {
        return webFluxResponse(response, HttpStatus.OK, msg, httpStatusEnums.getCode());
    }

    public static Mono<Void> webFluxResponse(ServerHttpResponse response, HttpStatus status, String msg, int code) {
        response.setStatusCode(status);
        response.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        ResponseResult<Object> result = ResponseResult.error(code, msg);
        try {
            byte[] bytes = objectMapper.writeValueAsBytes(result);
            DataBuffer buffer = response.bufferFactory().wrap(bytes);
            return response.writeWith(Mono.just(buffer));

        } catch (JsonProcessingException e) {
            byte[] fallback = "Internal Server Error".getBytes();
            DataBuffer buffer = response.bufferFactory().wrap(fallback);
            return response.writeWith(Mono.just(buffer));
        }
    }
}
