package com.example.demo.repository;

import com.example.demo.dto.SampleUserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISampleUserRepository extends JpaRepository<SampleUserDto, Long> {

}
