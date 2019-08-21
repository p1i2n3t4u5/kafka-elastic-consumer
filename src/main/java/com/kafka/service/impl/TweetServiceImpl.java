package com.kafka.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.kafka.model.Tweet;
import com.kafka.repository.TweetRepository;
import com.kafka.service.TweetService;

@Service
public class TweetServiceImpl implements TweetService {

	@Autowired
	private TweetRepository tweetRepository;

	public Tweet save(Tweet tweet) {
		return tweetRepository.save(tweet);
	}

	public void delete(Tweet tweet) {
		tweetRepository.delete(tweet);
	}

	public Tweet findOne(String id) {

		Optional<Tweet> optional = tweetRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public Iterable<Tweet> findAll() {
		return tweetRepository.findAll();
	}

	@Override
	public Page<Tweet> findAllPaged(Pageable pageable) {
		return tweetRepository.findAll(pageable);
	}

	@Override
	public Slice<Tweet> findAllSliced(Pageable pageable) {
		return tweetRepository.findAll(pageable);
	}

	@Override
	public Page<Tweet> findByFavoritedAndRetweeted(Boolean favorited, Boolean retweeted, Pageable pageable) {
		return tweetRepository.findByFavoritedAndRetweeted(favorited, retweeted, pageable);
	}

	@Override
	public Page<Tweet> findByFavoritedOrTruncated(Boolean favorited, Boolean truncated, Pageable pageable) {
		return tweetRepository.findByFavoritedOrTruncated(favorited, truncated, pageable);
	}

	public List<Tweet> findByLang(String lang) {
		return tweetRepository.findByLang(lang);
	}

	public List<Tweet> findByLangNot(String lang) {
		return tweetRepository.findByLangNot(lang);
	}

	@Override
	public List<Tweet> findByLangNotIn(Collection<String> languages) {
		return tweetRepository.findByLangNotIn(languages);
	}

	@Override
	public List<Tweet> findByTruncatedTrue() {
		return tweetRepository.findByTruncatedTrue();
	}

	@Override
	public List<Tweet> findByTruncatedFalse() {
		return tweetRepository.findByTruncatedFalse();
	}

	@Override
	public List<Tweet> findByTruncatedTrueOrderByLangDesc() {
		return tweetRepository.findByTruncatedTrueOrderByLangDesc();
	}

	@Override
	public List<Tweet> findByTextContaining(String contains) {
		return tweetRepository.findByTextContaining(contains);
	}

	@Override
	public Page<Tweet> findByIsQuoteStatus(Boolean quoteStatus, Pageable pageable) {
		return tweetRepository.findByIsQuoteStatusTrue(quoteStatus,pageable);
	}

	@Override
	public Page<Tweet> findByUserDescriptionContaining(String query_string, Pageable pageable) {
		return tweetRepository.findByUserDescriptionContainings(query_string,pageable);
	}
	
	@Override
	public Page<Tweet> findByUserDescriptionContaining2(String query_string, Pageable pageable) {
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				  .withQuery(QueryBuilders.matchQuery("user.description", query_string)).withPageable(pageable)
				  .build();
		return tweetRepository.search(searchQuery);
	}

	@Override
	public Page<Tweet> findByUserDescriptionMatchPhrase(String query_string, Pageable pageable) {
		return tweetRepository.findByUserDescriptionMatchPhrase(query_string,pageable);
	}

	@Override
	public Page<Tweet> findByTextAndUserDescriptionMultiMatch(String query_string, Pageable pageable) {
		return tweetRepository.findByTextAndUserDescriptionMultiMatch(query_string,pageable);
	}


}