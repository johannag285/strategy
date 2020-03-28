/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;


/**
 *
 * @author Johannna
 */
public class THREEDES extends CiframientoLlavePrivada {

    // Definición del tipo de algoritmo a utilizar (AES, DES, RSA)
    private final static String alg = "DESede";
    // Definición del modo de cifrado a utilizar
    private final static String cI = "DESede/CBC/PKCS5Padding";

    private final String MD5 = "5a3de55753ab1d33dcd0c76a662a0d28";

    private final String INI = "12345678901=";

    @Override
    public String encriptar(String cleartext) throws NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException {
        try {
            byte[] keyBytes = DatatypeConverter.parseBase64Binary(MD5);

            byte[] ivBytes = DatatypeConverter.parseBase64Binary(INI);

            SecretKey keyEncriptar = new SecretKeySpec(keyBytes, alg);
            IvParameterSpec iv = new IvParameterSpec(ivBytes);
            Cipher cipher = Cipher.getInstance(cI, "SunJCE");
            cipher.init(Cipher.ENCRYPT_MODE, keyEncriptar, iv);

            byte[] plainTextBytes;
            plainTextBytes = cleartext.getBytes("utf-8");
            byte[] cipherText = cipher.doFinal(plainTextBytes); // Encriptar

            String strreturn = DatatypeConverter.printBase64Binary(cipherText);

            return strreturn;
        } catch (UnsupportedEncodingException | NoSuchProviderException ex) {
            Logger.getLogger(THREEDES.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String desencriptar(String encrypted) throws Exception {
        
        byte[] message = DatatypeConverter.parseBase64Binary(encrypted);
        byte[] keyBytes = DatatypeConverter.parseBase64Binary(MD5);
        byte[] ivBytes = DatatypeConverter.parseBase64Binary(INI);

        SecretKey keyDesencriptar = new SecretKeySpec(keyBytes, alg);
        IvParameterSpec iv = new IvParameterSpec(ivBytes);
        Cipher decipher = Cipher.getInstance(cI, "SunJCE");
        decipher.init(Cipher.DECRYPT_MODE, keyDesencriptar, iv);

        byte[] plainText = decipher.doFinal(message); // Desencriptar
        String strreturn = new String(plainText, "UTF-8");
        return strreturn;
    }

}
