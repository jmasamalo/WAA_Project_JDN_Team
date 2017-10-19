package edu.mum.waa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.waa.domain.Patient;
import edu.mum.waa.domain.Prescription;
import edu.mum.waa.domain.User;
import edu.mum.waa.service.AppointmentService;
import edu.mum.waa.service.PatientService;
import edu.mum.waa.service.PrescriptionService;

@Controller
public class PatientController {
	@Autowired
	private PatientService patientService;

	@Autowired
	PrescriptionService pService;
	
	@Autowired
	AppointmentService appointmentService;

	@RequestMapping(value = "/patient/medicalReport", method = RequestMethod.GET)
	public String getPatientPrescription(Model model) {
		User user = ControllerHelper.getCurrentUser();
		Patient p = patientService.findByEmail(user.getUsername());
		List<Prescription> prescriptions = pService.findByPatient(p.getId());
		model.addAttribute("prescriptions", prescriptions);
		return "medicalReport";
	}

	@RequestMapping(value = "/registerPatient", method = RequestMethod.GET)
	public String getPatient(@ModelAttribute("newPatient") Patient patient) {
		return "registerPatient";
	}

	@RequestMapping(value = "/registerPatient", method = RequestMethod.POST)
	public String savePatient(@Valid @ModelAttribute("newPatient") Patient patient, BindingResult result) {
		if (result.hasErrors()) {
			return "registerPatient";
		}
		patientService.save(patient);
		return "redirect:/registerPatientSuccess";
	}

	@RequestMapping(value = "/registerPatientSuccess", method = RequestMethod.GET)
	public String successMessage() {
		return "registerPatientSuccess";
	}
	
	@RequestMapping(value = "/patient/appointment/status", method = RequestMethod.GET)
	public String appointmentStatus(Model model) {
		User user = ControllerHelper.getCurrentUser();
		model.addAttribute("appointments", appointmentService.findByPatientEmail(user.getUsername()));
		return "appointmentStatus";
	}
}