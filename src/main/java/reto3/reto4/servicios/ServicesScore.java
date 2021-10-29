/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto3.reto4.servicios;


import reto3.reto4.repositorio.RepositorioScore;
import reto3.reto4.modelo.Score;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diego Garzon
 */
@Service
public class ServicesScore {
    @Autowired
    private RepositorioScore metodosCrud;
    
    public List<Score> getAll()
    {
        return metodosCrud.getAll();
    }
    
    public Optional<Score> getScore(int id)
    {
        return metodosCrud.getScore(id);
    }
    
    public Score save(Score score)
    {
        if(score.getId() == null)
        {
            return metodosCrud.save(score);
        }else
        {
            Optional<Score> evt = metodosCrud.getScore(score.getId());
            if (evt.isEmpty())
            {
                return metodosCrud.save(score);
            }else
            {
                return score;
            }
        }
    }
    public Score update(Score score){
        if(score.getId()!=null){
            Optional<Score> e=metodosCrud.getScore(score.getId());
            if(!e.isEmpty()){
                if(score.getText()!=null){
                    e.get().setText(score.getText());
                }
                if(score.getStars()!=null){
                    e.get().setStars(score.getStars());
                }
                if(score.getDate()!=null){
                    e.get().setDate(score.getDate());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return score;
            }
        }else{
            return score;
        }
    }


    public boolean deleteScore(int scoreId) {
        Boolean aBoolean = getScore(scoreId).map(score -> {
            metodosCrud.delete(score);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
