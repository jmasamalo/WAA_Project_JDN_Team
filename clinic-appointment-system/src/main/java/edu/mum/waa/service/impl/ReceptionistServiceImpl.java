package edu.mum.waa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.waa.domain.Receptionist;
import edu.mum.waa.domain.User;
import edu.mum.waa.domain.UserRoles;
import edu.mum.waa.repository.ReceptionistRepository;
import edu.mum.waa.repository.UserRepository;
import edu.mum.waa.service.ReceptionistService;

@Service
@Transactional
public class ReceptionistServiceImpl implements ReceptionistService {
	@Autowired
	ReceptionistRepository receptionistRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public Receptionist add(Receptionist receptionist) {
		BCryptPasswordEncoder passworEncoder = new BCryptPasswordEncoder();
		User user = receptionist.getUser();
		user.setUsername(receptionist.getEmail());
		user.setRole(UserRoles.ROLE_RECEPTIONIST);
		user.setEnabled(true);
		user.setPassword(passworEncoder.encode(user.getPassword()));
		receptionist.setEnabled(true);
		return receptionistRepository.save(receptionist);
	}
	
	public Receptionist edit(Receptionist receptionist) {
		User user = receptionist.getUser();
		User existingUser = userRepository.findOne(user.getId());
		existingUser.setUsername(receptionist.getEmail());
		String password = user.getPassword();
		if (password != null && !password.isEmpty() && !password.equals("_BLANK_")) {
			BCryptPasswordEncoder passworEncoder = new BCryptPasswordEncoder();
			existingUser.setPassword(passworEncoder.encode(password));
		}
		receptionist.setUser(existingUser);
		userRepository.save(existingUser);
		return receptionistRepository.save(receptionist);
	}

	@Override
	public void delete(long id) {
		Receptionist receptionist = receptionistRepository.findOne(id);
		if (receptionist != null) {
			receptionist.setEnabled(false);
			User user = receptionist.getUser();
			user.setEnabled(false);
			receptionistRepository.save(receptionist);
			userRepository.save(user);
		}	
	}

	@Override
	public List<Receptionist> findAllActive() {
		return receptionistRepository.findAllActive();
	}

//	@Override
//	public List<Receptionist> findAll() {
//		// TODO Auto-generated method stub
//		return (List<Receptionist>) receptionistRepository.findAll();
//	}

	@Override
	public Receptionist findOne(long id) {
		// TODO Auto-generated method stub
		return receptionistRepository.findOne(id);
	}

	@Override
	public User getUserFromReceptionist(long id) {
		// TODO Auto-generated method stub
		return receptionistRepository.getUserFromReceptionist(id);
	}
}