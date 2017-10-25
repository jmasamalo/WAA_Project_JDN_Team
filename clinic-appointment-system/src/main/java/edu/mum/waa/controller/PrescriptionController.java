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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.waa.domain.Appointment;
import edu.mum.waa.domain.Prescription;
import edu.mum.waa.service.AppointmentService;
import edu.mum.waa.service.PrescriptionService;

@Controller
public class PrescriptionController {
	@Autowired
	PrescriptionService prescriptionService;
	
	@Autowired
	AppointmentService appointmentService;
	
	@RequestMapping(value = "/doctor/prescription", method = RequestMethod.GET)
	public String get(@RequestParam("appointmentId") long appointmentId, Model model) {
		Appointment appointment = appointmentService.findById(appointmentId);
		model.addAttribute("appointment", appointment);
		List<Prescription> prescriptions = prescriptionService.findByAppointmentId(appointmentId);
		model.addAttribute("prescriptions", prescriptions);
		return "doctorPrescriptions";
	}

	@RequestMapping(value = "/doctor/prescription", method = RequestMethod.POST)
	public @ResponseBody Prescription save(@Valid @RequestBody Prescription prescription) {
		prescriptionService.save(prescription);
		return prescription;
	}
	
	@RequestMapping(value = "/doctor/prescription/{id}", method = RequestMethod.DELETE)
	public @ResponseBody boolean delete(@PathVariable("id") long id) {
		prescriptionService.delete(id);
		return true;
	}
}