package com.springboot.study.app.springbootform.editors;

import com.springboot.study.app.springbootform.services.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import java.beans.PropertyEditorSupport;

@Component
public class RolesEditor extends PropertyEditorSupport {

  @Autowired private IRoleService service;

  @Override
  public void setAsText(String idString) throws IllegalArgumentException {
    try {
      Integer id = Integer.parseInt(idString);
      setValue(service.obtenerPorId(id));
    } catch (NumberFormatException e) {
      setValue(null);
    }
  }
}
