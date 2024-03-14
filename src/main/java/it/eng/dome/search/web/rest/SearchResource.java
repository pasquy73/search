package it.eng.dome.search.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.eng.dome.search.domain.IndexingObject;
import it.eng.dome.search.rest.web.util.PaginationUtil;
import it.eng.dome.search.service.SearchProcessor;

@RestController
@RequestMapping("/api")
public class SearchResource {

	@Autowired
	private SearchProcessor searchProcessor;

	// @ApiPageable
	@GetMapping(value = "/SearchByKeywords/{query}")
	public ResponseEntity<List<IndexingObject>> search(@PathVariable String query,
			/*
			 * @PageableDefault(sort = {"productOfferingName.keyword"}, direction =
			 * Sort.Direction.ASC, size = 50)
			 */ Pageable pageable) {

		Page<IndexingObject> page = searchProcessor.search(query, pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/SearchByKeywords/" + query);
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);

		// List<IndexingObject> objList = page.getContent();
		// return ResponseEntity.ok(objList);

	}

	/*
	 *
	 * 
	 * @GetMapping(value="/FuzzySearchByKeywords/{query}") public
	 * ResponseEntity<List<IndexingObject>> fuzzySearch(@PathVariable String query,
	 * 
	 * @PageableDefault(sort = {"productOfferingName.keyword"}, direction =
	 * Sort.Direction.ASC, size = 50) Pageable pageable){
	 * 
	 * 
	 * Page<IndexingObject> page = searchProcessor.fuzzySearch(query, pageable);
	 * HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page,
	 * "/api/FuzzySearchByKeywords/"+query); return new
	 * ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	 * 
	 * // List<IndexingObject> objList = page.getContent(); // return
	 * ResponseEntity.ok(objList);
	 * 
	 * }
	 */

	/*
	 * // @ApiPageable
	 * 
	 * @GetMapping(value = "/TestSearchByKeywords/{query}") public
	 * ResponseEntity<List<IndexingObject>> testSearch(@PathVariable String query,
	 * Pageable pageable) {
	 * 
	 * Page<IndexingObject> page = searchProcessor.testSearch(query, pageable);
	 * HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page,
	 * "/api/testSearchByKeywords/" + query); return new
	 * ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	 * 
	 * }
	 */

}
