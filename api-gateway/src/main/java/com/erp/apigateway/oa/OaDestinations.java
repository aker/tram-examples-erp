package com.erp.apigateway.oa;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "oa.destinations")
public class OaDestinations {

    @NotNull
    private String serviceUrl;

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String url) {
        this.serviceUrl = url;
    }
}