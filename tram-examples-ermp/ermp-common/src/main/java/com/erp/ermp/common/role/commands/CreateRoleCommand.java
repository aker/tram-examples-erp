package com.erp.ermp.common.role.commands;

import java.io.Serializable;

import io.eventuate.tram.commands.common.Command;

public class CreateRoleCommand implements Command, Serializable {
    
    private static final long serialVersionUID = -5984748706140748574L;
	private String code;
    private String name;

    public CreateRoleCommand() {

    }
    
    public CreateRoleCommand(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}