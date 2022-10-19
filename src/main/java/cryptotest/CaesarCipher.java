
package cryptotest;

public class CaesarCipher {
    private String plainText;
    private int key;
    
    public CaesarCipher(String plainText , int key){
        this.plainText = plainText;
        this.key = key;
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
        for(int i=0;i< plainText.length();i++){
               if (isUpper(plainText.charAt(i))){
                   conv = plainText.charAt(i) - 'A';
                   conv = (conv + key) % 26;
                   char ch = (char) (conv + 'A');
                   res += ch;
               }
               else if (isLower(plainText.charAt(i))){
                   conv = plainText.charAt(i) - 'a';
                   conv = (conv + key) % 26;
                   char ch = (char) (conv + 'a');
                   res += ch;
               } 
               else if (plainText.charAt(i)== ' '){res += ' ';}
        } 
        return res;
    }
    public String Decrypt(){
        String res = "";
        int conv;
        for(int i=0;i< plainText.length();i++){
               if (isUpper(plainText.charAt(i))){
                   conv = plainText.charAt(i) + 'A';
                   conv = ((conv - key) %26 + key) % 26;
                   char ch = (char) (conv + 'A');
                   res += ch;
               }
               else if (isLower(plainText.charAt(i))){
                   conv = plainText.charAt(i) + 'a';
                   conv = ((conv - key) %26 + key) % 26;
                   char ch = (char) (conv + 'a');
                   res += ch;
               } 
               else if (plainText.charAt(i)== ' '){res += ' ';}
        } 
        return res;
    }
}
