/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import static org.apache.commons.codec.binary.Base64.decodeBase64;
import static org.apache.commons.codec.binary.Base64.encodeBase64;

/**
 *
 * @author Johanna
 */
public class AES extends CiframientoLlavePrivada {

    // Definición del tipo de algoritmo a utilizar (AES, DES, RSA)
    private final static String alg = "AES";
    // Definición del modo de cifrado a utilizar
    private final static String cI = "AES/CBC/PKCS5Padding";

    // vector de inicialización usado en iv
    private final static String IV = "0123456789ABCDEF";
    //la llave en tipo String a utilizar
    private final static String Key = "92AE31A79FEEB2A3";

    /**
     * Función de tipo String que recibe el texto que se desea cifrar
     *
     * @param cleartext el texto sin cifrar a encriptar
     * @return el texto cifrado en modo String
     * @throws Exception puede devolver excepciones de los siguientes tipos:
     * NoSuchAlgorithmException, InvalidKeyException,
     * InvalidAlgorithmParameterException, IllegalBlockSizeException,
     * BadPaddingException, NoSuchPaddingException
     */
    @Override
    public String encriptar(String cleartext) throws NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(cI);
        SecretKeySpec skeySpec = new SecretKeySpec(Key.getBytes(), alg);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
        byte[] encrypted = cipher.doFinal(cleartext.getBytes());
        return new String(encodeBase64(encrypted));
    }

    /**
     * Función de tipo String que recibe el texto que se desea descifrar
     *
     * @param encrypted el texto cifrado en modo String
     * @return el texto desencriptado en modo String
     * @throws Exception puede devolver excepciones de los siguientes tipos:
     * NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
     * InvalidAlgorithmParameterException, IllegalBlockSizeException
     */
    @Override
    public String desencriptar(String encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance(cI);
        SecretKeySpec skeySpec = new SecretKeySpec(Key.getBytes(), alg);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes());
        byte[] enc = decodeBase64(encrypted.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);
        byte[] decrypted = cipher.doFinal(enc);
        return new String(decrypted);

    }

}
