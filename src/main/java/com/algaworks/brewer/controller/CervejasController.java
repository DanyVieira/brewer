package com.algaworks.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CervejasController {

	//Aqui o controller devolve o nome da view
	@RequestMapping("/cervejas/novo")//qdo digitar isso na url ele retorna cadastro cerveja
	public String novo() {
		return "cerveja/CadastroCerveja"; //não coloque .html pois o template ja sabe que é html
	}

	
}
