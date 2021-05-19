/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bonomi_clinica;

import eccezioni.*;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author Federico Bonomi
 */
public class Main 
{
    public static void main(String[] args) 
    {
        String nomeFileTesto="agenda.txt";
        String nomeFileBinario="agenda.bin";
        String[] vociMenu=new String[9];
        int sceltaUtente=-1;
        Scanner tastiera=new Scanner(System.in);
        Clinica c1=new Clinica();
        Appuntamento appuntamento;
        
        try
        {
            c1=c1.caricaAgenda(nomeFileBinario);
            System.out.println("\nDati caricati correttamente\n\n");
        }
        catch(FileException e1)
        {
            System.out.println(e1.toString());
        }
        catch(IOException e2)
        {
            System.out.println("\nErrore nella lettura del file");
        }
        
        vociMenu[0]="Esci";
        vociMenu[1]="Aggiungi appuntamento";
        vociMenu[2]="Visualizza visite";
        vociMenu[3]="Visualizza visite non svolte in ordine cronologico";
        vociMenu[4]="Visualizza visite non svolte in un detrminato giorno";
        vociMenu[5]="Esegui una visita";
        vociMenu[6]="Cancella una visita";
        vociMenu[7]="Salva gli appuntamenti in CSV";
        vociMenu[8]="Salva i dati in file binarioa\n";
        Menu menu=new Menu(vociMenu);
        
        do
        {
            try
            {
                sceltaUtente=menu.sceltaMenu();  
                switch(sceltaUtente)
                {
                    case 0:
                    {
                        System.out.println("L'applicazione verrà terminata");
                        break;
                    }
                    case 1:
                    {
                        try
                        {
                            appuntamento=new Appuntamento();
                            System.out.println("Nome Paziente -->");
                            appuntamento.setNomePaziente(tastiera.nextLine());
                            System.out.println("Cognome Paziente -->");
                            appuntamento.setCognomePaziente(tastiera.nextLine());
                            System.out.println("Nome Dottore -->");
                            appuntamento.setNomeDottore(tastiera.nextLine());
                            System.out.println("Cognome Dottore -->");
                            appuntamento.setCognomeDottore(tastiera.nextLine());
                            System.out.println("Anno della visita (non precedente al 2021) -->");
                            appuntamento.setAnno(tastiera.nextInt());
                            System.out.println("Mese della visita -->");
                            appuntamento.setMese(tastiera.nextInt());
                            System.out.println("Giorno della visita -->");
                            appuntamento.setGiorno(tastiera.nextInt());
                            System.out.println("Ora della visita (la clinica è aperta tra 8:30 e 20:30) -->");
                            appuntamento.setOra(tastiera.nextInt());
                            System.out.println("Minuti della visita (la clinica è aperta tra 8:30 e 20:30) -->");
                            appuntamento.setMinuti(tastiera.nextInt());
                            appuntamento.setIDVisita();
                            c1.aggiungiAppuntamento(appuntamento);
                            System.out.println("Inserimento avvenuto con successo");
                        }
                        catch(DataException e1)
                        {
                            System.out.println(e1.toString());
                        }
                        catch(OraException e2)
                        {
                            System.out.println(e2.toString());
                        }
                        catch(ClinicaChiusaException e3)
                        {
                            System.out.println(e3.toString());
                        }
                        catch(MassimoAppuntamentiException e4)
                        {
                            System.out.println(e4.toString());
                        }
                        System.out.println("\n\nPremi un pulsante per continuare...");
                        tastiera.nextLine();
                        tastiera.nextLine();
                        System.out.println("\n\n\n\n\n");
                        break;
                    }
                    case 2:
                    {
                        System.out.println("\n");
                        c1.visualizzaVisite();
                        System.out.println("\n\nPremi un pulsante per continuare...");
                        tastiera.nextLine();
                        System.out.println("\n\n\n\n\n");
                        break;
                    }
                    case 3:
                    {
                        System.out.println("\n");
                        try
                        {
                            c1.visulizzaAppuntamentiNonSvoltiCronologico();
                        }
                        catch(NessunAppuntamentoException e1)
                        {
                            System.out.println(e1.toString());
                        }
                        
                        System.out.println("\n\nPremi un pulsante per continuare...");
                        tastiera.nextLine();
                        System.out.println("\n\n\n\n\n");
                        break;
                    }
                    case 4:
                    {
                        int giorno,mese,anno;
                        System.out.println("Anno delle visite da visualizzare (non precedente al 2021) -->");
                        anno=tastiera.nextInt();
                        System.out.println("Mese delle visite da visualizzare -->");
                        mese=tastiera.nextInt();
                        System.out.println("Giorno delle visite da visualizzare -->");
                        giorno=tastiera.nextInt();
                        System.out.println("\n");
                        c1.visualizzaVisiteGiorno(giorno, mese, anno);
                        System.out.println("\n\nPremi un pulsante per continuare...");
                        tastiera.nextLine();
                        System.out.println("\n\n\n\n\n");
                        break;
                    }
                    case 5:
                    {
                        String nome,cognome;
                        System.out.println("Nome Paziente che vuole eseguire la visita -->");
                        nome=tastiera.nextLine();
                        System.out.println("Cognome Paziente che vuole eseguire la visita -->");
                        cognome=tastiera.nextLine();
                        try
                        {
                            c1.eseguiVisita(nome, cognome);
                        }
                        catch(NessunAppuntamentoException e1)
                        {
                            System.out.println(e1.toString(nome, cognome));
                        }
                        
                        System.out.println("\n\nPremi un pulsante per continuare...");
                        tastiera.nextLine();
                        tastiera.nextLine();
                        System.out.println("\n\n\n\n\n");
                        break;
                    }
                    case 6:
                    {
                        
                        System.out.println("\n\nPremi un pulsante per continuare...");
                        tastiera.nextLine();
                        tastiera.nextLine();
                        System.out.println("\n\n\n\n\n");
                        break;
                    }
                    case 7:
                    {
                        try
                        {
                            c1.esportaLibriCSV(nomeFileTesto);
                            System.out.println("Esportazione andata a buon fine");
                        }
                        catch(IOException e1)
                        {
                            System.out.println("Impossibile acedere al file");
                        }
                        catch (FileException e3) 
                        {
                            System.out.println(e3.toString());
                        }
                        System.out.println("\n\nPremi un pulsante per continuare...");
                        tastiera.nextLine();
                        System.out.println("\n\n\n\n\n");
                        break;
                    }
                    case 8:
                    {
                        try
                        {
                            c1.salvaAgenda(nomeFileBinario);
                            System.out.println("\nSalvataggio avvenuto con successo");
                        }
                        catch(IOException ex)
                        {
                            System.out.println("\nErrore nella scrittura del file");
                        }
                        
                        System.out.println("\n\nPremi un pulsante per continuare...");
                        tastiera.nextLine();
                        System.out.println("\n\n\n\n\n");
                        break;
                    }
                }
            }
            catch(InputMismatchException | NumberFormatException e1)
            {
                System.out.println("Input non corretto");
                tastiera.nextLine();
            } 
        }while(sceltaUtente!=0);
        
            
        
    }
}
