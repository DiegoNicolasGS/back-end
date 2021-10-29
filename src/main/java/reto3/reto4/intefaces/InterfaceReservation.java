/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package reto3.reto4.intefaces;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import reto3.reto4.modelo.Reservation;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Diego Garzon
 */
public interface InterfaceReservation extends CrudRepository<Reservation, Integer>{
    
    public List<Reservation> findAllByStatus(String status);
    
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    
    @Query("select c.client, count(c.client) from Reservation AS c group by c.client order by count(c.client)desc")
    public List<Object[]> countTotalReservationsByClient();
    
}
