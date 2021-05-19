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
     * Permette di istanziare un nuovo oggetto di Classe appuntamento nell'array agenda
     * @param nomePaziente è il nome che avrà il paziente
     * @param cognomePaziente è il cognome che avrà il paziente
     * @param nomeDottore è il nome che avrà il dottore
     * @param cognomeDottore è il cognome che avrà il dottore
     * @param giorno il giorno in cui si vuole prenotare la visita
     * @param mese il mese in cui si vuole prenotare la visita
     * @param anno l'anno in cui si vuole prenotare la visita
     * @param ora l'ora a cui si vuole prenotare la visita
     * @param minuti i in cui si vuole prenotare la visita
     * @throws DataException viene lanciato quando la data inserita non esiste
     * @throws OraException viene lanciato quando l'orario inserito non esiste
     * @throws ClinicaChiusaException viene lanciato quando nell'orario inserito la clinica è chiusa
     * @throws MassimoAppuntamentiException viene lanciato quando si è raggiunto il massimo di appuntamenti possibili da inserire
     */
    public void aggiungiAppuntamento(String nomePaziente, String cognomePaziente, String nomeDottore, String cognomeDottore, int giorno, int mese, int anno, int ora, int minuti) throws DataException, OraException, ClinicaChiusaException, MassimoAppuntamentiException
    {
        int bisestile=anno%4;
        if(mese==2)
        {
            if(bisestile==0 && (giorno<1 || giorno>29))
                throw new DataException(giorno, mese, anno);
            else if(bisestile!=0 && (giorno<1 || giorno>28))
                throw new DataException(giorno, mese, anno);
        }
        else if(mese==4 || mese==6 || mese==9 || mese==11)
        {
            if(giorno<1 || giorno>30)
                throw new DataException(giorno, mese, anno);
        }
        else if(mese<1 || mese>12)
            throw new DataException(giorno, mese, anno);
        else
            if(giorno<1 || giorno>31)
                throw new DataException(giorno, mese, anno);
        
        if(minuti<0 || minuti>60)
            throw new OraException(ora, minuti);
        else if(ora<0 || ora>23)
            throw new OraException(ora, minuti);
        
        if(ora<8 || ora>20)
            throw new ClinicaChiusaException(ora, minuti);
        else if((ora==8 || ora==20) && minuti<30)
            throw new ClinicaChiusaException(ora, minuti);
        
        if(getNumeroVisiteInserite()<getN_MAX_APPUNTAMENTI())
        {
            agenda[getNumeroVisiteInserite()]=new Appuntamento(nomePaziente, cognomePaziente, nomeDottore, cognomeDottore, giorno, mese, anno, ora, minuti);
            numeroVisiteInserite++;
        }
        else
            throw new MassimoAppuntamentiException();
            
    }
    
    
}
