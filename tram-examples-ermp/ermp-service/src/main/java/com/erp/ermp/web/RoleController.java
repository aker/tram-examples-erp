package com.erp.ermp.web;

import com.erp.ermp.domain.CreateRoleRequest;
import com.erp.ermp.domain.CreateRoleResponse;
import com.erp.ermp.domain.Role;
import com.erp.ermp.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(method = RequestMethod.POST)
    public CreateRoleResponse create(@RequestBody CreateRoleRequest createRoleRequest) {
        Role role = roleService.create(createRoleRequest);
        return new CreateRoleResponse(role.getId());
    }

}