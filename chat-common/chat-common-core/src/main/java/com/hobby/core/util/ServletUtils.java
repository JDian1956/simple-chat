package com.hobby.core.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hobby.core.enums.HttpStatusEnums;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Mono;

/**
 * @author Harris
 */
public class ServletUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static Mono<Void> webFluxResponse(ServerHttpResponse response, HttpStatusEnums httpStatusEnums) {
        return webFluxResponse(response, HttpStatus.OK, httpStatusEnums.getCode(), httpStatusEnums.getMsg());
    }

    public static Mono<Void> webFluxResponse(ServerHttpResponse response, String msg) {
        return webFluxResponse(response, HttpStatus.OK, HttpStatusEnums.OTHERS_ERROR.getCode(), msg);
    }

    public static Mono<Void> webFluxResponse(ServerHttpResponse response, HttpStatusEnums httpStatusEnums, String msg) {
        return webFluxResponse(response, HttpStatus.OK, httpStatusEnums.getCode(), msg);
    }

    public static Mono<Void> webFluxResponse(ServerHttpResponse response, int code, String msg) {
        return webFluxResponse(response, HttpStatus.OK, code, msg);
    }

    public static Mono<Void> webFluxResponse(ServerHttpResponse response, HttpStatus status, int code, String msg) {
        response.setStatusCode(status);
        response.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        ResponseResult<Object> result = ResponseResult.error(code, msg);
        try {
            byte[] bytes = OBJECT_MAPPER.writeValueAsBytes(result);
            DataBuffer buffer = response.bufferFactory().wrap(bytes);
            return response.writeWith(Mono.just(buffer));

        } catch (JsonProcessingException e) {
            byte[] fallback = "Internal Server Error".getBytes();
            DataBuffer buffer = response.bufferFactory().wrap(fallback);
            return response.writeWith(Mono.just(buffer));
        }
    }
}
