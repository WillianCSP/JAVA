package br.com.exemplo;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class ValidarSessaoFilter
 */
@WebFilter(filterName = "validarSessaoFilter", urlPatterns={"/meu-servlet"})
public class ValidarSessaoFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ValidarSessaoFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
    @Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
		Object nullCheck = ((HttpServletRequest)request).getSession().getAttribute(LoginService.ATRIBUTO_USUARIO);
		String usuario = null;
		if(nullCheck != null){
			usuario = nullCheck.toString();
		}
		
		if(usuario != null && !usuario.equals("")){
			chain.doFilter(request, response);
		}else{
			
			((HttpServletResponse) response).sendRedirect("./index.html");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
