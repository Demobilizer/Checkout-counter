package com.onlineretail.checkoutcounter.service;

import java.io.IOException;
import java.net.URL;

import org.springframework.stereotype.Service;



@Service
public class BillGenerationService {

	public void generateBill(int counterId) throws IOException {

		  URL url = new  URL("http://localhost:8080/generate-bill/counter/"+counterId);
		  url.openConnection().getContent();	
	}

}
