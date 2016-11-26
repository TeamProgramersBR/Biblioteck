/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.model;
import java.security.*;
import java.math.*;

public class MD5 {
    
    
    public String toMD5(String s) throws NoSuchAlgorithmException{
       String pass;
       MessageDigest m=MessageDigest.getInstance("MD5");
       m.update(s.getBytes(),0,s.length());
       pass =new BigInteger(1,m.digest()).toString(16);
       return pass;
    }


}
