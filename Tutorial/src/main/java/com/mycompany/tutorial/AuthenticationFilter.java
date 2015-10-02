/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tutorial;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.annotation.WebFilter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "/*", dispatcherTypes = DispatcherType.REQUEST)
public class AuthenticationFilter implements Filter{

    @Override
    public void init(FilterConfig fc) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        
        HttpServletRequest request = (HttpServletRequest)sr;
        HttpServletResponse response = (HttpServletResponse)sr1;
        
        String url = request.getRequestURI();
        Cookie []cookies = request.getCookies();
        Boolean isAuthCookie = Boolean.FALSE;
        String auth = "";
        String sessionID = "";
        
        if(url.contains("main.jsp")){
            for(Cookie c : cookies){
               if(c.getName().equals("auth")) auth = c.getValue();
               else if(c.getName().equals("JSESSIONID")) sessionID = c.getValue();
            }
            
            if(auth.equals("TRUE") 
                    && sessionID.equals(request.getSession().getId())){
                fc.doFilter(sr, sr1);
            }else /*response.sendRedirect("./loginPage.html")*/;
        }
        
        fc.doFilter(sr, sr1);   
    }

    @Override
    public void destroy() {
        
    }
    
    
    
}
