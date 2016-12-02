/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.model;

import br.harlock.dao.TituloDAO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.junit.Test;

/**
 *
 * @author kai
 */
public class teste_dat {

    public teste_dat() {
    }
    @Test
    public void testReserva() throws Exception{
        System.out.println("data");
//        TituloDAO dao = new TituloDAO();
//        Titulo titulo = new Titulo(1, 1, 1, null, null, null, null, null, null, null, null, null, null, null);
//        Titulo t = dao.Pesquisar(titulo);
//        //11/11/2016 00:00:00
//        //EEE MMM dd HH:mm:ss zzzz yyyy
//        SimpleDateFormat in= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//        SimpleDateFormat out = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy",Locale.US);
//
//        String result = out.format(in.parse(t.getDataDePublicacao().toString()));
//        
//        String r = result;
        
        
        
        
        
        String dateStr = "11/11/2016 00:00:00";
    DateFormat readFormat = new SimpleDateFormat( "dd/MM/yyyy HH:mm:ss");

    DateFormat writeFormat = new SimpleDateFormat( "EEE MMM dd HH:mm:ss z yyyy");
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

    System.out.println(formattedDate);
        
        
        
        
        
    }
    
}
