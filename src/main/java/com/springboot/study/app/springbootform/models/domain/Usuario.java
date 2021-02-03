package com.springboot.study.app.springbootform.models.domain;

import com.springboot.study.app.springbootform.utils.anotations.IdentificadorRegex;
import com.springboot.study.app.springbootform.utils.anotations.Requerido;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

@Getter
@Setter
public class Usuario {

  @IdentificadorRegex private String id;

  private String nombre;

  @Requerido private String apellido;

  @NotBlank
  @Size(min = 3, max = 8)
  private String username;

  @NotEmpty private String password;

  @Email() @NotEmpty private String email;

  @NotNull
  @Min(5)
  @Max(5000)
  private Integer cuenta;

  @NotNull
  @Future
  private Date fechaNacimiento;
}
