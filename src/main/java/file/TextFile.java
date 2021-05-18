/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import eccezioni.*;
import java.io.*;

/**
 *
 * @author Federico Bonomi
 */
public class TextFile 
{
    private char mode;
    private BufferedReader reader;
    private BufferedWriter writer;
    
    public TextFile(String nomeFile, char mode) throws IOException
    {
        this.mode='R';
        
        if(mode=='W' || mode=='w')
            this.mode='W';
        
        if(this.mode=='R')
            reader=new BufferedReader(new FileReader(nomeFile));
        else
            writer=new BufferedWriter(new FileWriter(nomeFile));
        
    }
    
    public TextFile(String nomeFile, char mode, boolean append) throws IOException
    {
        this.mode='R';
        
        if(mode=='W' || mode=='w')
            this.mode='W';
        
        if(this.mode=='R')
            reader=new BufferedReader(new FileReader(nomeFile));
        else
            writer=new BufferedWriter(new FileWriter(nomeFile, append));
        
    }
    
    public void toFile(String line) throws IOException, FileException
    {
        if(mode=='R')
            throw new FileException("\nImpossibile scrivere sul file, file aperto in lettura");
        writer.write(line);
        writer.newLine();
    }
    
    public String fromFile() throws IOException, FileException
    {
        String s="";
        if(mode=='W')
            throw new FileException("\nImpossibile leggere da file, file aperto in scrittura");
        
        s=reader.readLine();
        
        if(s==null)
            throw new FileException("\nRaggiunta la fine del file");
        
        return s;
    }
    
    public void close() throws IOException
    {
        if(mode=='R')
            reader.close();
        else
            writer.close();
    }
}
