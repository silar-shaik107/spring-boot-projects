package com.taskproject.serviceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskproject.entity.Users;
import com.taskproject.payload.UserDto;
import com.taskproject.repository.UserRepository;
import com.taskproject.service.UserService;


@Service
public class UserServiceImple implements UserService {
   
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDto createUser(UserDto userdto) {
		//this userdto is not an entity of Users
		Users user=userDtoToEntity(userdto); //converted userDto to Users
		Users savedUser=userRepository.save(user);
		return entityToUserDto(savedUser);
	}
     private Users userDtoToEntity(UserDto userdto) {
    	 Users users=new Users();
    	 users.setName(userdto.getName());
    	 users.setEmail(userdto.getEmail());
    	 users.setPassword(userdto.getPassword());
    	 
    	 return users;
     }
     private UserDto entityToUserDto(Users savedUser) {
    	 UserDto userdto=new UserDto();
    	 userdto.setId(savedUser.getId());
    	 userdto.setName(savedUser.getName());
    	 userdto.setEmail(savedUser.getEmail());
    	 userdto.setPassword(savedUser.getPassword());
    	 return userdto;
     }
	
}
