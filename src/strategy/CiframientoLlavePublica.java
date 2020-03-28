/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author Johanna
 */
public abstract class CiframientoLlavePublica implements ICiframiento {

    protected PrivateKey privateKey = null;

    protected PublicKey publicKey = null;

    protected String encriptacion = null;

    public PrivateKey getPrivateKey() {

        return privateKey;
    }

    public void setPrivateKey(PrivateKey privateKey) {

        this.privateKey = privateKey;

    }

    public PublicKey getPublicKey() {

        return publicKey;

    }

    public void setPublicKey(PublicKey publicKey) {

        this.publicKey = publicKey;

    }

    public String getEncriptacion() {

        return encriptacion;
    }

    public void setEncriptacion(String encriptacion) {

        this.encriptacion = encriptacion;
    }


}
