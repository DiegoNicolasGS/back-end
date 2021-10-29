/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto3.reto4.servicios;

import reto3.reto4.modelo.Admin;
import reto3.reto4.repositorio.RepositorioAdmin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diego Garzon
 */
@Service
public class ServicesAdmin {
    @Autowired
    private RepositorioAdmin metodosCrud;
    
    public List<Admin> getAll()
    {
        return metodosCrud.getAll();
    }
    
    public Optional<Admin> getAdmin(int id)
    {
        return metodosCrud.getAdmin(id);
    }
    
    public Admin save(Admin admin)
    {
        if(admin.getId() == null)
        {
            return metodosCrud.save(admin);
        }else
        {
            Optional<Admin> evt = metodosCrud.getAdmin(admin.getId());
            if (evt.isEmpty())
            {
                return metodosCrud.save(admin);
            }else
            {
                return admin;
            }
        }
    }
    public Admin update(Admin admin){
        if(admin.getId()!=null){
            Optional<Admin> e=metodosCrud.getAdmin(admin.getId());
            if(!e.isEmpty()){
                if(admin.getName()!=null){
                    e.get().setName(admin.getName());
                }
                if(admin.getPassword()!=null){
                    e.get().setPassword(admin.getPassword());
                }
                if(admin.getEmail()!=null){
                    e.get().setEmail(admin.getEmail());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return admin;
            }
        }else{
            return admin;
        }
    }


    public boolean delete(int adminId) {
        Boolean aBoolean = getAdmin(adminId).map(admin -> {
            metodosCrud.delete(admin);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
