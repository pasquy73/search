package it.eng.dome.search.rest.web.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestUtil {
	
	@Value("${dome.getproductofferingbyid}")
	private String getProductOfferingById;
	
	@Value("${dome.getproductspecificationbyid}")
	private String getProductSpecificationById;
	
	@Value("${dome.getservicespecificationbyid}")
	private String getServiceSpecificationById;
	
	@Value("${dome.getresourcespecificationbyid}")
	private String getResourceSpecificationById;
	
	@Value("${dome.getallproductofferings}")
	private String getAllProductOfferings;
	
	@Value("${dome.getallproductofferingsfromtmforum}")
	private String getAllProductOfferingsFromTMForum;
	
	private static final Logger log = LoggerFactory.getLogger(RestUtil.class);
	private static RestTemplate restTemplate = new RestTemplate();
	
	
	public String getProductOfferingById(String id) {

		ResponseEntity<String> response= restTemplate.getForEntity(getProductOfferingById + "/"+id, String.class);
		String result= response.getBody();	

		return result;
	}
	
	
	public String getProductSpecificationById(String id) {

		ResponseEntity<String> response= restTemplate.getForEntity(getProductSpecificationById + "/"+id, String.class);
		String result= response.getBody();	

		return result;
	}
	
	
	public String getServiceSpecificationById(String id) {

		ResponseEntity<String> response= restTemplate.getForEntity(getServiceSpecificationById + "/"+id, String.class);
		String result= response.getBody();	

		return result;
	}
	
	
	public String getResourceSpecificationById(String id) {

		ResponseEntity<String> response= restTemplate.getForEntity(getResourceSpecificationById + "/"+id, String.class);
		String result= response.getBody();	

		return result;
	}
	
	
	public String getAllProductOfferings() {

		ResponseEntity<String> response= restTemplate.getForEntity(getAllProductOfferings, String.class);
		String result= response.getBody();	

		return result;
	}
	
	public String getAllProductOfferingsFromTMForum() {

		ResponseEntity<String> response= restTemplate.getForEntity(getAllProductOfferingsFromTMForum, String.class);
		String result= response.getBody();	

		return result;
	}

}
