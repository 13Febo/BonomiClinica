/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eccezioni;

/**
 *
 * @author Federico Bonomi
 */
public class DataException extends Exception
{
    private int giorno;
    private int mese;
    private int anno;
    
    public DataException(int giorno, int mese, int anno)
    {
        this.giorno=giorno;
        this.mese=mese;
        this.anno=anno;
    }

    public int getGiorno() 
    {
        return giorno;
    }

    public int getMese() 
    {
        return mese;
    }

    public int getAnno() 
    {
        return anno;
    }
    
    public String toString() 
    {
        return "La data "+getGiorno()+"/"+getMese()+"/"+getAnno()+" non è valida";
    }
    
    
}
