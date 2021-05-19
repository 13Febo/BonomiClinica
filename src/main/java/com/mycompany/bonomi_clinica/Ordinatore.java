/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bonomi_clinica;

/**
 *
 * @author Federico Bonomi
 */
public class Ordinatore 
{
    private static void scambia(Appuntamento v[], int posizione1, int posizione2)
    {
        Appuntamento c;
        c=v[posizione1];
        v[posizione1]=v[posizione2];
        v[posizione2]=c;
    }
    
    private static void scambia(int v[], int posizione1, int posizione2)
    {
        int c;
        c=v[posizione1];
        v[posizione1]=v[posizione2];
        v[posizione2]=c;
    }
    
    private static void scambia(String v[], int posizione1, int posizione2)
    {
        String c;
        c=v[posizione1];
        v[posizione1]=v[posizione2];
        v[posizione2]=c;
    }
    
    public static int[] selectionSortCrescente(int[] a)
    {
        int[] ordinato=new int[a.length];
        
        //creo vettore copia
        for(int i=0;i<a.length;i++)
            ordinato[i]=a[i];
        
        
        //applico l'algoritmo selection sort al vattore copia
        for(int i=0;i<ordinato.length-1;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j]<ordinato[i])
                    scambia(ordinato, i, j);
            }
        }
        
        return ordinato;         
    }
    
    public static int[] selectionSortDecrescente(int[] a)
    {
        int[] ordinato=new int[a.length];
        
        //creo vettore copia
        for(int i=0;i<a.length;i++)
            ordinato[i]=a[i];
        
         //applico l'algoritmo selection sort al vattore copia
        for(int i=0;i<ordinato.length-1;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j]>ordinato[i])
                    scambia(ordinato, i, j);
            }
        }
        
        return ordinato;         
    }
    
    //ordina un array di stringhe in ordine alfabetico
    public static String[] selectionSortCrescente(String[] a)
    {
        String[] ordinato=new String[a.length];
        
        //creo vettore copia
        for(int i=0;i<a.length;i++)
            ordinato[i]=a[i];
        
        
        //applico l'algoritmo selection sort al vattore copia
        for(int i=0;i<ordinato.length-1;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j].compareToIgnoreCase(ordinato[i])<0)
                    scambia(ordinato, i, j);
            }
        }
        
        return ordinato;         
    }
    
    //ordina un array di stringhe in ordine alfabetico inverso
    public static String[] selectionSortDecrescente(String[] a)
    {
        String[] ordinato=new String[a.length];
        
        //creo vettore copia
        for(int i=0;i<a.length;i++)
            ordinato[i]=a[i];
        
        
        //applico l'algoritmo selection sort al vattore copia
        for(int i=0;i<ordinato.length-1;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j].compareToIgnoreCase(ordinato[i])>0)
                    scambia(ordinato, i, j);
            }
        }
        
        return ordinato;         
    }
    
     //ordina un array di libri in ordine alfabetico di autore e titoli
    public static Appuntamento[] selectionSortCronologico(Appuntamento[] a)
    {
        Appuntamento[] ordinato=new Appuntamento[a.length];
        
        //creo vettore copia
        for(int i=0;i<a.length;i++)
            ordinato[i]=a[i];
        
        
        //applico l'algoritmo selection sort al vattore copia
        for(int i=0;i<ordinato.length-1;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                try
                {
                    if(ordinato[j].getAnno()<ordinato[i].getAnno())
                        scambia(ordinato, i, j);
                    else if(ordinato[j].getAnno()==ordinato[i].getAnno() && ordinato[j].getMese()<ordinato[i].getMese())
                        scambia(ordinato, i, j);
                    else if(ordinato[j].getAnno()==ordinato[i].getAnno() && ordinato[j].getMese()==ordinato[i].getMese() && ordinato[j].getGiorno()<ordinato[i].getGiorno())
                        scambia(ordinato, i, j);
                    else if(ordinato[j].getAnno()==ordinato[i].getAnno() && ordinato[j].getMese()==ordinato[i].getMese() && ordinato[j].getGiorno()==ordinato[i].getGiorno() && ordinato[j].getOra()<ordinato[i].getOra())
                        scambia(ordinato, i, j);
                    else if(ordinato[j].getAnno()==ordinato[i].getAnno() && ordinato[j].getMese()==ordinato[i].getMese() && ordinato[j].getGiorno()==ordinato[i].getGiorno() && ordinato[j].getOra()==ordinato[i].getOra() && ordinato[j].getMinuti()<ordinato[i].getMinuti())
                        scambia(ordinato, i, j);
                }
                catch(NullPointerException e)
                {
                    
                }
            }
        }
        
        return ordinato;         
    }
}
