package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.User;
import com.remo.MyRepo;

@Service
public class UserService {
	@Autowired
	private MyRepo myRepo;
	
	
	ArrayList<User> al= new ArrayList<User>();
	public boolean loginValid(String name,String password) {
		if(name.equals("admin") && password.equals("manager")) {
			
			return true;
		}
		
		return false;
	}
	
	public void addUser(String name,String password,String email,String city)
	{
		//al.add(new User(name, password, email, city));
		myRepo.save(new User(name, password, email, city));
		System.out.println(al);
	}
	public List<User> loadUsers(){
	  // List lst=(List) myRepo.findAll();
		return (List<User>)myRepo.findAll();
	}

	
	public boolean findUser(String name) {
	
		
		Optional<User>user= myRepo.findById(name);
		if(user.isPresent()) {
			
			System.out.println(user);
			return true;
			
		}
		return false;
	}
	public boolean deleteUser(String name) {
		Optional<User>user= myRepo.findById(name);
		if(user.isPresent()) {
			
			myRepo.deleteById(name);
			
			return true;
			
		}
		return false;
	}
	
	
	public boolean updateUser(String name,String pass,String email,String city) {
		
		Optional<User>user= myRepo.findById(name);
		
		if(user.isPresent()) {
				myRepo.deleteById(name);
				myRepo.save(new User(name, pass, email, city));
				
			return true;
			
		}
		return false;
	}
	
	
	
}
