package edu.mum.waa.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String savePatient(@Valid @ModelAttribute("newPatient") Patient patient, 
			BindingResult result, 
			HttpServletRequest request,
			Model model,
			RedirectAttributes redirectAttributes) throws FileNotFoundException {
		if (result.hasErrors()) {
			return "registerPatient";
		}
		
		MultipartFile image = patient.getPhoto();
 		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		//String rootDirectory = request.getSession().getServletContext().getContextPath();
 		
 		/*String imageFileType = image.getOriginalFilename().split(".")[1].toLowerCase();
 		//System.out.println(imageFileType);
 		boolean imageFileTypeValid = false;
 		if(imageFileType.equals("jpg") || 
 				imageFileType.equals("jpeg") || 
 				imageFileType.equals("png") ||
 				imageFileType.equals("gif")) {
 			imageFileTypeValid = true;
 		}*/
 		


	   	//save before image saving to obtain the auto-generated id
		Patient savedPatient = patientService.save(patient);
		
		String destinationImage = rootDirectory+"\\resources\\images\\"+ savedPatient.getLastName()+"_"+ savedPatient.getId() + ".jpg";
 		//String destinationImage = rootDirectory+"resources\\images\\temp.jpg";
 		System.out.println(destinationImage);
		//isEmpty means file exists BUT NO Content
		if (image!=null && !image.isEmpty()) { //&& imageFileTypeValid) {
	       try {
	    	   image.transferTo(new File(destinationImage));
	       } catch (Exception e) {
	    	   //rollback the save
	    	   patientService.delete(savedPatient); 
	    	   throw new FileNotFoundException("Unable to save image: " + image.getOriginalFilename());
	       }
	   }
		
		model.addAttribute("destinationImage",destinationImage);
		
		redirectAttributes.addFlashAttribute("patient", savedPatient);
			
		//return "registerPatient";
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
	
	@RequestMapping(value = "/patient/details", method = RequestMethod.GET)
	public String patientDetails(Model model) {
		User user = ControllerHelper.getCurrentUser();
		Patient patient = patientService.findByEmail(user.getUsername());
		model.addAttribute("patient", patient);
		return "patientDetails";
	}
}