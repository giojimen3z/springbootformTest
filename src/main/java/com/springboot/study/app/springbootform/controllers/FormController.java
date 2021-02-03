package com.springboot.study.app.springbootform.controllers;

import com.springboot.study.app.springbootform.models.domain.Usuario;
import com.springboot.study.app.springbootform.validations.UsuarioValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes("usuario")
public class FormController {

  @Autowired private UsuarioValidador validador;

  @GetMapping("/form")
  public String form(Model model) {
    model.addAttribute("titulo", "Formulario usuario");
    Usuario usuario = new Usuario();
    usuario.setNombre("gio");
    usuario.setApellido("perez");
    usuario.setId("1234564654k");
    model.addAttribute("usuario", usuario);
    return "form";
  }

  @PostMapping("/form")
  public String procesar(
      @Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {
    validador.validate(usuario, result);
    model.addAttribute("titulo", "Resultado del form");
    if (result.hasErrors()) {
      return "form";
    }
    model.addAttribute("usuario", usuario);
    status.setComplete();
    return "resultado";
  }
}
