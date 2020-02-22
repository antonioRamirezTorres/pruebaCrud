package com.example.demo.controller;

import com.example.demo.dto.SampleUserDto;
import com.example.demo.service.ISampleUserService;

import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SampleController {
	
	private static final Logger log = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    private ISampleUserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Listado de todos los usuarios", notes = "Listado de todos los usuario")
    public List<SampleUserDto> getUsers() {
    	
    	log.info("Servicio getUsers");
    	
        return userService.findAllUsers();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Buscar un usuario", notes = "Buscamos un usuario por Id")
    public Optional<SampleUserDto> getUserById(@PathVariable Long id) {
    	
    	log.info("Servicio getUserById");
    	
        return userService.findUserById(id);
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "Guardar un usuario", notes = "Añadimos un nuevo usuario")
    public SampleUserDto addUser(@RequestBody SampleUserDto user) {
    	
    	log.info("Servicio addUser");
    	
        return userService.saveUser(user);
    }

    @RequestMapping(value = "/users/delete/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Eliminar un usuario", notes = "Eliminar un usuario por Id")
    public String deleteUser(@PathVariable Long id) {
    	
    	log.info("Servicio deleteUser");
    	
        return userService.deleteUser(id);
    }

    @RequestMapping(value = "/users/update", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "Actualizar un usuario", notes = "Actualizar un usuarios existente")
    public String updateUser(@RequestBody SampleUserDto user) {
    	
    	log.info("Servicio updateUser");
    	
        return userService.updateUser(user);
    }

}
