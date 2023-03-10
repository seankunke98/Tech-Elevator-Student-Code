package com.techelevator.hotels.services;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Reservation;
import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import javax.naming.spi.ResolveResult;
import javax.swing.text.html.parser.Entity;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;


public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000/";
    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * Create a new reservation in the hotel reservation system
     */
    public Reservation addReservation(Reservation newReservation) {
        //header
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //entity
        HttpEntity<Reservation> entity = new HttpEntity<>(newReservation, headers);
        Reservation returnedReservation = new Reservation();
        try {
           returnedReservation = restTemplate.postForObject(API_BASE_URL + "reservations", entity, Reservation.class);
       } catch (RestClientResponseException ex){
           BasicLogger.log(ex.getRawStatusCode() + " : " + ex.getStatusText());
       } catch (ResourceAccessException ex){
           BasicLogger.log(ex.getMessage());
       }

        return returnedReservation;
    }

    /**
     * Updates an existing reservation by replacing the old one with a new
     * reservation
     */
    public boolean updateReservation(Reservation updatedReservation) {
        HttpEntity<Reservation> returnedReservation = makeReservationEntity(updatedReservation);
        try{
            restTemplate.put(API_BASE_URL + "reservations/" + updatedReservation.getId(), returnedReservation, Reservation.class);
            return true;
        } catch (RestClientResponseException ex){
            BasicLogger.log(ex.getRawStatusCode() + " : " + ex.getStatusText());
        } catch (ResourceAccessException ex){
            BasicLogger.log(ex.getMessage());
        }
        return false;
    }

    /**
     * Delete an existing reservation
     */
    public boolean deleteReservation(int id) {
        boolean success = false;
        try{
            restTemplate.delete(API_BASE_URL + "reservations/" + id);
            success = true;
        } catch (RestClientResponseException ex){
            BasicLogger.log(ex.getRawStatusCode() + " : " + ex.getStatusText());
        } catch (ResourceAccessException ex){
            BasicLogger.log(ex.getMessage());
        }
        return success;
    }

    /* DON'T MODIFY ANY METHODS BELOW */

    /**
     * List all hotels in the system
     */
    public Hotel[] listHotels() {
        Hotel[] hotels = null;
        try {
            hotels = restTemplate.getForObject(API_BASE_URL + "hotels", Hotel[].class);
        } catch (RestClientResponseException e) {
            // handles exceptions thrown by rest template and contains status codes
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            // i/o error, ex: the server isn't running
            BasicLogger.log(e.getMessage());
        }
        return hotels;
    }

    /**
     * List all reservations in the hotel reservation system
     */
    public Reservation[] listReservations() {
        Reservation[] reservations = null;
        try {
            reservations = restTemplate.getForObject(API_BASE_URL + "reservations", Reservation[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservations;
    }

    /**
     * List all reservations by hotel id.
     */
    public Reservation[] listReservationsByHotel(int hotelId) {
        Reservation[] reservations = null;
        try {
            reservations = restTemplate.getForObject(API_BASE_URL + "hotels/" + hotelId + "/reservations", Reservation[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservations;
    }

    /**
     * Find a single reservation by the reservationId
     */
    public Reservation getReservation(int reservationId) {
        Reservation reservation = null;
        try {
            reservation = restTemplate.getForObject(API_BASE_URL + "reservations/" + reservationId, Reservation.class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservation;
    }


    private HttpEntity<Reservation> makeReservationEntity(Reservation reservation){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Reservation> entity = new HttpEntity<>(reservation, headers);
        return entity;
    }

}