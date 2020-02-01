package com.example.demo.service;

import com.example.demo.dto.SampleUserDto;

import java.util.List;
import java.util.Optional;

public interface ISampleUserService {

    List<SampleUserDto> findAllUsers();

    Optional<SampleUserDto> findUserById(Long id);

    SampleUserDto saveUser(SampleUserDto user);

    String deleteUser(Long id);

    String updateUser(SampleUserDto user);
}
