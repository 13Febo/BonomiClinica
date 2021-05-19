/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bonomi_clinica;

import eccezioni.*;

/**
 *
 * @author Federico Bonomi
 */
public class Main 
{
    public static void main(String[] args) 
    {
        //Test classe appuntamento
        /*Appuntamento a=new Appuntamento("Federico", "Bonomi", "Aldo", "Baglio", 29, 2, 2021, 15, 30);
        Appuntamento b=new Appuntamento("Chiara", "Bonomi", "Giovanni", "Storti", 28, 2, 2022, 14, 5);
        Appuntamento c=new Appuntamento(a);*/
        Clinica c1=new Clinica();
        try
        {
            c1.aggiungiAppuntamento("Federico","Bonomi", "Aldo", "Baglio", 30, 4, 2021, 8, 35);
            System.out.println("Inserimento andato a buon fine");
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
        
    }
}
