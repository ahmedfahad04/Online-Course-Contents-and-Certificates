package com.sample;

import com.sample.FileInput;

import java.io.IOException;

class CaeserBreaker{

    public void testDecrypt(String text){
        CaesarCipher obj = new CaesarCipher();
        String encryptedMessage = obj.encrypt(text, 23);
        String decryptedMessage = obj.decrypt(encryptedMessage);
        System.out.println("Encrypted: " + encryptedMessage);
        System.out.println("Decrypted: " + decryptedMessage);
    }

    public String halfOfString(String message, int start){
        StringBuilder newMessage = new StringBuilder();
        for(int i=start; i<message.length(); i+=2){
            newMessage.append(message.charAt(i));
        }
        return newMessage.toString();
    }

    public int getKey(String s){
        CaesarCipher cc = new CaesarCipher();
        int[] cnt = cc.countLetters(s);
        int maxDex = cc.maxIndex(cnt);

        int dkey = maxDex - 4;
        if(maxDex < 4){
            dkey = 26 - (4-maxDex);
        }
        return dkey;
    }

    // this is for unknown key.
    public String decrypTwoKey(String encrypted){
        CaesarCipher cc = new CaesarCipher();
        String firstHalf = halfOfString(encrypted,0);
        String secondHalf = halfOfString(encrypted, 1);

        int key1 = getKey(firstHalf);
        int key2 = getKey(secondHalf);
//        System.out.println("FIRST: " + firstHalf + "\nSecond: " + secondHalf);
        System.out.println("Key1: " + key1 + "--Key2: " + key2);

        StringBuilder result = new StringBuilder();
        result.append(cc.encryptTwoKeys(encrypted, 26-key1, 26-key2));

        return result.toString();

    }

}

public class Assignment_2_2 {
    public static void main(String[] args) throws IOException {
        CaeserBreaker cb = new CaeserBreaker();
        CaesarCipher cc = new CaesarCipher();

        FileInput fi = new FileInput("src/com/sample/data.txt");
        String data = fi.readFile();


        System.out.println("Text: " + data);
        String Single = cc.encrypt(data, 15);
        String Double = cc.encryptTwoKeys(data, 21, 8);

//        System.out.println("Single Key(Encrypted): " + Single );
//        System.out.println("DECRYPTED: " + cc.encrypt(Single, 26-15));

        // not working
        System.out.println("\nDouble Key: " + data);
        System.out.println("DECRYPTED(Unknown Key): " + cb.decrypTwoKey(data));
//        System.out.println("DECRYPTED(Known Key): " + cc.encryptTwoKeys(data, 26-14, 26-24));
    }
    // 4
    // 8

    // Run like wild to beat the wind
    // Eren and Emily have evil eerie green ears
    // Geometric computing research at Duke
    // 17,4

//    Rpc ndj xbpvxct axut LXIWDJI iwt xcitgcti PCS rdbejitgh xc ndjg edrzti?
//     Xii twp duvodvz gqam EDBCWPB bcm qibzzimo VVY xwhxpbzzn dv gjcm kwxszb?
//The original name of Java was Oak.

//    The name of the Java Mascot is Duke. Woeoeee!
//Duke Computer Science Department Overview
//17,4
}
