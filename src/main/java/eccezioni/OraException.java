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
public class OraException extends Exception
{
    private int ora;
    private int minuti;
    
    public OraException(int ora, int minuti)
    {
        this.ora=ora;
        this.minuti=minuti;
    }

    public int getOra() 
    {
        return ora;
    }

    public int getMinuti() 
    {
        return minuti;
    }
    
    public String toString() 
    {
        return "L' orario "+getOra()+":"+getMinuti()+" non esiste";
    }
}
