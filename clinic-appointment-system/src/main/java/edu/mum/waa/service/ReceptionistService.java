package edu.mum.waa.service;

import java.util.List;

import edu.mum.waa.domain.Receptionist;

public interface ReceptionistService {
	Receptionist add(Receptionist receptionist);
	Receptionist edit(Receptionist receptionist);
	void delete(long id);
	List<Receptionist> findAllActive();
}