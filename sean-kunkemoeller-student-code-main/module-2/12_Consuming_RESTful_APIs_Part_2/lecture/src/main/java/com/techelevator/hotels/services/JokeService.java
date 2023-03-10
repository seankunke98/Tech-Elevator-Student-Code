package com.techelevator.hotels.services;

import com.techelevator.hotels.model.Joke;
import org.springframework.web.client.RestTemplate;

public class JokeService {


    private final RestTemplate restTemplate = new RestTemplate();
    private static final String API_BASE_URL = "https://v2.jokeapi.dev/joke/Any?safe-mode";


    public Joke listJokes(){
        Joke joke = restTemplate.getForObject(API_BASE_URL, Joke.class);
        return joke;
    }

    public void printJokeMenu(Joke joke){
        System.out.println(joke.toString());
    }

    public static void main(String[] args) {
        JokeService jokeService = new JokeService();

        jokeService.printJokeMenu(jokeService.listJokes());


    }

}


