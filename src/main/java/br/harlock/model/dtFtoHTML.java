/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author kai
 */
public class dtFtoHTML {

    
    
    public String dtF(Date d1) throws ParseException{

        SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd");
        String data = out.format(d1);
        return data;
    }
}
