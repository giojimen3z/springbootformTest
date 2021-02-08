package com.springboot.study.app.springbootform.services.impl;

import com.springboot.study.app.springbootform.models.domain.Pais;
import com.springboot.study.app.springbootform.services.IPaisService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PaisServiceImpl implements IPaisService {

  private List<Pais> lista;

  public PaisServiceImpl() {

    this.lista =
        Arrays.asList(
            new Pais(1, "COL", "Colombia"),
            new Pais(2, "ES", "España"),
            new Pais(3, "MX", "Mexico"),
            new Pais(4, "AR", "Argentina"),
            new Pais(5, "CL", "Chile"),
            new Pais(6, "PR", "Peru"));
  }

  @Override
  public List<Pais> listar() {
    return lista;
  }

  @Override
  public Pais obtenerPorId(Integer id) {
    Pais resultado = null;
    for (Pais pais : this.lista) {

      if (id == pais.getId()) {
        resultado = pais;
        break;
      }
    }
    return resultado;
  }
}
