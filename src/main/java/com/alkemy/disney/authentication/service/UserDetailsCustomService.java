package com.alkemy.disney.authentication.service;

import com.alkemy.disney.authentication.dto.UserDTO;
import com.alkemy.disney.authentication.model.UserModel;
import com.alkemy.disney.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsCustomService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailService emailService;
    @Override
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException{
        UserModel userModel=userRepository.findByUsername(username);
        if (userModel == null){
            throw new UsernameNotFoundException("Usuario o Contraseña no encontrada.");
        }
        return new User(userModel.getUsername(), userModel.getPassword(), Collections.emptyList());
    }
    public boolean save(UserDTO userDTO){
        UserModel userModel=new UserModel();
        userModel.setUsername(userDTO.getUsername());
        userModel.setPassword(userDTO.getPassword());
        userModel=this.userRepository.save(userModel);
        if (userModel!=null){
            emailService.sendWelcome(userModel.getUsername());
        }
        return userModel!=null;
    }
}
