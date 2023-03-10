package com.techelevator.hotels.model;

public class Joke {

    private String setup;
    private String delivery;
    private String joke;


    public String getJoke() {
        return joke;
    }

    public String getSetup() {
        return setup;
    }

    public String getDelivery() {
        return delivery;
    }

    @Override
    public String toString() {
      return "Joke Details" +
              "\n Joke: " + joke +
              "\n Setup: " + setup +
              "\n Delivery: " + delivery;

    }

}
