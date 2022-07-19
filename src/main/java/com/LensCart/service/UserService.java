package com.LensCart.service;

import com.LensCart.Exception.UserNotFoundException;
import com.LensCart.Repository.UserRepository;
import com.LensCart.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<Users> getAllUsers(){
        return new ArrayList<>(userRepository.findAll());
    }
    public Users getUserById(int id){
        Optional<Users> users=userRepository.findById(id);
        if(users.isPresent()){

            return userRepository.findById(id).get();
        }
        else{
            throw new UserNotFoundException("Get Operation failed \n No User Found with id : "+id);
        }
    }
    public void deleteUser(int id)
    {
        Optional<Users> users=userRepository.findById(id);
        if(users.isPresent()){
            userRepository.deleteById(id);
        }
        else{
            throw new UserNotFoundException("Delete Operation failed \n No User Found with id : "+id);
        }
    }
    public void createUser(Users user){
        userRepository.save(user);
    }


}
