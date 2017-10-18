package edu.mum.waa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.waa.domain.Receptionist;
import edu.mum.waa.service.ReceptionistService;

@Controller
public class ReceptionistController {
	@Autowired
	ReceptionistService receptionistService;

	@RequestMapping(value = "/admin/receptionist", method = RequestMethod.GET)
	public String getList(Model model) {
		List<Receptionist> receptionists = receptionistService.findAllActive();
		model.addAttribute("receptionists", receptionists);
		return "adminReceptionists";
	}

	@RequestMapping(value = "/admin/receptionist", method = RequestMethod.POST)
	public @ResponseBody Receptionist add(@Valid @RequestBody Receptionist receptionist) {
		return receptionistService.add(receptionist);
	}
	
	@RequestMapping(value = "/admin/receptionist", method = RequestMethod.PUT)
	public @ResponseBody Receptionist edit(@Valid @RequestBody Receptionist receptionist) {
		return receptionistService.edit(receptionist);
	}

	@RequestMapping(value = "/admin/receptionist/{id}", method = RequestMethod.DELETE)
	public @ResponseBody boolean delete(@PathVariable long id) {
		receptionistService.delete(id);
		return true;
	}
}