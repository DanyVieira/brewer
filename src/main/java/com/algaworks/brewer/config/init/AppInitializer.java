package com.algaworks.brewer.config.init;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.algaworks.brewer.config.WebConfig;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {// ESSE É o front controller
		// TODO Auto-generated method stub
		return new Class<?>[] {WebConfig.class};//Retorna a classe que ensina o spring achar os controllers
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String [] {"/"};//diz o que devo entregar ao despaher ou seja tudo quem vem depois dessa barra na URL!
	}

}
