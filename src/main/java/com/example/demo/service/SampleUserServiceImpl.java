package com.example.demo.service;

import com.example.demo.dto.SampleUserDto;
import com.example.demo.repository.ISampleUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SampleUserServiceImpl implements ISampleUserService {

    @Autowired
    private ISampleUserRepository userRepository;

    @Override
    public List<SampleUserDto> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<SampleUserDto> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public SampleUserDto saveUser(SampleUserDto user) {
        if (user != null) {
            return userRepository.save(user);
        }

        return new SampleUserDto();
    }

    @Override
    public String deleteUser(Long id) {

        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return "Usuario eliminado correctamente";
        }

        return "El usuario no existe, no se ha podido eliminar";
    }

    @Override
    public String updateUser(SampleUserDto user) {
        return null;
    }
}
