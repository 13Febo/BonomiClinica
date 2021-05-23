/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bonomi_clinica;

import eccezioni.MassimoAppuntamentiException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 * @author Federico
 */
public class ClinicaTest 
{
    Clinica c1;
    
    @Before
    public void istanzioClinica()
    {
        c1=new Clinica();
    }
    /**
     * Test of getNumeroVisiteInserite method, of class Clinica.
     */
    @Test
    public void testGetNumeroVisiteInserite() throws MassimoAppuntamentiException 
    {
        Appuntamento a1=new Appuntamento();
        
        int atteso=0;
        
        for(int i=0;i<atteso;i++)
        {
            c1.aggiungiAppuntamento(a1);
        }
        
        int attuale=c1.getNumeroVisiteInserite();
        
        assertEquals("Visite inserite", atteso, attuale);
    }

    /**
     * Test of getN_MAX_APPUNTAMENTI method, of class Clinica.
     */
    @Test
    public void testGetN_MAX_APPUNTAMENTI()
    {
        int atteso=100;
        int attuale=c1.getN_MAX_APPUNTAMENTI();
        
        assertEquals("Visite massime", atteso, attuale);
    }

    /**
     * Test of aggiungiAppuntamento method, of class Clinica.
     */
    @Test
    public void testAggiungiAppuntamento() throws Exception 
    {
        Appuntamento a1=new Appuntamento("Federico", "Bonomi", "Aldo", "Baglio", 11, 5, 2003, 13, 30);
        c1.aggiungiAppuntamento(a1);
    }

    /**
     * Test of visualizzaVisite method, of class Clinica.
     */
    @Test
    public void testVisualizzaVisite() throws Exception {
    }

    /**
     * Test of visulizzaAppuntamentiNonSvoltiCronologico method, of class Clinica.
     */
    @Test
    public void testVisulizzaAppuntamentiNonSvoltiCronologico() throws Exception {
    }

    /**
     * Test of visualizzaVisiteGiorno method, of class Clinica.
     */
    @Test
    public void testVisualizzaVisiteGiorno() {
    }

    /**
     * Test of eseguiVisita method, of class Clinica.
     */
    @Test
    public void testEseguiVisita() throws Exception {
    }

    /**
     * Test of eliminaPrenotazione method, of class Clinica.
     */
    @Test
    public void testEliminaPrenotazione() throws Exception {
    }

    /**
     * Test of esportaLibriCSV method, of class Clinica.
     */
    @Test
    public void testEsportaLibriCSV() throws Exception {
    }

    /**
     * Test of salvaAgenda method, of class Clinica.
     */
    @Test
    public void testSalvaAgenda() throws Exception {
    }

    /**
     * Test of caricaAgenda method, of class Clinica.
     */
    @Test
    public void testCaricaAgenda() throws Exception {
    }
    
}
