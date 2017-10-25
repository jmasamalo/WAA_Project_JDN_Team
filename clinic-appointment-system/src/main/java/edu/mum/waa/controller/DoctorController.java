package edu.mum.waa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.waa.domain.Appointment;
import edu.mum.waa.domain.Doctor;
import edu.mum.waa.domain.User;
import edu.mum.waa.service.AppointmentService;
import edu.mum.waa.service.DoctorService;

@Controller
public class DoctorController {
	@Autowired
	DoctorService doctorService;
	
	@Autowired
	AppointmentService appointmentService;
	
	@RequestMapping(value="/admin/doctor/addDoctor", method=RequestMethod.GET)
	public String addDoctorPage(@ModelAttribute("addDoctor") Doctor doctor) {
		return "addDoctor";
	}
	
	
	
	@RequestMapping(value="/admin/doctor/addDoctor", method=RequestMethod.POST)
	public String addDoctorToDB(@ModelAttribute("addDoctor") Doctor doctor) {
		doctorService.add(doctor);
		return "redirect:/admin/doctor";
	}
	
	@RequestMapping(value = "/doctor/appointment", method = RequestMethod.GET)
	public String welcome(Model model) {
		User user = ControllerHelper.getCurrentUser();
		List<Appointment> appointments = appointmentService.findByDoctorEmail(user.getUsername());
		model.addAttribute("appointments", appointments);
		return "doctorAppointments";
	}

	@RequestMapping(value = "/admin/doctor", method = RequestMethod.GET)
	public String list(Model model) {
		List<Doctor> doctors = doctorService.findAllActive();
		model.addAttribute("doctors", doctors);
		return "adminDoctors";
	}
	
	@RequestMapping(value="/admin/doctor/deleteDoctor/{id}", method=RequestMethod.GET)
	public String deleteDoctor(@PathVariable("id") long id) {
		doctorService.delete(id);
		return "redirect:/admin/doctor";
	}
	
	
	@RequestMapping(value="/admin/doctor/addDoctor/{id}", method=RequestMethod.GET)
	public String editDoctorPage(@PathVariable("id") long id, @ModelAttribute("addDoctor") Doctor doctor, Model model) {
//		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		doctor = doctorService.findOne(id);
//		System.out.println(doctor.getUser().getId());
//		System.out.println("aaaaaaaaaaaaaaa"+doctor.getFirstName());
		model.addAttribute("addDoctor", doctor);
//		model.addAttribute("user",doctor.getUser());
		return "addDoctor";
	}
	
	@RequestMapping(value="/admin/doctor/addDoctor/{id}", method=RequestMethod.POST)
	public String editDoctor(@ModelAttribute("addDoctor") Doctor doctor, Model model) {
//		System.out.println("aaaaaaaaaaaaaaBBBBBBBBBBBBBBBBB");
//		System.out.println(doctor.getUser().getId());
		User user = doctorService.getUserFromDoctor(doctor.getId());
		doctor.getUser().setId(user.getId());
		doctorService.edit(doctor);
		return "redirect:/admin/doctor";
	}
	
}