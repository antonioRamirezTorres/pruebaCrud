package com.example.demo.dto;

import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "USUARIO")
public class SampleUserDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @ApiModelProperty(value = "Id de usuario", required = true)
    private Long id;

    @Column(name = "NOMBRE")
    @ApiModelProperty(value = "Nombre de usuario", required = true)
    private String nombre;

    @Column(name = "APELLIDOS")
    @ApiModelProperty(value = "Apellidos de usuario", required = false)
    private String apellidos;

    @Column(name = "DIRECCION")
    @ApiModelProperty(value = "Dirección de usuario", required = false)
    private String direccion;

    @Column(name = "TELEFONO")
    @ApiModelProperty(value = "Telefono de usuario", required = false)
    private String telefono;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "SampleUserDto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
