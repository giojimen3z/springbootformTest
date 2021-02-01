package com.springboot.study.app.springbootform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormController {

  @GetMapping("/form")
  public String form(Model model) {

    return "form";
  }

  @PostMapping("/form")
  public String procesar(Model model) {

    return "resultado";
  }
}
