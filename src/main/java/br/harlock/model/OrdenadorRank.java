/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.model;

import java.util.Iterator;

/**
 *
 * @author kai
 */
public class OrdenadorRank  extends OrdenadorTemplate{

    public OrdenadorRank(Iterator lista) {
        super(lista);
        
    }

    @Override
    public boolean isPrimeiro(Titulo rank1, Titulo rank2) {
      if (rank1.getObra().compareToIgnoreCase(rank2.getObra()) <= 0){
            return true;
        }else{
          return false;
      }
        
    }

    
    
}
