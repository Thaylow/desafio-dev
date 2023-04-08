package desafioDev.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.text.MaskFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desafioDev.entidade.DesafioDev;
import desafioDev.entidade.DesafioDevResponse;
import desafioDev.entidade.DesafioDevResponse2;
import desafioDev.repository.DesafioDevRepository;
import lombok.var;

@Service
public class DesafioDevServiceImpl implements DesafioDevService {
	
	@Autowired
	private DesafioDevRepository repository;
	
	@Override
	public void lerArquivoTxt(URL resource) throws IOException {
		
		String path = resource.getFile(); 
		
		System.out.print("\n");
		System.out.println(path);
		System.out.print("\n");
		
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";
		while (true) {
			if (linha != null) {
				
				if( linha!=null && !linha.isEmpty()) {
					
					DesafioDev desafioDev = new DesafioDev();
					
					desafioDev.setTipo(linha.substring(0,1));
					desafioDev.setData(linha.substring(1,9));
					int number = Integer.parseInt(linha.substring(9,19));
					desafioDev.setValor((double)number/100.00);
					desafioDev.setCpf(linha.substring(19,30));
					desafioDev.setCartao(linha.substring(30,42));
					desafioDev.setHora(linha.substring(42,48));
					desafioDev.setDonoDaLoja(linha.substring(48,62));
					desafioDev.setNomeDaLoja(linha.substring(62,80));
					
					this.repository.save(desafioDev);
					System.out.println(linha);
					
				}
				

			} else
				break;
			linha = buffRead.readLine();
		}
		buffRead.close();
	}

	@Override
	public DesafioDevResponse findAll() throws ParseException {
		
		DesafioDevResponse desafioDevResponse = new DesafioDevResponse();
		desafioDevResponse.setRegistros(new ArrayList<DesafioDevResponse2>());
		DesafioDevResponse2 desafioDevResponse2 = new DesafioDevResponse2();
		
		var resgistros = this.repository.findAll();
		
		for (DesafioDev item : resgistros) {
			desafioDevResponse2 = new DesafioDevResponse2();
			
			desafioDevResponse2.setId(item.getId());
			desafioDevResponse2.setTipo(item.getTipo());

			MaskFormatter formatter;
			formatter = new MaskFormatter("AAAA-AA-AA");
			formatter.setValueContainsLiteralCharacters(false);
			var data = formatter.valueToString(item.getData());
			desafioDevResponse2.setData(data);
			
			
			desafioDevResponse2.setValor(item.getValor());
			desafioDevResponse2.setCpf(item.getCpf());
			desafioDevResponse2.setCartao(item.getCartao());
			desafioDevResponse2.setHora(item.getHora());
			desafioDevResponse2.setDonoDaLoja(item.getDonoDaLoja());
			desafioDevResponse2.setNomeDaLoja(item.getNomeDaLoja());
			
			
			desafioDevResponse.getRegistros().add(desafioDevResponse2);
						
		}
		
		return desafioDevResponse;
	}    

}