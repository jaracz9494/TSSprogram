/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import javax.annotation.ManagedBean;

/**
 *
 * @author Dominik
 */
@ManagedBean
public class DAOchange extends DAO {
    
    private static String mieszk;
    private static String adr;

    public String getMieszk() {
        return mieszk;
    }

    public void setMieszk(String mieszk) {
        DAOchange.mieszk = mieszk;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        DAOchange.adr = adr;
    }
    
    
    public void gettingvalues(int pozycja) {
        
        mieszk = mieszkaniec.get(pozycja);
        adr = miejscowosc.get(pozycja);
        
        //System.out.println("mieszkaniec: " + mieszk + " adres: " + adr);
        
    }
    
    
    public void changevalues (String nowyMieszk, String nowyAdr) {
        System.out.println("stare dane: " + mieszk + " " + adr);
        System.out.println("nowe dane: " + nowyMieszk + " " + nowyAdr);
        
        try{
            pobieranie_sterownikow();
            
            statement.executeUpdate("UPDATE adresy SET MIESZKANIEC='" + nowyMieszk + "', ADRES='" + nowyAdr + "' WHERE MIESZKANIEC='" + mieszk + "' and ADRES='" + adr + "'");          
            
            connection.close();
            
        } catch(Exception ex){
            System.out.println("blad " + ex.getMessage());
        }
        
    }
}
