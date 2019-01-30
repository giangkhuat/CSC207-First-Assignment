
package firstAssignment;
import java.io.PrintWriter; 
import java.io.BufferedReader; 
import java.io.InputStreamReader; 



public class cipher {
    public static void  EncryptPart2(char[] str, char[] key){
        int stringSize = str.length;
        int keySize = key.length;
        int m = 0;
        PrintWriter pen = new PrintWriter(System.out, true);
        
        // if key is an empty string, do not encrypt and return 
        if (keySize == 0) {
        	return;
        }
        // else create a loop to encrypt each character by the key
        else {
        	for(int i = 0; i < stringSize; i++) {
        		// encrypting
        		int character = (int) str[i]; 
        		if (i != 0){
        			if ((i % keySize == 0) && (i >= keySize))
        			{
        				m = 0;
        			}
        		}
        		character = character - 97;
        		int keyNum = key[m] - 97;
        		character = ((character + keyNum) % 26); 
        		character = character + 97;
        		keyNum = keyNum + 97;
        		str[i] = (char) character;

        		m = m + 1;
        	}
        }
    }
    public static void  Decrypt(char[] str, char[] key){
        int stringSize = str.length;
        int keySize = key.length;
        int m = 0;
        PrintWriter pen = new PrintWriter(System.out, true);
        
        // if key is an empty string, do not decrypt and return 
        if (keySize == 0) {
        	return;
        }
        // else create a loop to decrypt each character by the key
        else {
        	for(int i = 0; i < stringSize; i++) {
        		// decrypting
        		int character = (int) str[i]; 
        		if (i != 0){
        			if ((i % keySize == 0) && (i >= keySize))
        			{
        				m = 0;
        			}
        		}
        		character = character - key[m];
        		if (character < 0){
        			character = character + 'z' - 'a' + 1;
        		}
        		character = character + 97;
        		str[i] = (char) character;
        		m = m + 1;
        	}
        }
    }
    public static void main(String[] args) throws Exception{

        BufferedReader eyes = new BufferedReader(new InputStreamReader( System.in));
        PrintWriter pen = new PrintWriter(System.out, true); 
        
        // encrypt
        pen.print("Enter a text to be encrypted: "); 
        pen.flush(); 
        String input = eyes.readLine(); 
        char[] str = input.toCharArray(); 
        pen.print("Enter a key to encrypt: ");
        pen.flush();
        String key = eyes.readLine();
        char[] keyArray = key.toCharArray();
        //KeyArray = new char(str.length);
        EncryptPart2(str, keyArray);
        pen.println(str);
        
        // decrypt 
        pen.print("Enter a text to be decrypted: "); 
        pen.flush();
        String input2 = eyes.readLine();
        char[] str2 = input2.toCharArray(); 
        pen.print("Enter a key to decrypt: ");
        pen.flush();
        
        String key2 = eyes.readLine();
        char[] keyArray2 = key2.toCharArray();
        
        Decrypt(str2, keyArray2);
        pen.println(str2);
    }
}
