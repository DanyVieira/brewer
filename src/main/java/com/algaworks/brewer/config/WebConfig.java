package com.algaworks.brewer.config;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.algaworks.brewer.controller.CervejasController;

@Configuration // é uma classe de configuração
@ComponentScan(basePackageClasses = {CervejasController.class})//ensina spring como encontrar controller. Neste caso digo para encontrar
																//os controller dentro dessa classe cervejaController
@EnableWebMvc //abilita essa configuração para um projeto web mvc
public class WebConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware{
	
	private ApplicationContext applicationContext;
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext= applicationContext;
			
		
	}
	//ele consegue encontrar as paginas HTML  p processar dados.
    @Bean
	public ViewResolver ViewResolver() {
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();//
		resolver.setTemplateEngine(templateEngine());
		resolver.setCharacterEncoding("UTF-8");
		return resolver;
		
	}
	
	
	
	// templateEngine pega o template resolver e ira usa lo
	@Bean //com essa anotação a engine fica disponivel no contexto engine
	public TemplateEngine templateEngine() {
		SpringTemplateEngine engine = new SpringTemplateEngine();// engine é que consegue processar os arquivos html
		engine.setEnableSpringELCompiler(true);
		engine.setTemplateResolver(templateResolver());
		return engine;
		
	}
	
// configurações do THYMELEAF
	private ITemplateResolver templateResolver() {
		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();//Resolve os templates do spring
		resolver.setApplicationContext(applicationContext);
		resolver.setPrefix("classpath:/templates/");//onde estão os meus templates
		resolver.setSuffix(".html");
		resolver.setTemplateMode(TemplateMode.HTML);//modo dos templates
		return resolver;
		
		
	}


	
}
