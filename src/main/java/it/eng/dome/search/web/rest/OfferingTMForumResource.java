package it.eng.dome.search.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.eng.dome.search.domain.IndexingObject;
import it.eng.dome.search.service.OfferingProcessor;

@RestController
@RequestMapping("/api")
public class OfferingTMForumResource {
	
	@Autowired
	private OfferingProcessor offeringProcessor;
	
	
	@GetMapping("/offering/processProductOfferingsFromTMForumAPI")
	public ResponseEntity<List<IndexingObject>> processProductOffetingsFromTMForumAPI(){
		List<IndexingObject> obj = offeringProcessor.processListProductOfferingFromTMForumAPI();
		return ResponseEntity.ok(obj);

	}

}
