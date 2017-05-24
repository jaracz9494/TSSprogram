/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import base.DataList;
import base.DAOchange;
import java.io.IOException;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dominik
 */

@WebServlet("/myservlet")
@ManagedBean
public class Actions extends HttpServlet {
    
    public String test;

    
    public List<String> getWypiszUzytk (){
        DataList zmiana = new DataList();
        return zmiana.wyswietlanie_uzytkownikow();
    
    }
    
    public void setStatic() {
        DataList zmiana = new DataList();
        zmiana.wpisywanie("nikt", "nigdzie");
    }
    
    public void delStatic() {
        DataList zmiana = new DataList();
        zmiana.usuwanie("nikt", "nigdzie");
    }
    
    public void wpisujdane(String mieszkaniec, String adres) {
        DataList zmiana = new DataList();
        zmiana.wpisywanie(mieszkaniec, adres);
        
    }
    
    public void usunwartosc(String nazwalaczna) {
        DataList zmiana = new DataList();
        zmiana.usun(nazwalaczna);
        
    }
    
    public void zmienwartosc(int wart) {
        DAOchange zmiana = new DAOchange();
        zmiana.gettingvalues(wart);
    }
    
    public void zaktualizuj(String mieszkaniec, String adres) {        
        DAOchange zmiana = new DAOchange();
        zmiana.changevalues(mieszkaniec, adres);
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Actions myClass = new Actions();
        
        if (request.getParameter("dodstat") != null) {
            myClass.setStatic();
        } else if (request.getParameter("usunstat") != null) {
            myClass.delStatic();
            
            
        } else if (request.getParameter("change") != null) {
            myClass.zmienwartosc(Integer.parseInt(request.getParameter("change")));
            request.getRequestDispatcher("/admin/change.jsp").forward(request, response);
            
        } else if (request.getParameter("update") != null) {
            
            String name = request.getParameter("name");
            String adres = request.getParameter("adress");
            
            if (name.contains(" ") || adres.contains(" ")){
                System.out.println("uzywaj nazw ciaglych");
            } else {
                myClass.zaktualizuj(name, adres);
            }
            
        } else if (request.getParameter("dodajMA") != null) {
            
            String name = request.getParameter("name");
            String adres = request.getParameter("adress");
            
            if (name.contains(" ") || adres.contains(" ")){
                System.out.println("uzywaj nazw ciaglych");
            } else {                
                myClass.wpisujdane(name, adres);
            }
            
        } else {
            DataList d = new DataList(); 
            List<String> mieszkancy = d.wyswietlanie_mieszkancow();
            List<String> miejscowosci = d.wyswietlanie_miejscowosci(); 
            
            for (int i=0; i<mieszkancy.size() || i<miejscowosci.size(); i++) {
                if (request.getParameter(Integer.toString(i)) != null){
                    String nazwylaczne = request.getParameter(Integer.toString(i));
                    myClass.usunwartosc(nazwylaczne);
                    break;                  
                }
            }
                 
        }
        
        request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
    }

}
