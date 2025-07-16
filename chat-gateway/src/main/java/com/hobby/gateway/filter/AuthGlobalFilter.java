package com.hobby.gateway.filter;

import com.hobby.core.enums.HttpStatusEnums;
import com.hobby.core.util.StringUtils;
import com.hobby.core.util.ServletUtils;
import com.hobby.security.constants.SecurityConstants;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author Harris
 */
@Order(Integer.MIN_VALUE)
@Component
public class AuthGlobalFilter implements GlobalFilter {
    private static final List<String> IGNORE_WHITE = List.of("/test", "/others/auth");

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String realPath = request.getPath().pathWithinApplication().value();
        if (StringUtils.matchesUrl(realPath, IGNORE_WHITE)) {
            return chain.filter(exchange);
        }
        String token = getToken(request);
        if (StringUtils.isBlank(token)) {
            //return unauthorized(exchange, "令牌不能为空");
        }

        return chain.filter(exchange);
    }

    private String getToken(ServerHttpRequest request) {
        HttpHeaders headers = request.getHeaders();
        String token = headers.getFirst(SecurityConstants.AUTHORIZATION);
        if (StringUtils.isNotEmpty(token) && token.startsWith(SecurityConstants.BEARER)) {
            token = token.replaceFirst(SecurityConstants.BEARER, StringUtils.EMPTY);
        }
        return token;
    }

    private Mono<Void> unauthorized(ServerWebExchange exchange, String msg) {
        return ServletUtils.webFluxResponse(exchange.getResponse(), HttpStatusEnums.UNAUTHORIZED, msg);
    }
}
