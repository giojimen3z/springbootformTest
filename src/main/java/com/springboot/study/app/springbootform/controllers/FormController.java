package com.springboot.study.app.springbootform.controllers;

import com.springboot.study.app.springbootform.editors.NombreMayusculaEditor;
import com.springboot.study.app.springbootform.editors.PaisPropertyEditors;
import com.springboot.study.app.springbootform.editors.RolesEditor;
import com.springboot.study.app.springbootform.models.domain.Pais;
import com.springboot.study.app.springbootform.models.domain.Role;
import com.springboot.study.app.springbootform.models.domain.Usuario;
import com.springboot.study.app.springbootform.services.IPaisService;
import com.springboot.study.app.springbootform.services.IRoleService;
import com.springboot.study.app.springbootform.validations.UsuarioValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.naming.Binding;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@SessionAttributes("usuario")
public class FormController {

  @Autowired private UsuarioValidador validador;

  @Autowired private IPaisService paisService;
  @Autowired private PaisPropertyEditors paisEditor;

  @Autowired private IRoleService roleService;
  @Autowired private RolesEditor roleEditor;

  @InitBinder
  public void initBinder(WebDataBinder binder) {
    binder.addValidators(validador);
    SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
    dateformat.setLenient(false);
    binder.registerCustomEditor(
        Date.class, "fechaNacimiento", new CustomDateEditor(dateformat, false));
    binder.registerCustomEditor(String.class, "nombre", new NombreMayusculaEditor());
    binder.registerCustomEditor(String.class, "apellido", new NombreMayusculaEditor());
    binder.registerCustomEditor(Pais.class, "pais", paisEditor);
    binder.registerCustomEditor(Role.class, "roles", roleEditor);
  }

  @PostMapping("/form")
  public String procesar(@Valid Usuario usuario, BindingResult result, Model model) {

    if (result.hasErrors()) {
      model.addAttribute("titulo", "Resultado del form");
      return "form";
    }

    return "redirect:/ver";
  }

  @GetMapping("/ver")
  public String ver(
      @SessionAttribute(name = "usuario", required = false) Usuario usuario,
      Model model,
      SessionStatus status) {

    if (usuario == null) {

      return "redirect:/form";
    }
    model.addAttribute("titulo", "Resultado del form");

    status.setComplete();
    return "resultado";
  }

  @GetMapping("/form")
  public String form(Model model) {
    model.addAttribute("titulo", "Formulario usuario");
    Usuario usuario = new Usuario();
    usuario.setNombre("gio");
    usuario.setApellido("perez");
    usuario.setId("12.123.123-G");
    usuario.setHabilitar(true);
    usuario.setValorSecreto("algun valor secreto ****");
    usuario.setPais(new Pais(1, "COL", "Colombia"));
    usuario.setRoles(Arrays.asList(new Role(2, "Usuario", "ROLE_USER")));
    model.addAttribute("usuario", usuario);
    return "form";
  }

  @ModelAttribute("paises")
  public List<String> paises() {

    return Arrays.asList("España", "Colombia", "Chile", "Mexico", "Peru", "Argentina");
  }

  @ModelAttribute("paisesMap")
  public Map<String, String> paisesMap() {
    Map<String, String> paises = new HashMap<String, String>();
    paises.put("COL", "Colombia");
    paises.put("Es", "España");
    paises.put("MX", "Mexico");
    paises.put("AR", "Argentina");
    paises.put("CL", "Chile");
    paises.put("PR", "Peru");
    return paises;
  }

  @ModelAttribute("listaPaises")
  public List<Pais> listaPaises() {

    return paisService.listar();
  }

  @ModelAttribute("listadoRolesString")
  public List<String> listadoRolesString() {
    List<String> roles = new ArrayList<String>();
    roles.add("ROLE_ADMIN");
    roles.add("ROLE_USER");
    roles.add("ROLE_MODERATOR");
    return roles;
  }

  @ModelAttribute("rolesMap")
  public Map<String, String> rolesMap() {
    Map<String, String> roles = new HashMap<String, String>();
    roles.put("ROLE_ADMIN", "Administrador");
    roles.put("ROLE_USER", "Usuario");
    roles.put("ROLE_MODERATOR", "Moderador");
    return roles;
  }

  @ModelAttribute("listaRoles")
  public List<Role> listaRoles() {

    return roleService.listar();
  }

  @ModelAttribute("genero")
  public List<String> genero() {

    return Arrays.asList("Hombre", "Mujer");
  }
}
