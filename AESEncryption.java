/*
 * AES Encryption using 32 characters long key.
 */

import java.math.BigInteger;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Ali Adnan Aslam
 */
public class COMM044Coursework6502115 {
    
    // Main function 
    public static void main(String[] args) {
        
        String str = "Battersea Polytechnic Institute";     //String to encrypt
        String key = "95f4baee029feb5a92bff11bdc5bddd4";    //Encryption key
        
        try {
            aead(str, key);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    /**
     * aead function provides the encryption of plain text to Cipher text in bytes
     * @param str this is the plain text string which is going to encrypt
     * @param hexKey this is the encryption key
     * @throws Exception 
     */
    
    public static void aead(String str, String hexKey) throws Exception {
        
        // Converting key from hex to bytes
        byte[] key  = new BigInteger (hexKey,16).toByteArray();
        
        // Assuring the key length
        if (key.length > 16 ) {
            key = Arrays.copyOfRange (key, 1, key.length); 
        }     
        if (key.length != 16 ) throw new Exception ("key length wrong!");
        
        // For the sack of secure key generating IV's initialized to zero
        byte[] IV = new byte[16];
        
        // Converting the plain text to bytes
        byte[] plainbytes = str.getBytes("UTF-8");
        
        /*
         * ENCRYPT: we need to add zero padding ourself since JCE doesn't do that
         * Java makes this easy because arrays are initialized to all-zeros
         */
        if( plainbytes.length %16 !=0 ) {
            plainbytes = Arrays.copyOf (plainbytes, (plainbytes.length /16 +1)*16);
        }
        Cipher aes = Cipher.getInstance ("AES/CBC/NoPadding");
        aes.init (Cipher.ENCRYPT_MODE, new SecretKeySpec (key, "AES"), new IvParameterSpec (IV));
        byte[] cipherbytes = aes.doFinal (plainbytes);
        
        //Displaying the output to screen
        System.out.println("The encryption and IV of \"Battersea Polytechnic Institute\" are: " +
                new BigInteger (1,cipherbytes).toString(16) + " - " +
                IV);
    }
}
