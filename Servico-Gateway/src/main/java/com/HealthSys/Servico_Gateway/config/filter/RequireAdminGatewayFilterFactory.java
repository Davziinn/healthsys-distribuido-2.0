package com.HealthSys.Servico_Gateway.config.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class RequireAdminGatewayFilterFactory extends AbstractGatewayFilterFactory<RequireAdminGatewayFilterFactory.Config> {

    public RequireAdminGatewayFilterFactory () {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            String roles = exchange.getRequest().getHeaders().getFirst("X-User-Roles");

            boolean isAdmin = roles != null && Arrays.stream(roles.split(","))
                    .map(String::trim)
                    .anyMatch("ADM"::equals);

            if (!isAdmin) {
                exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
                return exchange.getResponse().setComplete();
            }

            return chain.filter(exchange);
        };
    }

    public static class Config {}
}
