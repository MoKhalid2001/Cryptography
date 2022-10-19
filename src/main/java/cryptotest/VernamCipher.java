
package cryptotest;

import java.awt.BorderLayout;

public class VernamCipher {
    private String plainText;
    private String Key;
    private int zeroscount = 0;
    private int onescount = 0;
    private int runs = 1;
    private int gapslenght = 0;
    private int blockslength = 0;
    private  char cur;
    
   
    public VernamCipher(String plainText , String Key){
        this.plainText = plainText;
        this.Key = Key;
    }
    
    private boolean isG1(){
        //Check for number of zeros and ones :
        for(int i=0;i<Key.length();i++){
            if (Key.charAt(i) == '0') zeroscount++;
            else onescount++;
        }
       if (!(Math.abs(zeroscount - onescount) <= 1)) return false;
       return true;
    }
    
    private boolean isG2(){
        //Check for runs :
         for(int i=1;i<Key.length();i++){
            if (Key.charAt(i)!= Key.charAt(i-1))
                runs++;
        }
         int start = runs / 2;
        //Counting blocks and gaps : 
        int[] gapsfreq = new int[start+1];
        int[] blocksfreq = new int[start+1];
        
         cur = Key.charAt(0);
        if (cur == '0') gapslenght++;
        else blockslength++;
       
        for(int i=1;i<Key.length();i++){
           if (Key.charAt(i) == cur && cur == '0')
               gapslenght++;
           else if (Key.charAt(i) == cur && cur == '1')
               blockslength++;
           else {
               cur = Key.charAt(i);
               if (gapslenght != 0) gapsfreq[gapslenght-1]++;
               if (blockslength != 0) blocksfreq[blockslength-1]++;
               gapslenght = 0;
               blockslength = 0;
                if (cur == '0') gapslenght++;
                else blockslength++;    
           }
        }
        if (gapslenght != 0) gapsfreq[gapslenght-1]++;
        if (blockslength != 0) blocksfreq[blockslength-1]++;
        for(int i=0;i<=start;i++){
            if (gapsfreq[i] == blocksfreq[i] && gapsfreq[i] + blocksfreq[i] == start){
                start /= 2;
                continue;
            }
            else if ((gapsfreq[i] == 1 && blocksfreq[i] == 0) || (gapsfreq[i] == 0 && blocksfreq[i] == 1))
                continue;
            else if ((gapsfreq[i] == 0 && blocksfreq[i] == 0)) break;
            else return false;
        }
        return true;
        
    }
    public boolean isG3(){
        int ptr1 ,ptr2;
        int correct , wrong , ans = 0;
        String key2 = this.Key;
        for(int i=0;i<Key.length() - 1;i++){
            ptr1 = 0; ptr2 = (i+1) % (Key.length());
            correct = 0; wrong = 0;
            while(ptr1 < Key.length()){
                if (Key.charAt(ptr1) == key2.charAt(ptr2))
                    correct++;
                else wrong++;
                ptr1++;
                ptr2 = (ptr2 + 1) % (Key.length());
            }
            if (ans == 0){
                ans = correct - wrong;
            }
            else if (correct - wrong != ans){
                System.out.println(i);
                return false;
            }
        }
        return true;
    }
    public String Encrypt(){
        String res = "";
        if (!(isG1() && isG2() && isG3())){
        System.out.println("ERROR");
        return res;
        }
        for(int i=0;i<plainText.length();i++){
            int num1 = plainText.charAt(i) - '0';
            int num2 = Key.charAt(i) - '0';
            res += (char) ((num1 ^ num2) + '0');
        }
        return res;
    }

}
