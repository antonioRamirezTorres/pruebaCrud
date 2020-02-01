package com.example.demo.repository;

import com.example.demo.dto.SampleUserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISampleUserRepository extends JpaRepository<SampleUserDto, Long> {

}
