/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Dominik
 */
public class DAO {
    public static ArrayList<String> l;
    public static ArrayList<String> mieszkaniec;
    public static ArrayList<String> miejscowosc;
    
    
    public java.sql.Connection connection;
    public Statement statement;
    public ResultSet result;
    //private String adres="../../../Baza/";
    private static final String Sterownik = "org.apache.derby.jdbc.ClientDriver";
    private static final String URL = "jdbc:derby://localhost:1527/baza";
    private static final String BLogin = "user1";
    private static final String BPass = "zaq1";    
        
    
    public void pobieranie_sterownikow() {
        try {
            Class.forName(Sterownik);
            connection = DriverManager.getConnection(URL, BLogin, BPass);
            statement = connection.createStatement();
            
                    
        } catch(Exception ex){
            System.out.println("blad pobierania sterownikow, adresu, loginu lub hasla" + ex.getMessage());
        }
    }
}
