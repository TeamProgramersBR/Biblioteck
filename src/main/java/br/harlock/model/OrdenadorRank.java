/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.model;

/**
 *
 * @author kai
 */
public class OrdenadorRank  extends OrdenadorTemplate{

    @Override
    public boolean isPrimeiro(TelaRank rank1, TelaRank rank2) {
      if ((rank1.getQnt() > rank2.getQnt())){
            return true;
        }
        return false;
    }
    
}
