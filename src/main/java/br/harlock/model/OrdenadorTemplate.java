/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 *
 * @author kai
 */
public abstract class OrdenadorTemplate {
    private Iterator listaI;

    public OrdenadorTemplate(Iterator lista) {
        listaI = lista;
    }
    
     public abstract boolean isPrimeiro(Titulo rank1, Titulo rank2);
 
    public Iterator ordenarTela() {
        ArrayList<Titulo> novaLista = new ArrayList<Titulo>();
        
        while (listaI.hasNext()) {
             novaLista.add((Titulo) listaI.next());
         }
 
        for (int i = 0; i < novaLista.size(); i++) {
            for (int j = i; j < novaLista.size(); j++) {
                if (!isPrimeiro(novaLista.get(i), novaLista.get(j))) {
                    Titulo temp = novaLista.get(j);
                    novaLista.set(j, novaLista.get(i));
                    novaLista.set(i, temp);
                }
            }
        }
        ArrayList<Titulo> verif = novaLista;
        return novaLista.iterator();
    }
}
