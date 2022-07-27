package com.dcc.jdt.entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "voluntarios")
public class voluntario {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nombre;

    @NotEmpty
    private String apellido;

    @NotEmpty
    private String documento;

    @NotEmpty
    @Email
    private String email;

    @NotNull
    private Long telefono;

    @NotEmpty
    private String direccion;

    @NotEmpty
    private String sexo;

    @NonNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

    @NotEmpty
    private String estadoCivil;

    @NotEmpty
    private String escolaridad;

    @NotNull
    private Double antiguedad;

    @NotEmpty
    private String CasoEmergencia;

    @NotNull
    private Long numeroCasoEmergencia;

    public voluntario() {
        super();
    }

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public Double getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(Double antiguedad) {
        this.antiguedad = antiguedad;
    }

    public String getCasoEmergencia() {
        return CasoEmergencia;
    }

    public void setCasoEmergencia(String casoEmergencia) {
        CasoEmergencia = casoEmergencia;
    }

    public Long getNumeroCasoEmergencia() {
        return numeroCasoEmergencia;
    }

    public void setNumeroCasoEmergencia(Long numeroCasoEmergencia) {
        this.numeroCasoEmergencia = numeroCasoEmergencia;
    }

}