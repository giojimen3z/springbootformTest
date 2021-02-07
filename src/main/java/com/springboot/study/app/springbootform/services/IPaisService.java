package com.springboot.study.app.springbootform.services;

import com.springboot.study.app.springbootform.models.domain.Pais;

import java.util.List;

public interface IPaisService {

  public List<Pais> listar();

  public Pais obtenerPorId(Integer id);
}
