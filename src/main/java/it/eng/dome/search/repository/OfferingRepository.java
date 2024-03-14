package it.eng.dome.search.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import it.eng.dome.search.domain.IndexingObject;

@Repository
public interface OfferingRepository extends ElasticsearchRepository<IndexingObject, String> {

	List<IndexingObject> findByProductOfferingId(String productOfferingId);
	
	List<IndexingObject> findByServicesId(String servicesId);
	
}
