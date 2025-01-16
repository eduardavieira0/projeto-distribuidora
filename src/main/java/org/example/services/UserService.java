package org.example.services;

import org.example.entities.User;
import org.example.entities.User;
import org.example.repositories.UserRepository;
import org.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    public List <User> findAll(){
        return userRepository.findAll();
    }

    public Optional <User> findID(Long id){
        return userRepository.findById(id);
    }

    public User insert(User user){
        return userRepository.save(user);
    }

    public void deleteID(Long id){
        userRepository.deleteById(id);
    }


}
