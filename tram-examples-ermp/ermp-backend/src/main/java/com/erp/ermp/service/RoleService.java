package com.erp.ermp.service;

import com.erp.ermp.domain.CreateRoleRequest;
import com.erp.ermp.domain.Role;
import com.erp.ermp.domain.RoleRespository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleRespository roleRespository;

    public Role create(CreateRoleRequest cRoleRequest) {
        Role role = new Role(cRoleRequest.getCode(), cRoleRequest.getName());
        role = roleRespository.save(role);

        return role;
    }

	public Role updateName(Long roleId, String roleName) {
        Role role = roleRespository.findOne(roleId);
        if(role != null ) {
            role.setName(roleName);
            role = roleRespository.save(role);
        }

        return role;
	}
}