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

	@RequestMapping(value = "/admin/doctor", method = RequestMethod.POST)
	public @ResponseBody Doctor add(@Valid @RequestBody Doctor doctor) {
		return doctorService.add(doctor);
	}
	
	@RequestMapping(value = "/admin/doctor", method = RequestMethod.PUT)
	public @ResponseBody Doctor edit(@Valid @RequestBody Doctor doctor) {
		return doctorService.edit(doctor);
	}
	
	@RequestMapping(value = "/admin/doctor/{id}", method = RequestMethod.DELETE)
	public @ResponseBody boolean delete(@PathVariable("id") long id) {
		doctorService.delete(id);
		return true;
	}
}