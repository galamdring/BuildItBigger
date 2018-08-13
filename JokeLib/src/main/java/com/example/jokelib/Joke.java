package com.example.jokelib;

public class Joke{
    private String _joke;
    private String _punchline;

    public Joke(String joke, String punchline){
        _joke = joke;
        _punchline = punchline;
    }

    public String get_joke() {
        return _joke;
    }

    public String get_punchline() {
        return _punchline;
    }

    @Override
    public String toString() {
        return _joke+"\n"+_punchline;
    }
}
