package com.kafka.service;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import com.kafka.model.Tweet;

public interface TweetService {

	Tweet save(Tweet tweet);

	void delete(Tweet tweet);

	Tweet findOne(String id);

	Iterable<Tweet> findAll();

	Page<Tweet> findAllPaged(Pageable pageable);

	Slice<Tweet> findAllSliced(Pageable pageable);

	Page<Tweet> findByFavoritedAndRetweeted(Boolean favorited, Boolean retweeted, Pageable pageable);

	Page<Tweet> findByFavoritedOrTruncated(Boolean favorited, Boolean truncated, Pageable pageable);

	List<Tweet> findByLang(String lang);

	List<Tweet> findByLangNot(String lang);

	List<Tweet> findByLangNotIn(Collection<String> languages);

	List<Tweet> findByTruncatedTrue();

	List<Tweet> findByTruncatedFalse();
	
	List<Tweet> findByTruncatedTrueOrderByLangDesc();
	
	List<Tweet> findByTextContaining(String contains);
	
	Page<Tweet> findByIsQuoteStatus(Boolean quoteStatus,Pageable pageable);
	
	Page<Tweet> findByUserDescriptionContaining(String query_string, Pageable pageable);
	
	Page<Tweet> findByUserDescriptionContaining2(String query_string, Pageable pageable);
	
	Page<Tweet> findByUserDescriptionMatchPhrase(String query_string, Pageable pageable);
	
	Page<Tweet> findByTextAndUserDescriptionMultiMatch(String query_string, Pageable pageable);
}
