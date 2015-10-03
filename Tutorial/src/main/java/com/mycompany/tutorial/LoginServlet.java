
package com.mycompany.tutorial;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet{

   
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        
        AcountService acountService = AcountService.getInstance();
        String username = req.getParameter("UserName");
        String password = req.getParameter("Password");

       
        if(username != null && password != null){
        
            Boolean check = acountService.checkProfileData(username, password);
        
            if(check){
                req.getSession(true).setAttribute("username", username);
                Cookie cookie = new Cookie("auth", "TRUE");
                cookie.setMaxAge(60*60*3);
                resp.addCookie(cookie);
                req.getRequestDispatcher("./main.jsp").forward(req, resp);
            }else{
                resp.getWriter().print("Not correct login or password" );
            }
        
        }else{
            req.getRequestDispatcher("./loginPage.jsp").forward(req, resp);
        }
        
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp); 
    }
    
    
   
}
