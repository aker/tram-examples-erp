package com.erp.ermp.domain;

public class CreateRoleRequest {
    private String code;
    private String name;

    public CreateRoleRequest() {

    }

    public CreateRoleRequest(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}