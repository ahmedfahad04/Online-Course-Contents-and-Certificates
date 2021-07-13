package com.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

class FileInput{

    private String path = "";
    private String data = "";
    public FileInput(String path){
        this.path = path;
    }

    public String readFile() throws IOException {
        File fp = new File(path);
        FileInputStream f = new FileInputStream(fp);
        int cnt = f.read();
        while((cnt)!=-1){
            data += (char)cnt;
//            System.out.print((char)cnt);
            cnt = f.read();
        }
        return data;
    }

}

class CaesarCipher2{
    private String upperCase;
    private String lowerCase;

    private int mainkey;

    public CaesarCipher2(int key){
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        mainkey = key;
    }

    public String encrypt(String input){
        StringBuilder encrypted = new StringBuilder(input);

        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";

        String upperEncript = upperCase.substring(mainkey) + upperCase.substring(0, mainkey);
        String lowerEncript = lowerCase.substring(mainkey) + lowerCase.substring(0, mainkey);

        for (int i = 0; i < input.length(); i++) {
            char txtChar = input.charAt(i);
            char encriptedChar = 0;
            if (Character.isAlphabetic(txtChar)) {
                if (Character.isUpperCase(txtChar)) {
                    int txtId = upperCase.indexOf(txtChar);
                    encriptedChar = upperEncript.charAt(txtId);
                }
                if (Character.isLowerCase(txtChar)) {
                    int txtId = lowerCase.indexOf(txtChar);
                    encriptedChar = lowerEncript.charAt(txtId);
                }
            } else continue;


            encrypted.setCharAt(i, encriptedChar);
        }

        return encrypted.toString();
    }

    public String decrypt(String input){
        // making object in his own class
        CaesarCipher2 cc = new CaesarCipher2(26-mainkey);
        return cc.encrypt(input);
    }

}

class TestCaesarCipher{

    public int[] countLetters(String text){
        int[] letters = new int[26];

        for(int i=0; i<text.length(); i++){

            char ch = Character.toLowerCase(text.charAt(i));
            if(Character.isAlphabetic(ch)) {
                int id = (int) (ch - 97);
                letters[id]++;
            }
            else continue;
        }
        return letters;
    }

    public int maxIndex(int[] freq){
        int max = 0;
        for(int i=0 ; i<freq.length; i++){
            if(freq[i] > freq[max]) max = i;
        }
        return max;
    }

    public void simpleTests(int key) throws IOException {
        CaesarCipher2 cc = new CaesarCipher2(key);

        FileInput fi = new FileInput("src/com/sample/data.txt");
        String str = fi.readFile();
        System.out.println("Input: " + str);

        String encrypted = cc.encrypt(str);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = cc.decrypt(encrypted);
        System.out.println("Decrypted: " + decrypted);

        String autoDecrypt = breakCaesarCipher(encrypted);
        System.out.println("Automatically Decrypted: " + autoDecrypt);
    }

    public String breakCaesarCipher(String input){
        int[] counts = countLetters(input);
        int maxDex = maxIndex(counts);
        int dkey = maxDex - 4;

        if(maxDex < 4){
            dkey = 26 - (4-maxDex);
        }

        System.out.println("Auto Key tracker: " + dkey);
        CaesarCipher2 cc = new CaesarCipher2(dkey);
        String decrypted = cc.decrypt(input);
        return decrypted;
    }
}

public class Final_1 {
    public static void main(String[] args) throws IOException {
        TestCaesarCipher tc = new TestCaesarCipher();
        tc.simpleTests(15);
    }
}
