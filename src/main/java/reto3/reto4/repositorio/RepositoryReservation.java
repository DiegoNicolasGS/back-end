/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto3.reto4.repositorio;

import java.util.ArrayList;
import java.util.Date;
import reto3.reto4.intefaces.InterfaceReservation;
import reto3.reto4.modelo.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reto3.reto4.modelo.Client;
import reto3.reto4.reportes.CountClient;

/**
 *
 * @author Diego Garzon
 */
@Repository
public class RepositoryReservation {
    @Autowired
    private InterfaceReservation crud4;

    public List<Reservation> getAll(){
        return (List<Reservation>) crud4.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return crud4.findById(id);
    }
    public Reservation save(Reservation reservation){
        return crud4.save(reservation);
    }
    public void delete(Reservation reservation){
        crud4.delete(reservation);
    }
    
    public List<Reservation> ReservationStatus(String status)
    {
        return crud4.findAllByStatus(status);
    }
    
    public List<Reservation> ReservationDates(Date dateOne, Date dateTwo)
    {
        return crud4.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
    }
    
    public List<CountClient> getTopCliente()
    {
        List<CountClient> res = new ArrayList<>();
        List<Object[]> report = crud4.countTotalReservationsByClient();
        for(int iterator=0; iterator<report.size(); iterator++)
        {
            res.add(new CountClient((Long) report.get(iterator)[1],(Client) report.get(iterator)[0]));
        }
        return res;
    }
}
