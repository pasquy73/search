package it.eng.dome.search.service;

//import java.io.BufferedReader;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.eng.dome.search.domain.IndexingObject;
import it.eng.dome.search.domain.ProductOffering;
import it.eng.dome.search.indexing.IndexingManager;

import it.eng.dome.search.repository.OfferingRepository;
import it.eng.dome.search.rest.web.util.RestUtil;

@Service
public class OfferingProcessor {

	@Autowired
	private OfferingRepository offeringRepo;

	@Autowired
	private IndexingManager indexingManager;

	private static final ObjectMapper objectMapper = new ObjectMapper();


	@Autowired
	private RestUtil restUtil;

	private static final Logger log = LoggerFactory.getLogger(OfferingProcessor.class);

	public IndexingObject save(IndexingObject obj) {
		return offeringRepo.save(obj);

	}


	/** MANAGE BAE ENDPOINT */


	public IndexingObject processProductOffering(ProductOffering product) {

		IndexingObject objToIndex = new IndexingObject();

		//validate product offering
		//prepare metadata
		objToIndex = indexingManager.processOffering(product, objToIndex);
		objToIndex = save(objToIndex);

		return objToIndex;

	}


	/** */ //---->to complete
	/*
	 * public IndexingObject processProductOfferingById(String productOfferingId) {
	 * log.info("Prepare for mapping: " + productOfferingId);
	 * 
	 * String productOfferingRequest =
	 * restUtil.getProductOfferingById(productOfferingId);
	 * 
	 * return null;
	 * 
	 * }
	 */


	public List<IndexingObject> processListProductOffering() {

		List<IndexingObject> toRet = new ArrayList<IndexingObject>();
		String listProductOfferings = restUtil.getAllProductOfferings();

		try {
			ProductOffering[] productOffList = objectMapper.readValue(listProductOfferings, ProductOffering[].class);

			for(ProductOffering product : productOffList) {

				IndexingObject objToIndex = new IndexingObject();
				objToIndex = indexingManager.processOffering(product,objToIndex);

				objToIndex = save(objToIndex);
				toRet.add(objToIndex);
			}

		} catch (JsonMappingException e) {
			log.warn("JsonMappingException - Error during processListProductOffering(). Skipped: {}", e.getMessage());

			e.printStackTrace();
		} catch (JsonProcessingException e) {
			log.warn("JsonProcessingException - Error during processListProductOffering(). Skipped: {}", e.getMessage());

			e.printStackTrace();
		}

		return toRet;
	}



	public List<IndexingObject> processListProductOffering(ProductOffering[] products) throws JsonMappingException, JsonProcessingException {

		List<IndexingObject> toRet = new ArrayList<IndexingObject>();

		for(ProductOffering product : products) {

			IndexingObject objToIndex = new IndexingObject();
			objToIndex = indexingManager.processOffering(product,objToIndex);

			objToIndex = save(objToIndex);
			toRet.add(objToIndex);
		}

		return toRet;
	}



	//method to analyze indexed tokens
	/*
	 * public String analyzeToken() { String elasticsearchUrl =
	 * "http://localhost:9200"; String indexName = "indexing-object"; String
	 * textToAnalyze = "OneDrive";
	 * 
	 * 
	 * HttpClient httpClient = HttpClients.createDefault();
	 * 
	 * // Costruisci l'URL per l'analisi del token String analyzeUrl =
	 * elasticsearchUrl + "/" + indexName + "/_analyze";
	 * 
	 * // Costruisci la richiesta HTTP POST HttpPost httpPost = new
	 * HttpPost(analyzeUrl); httpPost.setHeader("Content-Type", "application/json");
	 * 
	 * // Costruisci il corpo della richiesta con il testo da analizzare String
	 * requestBody = "{ \"analyzer\": \"standard\", \"text\": \"" + textToAnalyze +
	 * "\" }"; try { httpPost.setEntity(new StringEntity(requestBody)); } catch
	 * (UnsupportedEncodingException e1) { // TODO Auto-generated catch block
	 * e1.printStackTrace(); } try { // Esegui la richiesta HttpResponse response;
	 * 
	 * response = httpClient.execute(httpPost);
	 * 
	 * HttpEntity entity = response.getEntity();
	 * 
	 * StringBuilder result = new StringBuilder(); try (BufferedReader br = new
	 * BufferedReader(new InputStreamReader(entity.getContent()))) { String line;
	 * while ((line = br.readLine()) != null) { result.append(line); } }
	 * 
	 * return result.toString();
	 * 
	 * } catch (ClientProtocolException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); }
	 * 
	 * return null; }
	 */


	/** MANAGE TMFORUM API*/

	public List<IndexingObject> processListProductOfferingFromTMForumAPI() {
		// TODO Auto-generated method stub

		List<IndexingObject> toRet = new ArrayList<IndexingObject>();
		String listProductOfferings = restUtil.getAllProductOfferingsFromTMForum();

		try {
			ProductOffering[] productOffList = objectMapper.readValue(listProductOfferings, ProductOffering[].class);

			for(ProductOffering product : productOffList) {

				IndexingObject objToIndex = new IndexingObject();
				objToIndex = indexingManager.processOfferingFromTMForum(product,objToIndex);

				objToIndex = save(objToIndex);
				toRet.add(objToIndex);
			}

		} catch (JsonMappingException e) {
			log.warn("JsonMappingException - Error during processListProductOffering(). Skipped: {}", e.getMessage());

			e.printStackTrace();
		} catch (JsonProcessingException e) {
			log.warn("JsonProcessingException - Error during processListProductOffering(). Skipped: {}", e.getMessage());

			e.printStackTrace();
		}

		return toRet;
	}


	/** General usage*/
	public void clearRepository() {		
		offeringRepo.deleteAll();		
	}



}
