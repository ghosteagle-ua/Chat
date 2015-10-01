
package com.mycompany.tutorial;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        resp.setContentType("text/html");
        Cookie []cookies = req.getCookies();
        
        for (Cookie c : cookies){
            if(c.getName().equals("auth")){
                c.setMaxAge(0);
                resp.addCookie(c);
            }
        }
        
        req.getSession().invalidate();
        resp.sendRedirect("./loginPage.html"); 
              
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    
    
    
    
    
}
