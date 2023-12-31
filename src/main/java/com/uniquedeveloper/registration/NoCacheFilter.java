package com.uniquedeveloper.registration;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NoCacheFilter
 */



@WebFilter("/*")
public class NoCacheFilter extends HttpServlet implements Filter {
	private static final long serialVersionUID = 1L;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Cast ServletResponse to HttpServletResponse
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Prevent caching in the browser
        httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        httpResponse.setHeader("Pragma", "no-cache");
        httpResponse.setHeader("Expires", "0");

        // Continue the filter chain
        chain.doFilter(request, httpResponse);
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed
    }
}

//public class NoCacheFilter extends HttpServlet implements Filter {
//	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public NoCacheFilter() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
	
//	    @Override
//	    public void init(FilterConfig filterConfig) throws ServletException {
//	        // Initialization code, if needed
//	    }
//
//	    @Override
//	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//	            throws IOException, ServletException {
//	        // Prevent caching in the browser
//	    	HttpServletResponse httpResponse = (HttpServletResponse) response;
//	        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
//	        response.setHeader("Pragma", "no-cache");
//	        response.setHeader("Expires", "0");
//
//	        // Continue the filter chain
//	        chain.doFilter(request, response);
//	    }
//
//	    @Override
//	    public void destroy() {
//	        // Cleanup code, if needed
//	    }
//	}