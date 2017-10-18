package edu.mum.waa.service;

import java.util.List;

import edu.mum.waa.domain.Doctor;

public interface DoctorService {
	List<Doctor> findAllActive();
	Doctor add(Doctor doctor);
	Doctor edit(Doctor doctor);
	void delete(long id);
}