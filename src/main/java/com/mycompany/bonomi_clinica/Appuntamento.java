/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bonomi_clinica;

import eccezioni.ClinicaChiusaException;
import eccezioni.DataException;
import eccezioni.OraException;
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
     * @throws DataException viene lanciato quando la data inserita non esiste
     * @throws OraException viene lanciato quando l'orario inserito non esiste
     * @throws ClinicaChiusaException viene lanciato quando nell'orario inserito la clinica è chiusa
     */
    public Appuntamento(String nomePaziente, String cognomePaziente, String nomeDottore, String cognomeDottore, int giorno, int mese, int anno, int ora, int minuti) throws DataException, OraException, ClinicaChiusaException
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
        
        dataOra=dataOra.of(anno, mese, giorno, ora, minuti);
        appuntamentiInseriti++;
        codiceIdentificativo=appuntamentiInseriti;
        this.nomePaziente=nomePaziente;
        this.cognomePaziente=cognomePaziente;
        this.nomeDottore=nomeDottore;
        this.cognomeDottore=cognomeDottore;
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
        dataOra=dataOra.of(2000, 1, 1, 1, 0);
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
     * Permette di inserire il giorno nel LocalDateTime
     * @param giorno il giorno dell'apppuntamento
     * @throws DataException viene lanciato quando la data non è valida
     */
    public void setGiorno(int giorno) throws DataException
    {
        int bisestile=getAnno()%4;
        if(getMese()==2)
        {
            if(bisestile==0 && (giorno<1 || giorno>29))
                throw new DataException(giorno, getMese(), getAnno());
            else if(bisestile!=0 && (giorno<1 || giorno>28))
                throw new DataException(giorno, getMese(), getAnno());
        }
        else if(getMese()==4 || getMese()==6 || getMese()==9 || getMese()==11)
        {
            if(giorno<1 || giorno>30)
                throw new DataException(giorno, getMese(), getAnno());
        }
        else if(getMese()<1 || getMese()>12)
            throw new DataException(giorno, getMese(), getAnno());
        else
            if(giorno<1 || giorno>31)
                throw new DataException(giorno, getMese(), getAnno());
        
        dataOra=dataOra.withDayOfMonth(giorno);        
    }
    
    /**
     * Permette di inserire il giorno nel LocalDateTime
     * @param mese il mese dell'appuntamento
     * @throws DataException viene lanciato quando la data non è valida
     */
    public void setMese(int mese) throws DataException
    {
        if(mese<1 || mese>12)
        {
            dataOra=dataOra.withDayOfMonth(1);
            throw new DataException(getGiorno(), mese, getAnno());
        }
        
        dataOra=dataOra.withMonth(mese);
    }
    
    /**
     * Permette di inserire l'anno nel LocalDateTime
     * @param anno l'anno dell'appuntamento
     * @throws DataException viene lanciato quando la data non è valida
     */
    public void setAnno(int anno) throws DataException
    {
        if(anno<2021)
        {
            dataOra=dataOra.withDayOfMonth(1);
            dataOra=dataOra.withMonth(1);
            throw new DataException(getGiorno(), getMese(), anno);
        }
            
        dataOra=dataOra.withYear(anno);
    }
    
    /**
     * Permette di inserire l'ora nel LocalDateTime
     * @param ora l'ora della visita
     * @throws OraException viene lanciato quando l'orario non è valido
     * @throws ClinicaChiusaException viene lanciato qual ora nell'orario inserito la clinica sia chiusa
     */
    public void setOra(int ora) throws OraException, ClinicaChiusaException
    {
        if(ora<0 || ora>23)
        {
            dataOra=dataOra.withMinute(0);
            throw new OraException(ora, getMinuti());
        }
        
        if(ora<8 || ora>20)
        {
            dataOra=dataOra.withMinute(0);
            throw new ClinicaChiusaException(ora, getMinuti());
        }
        
        dataOra=dataOra.withHour(ora);
            
    }
    
    /**
     * Permette di inserire i minuti nel LocalDateTime
     * @param minuti i minuti della visita
     * @throws OraException viene lanciato quando l'orario non è valido
     * @throws ClinicaChiusaException viene lanciato qual ora nell'orario inserito la clinica sia chiusa
     */
    public void setMinuti(int minuti) throws OraException, ClinicaChiusaException
    {
         if(minuti<0 || minuti>60)
            throw new OraException(getOra(), minuti);
         if((getOra()==8 || getOra()==20) && minuti<30)
            throw new ClinicaChiusaException(getOra(), minuti);
         
         dataOra=dataOra.withMinute(minuti);
    }
    
    /**
     * Permette di inserire un ID ad un'istanza che originalmente era vuota
     */
    public void setIDVisita()
    {
        appuntamentiInseriti++;
        codiceIdentificativo=appuntamentiInseriti;
    }
    
    /**
     * Simula l'esecuzione di una visita portando l'indicatore su true
     */
    public void esegui()
    {
        eseguita=true;
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
