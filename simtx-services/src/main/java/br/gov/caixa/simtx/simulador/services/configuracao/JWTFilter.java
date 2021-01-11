package br.gov.caixa.simtx.simulador.services.configuracao;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import br.gov.caixa.simtx.simulador.services.exception.ControleException;
import br.gov.caixa.simtx.simulador.services.util.jwt.JWTUtil;

public class JWTFilter implements Filter{
	
	private static final Logger logger = Logger.getLogger(JWTFilter.class);

	
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    	//init null
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN");

        String token = request.getHeader(JWTUtil.TOKEN_HEADER);

        if(token == null || token.trim().isEmpty()) {
        	logger.error("[SIMULADOR] Token nao informado");
            response.setStatus(401);
            return;
        }

        try {
            JWTUtil.validarToken(token);
            filterChain.doFilter(servletRequest, servletResponse);
        } 
        catch (ControleException e) {
        	logger.error("[SIMULADOR] " + e.getMensagem());
            response.setStatus(401);
        }
    }

    @Override
    public void destroy() {
    	//destroy null
    }
}