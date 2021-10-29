/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto3.reto4.servicios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import reto3.reto4.repositorio.RepositoryReservation;
import reto3.reto4.modelo.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto3.reto4.reportes.CountClient;
import reto3.reto4.reportes.StatusReservas;

/**
 *
 * @author Diego Garzon
 */
@Service
public class ServicesReservation {
    @Autowired
    private RepositoryReservation metodosCrud;

    public List<Reservation> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Reservation> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }

    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<Reservation> e= metodosCrud.getReservation(reservation.getIdReservation());
            if(e.isEmpty()){
                return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> e= metodosCrud.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    //{"completed":3,"cancelled":1}
    public StatusReservas getReporteStatus()
    {
        List<Reservation>completed=metodosCrud.ReservationStatus("completed");
        List<Reservation>cancelled=metodosCrud.ReservationStatus("cancelled");
        
        return new StatusReservas(completed.size(), cancelled.size());
    }
    
    public List<Reservation> getReportesTiempos(String dateOne, String dateTwo)
    {
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");
        Date datoUno = new Date();
        Date datoDos = new Date();
        
        try
        {
            datoUno = parser.parse(dateOne);
            datoDos = parser.parse(dateTwo);
        }catch(ParseException evt)
        {
            evt.printStackTrace();
        }
        if(datoUno.before(datoDos))
        {
            return metodosCrud.ReservationDates(datoUno, datoDos);
        }
        else
        {
            return new ArrayList<>();
        }
    }
    
    public List<CountClient> servicioTopCliente()
    {
        return metodosCrud.getTopCliente();
    }
}