/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bonomi_clinica;

import java.io.Serializable;
import java.time.*;
import java.util.Objects;

/**
 * La classe appuntamento rappresenta un appuntamento di uno studio medico.
 * Un appuntamento è costituito da un dodice identificativo univoco,
 * nome e cognome di paziente e dottore, data e ora della visita ed infine
 * una variabile che stabilisce se una visita è stata eseguita o no.
 * @author Federico Bonomi
 */
public class Appuntamento implements Serializable
{
    private int codiceIdentificativo;
    private String nomePaziente;
    private String cognomePaziente;
    private String nomeDottore;
    private String cognomeDottore;
    private LocalDateTime dataOra;
    private boolean eseguita=false;
    private static int appuntamentiInseriti=0;

    /**
     * Permette di istanziare un oggetto di classe Appuntamento
     * @param nomePaziente la stringa contenente il nome che si vuole dare al paziente
     * @param cognomePaziente la stringa contenente il cognome che si vuole dare al paziente
     * @param nomeDottore la stringa contenente il nome che si vuole dare al dottore
     * @param cognomeDottore la stringa contenente il cognome che si vuole dare al dottore
     * @param giorno il giorno in cui si vuole prenotare la visita
     * @param mese il mese in cui si vuole prenotare la visita
     * @param anno l'anno in cui si vuole prenotare la visita
     * @param ora l'ora a cui si vuole prenotare la visita
     * @param minuti i in cui si vuole prenotare la visita
     */
    public Appuntamento(String nomePaziente, String cognomePaziente, String nomeDottore, String cognomeDottore, int giorno, int mese, int anno, int ora, int minuti)
    {
        appuntamentiInseriti++;
        codiceIdentificativo=appuntamentiInseriti;
        this.nomePaziente=nomePaziente;
        this.cognomePaziente=cognomePaziente;
        this.nomeDottore=nomeDottore;
        this.cognomeDottore=cognomeDottore;
        dataOra=dataOra.of(anno, mese, giorno, ora, minuti);
    }
    
    /**
     * Permette di istanziare una copia indipendente di un oggetto
     * di classe Appuntamento
     * @param appuntamento L'istanza della classe appuntamento che si vuole copiare
     */
    public Appuntamento(Appuntamento a)
    {
        codiceIdentificativo=a.getCodiceIdentificativo();
        nomePaziente=a.getNomePaziente();
        cognomePaziente=a.getCognomePaziente();
        nomeDottore=a.getNomeDottore();
        cognomeDottore=a.getCognomeDottore();
        dataOra=a.dataOra.of(a.getAnno(),a.getMese(),a.getGiorno(),a.getOra(),a.getMinuti());
    }
    
    /**
     * Permette di Istanziare un aggetto della classe Appuntamento vuoto
     */
    public Appuntamento()
    {
        codiceIdentificativo=-1;
        nomePaziente=null;
        cognomePaziente=null;
        nomeDottore=null;
        cognomeDottore=null;
        dataOra=null;
    }
    
    /**
     * Restituisce il codice identificativo di un appuntamento
     * @return codiceIdentificativo
     */
    public int getCodiceIdentificativo() 
    {
        return codiceIdentificativo;
    }

    /**
     * Restituisce il nome del paziente
     * @return nomePaziente
     */
    public String getNomePaziente() 
    {
        return nomePaziente;
    }

    /**
     * restituisce il cognome del paziente
     * @return cognomePaziente
     */
    public String getCognomePaziente() 
    {
        return cognomePaziente;
    }

    /**
     * Restituisce il nome del dottore
     * @return nomeDottore
     */
    public String getNomeDottore() 
    {
        return nomeDottore;
    }

    /**
     * Restituisce il cognome del dottore
     * @return cognomeDottore
     */
    public String getCognomeDottore() 
    {
        return cognomeDottore;
    }

    /**
     * Restituisce il giorno dell'appuntamento
     * @return giorno
     */
    public int getGiorno() 
    {
        return dataOra.getDayOfMonth();
    }
    
    /**
     * Restituisce il mese dell'appuntamento
     * @return mese
     */
    public int getMese() 
    {
        return dataOra.getMonthValue();
    }

    /**
     * Restituisce il Anno dell'appuntamento
     * @return anno
     */
    public int getAnno() 
    {
        return dataOra.getYear();
    }
    
    /**
     * Restituisce l'ora dell'appuntamento
     * @return ora
     */
    public int getOra() 
    {
        return dataOra.getHour();
    }
    
    /**
     * Restituisce i minuti dell'appuntamento
     * @return minuti
     */
    public int getMinuti() 
    {
        return dataOra.getMinute();
    }
    
    /**
     * Restituisce se la visita è stata eseguita o no
     * @return true: visita eseguita<br>
     *         false: visita non ancora eseguita
     */
    public boolean isEseguita() 
    {
        return eseguita;
    }
    
    /**
     * Restituisce quanti appuntamenti sono stati inseriti
     * @return appuntamentiInseriti
     */
    public static int getAppuntamentiInseriti()
    {
        return appuntamentiInseriti;
    }

    /**
     * Permette di inserire il nome del paziente
     * @param nomePaziente 
     */
    public void setNomePaziente(String nomePaziente) 
    {
        this.nomePaziente = nomePaziente;
    }

    /**
     * Permette di inserire il cognome del paziente
     * @param cognomePaziente 
     */
    public void setCognomePaziente(String cognomePaziente) 
    {
        this.cognomePaziente = cognomePaziente;
    }

    /**
     * Permette di inserire il nome del dottore
     * @param nomeDottore 
     */
    public void setNomeDottore(String nomeDottore) 
    {
        this.nomeDottore = nomeDottore;
    }

    /**
     * Permette di inserire il cognome del dottore
     * @param cognomeDottore 
     */
    public void setCognomeDottore(String cognomeDottore) 
    {
        this.cognomeDottore = cognomeDottore;
    }

    /**
     * Permette di inserire data e ora di una visita
     * @param dataOra 
     */
    public void setDataOra(LocalDateTime dataOra) 
    {
        this.dataOra = dataOra;
    }

    /**
     * Traduce in una stringa un istanza della classe appuntamento
     * @return una string con le informazione di un istanza della classe appuntamento
     */
    public String toString() 
    {
        return "Appuntamento N. "+codiceIdentificativo+" { nome paziente="+nomePaziente+", cognome paziente="+cognomePaziente+", nome dottore="+nomeDottore+", cognome dottore="+cognomeDottore+", data="+dataOra.getDayOfMonth()+"/"+ dataOra.getMonthValue()+"/"+dataOra.getYear()+", ora="+dataOra.getHour()+":"+dataOra.getMinute() + ", eseguita=" + eseguita + '}';
    }
    
    
}
