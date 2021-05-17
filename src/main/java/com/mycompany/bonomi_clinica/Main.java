/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bonomi_clinica;

/**
 *
 * @author Federico
 */
public class Main 
{
    public static void main(String[] args) 
    {
        //Test classe appuntamento
        Appuntamento a=new Appuntamento("Federico", "Bonomi", "Aldo", "Baglio", 13, 7, 2021, 15, 30);
        System.out.println(a.toString());
        Appuntamento b=new Appuntamento("Chiara", "Bonomi", "Giovanni", "Storti", 28, 2, 2022, 14, 5);
        System.out.println(b.toString());
        Appuntamento c=new Appuntamento(a);
        System.out.println(c.toString());
    }
}
