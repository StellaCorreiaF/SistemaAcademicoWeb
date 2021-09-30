package br.edu.ifs.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.DispatcherType;


/**
 * Servlet Filter implementation class FiltroAutenticacaoFrontEnd
 */
@WebFilter(dispatcherTypes= { DispatcherType.REQUEST }, urlPatterns = "/*")
public class FiltroAutenticacaoFrontEnd implements Filter {
	
	private HttpServletRequest httpRequest;

	private boolean ehUmaRequisicaoLogin;
	
	private static final String[] URLsNecessitamAutenticacao = {
			"/usuario", "/aluno"
	};
	

    /**
     * Default constructor. 
     */
    public FiltroAutenticacaoFrontEnd() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		httpRequest = (HttpServletRequest) request;
		
		String caminhoURL = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
		
		HttpSession sessao = httpRequest.getSession(false);
		
		boolean usuarioEstaAutenticado = (sessao !=null && sessao.getAttribute("usuarioAutenticado") != null);
		
		String loginURL = httpRequest.getContextPath() + "/autenticacao/Login.jsp";
		boolean ehUmaRequsicaoLogin = httpRequest.getRequestURI().equals(loginURL);
		boolean ehUmaPaginaLogin = httpRequest.getRequestURI().endsWith("Login.jsp");
		
		if (usuarioEstaAutenticado && (ehUmaRequisicaoLogin || ehUmaPaginaLogin)) {
			httpRequest.getRequestDispatcher("/home.html").forward(request, response);
		
			//O usu�rio j� est� autenticado e est� tentando logar novamente
			// em seguida, encaminhe para a pagina inicial
						
		} else if (!usuarioEstaAutenticado && ehNecessarioAutenticacao()) {
		//O usu�rio n�o est� autenticado e a p�gina solicitada requer autentica��o
			///autentica��o e, em seguida, encaminhe para a pagina de loign
			System.out.println("String2");
			String PaginaLogin = "/autenticacao/Login.jsp";
			RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(PaginaLogin);
			dispatcher.forward(request, response);
		
		} else {
			//Para outras p�ginas solicitadas que n�o requerem autentica�� o
			// ou o usu�rio j� est� logado, continue o fluxo de p�ginas
			System.out.println("String3");
			chain.doFilter(request, response);
		}
		
					
	}

	private boolean ehNecessarioAutenticacao() {
		String requestURL = httpRequest.getRequestURL().toString();
		
		for (String URL: URLsNecessitamAutenticacao) {
			if (requestURL.contains(URL)) {
				return true;
			}
		}
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
