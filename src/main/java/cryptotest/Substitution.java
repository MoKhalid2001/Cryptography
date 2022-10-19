/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cryptotest;
import java.util.HashMap;
public class Substitution {
    private HashMap<Character, Integer> smallMap = new HashMap<>();
    private HashMap<Character, Integer> capitalMap = new HashMap<>();
    private String plainText;
    private String cipherLettersCapital = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
    private String cipherLettersSmall = "ekmflgdqvzntowyhxuspaibrcj";
    
    public Substitution(String plainText){
        this.plainText = plainText;
    }
    private boolean isUpper(char ch){
        if (ch >= 'A' && ch <= 'Z') return true;
        return false;
    }
    private boolean isLower(char ch){
        if (ch >= 'a' && ch <= 'z') return true;
        return false;
    }
    public String Encrypt(){
        String res = "";
        int conv;
        for(int i=0;i<plainText.length();i++){
            if (isUpper(plainText.charAt(i))){
                   conv = plainText.charAt(i) - 'A';
                   res += cipherLettersCapital.charAt(conv);
               }
            if (isLower(plainText.charAt(i))){
                   conv = plainText.charAt(i) - 'a';
                   res += cipherLettersSmall.charAt(conv);
               }
        }
        return res;
    }
    public String Decrypt(){
        //Mapping :
        for(int i=0;i<cipherLettersCapital.length();i++){
            capitalMap.put(cipherLettersCapital.charAt(i), i);
        }
        for(int i=0;i<cipherLettersSmall.length();i++){
            smallMap.put(cipherLettersSmall.charAt(i), i);
        }
        //Decoding :
        String res = "";
        int idx;
        for(int i=0;i<plainText.length();i++){
            if (isUpper(plainText.charAt(i))){
                   idx = capitalMap.get(plainText.charAt(i));
                   res += (char)(idx + 'A');
               }
            if (isLower(plainText.charAt(i))){
                   idx = smallMap.get(plainText.charAt(i));
                   res += (char)(idx + 'a');
               }
        }
        return res;
    }
}
