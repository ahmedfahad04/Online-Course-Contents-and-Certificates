package com.company;


class CaesarCipher {

    public String encrypt(String text, int key) {
        StringBuilder encriptedMessage = new StringBuilder(text);

        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";

        String upperEncript = upperCase.substring(key) + upperCase.substring(0, key);
        String lowerEncript = lowerCase.substring(key) + lowerCase.substring(0, key);

        for (int i = 0; i < text.length(); i++) {
            char txtChar = text.charAt(i);
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


            encriptedMessage.setCharAt(i, encriptedChar);
        }

        return encriptedMessage.toString();

    }

    public String encryptTwoKeys(String text, int key1, int key2) {
        StringBuilder encriptedMessage = new StringBuilder(text);

        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";

        String upperEncript1 = upperCase.substring(key1) + upperCase.substring(0, key1);
        String lowerEncript1 = lowerCase.substring(key1) + lowerCase.substring(0, key1);
        String upperEncript2 = upperCase.substring(key2) + upperCase.substring(0, key2);
        String lowerEncript2 = lowerCase.substring(key2) + lowerCase.substring(0, key2);

        for (int i = 0; i < text.length(); i++) {
            char txtChar = text.charAt(i);
            char encriptedChar = 0;

            if (Character.isAlphabetic(txtChar)) {
                if (Character.isUpperCase(txtChar)) {
                    int txtId = upperCase.indexOf(txtChar);
                    if ((i + 1) % 2 == 1) encriptedChar = upperEncript1.charAt(txtId);
                    else encriptedChar = upperEncript2.charAt(txtId);
                }
                if (Character.isLowerCase(txtChar)) {
                    int txtId = lowerCase.indexOf(txtChar);
                    if ((i + 1)%2 == 1) encriptedChar = lowerEncript1.charAt(txtId);
                    else encriptedChar = lowerEncript2.charAt(txtId);
                }
            } else continue;


            encriptedMessage.setCharAt(i, encriptedChar);

        }

        return encriptedMessage.toString();
    }

}

    public class Assignment2 {

        public static void main(String[] args) {
            CaesarCipher obj = new CaesarCipher();

            System.out.println(obj.encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15));
            System.out.println(obj.encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",8, 21));
        }
}

