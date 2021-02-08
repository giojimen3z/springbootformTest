package com.springboot.study.app.springbootform.validations;

import com.springboot.study.app.springbootform.utils.anotations.IdentificadorRegex;
import com.springboot.study.app.springbootform.utils.anotations.Requerido;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RequeridoValidador implements ConstraintValidator<Requerido, String> {
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {

    if (value == null || value.isEmpty() || !StringUtils.hasText(value)) {

      return false;
    }

    return true;
  }
}
