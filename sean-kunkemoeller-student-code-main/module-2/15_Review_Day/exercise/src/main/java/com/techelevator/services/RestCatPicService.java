package com.techelevator.services;

import org.springframework.stereotype.Component;

import com.techelevator.model.CatPic;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatPicService implements CatPicService {

	@Override
	public CatPic getPic() {
		RestTemplate restTemplate = new RestTemplate();
		CatPic catPic = restTemplate.getForObject("https://cat-data.netlify.app/api/pictures/random", CatPic.class);
		return catPic;
	}

}
