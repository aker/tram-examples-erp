package com.erp.ermp.common;

import io.eventuate.tram.events.common.DomainEvent;

public class RoleCreated implements DomainEvent {
    private String code;
    private String name;

    public RoleCreated() {}

    public RoleCreated(String code, String name) {
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