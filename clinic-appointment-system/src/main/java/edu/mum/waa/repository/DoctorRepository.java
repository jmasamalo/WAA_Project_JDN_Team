package edu.mum.waa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.waa.domain.Doctor;;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {
	@Query("SELECT d FROM doctor d WHERE d.enabled = True")
	List<Doctor> findAllActive();
}