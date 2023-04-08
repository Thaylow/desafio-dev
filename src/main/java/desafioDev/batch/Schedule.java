package desafioDev.batch;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import desafioDev.controller.Controller;

@Service
@Component
public class Schedule {

	@Autowired
	Controller controller;

	@Scheduled(cron = "0 0/1 * * * *")
	public void teste() throws IOException {
		
//		controller.lerArquivoTxt();
		
	}

}
