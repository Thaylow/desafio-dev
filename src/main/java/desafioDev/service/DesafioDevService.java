package desafioDev.service;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;

import org.springframework.stereotype.Service;

import desafioDev.entidade.DesafioDevResponse;

@Service
public interface DesafioDevService {

    public void lerArquivoTxt(URL reseource) throws IOException;

	public DesafioDevResponse findAll() throws ParseException;
   
}