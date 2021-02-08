package com.springboot.study.app.springbootform.editors;

import com.springboot.study.app.springbootform.services.IPaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class PaisPropertyEditors extends PropertyEditorSupport {

  @Autowired private IPaisService service;

  @Override
  public void setAsText(String idString) throws IllegalArgumentException {

    try {
      Integer id = Integer.parseInt(idString);
      this.setValue(service.obtenerPorId(id));
    } catch (NumberFormatException e) {
      setValue(null);
    }
  }
}
