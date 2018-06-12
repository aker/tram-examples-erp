package com.erp.apigateway.ermp;


import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "ermp.destinations")
public class ErmpDestinations {

    @NotNull
    private String serviceUrl;

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String url) {
        this.serviceUrl = url;
    }
}