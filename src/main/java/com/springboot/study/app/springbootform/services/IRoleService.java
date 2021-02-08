package com.springboot.study.app.springbootform.services;

import com.springboot.study.app.springbootform.models.domain.Role;

import java.util.List;

public interface IRoleService {

  public List<Role> listar();

  public Role obtenerPorId(Integer id);
}
