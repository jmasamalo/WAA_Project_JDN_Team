package edu.mum.waa.service;

import edu.mum.waa.domain.Patient;

public interface PatientService {
	Patient findByEmail(String email);
	void save(Patient patient);
}