package edu.mum.waa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.waa.domain.Doctor;
import edu.mum.waa.domain.User;
import edu.mum.waa.domain.UserRoles;
import edu.mum.waa.repository.DoctorRepository;
import edu.mum.waa.repository.UserRepository;
import edu.mum.waa.service.DoctorService;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public List<Doctor> findAllActive(){
		return doctorRepository.findAllActive();
	}

	public Doctor add(Doctor doctor) {
		BCryptPasswordEncoder passworEncoder = new BCryptPasswordEncoder();
		User user = doctor.getUser();
		user.setUsername(doctor.getEmail());
		user.setRole(UserRoles.ROLE_DOCTOR);
		user.setEnabled(true);
		user.setPassword(passworEncoder.encode(user.getPassword()));
		return doctorRepository.save(doctor);
	}
	
	public Doctor edit(Doctor doctor) {
		User user = doctor.getUser();
		User existingUser = userRepository.findOne(user.getId());
		existingUser.setUsername(doctor.getEmail());
		String password = user.getPassword();
		if (password != null && !password.isEmpty() && !password.equals("_BLANK_")) {
			BCryptPasswordEncoder passworEncoder = new BCryptPasswordEncoder();
			existingUser.setPassword(passworEncoder.encode(password));
		}
		doctor.setUser(existingUser);
		userRepository.save(existingUser);
		return doctorRepository.save(doctor);
	}

	public void delete(long id) {
		Doctor doctor = doctorRepository.findOne(id);
		if(doctor != null) {
			doctor.setEnabled(false);
			User user = doctor.getUser();
			user.setEnabled(false);
			doctorRepository.save(doctor);
			userRepository.save(user);
		}
	}
}