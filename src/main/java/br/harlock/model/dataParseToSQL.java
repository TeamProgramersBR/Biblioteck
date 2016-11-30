/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.model;
import java.text.SimpleDateFormat;

import java.sql.Date;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
/**
 *
 * @author kai
 */
public class dataParseToSQL {
    
    public java.sql.Date convertJavaDateToSqlDate(java.util.Date date) {
        
    return new java.sql.Date(date.getTime());
}
    
}
