/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import javax.crypto.SecretKey;

/**
 *
 * @author Johanna
 */
public abstract class CiframientoLlavePrivada implements ICiframiento {

    private String llavePrivada = "";

    public SecretKey key;

    public String getLlavePrivada() {

        return llavePrivada;

    }

    public void setLlavePrivada(String LlavePrivada) {

        this.llavePrivada = LlavePrivada;

    }

    public SecretKey getKey() {

        return key;

    }

    public void setKey(SecretKey key) {

        this.key = key;

    }

   

}
