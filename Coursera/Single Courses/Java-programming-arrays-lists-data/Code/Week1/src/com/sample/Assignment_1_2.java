package com.sample;


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

//       for(int i = 0; i<26; i++){
//           if(letters[i]!=0){
//               System.out.println(letters[i] + " --- " + (char)('a'+i));
//           }
//       }

        return letters;
    }

    public int maxIndex(int[] freq){
        int max = 0;
        for(int i=0 ; i<freq.length; i++){
            if(freq[i] > freq[max]) max = i;
        }
        return max;
    }

    public String decrypt(String encrypted){
        int[] freqs = countLetters(encrypted);

        int maxDex = maxIndex(freqs);
        System.out.println("MAX id: " + maxDex);

        int dkey = maxDex - 4;
        if(maxDex < 4){
            dkey = 26 - (4-maxDex);
        }

        System.out.println("Dkey: " + dkey);
        return encrypt(encrypted, dkey);
    }

}

    public class Assignment_1_2 {

        public static void main(String[] args) {
            CaesarCipher obj = new CaesarCipher();

//            System.out.println(obj.encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15));
//            System.out.println(obj.encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",8, 21));

            String data = "Istiaq Ahmed Fahad";
            System.out.println("TEXT: " + data);
            String encrypt = obj.encrypt(data, 15);

            System.out.println("Encrypted: " + encrypt);
            System.out.println("Decrypted: " + obj.decrypt(encrypt));

        }
}

