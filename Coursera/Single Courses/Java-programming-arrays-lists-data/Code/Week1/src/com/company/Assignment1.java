package com.company;

class WordPlay{
    public boolean isVowel(char ch){
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public String replaceVowels(String phrase, char ch){
        StringBuilder newphrase = new StringBuilder(phrase);
        for(int i=0 ; i< phrase.length(); i++){
            if(isVowel(phrase.charAt(i))) newphrase.setCharAt(i, ch);
        }

        return newphrase.toString();
    }

    public String emphasize(String phrase, char ch){
        StringBuilder newphrase = new StringBuilder(phrase);
        for(int i=0 ; i< phrase.length(); i++){
            if(Character.isAlphabetic(phrase.charAt(i))) {
                if (phrase.charAt(i) == ch && (i % 2) == 0) newphrase.setCharAt(i, '*');
                else if (phrase.charAt(i) == ch && (i % 2) == 1) newphrase.setCharAt(i, '+');
            }
            else continue;
        }

        return newphrase.toString();
    }
}

public class Assignment1 {
    public static void main(String[] args) {
        WordPlay obj1 = new WordPlay();
        System.out.println(obj1.replaceVowels("Hello World", '*'));
        System.out.println(obj1.emphasize("dna ctgaaactga",'a'));
    }
}
