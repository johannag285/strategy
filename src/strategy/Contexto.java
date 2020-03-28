/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

/**
 *
 * @author Johanna
 */
public class Contexto {

    private final ICiframiento iCiframiento;
    private CiframientoLlavePrivada llavePrivada;
    private CiframientoLlavePublica llavePublica;

    public Contexto(ICiframiento iCiframiento) {
        this.iCiframiento = iCiframiento;
    }

    public void ejecutarEstrategia(String texto, String Cifrar) {

        switch (Cifrar) {
            case "AES": {
                try {
                    System.out.println("\nMETODO AES");
                    System.out.println("Texto: "  + texto);
                    llavePrivada = (CiframientoLlavePrivada) this.iCiframiento;
                    llavePrivada.setLlavePrivada(iCiframiento.encriptar(texto));
                    System.out.println("Cifrado: " + llavePrivada.getLlavePrivada());
                    System.out.println("Descifrado: " + iCiframiento.desencriptar(llavePrivada.getLlavePrivada()));           
                } catch (Exception e) {
                    System.out.println("Exception" + e);
                }
                break;
            }
            case "DES": {
                try {
                    System.out.println("\nMETODO DES");
                    System.out.println("Texto: "  + texto);
                    llavePrivada = (CiframientoLlavePrivada) this.iCiframiento;
                    llavePrivada.setLlavePrivada(iCiframiento.encriptar(texto));
                    System.out.println("Cifrado: " + llavePrivada.getLlavePrivada());      
                    System.out.println("Descifrado: " + iCiframiento.desencriptar(llavePrivada.getLlavePrivada()));
                } catch (Exception e) {
                    System.out.println("Exception" + e);
                }
                break;
            }
            case "THREEDES": {
                try {
                    System.out.println("\nMETODO 3DES");
                    System.out.println("Texto: "  + texto);
                    llavePrivada = (CiframientoLlavePrivada) this.iCiframiento;
                    llavePrivada.setLlavePrivada(iCiframiento.encriptar(texto));
                    System.out.println("Cifrado: " + llavePrivada.getLlavePrivada());
                    System.out.println("Descifrado: " + iCiframiento.desencriptar(llavePrivada.getLlavePrivada()));
                } catch (Exception e) {
                    System.out.println("Exception" + e);
                }
                break;
            }
            case "RSA": {
                try {
                    System.out.println("\nMETODO RSA");
                    System.out.println("Texto: "  + texto);
                    llavePublica = (CiframientoLlavePublica) this.iCiframiento;
                    System.out.println("Cifrado: " + llavePublica.encriptar(texto));
                    System.out.println("Descifrado: " + llavePublica.desencriptar(this.llavePublica.getEncriptacion()));
                 
                } catch (Exception e) {
                    System.out.println("Exception" + e);
                }
                break;
            }
            case "ElGamal": {
                try {
                    System.out.println("Texto: "  + texto);
                    llavePublica = (CiframientoLlavePublica) this.iCiframiento;
                    System.out.println("\nCifrado:");
                    System.out.println(llavePublica.encriptar(texto));
                    System.out.println("\nDescifrado:");
                    System.out.println(llavePublica.desencriptar(this.llavePublica.getEncriptacion()));
                    System.out.println("");
                } catch (Exception e) {
                    System.out.println("Exception" + e);
                }

                break;
            }
            default: {
                System.out.println("No coincide");
            }
        }

    }

}
