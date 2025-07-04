package com.hobby.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.InetSocketAddress;

/**
 * @author Harris
 */
@Slf4j
@Order(Integer.MIN_VALUE)
@Component
public class AccessLogGlobalFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("[网关日志]请求路径:{},请求参数:{}", exchange.getRequest().getPath(), exchange.getRequest().getQueryParams());
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getPath().pathWithinApplication().value();
        InetSocketAddress remoteAddress = request.getRemoteAddress();

        return chain.filter(exchange)
                .then(Mono.fromRunnable(() -> {
                            ServerHttpResponse response = exchange.getResponse();
                            HttpStatusCode statusCode = response.getStatusCode();
                            log.info("[网关日志]请求路径:{},远程IP地址:{},响应状态码:{}", path, remoteAddress, statusCode);
                        }
                ));
    }
}
