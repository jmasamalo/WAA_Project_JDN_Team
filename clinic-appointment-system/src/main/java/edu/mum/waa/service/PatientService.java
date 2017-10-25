package edu.mum.waa.service;

import edu.mum.waa.domain.Patient;

public interface PatientService {
	Patient findByEmail(String email);
	Patient save(Patient patient);
	void delete(Patient patient);
}