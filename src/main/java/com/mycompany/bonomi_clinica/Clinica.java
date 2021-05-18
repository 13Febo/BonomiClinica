/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bonomi_clinica;

import java.io.Serializable;

/**
 * Questa classe simula un agenda di una clinica.
 * Quest'agenda può contenere al massimo N_MAX_APPUNTAMENTI
 * ed ogni appuntamento è un istanza della classe Appuntamento.<br>
 * Gli attributi sono:<br>
 * agenda: array di Appuntamento<br>
 * numeroVisiteInserite: quante visite sono state inserite<br>
 * N_MAX_APPUNTAMENTI: il numero massimo di appuntamenti che possono essere inseriti
 * @author Federico Bonomi
 */
public class Clinica implements Serializable
{
    private int numeroVisiteInserite=0;
    private Appuntamento[] agenda;
    private final static int N_MAX_APPUNTAMENTI=100;

    /**
     * Permette l'istanza di un oggetto di classe Clinica
     */
    public Clinica()
    {
        agenda=new Appuntamento[getN_MAX_APPUNTAMENTI()];
        
        for(int i=0;i<getN_MAX_APPUNTAMENTI();i++)
        {
            agenda[i]=new Appuntamento();
        }
    }
    
    /**
     * Ritorna il numero di visite inserite
     * @return numeroVisiteInserite
     */
    public int getNumeroVisiteInserite() 
    {
        return numeroVisiteInserite;
    }

    /**
     * Ritorna il numero massimo di visite che possono essere inserite
     * @return 
     */
    public static int getN_MAX_APPUNTAMENTI() 
    {
        return N_MAX_APPUNTAMENTI;
    }
    
    /**
     * Ritorna una ppuntamento con un determinato identificativo
     * @param identificativo l'identificativo che ha l'appuntamento che si cerca
     * @return 
     */
    public Appuntamento getAppuntamento(int identificativo)
    {
        for(int i=0;i<getNumeroVisiteInserite();i++)
        {
            if(agenda[i].getCodiceIdentificativo()==identificativo)
            {
                return agenda[i];
            }
        }
        
        return null;
    }
    
    public void aggiungiAppuntamento(String nomePaziente, String cognomePaziente, String nomeDottore, String cognomeDottore, int giorno, int mese, int anno, int ora, int minuti)
    {
        
    }
    
    
}
