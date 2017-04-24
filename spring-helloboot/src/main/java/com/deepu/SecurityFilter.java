/**
 * Author           : Deepu
 * Date Created     : Apr 12, 2017
 * Source File Name : SecurityFilter.java
 * Package Name     : com.deepu
 * 
 * 
 */
package com.deepu;

import org.springframework.core.Ordered;  
import org.springframework.core.annotation.Order;  
import org.springframework.stereotype.Component;  
  
import javax.servlet.*;  
import javax.servlet.http.HttpServletResponse;  
import java.io.IOException;  
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
/**
 *
 *
 * @author Deepu
 *
 */
	@Component  
	@Order(Ordered.HIGHEST_PRECEDENCE)  
	public class SecurityFilter implements Filter {  
	  
	    private static final boolean CONDITION = true;  
	  
	    private Logger log;
	    
	    @Override  
	    public void init(FilterConfig filterConfig) throws ServletException {  
	  
	    }  
	  
	    @SuppressWarnings("unused")
		@Override  
	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {  
	        if(CONDITION==true)  {
	        	
	        	 log = Logger.getLogger("clazz");
	        	 // Here we can add MDC also
	        	 
	        	 MDC.clear();
	 			MDC.put("testKey", "localHostName");
	 			
	 			
	 			Object object = MDC.get("testKey");
	 			
	 			log.debug("message");
	        	 
	        	 
	            chain.doFilter(request,response);  
	        
	    }
	        
	        
	        else{  
	            ((HttpServletResponse)response).setStatus(HttpServletResponse.SC_BAD_REQUEST);  
	        }  
	  
	    }  
	  
	    @Override  
	    public void destroy() {  
	  
	    }  
}
