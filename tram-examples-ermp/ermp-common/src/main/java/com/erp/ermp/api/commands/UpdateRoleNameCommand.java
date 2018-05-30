package com.erp.ermp.api.commands;

import io.eventuate.Command;

public class UpdateRoleNameCommand implements Command {

    private Long roleId;
    private String roleName;

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

	public Long getRoleId() {
		return roleId;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

	public String getRoleName() {
		return roleName;
	}
    
}