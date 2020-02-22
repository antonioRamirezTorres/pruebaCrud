package com.example.demo.service;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.dto.SampleUserDto;
import com.example.demo.repository.ISampleUserRepository;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class SampleUserServiceTest {
	
	@InjectMocks
	private SampleUserServiceImpl userService;
	
	@Mock
	private ISampleUserRepository userRepository;
	
	private List<SampleUserDto> listUsers;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        
        listUsers = new ArrayList<>();
        
        SampleUserDto user1 = new SampleUserDto();
		user1.setApellidos("apellidos1");
		user1.setDireccion("direccion1");
		user1.setId(1L);
		user1.setNombre("nombre1");
		user1.setTelefono("123456");
		
		SampleUserDto user2 = new SampleUserDto();
		user2.setApellidos("apellidos2");
		user2.setDireccion("direccion2");
		user2.setId(2L);
		user2.setNombre("nombre2");
		user2.setTelefono("654321");
		
		listUsers.add(user1);
		listUsers.add(user2);
    }
	
	@After
	public void terminated() {
		listUsers = null;
	}
	
	@Test
	public void listAllTest() {		
		
		Mockito.when(userRepository.findAll()).thenReturn(listUsers);
		
		assertEquals(listUsers.size(), userService.findAllUsers().size());
		
	}
	
	@Test
	public void getByIdTest() {
		
		Mockito.when(userRepository.findById(2L)).thenReturn(Optional.of(listUsers.get(1)));
		
		assertEquals(listUsers.get(1).getId(), userService.findUserById(2L).get().getId());
	}
	
	@Test
	public void saveUserTestOk() {
		
		SampleUserDto newUser = new SampleUserDto();
		newUser.setApellidos("nuevos apellidos");
		newUser.setDireccion("nueva direccion");
		newUser.setId(3L);
		newUser.setNombre("nuevo nombre");
		newUser.setTelefono("92992");
		
		Mockito.when(userRepository.save(newUser)).thenReturn(newUser);
		
		assertEquals(newUser, userService.saveUser(newUser));
	}
	
	@Test
	public void saveUserTestKo() {
		
		SampleUserDto newUser = null;		
		
		assertNotEquals(newUser, userService.saveUser(newUser));
	}
	
	@Test
	public void deleteUserTestOk() {
		
		Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(listUsers.get(1)));
		
		assertEquals("Usuario eliminado correctamente", userService.deleteUser(1L));
	}
	
	@Test
	public void deleteUserTestKo() {	
		assertEquals("El usuario no existe, no se ha podido eliminar", userService.deleteUser(1L));
	}
	
	@Test
	public void updateUserTestKo() {	
		SampleUserDto user = new SampleUserDto();
		assertEquals("Error al modificar el usuario", userService.updateUser(user));
	}
	
	@Test
	public void updateUserTestOk() {	
		SampleUserDto user1 = new SampleUserDto();
		user1.setApellidos("apellidos modificado");
		user1.setDireccion("direccion modificado");
		user1.setId(1L);
		user1.setNombre("nombre modificado");
		user1.setTelefono("9876554");
		
		Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(listUsers.get(1)));
		
		assertEquals("Usuario modificado", userService.updateUser(user1));
	}

}
