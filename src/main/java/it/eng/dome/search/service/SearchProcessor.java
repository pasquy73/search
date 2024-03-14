package it.eng.dome.search.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import it.eng.dome.search.domain.IndexingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class SearchProcessor {
	
	@Autowired
    private ElasticsearchOperations elasticsearchOperations;
	
	private static final Logger logger = LoggerFactory.getLogger(SearchProcessor.class);

	
	public Page<IndexingObject> search(String q, Pageable pageable){

       // QueryBuilder queryBuilder = QueryBuilders.simpleQueryStringQuery(q);
		QueryBuilder queryBuilder = QueryBuilders.queryStringQuery(q);
        		
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder )
                .withPageable(pageable);

        Query elasticQuery = nativeSearchQueryBuilder.build();

        try {
            SearchHits<IndexingObject> searchHits = elasticsearchOperations.search(elasticQuery, IndexingObject.class); 
            List<IndexingObject> resultPage = searchHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
            return  new PageImpl<>(resultPage,pageable,searchHits.getTotalHits());
        } catch (Exception e) {
            logger.warn("Error during search. Skipped: {}", e.getMessage());
            return new PageImpl<>(new ArrayList<>());
        }
    }
	
	
	
	public Page<IndexingObject> fuzzySearch(String q, Pageable pageable){

        QueryBuilder queryBuilder = QueryBuilders.queryStringQuery(q).fuzziness(Fuzziness.AUTO);
        		
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder )
                .withPageable(pageable);

        Query elasticQuery = nativeSearchQueryBuilder.build();

        try {
            SearchHits<IndexingObject> searchHits = elasticsearchOperations.search(elasticQuery, IndexingObject.class); 
            List<IndexingObject> resultPage = searchHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
            return  new PageImpl<>(resultPage,pageable,searchHits.getTotalHits());
        } catch (Exception e) {
            logger.warn("Error during Fuzzy search. Skipped: {}", e.getMessage());
            return new PageImpl<>(new ArrayList<>());
        }
    }



	public Page<IndexingObject> testSearch(String query, Pageable pageable) {

		QueryBuilder queryBuilder = QueryBuilders.boolQuery()
				.should(QueryBuilders.matchQuery("productOfferingDescription", query))
                .should(QueryBuilders.matchQuery("productOfferingNameText", query))
                .should(QueryBuilders.matchQuery("productOfferingName", query));
		
		NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .withPageable(pageable);
		
		Query elasticQuery = nativeSearchQueryBuilder.build();
                
		try {
		SearchHits<IndexingObject> searchHits = elasticsearchOperations.search(elasticQuery, IndexingObject.class);
    
		List<IndexingObject> resultPage = searchHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
		return  new PageImpl<>(resultPage,pageable,searchHits.getTotalHits());
		 } catch (Exception e) {
	            logger.warn("Error during test for oneDrive search. Skipped: {}", e.getMessage());
	            return new PageImpl<>(new ArrayList<>());
	        }
	}

}
