/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto3.reto4.repositorio;

import reto3.reto4.modelo.Admin;
import reto3.reto4.intefaces.InterfaceAdmin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Diego Garzon
 */
@Repository
public class RepositorioAdmin {
    @Autowired
    private InterfaceAdmin crud;
    
    public List<Admin> getAll()
    {
        return (List<Admin>) crud.findAll();
    }
    
    public Optional <Admin> getAdmin(int id)
    {
        return crud.findById(id);
    }
    
    public Admin save(Admin admin)
    {
        return crud.save(admin);
    }
    
    public void delete(Admin admin){
        crud.delete(admin);
    }
}
