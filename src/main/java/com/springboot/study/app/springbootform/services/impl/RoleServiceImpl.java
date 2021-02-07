package com.springboot.study.app.springbootform.services.impl;

import com.springboot.study.app.springbootform.models.domain.Role;
import com.springboot.study.app.springbootform.services.IRoleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

  private List<Role> roles;

  public RoleServiceImpl() {
    this.roles = new ArrayList<>();
    this.roles.add(new Role(1, "Administrador", "ROLE_ADMIN"));
    this.roles.add(new Role(2, "Usuario", "ROLE_USER"));
    this.roles.add(new Role(3, "Moderador", "ROLE_MODERATOR"));
  }

  @Override
  public List<Role> listar() {
    return roles;
  }

  @Override
  public Role obtenerPorId(Integer id) {
    Role resultado = null;
    for (Role role : roles) {
      if (id == role.getId()) {
        resultado = role;
        break;
      }
    }
    return resultado;
  }
}