package com.hobby.gateway.handler;

import com.hobby.core.enums.HttpStatusEnums;
import com.hobby.core.util.ServletUtils;
import org.slf4j.Logger;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author Harris
 *
 * 网关统一异常处理
 */
@Order(-1)
@Configuration
public class GatewayExceptionHandler implements ErrorWebExceptionHandler {
    private final Logger logger = org.slf4j.LoggerFactory.getLogger(GatewayExceptionHandler.class);

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        ServerHttpResponse response = exchange.getResponse();
        if (response.isCommitted()) {
            return Mono.error(ex);
        }

        logger.error("[网关异常处理]请求路径:{},异常信息:{}", exchange.getRequest().getPath(), ex.getMessage());

        if (ex instanceof NotFoundException) {
            return ServletUtils.webFluxResponse(response, HttpStatusEnums.NOT_FOUND);
        } else if (ex instanceof ResponseStatusException) {
            return ServletUtils.webFluxResponse(response, ex.getMessage());
        } else {
            return ServletUtils.webFluxResponse(response, HttpStatusEnums.SERVER_ERROR);
        }
    }
}
