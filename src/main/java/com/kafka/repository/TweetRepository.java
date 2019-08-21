package com.kafka.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.kafka.model.Tweet;

@Repository
public interface TweetRepository extends ElasticsearchRepository<Tweet, String> {

	Page<Tweet> findByFavoritedAndRetweeted(Boolean favorited, Boolean retweeted, Pageable pageable);

	Page<Tweet> findByFavoritedOrTruncated(Boolean favorited, Boolean truncated, Pageable pageable);

	List<Tweet> findByLang(String language);

	List<Tweet> findByLangNot(String language);

	List<Tweet> findByLangNotIn(Collection<String> languages);

	List<Tweet> findByLangIn(Collection<String> languages);

	List<Tweet> findByTruncatedTrue();

	List<Tweet> findByTruncatedFalse();

	List<Tweet> findByTruncatedTrueOrderByLangDesc();

	List<Tweet> findByTextContaining(String contains);

	@Query("{\"bool\" : {\"must\" : {\"term\" : {\"is_quote_status\" : \"?0\"}}}}")
	Page<Tweet> findByIsQuoteStatusTrue(Boolean quoteStatus, Pageable pageable);
	
	//@Query("{\"match\" : { \"user.description\" : { \"query\" : \"?0\"} } }")
	//@Query("{\"bool\": {\"must\": [ {\"match\": {\"text\": \"?0\"}}]}}")
	//@Query("{\"bool\": {\"must\": [ {\"match\": {\"text\": {\"query\":\"?0\",\"operator\":\"or\"}}}]}}")
	//@Query(name="dddd",value="{\"bool\":{\"must\":[{\"query_string\":{\"query\":\"?0\",\"fields\":[\"user.description^1.0\",\"text\"]}}]}}")
	//@Query("{\"bool\":{\"must\":[{\"query_string\":{\"query\":\"*modi*\",\"fields\":[\"text^1.0\"],\"type\":\"best_fields\",\"default_operator\":\"or\",\"max_determinized_states\":10000,\"enable_position_increments\":true,\"fuzziness\":\"AUTO\",\"fuzzy_prefix_length\":0,\"fuzzy_max_expansions\":50,\"phrase_slop\":0,\"analyze_wildcard\":true,\"escape\":false,\"auto_generate_synonyms_phrase_query\":true,\"fuzzy_transpositions\":true,\"boost\":1.0}}],\"adjust_pure_negative\":true,\"boost\":1.0}}")

	//@Query("{\"bool\":{\"must\":[{\"query_string\":{\"query\":\"?0\",\"fields\":[\"user.description^1.0\",\"text\"]}}]}}")
	@Query("{\"bool\": {\"must\": [ {\"match\": {\"user.description\": {\"query\":\"?0\",\"operator\":\"or\"}}}]}}")
	Page<Tweet> findByUserDescriptionContainings(String query_string, Pageable pageable);
	
	@Query("{\"bool\": {\"must\": [ {\"match_phrase\":{\"user.description\":{\"query\": \"?0\"}}}]}}")
	Page<Tweet> findByUserDescriptionMatchPhrase(String query_string, Pageable pageable);
	
	//to search in multiple fields
	@Query("{\"bool\": {\"must\": [ {\"multi_match\":{\"query\": \"?0\",\"fields\": [\"text\",\"user.description\"]}}]}}")
	Page<Tweet> findByTextAndUserDescriptionMultiMatch(String query_string, Pageable pageable);
	
	
	
	
	

}
