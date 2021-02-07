package com.springboot.study.app.springbootform.models.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pais {

  private Integer id;
  private String codigo;
  private String nombre;

  @Override
  public String toString() {
    return this.id.toString();
  }
}
