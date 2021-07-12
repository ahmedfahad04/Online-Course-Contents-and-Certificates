package com.sample;


class WordLengths{
    public int countWordLength(String word){
        int len = word.length();

        if(word.charAt(0)=='\"' && word.charAt(len-1)=='\"') len -= 2; //quoted string
        else {
            if (!Character.isLetter(word.charAt(0))) { //first char
                len -= 1;
            }
            if (!Character.isLetter(word.charAt(len - 1))) { // last char
                len -= 1;
            }
        }

        return len;
    }

    public void testCountWordLengths(String s){
         int[] counts = new int[31];

    }

}

public class Assignment_2_1 {
    public static void main(String[] args) {

    }
}
