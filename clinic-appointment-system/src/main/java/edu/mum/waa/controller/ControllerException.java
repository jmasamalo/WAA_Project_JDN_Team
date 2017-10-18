package edu.mum.waa.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import edu.mum.waa.exceptions.AppointmentExceptions;

@ControllerAdvice
public class ControllerException {
	@ExceptionHandler(Exception.class)
	public String handlecommonExceptions(Exception e, Model model) {
		return "error";
	}

	@ExceptionHandler(AppointmentExceptions.class)
	public String handleappointmentExceptions(Exception e, Model model) {
		return "error";
	}
}