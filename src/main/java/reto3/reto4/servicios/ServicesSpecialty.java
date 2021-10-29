/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto3.reto4.servicios;

import reto3.reto4.repositorio.RepositorySpecialty;
import reto3.reto4.modelo.Specialty;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diego Garzon
 */
@Service
public class ServicesSpecialty {
    @Autowired
    private RepositorySpecialty metodosCrud;

    public List<Specialty> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Specialty> getSpecialty(int SpecialtyId) {
        return metodosCrud.getSpecialty(SpecialtyId);
    }

    public Specialty save(Specialty specialty) {
        if (specialty.getId()== null) {
            return metodosCrud.save(specialty);
        } else {
            Optional<Specialty> specialty1 = metodosCrud.getSpecialty(specialty.getId());
            if (specialty1.isEmpty()) {
                return metodosCrud.save(specialty);
            } else {
                return specialty;
            }
        }
    }

    public Specialty update(Specialty specialty){
        if(specialty.getId()!=null){
            Optional<Specialty> g =metodosCrud.getSpecialty(specialty.getId());
            if(!g.isEmpty()){
                if(specialty.getDescription()!=null){
                    g.get().setDescription(specialty.getDescription());
                }
                if(specialty.getName()!=null){
                    g.get().setName(specialty.getName());
                }
                return metodosCrud.save(g.get());
            }
        }
        return specialty;
    }
    public boolean deletespecialty(int specialtyId){
        Boolean d =getSpecialty(specialtyId).map(specialty -> {
            metodosCrud.delete(specialty);
            return true;
        }).orElse(false);
        return d;
    }
}
