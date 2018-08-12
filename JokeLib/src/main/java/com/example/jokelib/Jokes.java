package com.example.jokelib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Jokes {
    static Joke[] _jokeArray= {
            new Joke("Why do ghosts like elevators?",
                    "It raises their spirits."),
            new Joke("Want to hear a dirty joke?",
                    "Three white horses fell in the mud."),
            new Joke("What's a build master's favorite black metal band?",
                    "Gradle of Filth!"),
            new Joke("How long does it take to master build tools?",
                    "From the Gradle to the grave."),


    };
    private static List<Joke> _jokes = new ArrayList<Joke>(Arrays.asList(_jokeArray));

    public static Joke getRandomJoke(){
       return _jokes.get(new Random().nextInt(_jokes.size()));
    }
}
