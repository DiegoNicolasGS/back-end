/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto3.reto4.repositorio;

import reto3.reto4.intefaces.InterfaceMessage;
import reto3.reto4.modelo.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Diego Garzon
 */
@Repository
public class RepositoryMessage {
    @Autowired
    private InterfaceMessage crud3;
    public List<Message> getAll(){
        return (List<Message>) crud3.findAll();
    }
    public Optional<Message> getMessage(int id){
        return crud3.findById(id);
    }

    public Message save(Message message){
        return crud3.save(message);
    }
    public void delete(Message message){
        crud3.delete(message);
    }
}
