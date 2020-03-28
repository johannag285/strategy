/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author Johanna
 */
public class RSA extends CiframientoLlavePublica {

    @Override
    public String encriptar(String cleartext) throws NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException {

        genKeyPair(512);

        byte[] encryptedBytes;

        Cipher cipher = Cipher.getInstance("RSA");

        cipher.init(Cipher.ENCRYPT_MODE, this.publicKey);

        encryptedBytes = cipher.doFinal(cleartext.getBytes());

        this.encriptacion = bytesToString(encryptedBytes);

        return bytesToString(encryptedBytes);
    }

    @Override
    public String desencriptar(String encrypted) throws Exception {
        byte[] decryptedBytes;

        Cipher cipher = Cipher.getInstance("RSA");

        cipher.init(Cipher.DECRYPT_MODE, this.privateKey);

        decryptedBytes = cipher.doFinal(stringToBytes(encrypted));

        return new String(decryptedBytes);

    }

    public void genKeyPair(int size) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");

        kpg.initialize(size);

        KeyPair kp = kpg.genKeyPair();

        PublicKey publicKeys = kp.getPublic();

        PrivateKey privateKeys = kp.getPrivate();

        this.privateKey = privateKeys;

        this.publicKey = publicKeys;
    }

    public String getPrivateKeyString() {

        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(this.privateKey.getEncoded());

        return bytesToString(pkcs8EncodedKeySpec.getEncoded());
    }

    public String getPublicKeyString() {

        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(this.publicKey.getEncoded());

        return bytesToString(x509EncodedKeySpec.getEncoded());
    }

    public String bytesToString(byte[] b) {

        byte[] b2 = new byte[b.length + 1];

        b2[0] = 1;

        System.arraycopy(b, 0, b2, 1, b.length);

        return new BigInteger(b2).toString(36);

    }

    public byte[] stringToBytes(String s) {

        byte[] b2 = new BigInteger(s, 36).toByteArray();

        return Arrays.copyOfRange(b2, 1, b2.length);

    }

}
