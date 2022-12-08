
package cryptotest;

import java.awt.font.TextAttribute;
import java.util.*;

public class CryptoTest {
public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int methodchoice , cryptochoice;
        String message;
        System.out.println("Choose the method u wanna use:");
        //Chosing method : 
        System.out.println("[1] Caesar Cipher.");
        System.out.println("[2] Substitution Cipher.");
        System.out.println("[3] Polyalphabetic Substitution Cipher.");
        System.out.println("[4] Vigenere Cipher.");
        System.out.println("[5] Vernam Cipher.");
        //Encryption and Decryption :
        methodchoice = input.nextInt(); 
        input.nextLine();
        System.out.println("[1] Encrypt,[2] Decrypt:");
        cryptochoice = input.nextInt();
        input.nextLine();
        //Entering message : 
        System.out.println("Enter the massage:");
        message = input.nextLine();
        convert(methodchoice, cryptochoice, message);
    }
    
    public static void convert( int methodchoice ,int cryptochoice ,String message){
        if (methodchoice ==1 && cryptochoice == 1){
            System.out.println(" Enter the key:");
            int key = input.nextInt();
            CaesarCipher txt = new CaesarCipher(message,key);
            System.out.println(txt.Encrypt());
        }
        else if (methodchoice ==1 && cryptochoice == 2){
            System.out.println("Enter the key:");
            int key = input.nextInt();
            CaesarCipher txt = new CaesarCipher(message,key);
            System.out.println(txt.Decrypt());
        } 
        else if (methodchoice == 2 && cryptochoice == 1){
                Substitution txt = new Substitution(message);
                System.out.println(txt.Encrypt());
        }
        else if (methodchoice == 2 && cryptochoice == 2){
                Substitution txt = new Substitution(message);
                System.out.println(txt.Decrypt());
        }
        else if (methodchoice == 3 && cryptochoice == 1){
                PolyalphabeticSubstitution txt = new PolyalphabeticSubstitution(message);
                System.out.println(txt.Encrypt());
        }
        else if (methodchoice == 3 && cryptochoice == 2){
                PolyalphabeticSubstitution txt = new PolyalphabeticSubstitution(message);
                System.out.println(txt.Decrypt());
        }
        else if (methodchoice == 4 && cryptochoice == 1){
                System.out.println("Enter the key:");
                String Key = input.next();
                VigenereCipher txt = new VigenereCipher(message,Key);
                System.out.println(txt.Encrypt());
        }
        else if (methodchoice == 4 && cryptochoice == 2){
                System.out.println("Enter the key:");
                String Key = input.next();
                VigenereCipher txt = new VigenereCipher(message,Key);
                System.out.println(txt.Decrypt());
        }
        else if (methodchoice == 5 && cryptochoice == 1){
                System.out.println("Enter the key:");
                String Key = input.next();
                VernamCipher txt = new VernamCipher(message,Key);
                System.out.println(txt.EncryptOrDecrypt());
        }
    }
}
