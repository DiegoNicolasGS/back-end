/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto3.reto4.repositorio;

import reto3.reto4.intefaces.InterfaceSpecialty;
import reto3.reto4.modelo.Specialty;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Diego Garzon
 */
@Repository
public class RepositorySpecialty {
    @Autowired
    private InterfaceSpecialty crud;
    public List<Specialty> getAll(){
        return (List<Specialty>) crud.findAll();
    }
    public Optional<Specialty> getSpecialty(int id){
        return crud.findById(id);
    }

    public Specialty save(Specialty specialty){
        return crud.save(specialty);
    }
    public void delete(Specialty specialty){
       crud.delete(specialty);
    }
}
