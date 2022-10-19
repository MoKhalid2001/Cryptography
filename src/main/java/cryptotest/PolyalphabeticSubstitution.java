
package cryptotest;

import java.util.HashMap;

public class PolyalphabeticSubstitution {
    private  String plainText;
    private  String oddLetters = "TMKGOYDSIPELUAVCRJWXZNHBQF";
    private  String evenLetters = "DCBAHGFEMLKJIZYXWVUTSRQPON";
    private HashMap<Character, Integer> oddMap = new HashMap<>();
    private HashMap<Character, Integer> evenMap = new HashMap<>();


    
    public PolyalphabeticSubstitution(String plainText){
        this.plainText = plainText;
    }

    public String Encrypt(){
        String res = "";
        int conv;
        for(int i=0;i<plainText.length();i++){
            conv = plainText.charAt(i) - 'A';
            if ((i+1) % 2 == 0) res += evenLetters.charAt(conv);
            else res += oddLetters.charAt(conv);
        }
        return res;
    }
    public String Decrypt(){
        String res = "";
        int conv;
         //Mapping :
        for(int i=0;i<oddLetters.length();i++){
            oddMap.put(oddLetters.charAt(i), i);
        }
        for(int i=0;i<evenLetters.length();i++){
            evenMap.put(evenLetters.charAt(i), i);
        }
        //Decoding : 
        for(int i=0;i<plainText.length();i++){
            if ((i+1) % 2 == 0) res += (char) (evenMap.get(plainText.charAt(i)) + 'A');
            else res += (char) (oddMap.get(plainText.charAt(i)) + 'A');
        }
        return res;
    }
}
