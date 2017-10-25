package edu.mum.waa.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.waa.domain.Receptionist;
import edu.mum.waa.domain.User;
import edu.mum.waa.service.ReceptionistService;
import edu.mum.waa.validator.ReceptionistValidator;

@Controller
public class ReceptionistController {
	@Autowired
	ReceptionistService receptionistService;

	@RequestMapping(value = "/admin/receptionist/addReceptionist", method = RequestMethod.GET)
	public String addReceptionistForm(@ModelAttribute("addReceptionist") Receptionist receptionist) {
		return "addReceptionist";
	}

	
	@RequestMapping(value = "/admin/receptionist/addReceptionist", method = RequestMethod.POST)
	public String addReceptionist(@Valid @ModelAttribute("addReceptionist") Receptionist receptionist, BindingResult bindingResult) {
		
//		ReceptionistValidator receptionistValidator = new ReceptionistValidator();
//		receptionistValidator.validate(receptionist, bindingResult);
		if(receptionistService.emailExists(receptionist))
		{
			bindingResult.rejectValue("email", "receptionist.Email");
		}
		if(bindingResult.hasErrors()) {
			return "addReceptionist";
		}
		receptionistService.add(receptionist);
		return "redirect:/admin/receptionist";
	}

	@RequestMapping(value = "/admin/receptionist", method = RequestMethod.GET)
	public String getList(Model model) {
		List<Receptionist> receptionists = receptionistService.findAllActive();
		// List<Receptionist> receptionists = receptionistService.findAll();
		model.addAttribute("receptionists", receptionists);
		return "adminReceptionists";
	}

	@RequestMapping(value = "/admin/receptionist/addReceptionist/{id}", method = RequestMethod.GET)
	public String editReceptionistPage(@PathVariable("id") long id,
			@ModelAttribute("addReceptionist") Receptionist receptionist, Model model) {
		receptionist = receptionistService.findOne(id);
		model.addAttribute("addReceptionist", receptionist);

		return "addReceptionist";
	}

	@RequestMapping(value = "/admin/receptionist/addReceptionist/{id}", method = RequestMethod.POST)
	public String editReceptionist(@ModelAttribute("addReceptionist") Receptionist receptionist, Model model , BindingResult bindingResult) {
		User user = receptionistService.getUserFromReceptionist(receptionist.getId());
		receptionist.getUser().setId(user.getId());
		
		if(receptionistService.emailExists(receptionist))
		{
			bindingResult.rejectValue("email", "receptionist.Email");
		}
		if(bindingResult.hasErrors()) {
			return "addReceptionist";
		}

		receptionistService.edit(receptionist);
		return "redirect:/admin/receptionist";
	}

	@RequestMapping(value = "/admin/receptionist/deleteReceptionist/{id}", method = RequestMethod.GET)
	public String deleteReceptionist(@PathVariable("id") long id) {
		receptionistService.delete(id);
		return "redirect:/admin/receptionist";

	}

	@RequestMapping(value = "/receptionist/receptionistProfile", method = RequestMethod.GET)
	public String viewProfilePage(Model model) {
		Receptionist receptionist = receptionistService.findByEmail(ControllerHelper.getCurrentUser().getUsername());
		model.addAttribute("userdetail",receptionist);
		return "receptionistProfile";
		 
	}
	
	

}