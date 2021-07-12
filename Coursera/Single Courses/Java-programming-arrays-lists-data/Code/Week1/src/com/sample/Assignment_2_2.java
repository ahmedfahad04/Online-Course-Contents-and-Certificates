package com.sample;

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
    public static void main(String[] args) {
        CaeserBreaker cb = new CaeserBreaker();
        CaesarCipher cc = new CaesarCipher();
        String data = "Top ncmy qkff vi vguv vbg ycpx";
//        cb.testDecrypt(data);
//        System.out.println(cb.halfOfString("Qbkm Zgis", 1));

//        String info = cc.encryptTwoKeys(data, 2, 20);
        System.out.println(cb.decrypTwoKey("Top ncmy qkff vi vguv vbg ycpx"));
        System.out.println(cc.encryptTwoKeys("Top ncmy qkff vi vguv vbg ycpx", 26-2, 26-20));
    }
// 4
    // 8

    // Run like wild to beat the wind
    // Eren and Emily have evil eerie green ears
    // Geometric computing research at Duke
    // 17,4

}
