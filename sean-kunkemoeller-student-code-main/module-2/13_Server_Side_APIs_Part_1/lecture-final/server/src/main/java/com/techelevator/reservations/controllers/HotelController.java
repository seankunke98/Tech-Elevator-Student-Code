package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    /**
        list all the reservations
     */

    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<Reservation> listReservations(){
        return reservationDao.findAll();
    }

    /**
     * list reservations for a hotel
     * */

    @RequestMapping(path = "/hotels/{id}/reservations", method = RequestMethod.GET)
    public List<Reservation> listReservationsByHotel(@PathVariable int id){
        return reservationDao.findByHotel(id);
    }

    /**
     * get a reservation by id
     * */

    @RequestMapping(path = "/reservations/{id}", method = RequestMethod.GET)
    public Reservation getReservation(@PathVariable int id){
        return reservationDao.get(id);
    }

    /**
     * add a reservation
     * */

    @RequestMapping(path = "/hotels/{id}/reservations", method = RequestMethod.POST)
    public Reservation addReservation(@PathVariable int id, @RequestBody Reservation reservation){
        return reservationDao.create(reservation,id);
    }

    /**
     * users can filter hotels by city and state
     * /hotels/filter?state=oh&city=cleveland
     *
     * */

    @RequestMapping(path = "/hotels/filter", method = RequestMethod.GET)
    public List<Hotel> filterByStateAndCity(@RequestParam String state, @RequestParam(required = false) String city){
        List<Hotel> hotels = hotelDao.list();
        List<Hotel> filteredHotels = new ArrayList<>();
        for(Hotel hotel : hotels){
            if(city != null){
                if((hotel.getAddress().getCity().toLowerCase().equalsIgnoreCase(city)) && hotel.getAddress().getState().toLowerCase().equals(state.toLowerCase())){
                    filteredHotels.add(hotel);
                }
            } else {
                if(hotel.getAddress().getState().toLowerCase().equals(state.toLowerCase())){
                    filteredHotels.add(hotel);
                }
            }

        }

        return filteredHotels;
    }
}
