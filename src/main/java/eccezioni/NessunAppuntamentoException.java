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
public class NessunAppuntamentoException extends Exception 
{
    public String toString()
    {
        return "Nessun Appuntamento insserito";
    }
    
    public String toString(String nome, String cognome)
    {
        return "Nessuna visita a nome: "+nome+" "+cognome;
    }
}
