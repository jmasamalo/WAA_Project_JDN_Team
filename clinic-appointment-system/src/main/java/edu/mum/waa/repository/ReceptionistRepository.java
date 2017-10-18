package edu.mum.waa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.mum.waa.domain.Receptionist;

public interface ReceptionistRepository extends CrudRepository<Receptionist, Long> {
	@Query("SELECT r FROM receptionist r WHERE r.enabled = True")
	List<Receptionist> findAllActive();
}