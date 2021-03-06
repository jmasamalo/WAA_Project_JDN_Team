package edu.mum.waa.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.waa.domain.Prescription;
import edu.mum.waa.repository.PrescriptionRepository;
import edu.mum.waa.service.PrescriptionService;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {
	@Autowired
	PrescriptionRepository prescriptionRepository;

	public List<Prescription> findByPatient(long patientID) {
		return prescriptionRepository.findByPatientID(patientID);
	}

	public List<Prescription> findByAppointmentId(long appointmentId) {
		return prescriptionRepository.findByAppointmentId(appointmentId);
	}

	public Prescription save(Prescription prescription) {
		prescription.setDate(new Date());
		return prescriptionRepository.save(prescription);
	}

	public void delete(long id) {
		prescriptionRepository.delete(id);
	}

	@Override
	public Prescription findOne(long id) {
		return prescriptionRepository.findOne(id);
	}
}