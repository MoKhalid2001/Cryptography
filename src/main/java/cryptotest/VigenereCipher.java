
package cryptotest;

public class VigenereCipher {
    private String plainText;
    private String Key;
    
    public VigenereCipher(String plainText , String Key){
        this.plainText = plainText;
        this.Key = Key;
    }
    
    public String Encrypt(){
        String res = "";
        int conv;
        int keyptr = 0;
        for(int i=0;i<plainText.length();i++){
            conv = (int) (plainText.charAt(i) - 'A') + (int) (Key.charAt(keyptr) - 'A');
            conv %= 26;
            res += (char) ('A' + conv);
            keyptr = (keyptr + 1 ) % (Key.length());
        }
        return res;
    }
    public String Decrypt(){
        String res = "";
        int conv;
        int keyptr = 0;
        for(int i=0;i<plainText.length();i++){
            conv = (int) (plainText.charAt(i) - 'A') - (int) (Key.charAt(keyptr) - 'A');
            conv = ((conv % 26 ) + 26) % 26;
            res += (char) ('A' + conv);
            System.out.println(conv);
            keyptr = (keyptr + 1 ) % (Key.length());
        }
        return res;
    }
}
