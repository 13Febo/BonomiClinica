/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bonomi_clinica;

import eccezioni.*;
import java.io.Serializable;
import java.time.*;

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
    
    /**
     * Permette di aggiungere un appuntamento
     * @param a l'appuntamento da inserie
     * @throws MassimoAppuntamentiException viene lanciato nel caso si siano raggiunti il massimo di appuntamenti
     */
    public void aggiungiAppuntamento(Appuntamento a) throws MassimoAppuntamentiException
    {
        if(getNumeroVisiteInserite()<getN_MAX_APPUNTAMENTI())
        {
            agenda[getNumeroVisiteInserite()]=new Appuntamento(a);
            numeroVisiteInserite++;
        }
        else
            throw new MassimoAppuntamentiException();
    }
    
    /**
     * Questo metodo mostra a schermo le visite non ancora svolte in ordine cronologico
     * @throws NessunAppuntamentoException 
     */
    public void visulizzaAppuntamentiNonSvoltiCronologico() throws NessunAppuntamentoException
    {
        if(numeroVisiteInserite==0)
            throw new NessunAppuntamentoException();
        
        Appuntamento[] ordinato=new Appuntamento[agenda.length];
        int o=0;
        
        for(int i=0;i<numeroVisiteInserite;i++)
        {
            if(agenda[i].isEseguita()==false)
            {
                ordinato[o]=agenda[i];
                o++;
            }
        }
        
        ordinato=Ordinatore.selectionSortCronologico(ordinato);
        
        for(int i=0;i<agenda.length;i++)
        {
            try
            {
                System.out.println(ordinato[i].toString());
            }
            catch(NullPointerException e)
            {
                
            }
        }
    }
    
    /**
     * Mostra a schermo le visite da eseguire in un determinato giorno
     * @param giorno giorno nel quale vuoi visulizzare le visite
     * @param mese mese nel quale vuoi visulizzare le visite
     * @param anno anno nel quale vuoi visulizzare le visite
     */
    public void visualizzaVisiteGiorno(int giorno, int mese, int anno)
    {
        int o=0;
        for(int i=0;i<getN_MAX_APPUNTAMENTI();i++)
        {
            if(agenda[i].getAnno()==anno && agenda[i].getMese()==mese && agenda[i].getGiorno()==giorno && agenda[i].isEseguita()==false)
            {
                System.out.println(agenda[i].toString());
                o++;
            }
        }
        if(o==0)
            System.out.println("\nNessuna visita presente per questo giorno");
    }
}
