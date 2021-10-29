/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto3.reto4.modelo;

import reto3.reto4.modelo.Message;
import reto3.reto4.modelo.Reservation;
import reto3.reto4.modelo.Specialty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Diego Garzon
 */
@Entity
@Table(name = "doctor")
/**
 * clase serializable
 */
public class Doctor implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    /**
     * atributo ID
     */
    private Integer id;
    /**
     * atributo NAME
     */
    private String name;
    /**
     * atributo DEPARTMENT
     */
    private String department;
    /**
     * atributo year
     */
    private Integer year;
    /**
     * atributo DESCRIPTION
     */
    private String description;

    @ManyToOne
    @JoinColumn(name = "specialtyId")
    @JsonIgnoreProperties("doctors")
    /**
     * 
     */
    private Specialty specialty;
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="doctor")
    @JsonIgnoreProperties({"doctor","client"})
    /**
     * 
     */
    private List<Message> messages;
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="doctor")
    @JsonIgnoreProperties({"doctor","client"})
    /**
     * 
     */
    private List<Reservation> reservations;

    /**
     * 
     * @return 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return 
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 
     * @param department 
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * 
     * @return 
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 
     * @param year 
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 
     * @return 
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return 
     */
    public Specialty getSpecialty() {
        return specialty;
    }

    /**
     * 
     * @param specialty 
     */
    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    /**
     * 
     * @return 
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * 
     * @param messages 
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * 
     * @return 
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * 
     * @param reservations 
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    
}

