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
public class TTA {
    int idT;
    int idA;
    String tipo;

    public TTA() {
    }

    public TTA(int idT, int idA, String tipo) {
        this.idT = idT;
        this.idA = idA;
        this.tipo = tipo;
    }

    public int getIdT() {
        return idT;
    }

    public void setIdT(int idT) {
        this.idT = idT;
    }

    public int getIdA() {
        return idA;
    }

    public void setIdA(int idA) {
        this.idA = idA;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
