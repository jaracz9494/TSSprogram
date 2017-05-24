/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import base.DAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dominik
 */
public class DataList extends DAO {
    
    
    
    
    public List<String> wyswietlanie_uzytkownikow(){
        try{
            String adres;
            l = new ArrayList<String>();
            pobieranie_sterownikow();
            
            result=statement.executeQuery("select LOGIN from USERS");
            
            while(result.next()) {
                adres = result.getString(1);                
                l.add(adres);
                //System.out.println(adres);                 
            }           
            
            connection.close();
            return l;
            
        } catch(Exception ex){
            System.out.println("blad " + ex.getMessage());
            return null;
        }
    }
    
    
    public List<String> wyswietlanie_mieszkancow(){
        try{
            String adres;
            mieszkaniec = new ArrayList<String>();
            pobieranie_sterownikow();
            
            result=statement.executeQuery("select MIESZKANIEC from ADRESY");
            
            while(result.next()) {
                adres = result.getString(1);                
                mieszkaniec.add(adres);                 
            }           
            
            connection.close();
            return mieszkaniec;
            
        } catch(Exception ex){
            System.out.println("blad " + ex.getMessage());
            return null;
        }
    }
    
    public List<String> wyswietlanie_miejscowosci(){
        try{
            String adres;
            miejscowosc = new ArrayList<String>();
            pobieranie_sterownikow();
            
            result=statement.executeQuery("select ADRES from ADRESY");
            
            while(result.next()) {
                adres = result.getString(1);                
                miejscowosc.add(adres);                 
            }           
            
            connection.close();
            return miejscowosc;
            
        } catch(Exception ex){
            System.out.println("blad " + ex.getMessage());
            return null;
        }
    }
    
    
    public void wpisywanie(String mieszkaniec, String adres){
        try{
            pobieranie_sterownikow();
            
            statement.executeUpdate("INSERT INTO ADRESY VALUES ('" + mieszkaniec + "', '" + adres + "')");          
            
            connection.close();
            
        } catch(Exception ex){
            System.out.println("blad " + ex.getMessage());
        }
    }
    
    public void usuwanie(String mieszkaniec, String adres){
        try{
            pobieranie_sterownikow();
            
            statement.executeUpdate("DELETE FROM adresy WHERE MIESZKANIEC='" + mieszkaniec + "' and ADRES='" + adres + "'");          
            
            connection.close();
            
        } catch(Exception ex){
            System.out.println("blad " + ex.getMessage());
        }
    }
    
    public void usun(String nazwalaczna){
        System.out.println(nazwalaczna);
        String wynik1[] = null;
        wynik1 = nazwalaczna.split(" ");
        //System.out.println(wynik1[0]);
        //System.out.println(wynik1[1]);
        usuwanie(wynik1[0], wynik1[1]);
    }
    
}
