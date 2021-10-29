/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package reto3.reto4.intefaces;

import reto3.reto4.modelo.Client;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Diego Garzon
 */
public interface InterfaceClient extends CrudRepository<Client, Integer>{
    
}
