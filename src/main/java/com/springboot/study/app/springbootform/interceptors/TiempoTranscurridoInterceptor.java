package com.springboot.study.app.springbootform.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;
import java.util.logging.Handler;

@Component("tiempoTranscurridoInterceptor")
public class TiempoTranscurridoInterceptor implements HandlerInterceptor {

  private static final Logger logger = LoggerFactory.getLogger(TiempoTranscurridoInterceptor.class);

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {

    if (request.getMethod().equalsIgnoreCase("post")) {

      return true;
    }
    if (handler instanceof HandlerMethod) {
      HandlerMethod metodo = (HandlerMethod) handler;
      logger.info("Es un metodo del controlador " + metodo.getMethod().getName());
    }
    logger.info("TiempoTranscurridoInterceptor: preHandle() entrandp......");
    logger.info("Interceptando : " + handler);
    long tiempoInicio = System.currentTimeMillis();
    request.setAttribute("tiempoInicio", tiempoInicio);

    Random random = new Random();
    Integer demora = random.nextInt(100);
    Thread.sleep(demora);
    return true;
  }

  @Override
  public void postHandle(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler,
      ModelAndView modelAndView)
      throws Exception {
    if (request.getMethod().equalsIgnoreCase("post")) {
      return;
    }
    long tiempoInicio = (Long) request.getAttribute("tiempoInicio");
    long tiempoFin = System.currentTimeMillis();
    long tiempoTranscurrido = tiempoFin - tiempoInicio;

    if (handler instanceof HandlerMethod && modelAndView != null) {
      modelAndView.addObject("tiempoTranscurrido", tiempoTranscurrido);
    }

    logger.info("TiempoTranscurrido: " + tiempoTranscurrido + " milisegundos");

    logger.info("TiempoTranscurridoInterceptor: postHandle() saliendo......");
  }
}
