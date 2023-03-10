package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.web.bind.annotation.*;

import javax.naming.spi.ResolveResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
public class HotelController {

    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    public HotelController() {
        this.hotelDao = new MemoryHotelDao();
        this.reservationDao = new MemoryReservationDao(hotelDao);
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> list() {
        return hotelDao.list();
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable int id) {
        return hotelDao.get(id);
    }


    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<Reservation> listReservations(){
        return reservationDao.findAll();
    }

    @RequestMapping(path = "hotels/{id}/reservations", method = RequestMethod.GET)
    public List<Reservation> listReservationsByHotel(@PathVariable int id){
        return reservationDao.findByHotel(id);
    }

    @RequestMapping(path = "/reservations/{id}", method = RequestMethod.GET)
    public Reservation getReservation(@PathVariable int id){
        return reservationDao.get(id);
    }

    @RequestMapping(path = "/hotels/{id}/reservations/", method = RequestMethod.POST)
    public Reservation addReservation(@PathVariable int id, @RequestBody Reservation reservation){
        return reservationDao.create(reservation, id);
    }

    @RequestMapping(path = "/hotels/filter", method = RequestMethod.GET)
    public List<Hotel> filterHotelsByCityAndState(@RequestParam String state, @RequestParam(required = false) String city){
        List<Hotel> hotels = hotelDao.list();
        List<Hotel> filteredList = new ArrayList<>();
        for(Hotel hotel : hotels){
            if(hotel.getAddress().getState().toLowerCase().equals(state.toLowerCase()) && hotel.getAddress().getCity().toLowerCase().equals(city.toLowerCase())){
                filteredList.add(hotel);
            }
        }
        return filteredList;
    }

}
