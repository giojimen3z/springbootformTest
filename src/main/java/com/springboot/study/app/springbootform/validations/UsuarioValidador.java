package com.springboot.study.app.springbootform.validations;

import com.springboot.study.app.springbootform.models.domain.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UsuarioValidador implements Validator {

  @Override
  public boolean supports(Class<?> clazz) {
    return Usuario.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "requerido.usuario.nombre");
  }
}
