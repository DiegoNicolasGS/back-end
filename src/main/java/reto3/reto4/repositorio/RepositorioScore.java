/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto3.reto4.repositorio;

import reto3.reto4.intefaces.InterfaceScore;
import reto3.reto4.modelo.Score;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Diego Garzon
 */
@Repository
public class RepositorioScore {
    @Autowired
    private InterfaceScore crud4;

    public List<Score> getAll(){
        return (List<Score>) crud4.findAll();
    }
    public Optional<Score> getScore(int id){
        return crud4.findById(id);
    }
    public Score save(Score score){
        return crud4.save(score);
    }
    public void delete(Score score){
        crud4.delete(score);
    }
}
