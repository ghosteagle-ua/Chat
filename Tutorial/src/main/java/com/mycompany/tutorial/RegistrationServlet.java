/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tutorial;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        
        AcountService acountService = AcountService.getInstance();
        String username = req.getParameter("UserName");
        String password = req.getParameter("Password");
        
          
        if(username != null && password != null){
            
            Boolean check = acountService.userExist(username);
        
            if(!check){
                UserProfile userProfile = new UserProfile(username, password);
                acountService.addUser(userProfile);
            
                req.getSession(true).setAttribute("username", username);
                Cookie cookie = new Cookie("auth", "TRUE");
                cookie.setMaxAge(60*60*3);
                resp.addCookie(cookie);
                resp.getWriter().print("User with this data alredy exist"+" "+ username +" "+password+" "+check );
                resp.sendRedirect("./main.jsp");
            }else{
                resp.getWriter().print("User with this data alredy exist" );
            }
            
            }else{
                resp.sendRedirect("./registration.html");
            }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    
    
    
    
}
