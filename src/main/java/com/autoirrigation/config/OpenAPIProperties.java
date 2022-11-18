package com.autoirrigation.config;

import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

//@RefreshScope
@Component
public class OpenAPIProperties {

    @Value("${openapi.server}")
    private String url;

    public String getUrl() {
        return url;
    }
}
