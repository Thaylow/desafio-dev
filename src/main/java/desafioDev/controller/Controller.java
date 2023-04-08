package desafioDev.controller;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.io.Resources;

import desafioDev.entidade.DesafioDevResponse;
import desafioDev.service.DesafioDevService;
import lombok.var;

@RestController
@RequestMapping("/api")
public class Controller {

	@Autowired
	DesafioDevService desafioDevService;
	
	private static final String ARQUIVO_TXT = "CNAB.txt";

	/**
	 * @author Thaylow Viana Método chamado pelo Cron da classe Schedule.java
	 * @throws ParseException 
	 */
	@CrossOrigin
	@PostMapping(value = "/lerArquivoTxt/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<DesafioDevResponse> lerArquivoTxt() throws IOException, ParseException {
				
		URL resource = Resources.getResource(ARQUIVO_TXT);

		this.desafioDevService.lerArquivoTxt(resource);
		
		var response = this.desafioDevService.findAll();
		
		return new ResponseEntity<>(response, HttpStatus.CREATED);

	}

}
