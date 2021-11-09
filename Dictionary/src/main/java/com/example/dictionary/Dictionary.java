package com.example.dictionary;

import java.util.ArrayList;

public class Dictionary {
    private ArrayList<Word> words = new ArrayList<Word>();

    public ArrayList<Word> getWords() {
        return words;
    }

    public void setWords(ArrayList<Word> words) {
        this.words = words;
    }

    public void pushWord(Word word) {
        words.add(word);
    }

}
