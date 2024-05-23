package it.eng.dome.search;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.eng.dome.search.service.OfferingProcessor;

@SpringBootTest
class SearchAndBrowsingApplicationTests {

	@Autowired
	private OfferingProcessor offeringProcessor;

	@Test
	void contextLoads() {
		//assertThat(offeringProcessor).isNotNull();
		System.out.println( offeringProcessor );
	}

}
