package com.example.jokes;

import java.util.Random;

/***
 * This class contains jokes from Reader's Digest.
 */
public class RDJokes {

    // List of jokes from Reader's Digest.
    private String [] jokes = {
        "Greeting Cards: When you care enough to send the very best but not enough to actually write something.",
        "Before LinkedIn, I didn't know any strangers.",
        "I put so much more effort into naming my first Wi-Fi than my first child.",
        "Electricity is really just organized lighting."
    };

    // Create a random generator.
    private Random joker = new Random();

    /**
     * Returns a joke.
     *
     * @return a string containing a joke
     */
    public String getJoke() {
        int index = joker.nextInt(jokes.length);
        return jokes[index];
    }

}
