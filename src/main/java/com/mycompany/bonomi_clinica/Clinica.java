/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bonomi_clinica;

import eccezioni.*;
import file.TextFile;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.*;
import java.util.InputMismatchException;
import java.util.Scanner;

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
    private final int N_MAX_APPUNTAMENTI=100;

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
    public int getN_MAX_APPUNTAMENTI() 
    {
        return N_MAX_APPUNTAMENTI;
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
     * Visualizza tutte le visite a schermo sia svolte che non svolte
     */
    public void visualizzaVisite() throws NessunAppuntamentoException
    {
        if(numeroVisiteInserite==0)
            throw new NessunAppuntamentoException();
        for(int i=0;i<numeroVisiteInserite;i++)
        {
            System.out.println(agenda[i].toString());
        }
        System.out.println("\n");
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
    
    /**
     * Simula l'esecuzione di una visita
     * @param nome il nome del paziente che vuole eseguire la visita
     * @param cognome il cognome del paziente che vuole eseguire la visita
     * @throws NessunAppuntamentoException lanciata quando non viene trovato nessun paziente con tale nome
     */
    public void eseguiVisita(String nome, String cognome) throws NessunAppuntamentoException
    {
        int o=0;
        int identificativo=-1;
        boolean corretto=false;
        Scanner tastiera=new Scanner(System.in);
        
        for (int i=0;i<numeroVisiteInserite;i++)
        {
            if(agenda[i].getNomePaziente().compareToIgnoreCase(nome)==0 && agenda[i].getCognomePaziente().compareToIgnoreCase(cognome)==0 && agenda[i].isEseguita()==false)
                o++;
        }
        
        if(o==0)
            throw new NessunAppuntamentoException();
        
        int[] array=new int[o+1];
        o=0;
        
        for (int i=0;i<numeroVisiteInserite;i++)
        {
            if(agenda[i].getNomePaziente().compareToIgnoreCase(nome)==0 && agenda[i].getCognomePaziente().compareToIgnoreCase(cognome)==0 && agenda[i].isEseguita()==false)
            {
                array[o]=agenda[i].getCodiceIdentificativo();
                o++;
            }
        }
        
            
        
        do 
        {
            System.out.println("\n");
            for (int i=0;i<numeroVisiteInserite;i++)
            {
                for(int j=0;j<numeroVisiteInserite;j++)
                {
                    if(agenda[j].getCodiceIdentificativo()==array[i])
                    {
                        System.out.println(agenda[j].toString());
                    }
                }
            }
            
            System.out.println("\nInserisci il numero della visita che vuoi eseguire --> ");
            try
            {
                identificativo=tastiera.nextInt();
            }
            catch(InputMismatchException | NumberFormatException e1)
            {
                System.out.println("Input non corretto...\nReinserisci:");
                tastiera.nextLine();
                tastiera.nextLine();
                continue;
            }
            
            for(int i=0;i<array.length;i++)
            {
                if(identificativo==array[i])
                    corretto=true;
            }
            
            if(corretto==false)
            {
                System.out.println("\nErrore, identificativo non valido: riprova...");
                tastiera.nextLine();
                tastiera.nextLine();
            }
        }while(corretto==false);
        
        for (int i=0;i<numeroVisiteInserite;i++)
        {
            if(agenda[i].getCodiceIdentificativo()==identificativo)
            {
                System.out.println(agenda[i].toString());
                agenda[i].esegui();
                System.out.println("Esecuzione in corso....");
                tastiera.nextLine();
                tastiera.nextLine();
            }
        }
    }
    
    /**
     * Permette di eliminare una visita prenotata e non ancora eseguita
     * @param nome il nome del paziente che vuole eliminare la visita
     * @param cognome il cognome del paziente che vuole eliminare la visita
     * @throws NessunAppuntamentoException viene lanciato nel caso non ci siano pazienti con questo nome
     */
    public void eliminaPrenotazione(String nome, String cognome) throws NessunAppuntamentoException
    {
        int o=0;
        int identificativo=-1;
        boolean corretto=false;
        Scanner tastiera=new Scanner(System.in);
        
        for (int i=0;i<numeroVisiteInserite;i++)
        {
            if(agenda[i].getNomePaziente().compareToIgnoreCase(nome)==0 && agenda[i].getCognomePaziente().compareToIgnoreCase(cognome)==0 && agenda[i].isEseguita()==false)
                o++;
        }
        
        if(o==0)
            throw new NessunAppuntamentoException();
        
        int[] array=new int[o+1];
        o=0;
        
        for (int i=0;i<numeroVisiteInserite;i++)
        {
            if(agenda[i].getNomePaziente().compareToIgnoreCase(nome)==0 && agenda[i].getCognomePaziente().compareToIgnoreCase(cognome)==0 && agenda[i].isEseguita()==false)
            {
                array[o]=agenda[i].getCodiceIdentificativo();
                o++;
            }
        }
        
            
        
        do 
        {
            System.out.println("\n");
            for (int i=0;i<array.length;i++)
            {
                for(int j=0;j<numeroVisiteInserite;j++)
                {
                    if(agenda[j].getCodiceIdentificativo()==array[i])
                    {
                        System.out.println(agenda[j].toString());
                    }
                }
            }
            
            System.out.println("\nInserisci il numero della visita che vuoi eseguire --> ");
            try
            {
                identificativo=tastiera.nextInt();
            }
            catch(InputMismatchException | NumberFormatException e1)
            {
                System.out.println("Input non corretto...\nReinserisci:");
                tastiera.nextLine();
                tastiera.nextLine();
                continue;
            }
            
            for(int i=0;i<array.length;i++)
            {
                if(identificativo==array[i])
                    corretto=true;
            }
            
            if(corretto==false)
            {
                System.out.println("\nErrore, identificativo non valido: riprova...");
                tastiera.nextLine();
                tastiera.nextLine();
            }
        }while(corretto==false);
        
        int j=-1;
        
        for (int i=0;i<numeroVisiteInserite;i++)
        {
            if(agenda[i].getCodiceIdentificativo()==identificativo)
            {
                j=i;
            }
        }
        
        for(int i=j;j<numeroVisiteInserite;i++)
        {
            agenda[i]=new Appuntamento(agenda[i+1]);
            if(agenda[i].getCodiceIdentificativo()==-1)
                break;
        }
        
        numeroVisiteInserite--;
    }
    
    /**
     * Permette di esportare i dati di tutti gli appuntamenti in un file di testo con formato CSV
     * @param nomeFileTesto è il nome che avrà il file di testo
     * @throws IOException
     * @throws FileException 
     */
    public void esportaLibriCSV(String nomeFileTesto) throws IOException, FileException
    {
        TextFile f1=new TextFile(nomeFileTesto, 'w');
         
        for(int i=0;i<getN_MAX_APPUNTAMENTI();i++)
        {
            if(agenda[i].getCodiceIdentificativo()!=-1)
            {
                f1.toFile(agenda[i].getCodiceIdentificativo()+";"+agenda[i].getNomePaziente()+";"+agenda[i].getCognomePaziente()+";"+agenda[i].getNomeDottore()+";"+agenda[i].getCognomeDottore()+";"+agenda[i].getGiorno()+";"+agenda[i].getMese()+";"+agenda[i].getAnno()+";"+agenda[i].getOra()+";"+agenda[i].getMinuti()+";"+agenda[i].isEseguita()+";");
            }
        }
        f1.close();
    }
    
    /**
     * Permette di salvare i dati in formato binario
     * @param nomeFile è il nome che avrà il file binario
     * @throws IOException 
     */
    public void salvaAgenda(String nomeFile) throws IOException
     {
        FileOutputStream f1=new FileOutputStream(nomeFile);
        ObjectOutputStream writer=new ObjectOutputStream(f1);
        writer.writeObject(this);
        writer.flush();
        writer.close();
     }
    
    /**
     * Carica i dati della clinica da un file binario
     * @param nomeFile il nome del file da cui caricare i dati
     * @return la clinica con i dati caricati
     * @throws IOException
     * @throws FileException 
     */
    public Clinica caricaAgenda(String nomeFile) throws IOException, FileException
     {
        Clinica c=null;
        FileInputStream f1=new FileInputStream(nomeFile);
        ObjectInputStream reader=new ObjectInputStream(f1);
        
        try
        {
            c=(Clinica)reader.readObject();
            reader.close();
        }
        catch(ClassNotFoundException ex)
        {
            reader.close();
            throw new FileException("Errore di lettura");
        }
        
        
        for(int i=0;i<c.getN_MAX_APPUNTAMENTI();i++)
        {
            if(c.agenda[i].getCodiceIdentificativo()==-1)
            {
                Appuntamento.setProssimoId(c.agenda[i-1].getCodiceIdentificativo());
                break;
            }
        }
        
        return c;
     }
}
