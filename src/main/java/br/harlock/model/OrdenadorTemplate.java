/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author kai
 */
public abstract class OrdenadorTemplate {
     public abstract boolean isPrimeiro(TelaRank rank1, TelaRank rank2);
 
    public Iterator ordenarTela(ArrayList<TelaRank> lista) {
        ArrayList<TelaRank> novaLista = new ArrayList<TelaRank>();
        for (TelaRank rank : lista) {
            novaLista.add(rank);
        }
 
        for (int i = 0; i < novaLista.size(); i++) {
            for (int j = i; j < novaLista.size(); j++) {
                if (!isPrimeiro(novaLista.get(i), novaLista.get(j))) {
                    TelaRank temp = novaLista.get(j);
                    novaLista.set(j, novaLista.get(i));
                    novaLista.set(i, temp);
                }
            }
        }
 
        return novaLista.iterator();
    }
}
