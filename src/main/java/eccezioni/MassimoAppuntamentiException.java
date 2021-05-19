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
public class MassimoAppuntamentiException extends Exception
{
    public String toString() 
    {
        return "Non possono essere aggiunti altri appuntamenti perchè abbiamo raggiunto il massimo";
    }
}
