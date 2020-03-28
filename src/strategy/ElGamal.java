/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.StringTokenizer;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author Johanna
 */
public class ElGamal extends CiframientoLlavePublica{
    
    
    
    	private BigInteger p,g,a,y, y1,y2, A;
        
	private Random r;

	public ElGamal(){
            
		r = new Random();
                
		p = new BigInteger("14893003337626352152463254152616458181260144281");
                
		g = new BigInteger("4893003337626352152463254152616458181260144281");
                
		a = new BigInteger("843900337326351225463254152616458181260144281");
                
		y = g.modPow(a,p);
                
		y1 = new BigInteger("0");
                
		y2 = new BigInteger("0");
                
	}
        
        public String bigEncrypt(String message,String key){
            
		StringTokenizer st = new StringTokenizer(key,"(),");
                
		p = new BigInteger(st.nextToken());
                
		g = new BigInteger(st.nextToken());
                
		y = new BigInteger(st.nextToken());
                
		return bigEncrypt(message);
	}

    

    private String bigEncrypt(String message) {
         
         byte[] b = message.getBytes();
         BigInteger[][] cipher = new BigInteger[b.length][2];
         for(int i= 0; i<b.length; i++){
             encrypt(new BigInteger(b[i] + ""));
             cipher[i][0] = y1;
             cipher[i][1] = y2;
         }
      
         return message;
    }
    
    /**
     *
     * @param a
     * @return
     */
    public BigInteger randomPrimeBigInteger(BigInteger a){
        Random random = new Random();
        int maxNumber = a.bitLength();
        BigInteger aRandom;
        do{
            aRandom = new BigInteger(maxNumber, random);
        }while(aRandom.compareTo(a) > 0 && aRandom.isProbablePrime(1));
        return aRandom;  
    }
    
    public void encrypt(BigInteger encriptar){
        BigInteger b = randomPrimeBigInteger(new BigInteger("29995224275833"));
        y = g.modPow(a, p);
        y1 = g.modPow(b, p);
        y2 = encriptar.xor(A.modPow(b, p));
    }

    @Override
    public String encriptar(String cleartext) throws NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException {
      return cleartext;
    }

    @Override
    public String desencriptar(String encrypted) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
