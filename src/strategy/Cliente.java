/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import java.math.BigInteger;

/**
 *
 * @author Johanna
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        Contexto contexto = new Contexto(new DES());
        contexto.ejecutarEstrategia("Hola mundo johanna gonzalez", "DES");

        Contexto contexto2 = new Contexto(new THREEDES());
        contexto2.ejecutarEstrategia("Hola mundo", "THREEDES");

        Contexto contexto3 = new Contexto(new AES());
        contexto3.ejecutarEstrategia("johanna gonzalez", "AES");

        Contexto contexto4 = new Contexto(new RSA());
        contexto4.ejecutarEstrategia("johanna ", "RSA");

        //Contexto contexto5 = new Contexto(new ElGamal());
        //contexto5.ejecutarEstrategia("johanna ", "ElGamal");

       
    }

}
