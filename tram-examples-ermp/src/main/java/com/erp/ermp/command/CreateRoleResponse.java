package com.erp.ermp.command;

public class CreateRoleResponse {
    private Long id;

    public CreateRoleResponse() {}

    public CreateRoleResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}