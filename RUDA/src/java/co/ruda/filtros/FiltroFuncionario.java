
package co.ruda.filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Funcionario;

public class FiltroFuncionario implements Filter{
    
     private FilterConfig configuration;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.configuration=filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try{
        String tipo=((HttpServletRequest) request).getSession().getAttribute("tipo").toString();
        System.out.println("Tipo "+tipo);
        if(tipo!=null)
        {
            if(!tipo.equals("funcionario"))
            {
               // Instuctor instructor = (Instuctor) ((HttpServletRequest)request).getSession().getAttribute("usuario");
                ((HttpServletResponse)response).sendRedirect("faces/SesionInvalida.xhtml");
            }else{
                Funcionario funcionario =(Funcionario)((HttpServletRequest)request).getSession().getAttribute("usuario");
            
                if(funcionario!=null){
                    chain.doFilter(request, response);
                }else{
                    ((HttpServletResponse)response).sendRedirect("faces/SesionInvalida.xhtml");
                }
            
            }
        }
        }catch(NullPointerException e){
            ((HttpServletResponse)response).sendRedirect("faces/SesionInvalida.xhtml");
        }
    }

    @Override
    public void destroy() {
        this.configuration = null;
        
    }
    
}
