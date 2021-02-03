package com.springboot.study.app.springbootform.models.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class Usuario {

  private String id;

  private String nombre;

  @NotEmpty private String apellido;

  @NotEmpty
  @Size(min = 3, max = 8)
  private String username;

  @NotEmpty private String password;

  @Email() @NotEmpty private String email;
}
