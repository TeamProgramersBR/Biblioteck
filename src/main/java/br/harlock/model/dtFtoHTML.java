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

    
    
    public String dtF(Date d1){
        String dateStr=d1.toString();
        DateFormat readFormat = new SimpleDateFormat( "EEE MMM dd HH:mm:ss zzzz yyyy");

    DateFormat writeFormat = new SimpleDateFormat( "yyyy-MM-dd");
    Date date = null;
    try {
       date = readFormat.parse( dateStr );
    } catch ( ParseException e ) {
        e.printStackTrace();
    }

    String formattedDate = "";
    if( date != null ) {
    formattedDate = writeFormat.format( date );
    }
        return formattedDate;
    }
}
