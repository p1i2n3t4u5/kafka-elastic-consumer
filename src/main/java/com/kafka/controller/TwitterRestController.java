package com.kafka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.model.Tweet;
import com.kafka.service.TweetService;

@RestController
@RequestMapping(path = "/twitter")
public class TwitterRestController {

	@Autowired
	TweetService tweetService;

	@GetMapping(path = "")
	public String getTweet() {
		return "Hello";
	}

	@GetMapping(path = "{id}")
	public ResponseEntity<Tweet> getTweet(@PathVariable("id") String id) {
		Tweet tweet = tweetService.findOne(id);
		return new ResponseEntity<Tweet>(tweet, HttpStatus.OK);
	}

	@GetMapping(path = "/findAll")
	public ResponseEntity<Iterable<Tweet>> getAll() {
		Iterable<Tweet> tweets = tweetService.findAll();
		return new ResponseEntity<Iterable<Tweet>>(tweets, HttpStatus.OK);
	}

	@GetMapping(value = "/paged")
	public ResponseEntity<Page<Tweet>> listAllAddressPaged(@RequestParam("page") int page,
			@RequestParam("size") int size) {
		Page<Tweet> address = tweetService.findAllPaged(PageRequest.of(page, size));
		if (address.getSize() == 0) {
			return new ResponseEntity<Page<Tweet>>(HttpStatus.NO_CONTENT);// You
		}
		return new ResponseEntity<Page<Tweet>>(address, HttpStatus.OK);
	}

	@GetMapping(value = "/slice")
	public ResponseEntity<Slice<Tweet>> listAllAddressSliced(@RequestParam("page") int page,
			@RequestParam("size") int size) {
		Slice<Tweet> slice = tweetService.findAllSliced(PageRequest.of(page, size));
		if (slice.getSize() == 0) {
			return new ResponseEntity<Slice<Tweet>>(HttpStatus.NO_CONTENT);// You
		}
		return new ResponseEntity<Slice<Tweet>>(slice, HttpStatus.OK);
	}

	@GetMapping(value = "/favoritedAndRetweeted")
	public ResponseEntity<Slice<Tweet>> findByFavoritedAndRetweeted(@RequestParam("favorited") boolean favorited,
			@RequestParam("retweeted") boolean retweeted, @RequestParam("page") int page,
			@RequestParam("size") int size) {
		Slice<Tweet> slice = tweetService.findByFavoritedAndRetweeted(favorited, retweeted, PageRequest.of(page, size));
		if (slice.getSize() == 0) {
			return new ResponseEntity<Slice<Tweet>>(HttpStatus.NO_CONTENT);// You
		}
		return new ResponseEntity<Slice<Tweet>>(slice, HttpStatus.OK);
	}

	@GetMapping(value = "/favoritedOrTruncated")
	public ResponseEntity<Slice<Tweet>> findByFavoritedOrTruncated(@RequestParam("favorited") boolean favorited,
			@RequestParam("truncated") boolean truncated, @RequestParam("page") int page,
			@RequestParam("size") int size) {
		Slice<Tweet> slice = tweetService.findByFavoritedOrTruncated(favorited, truncated, PageRequest.of(page, size));
		if (slice.getSize() == 0) {
			return new ResponseEntity<Slice<Tweet>>(HttpStatus.NO_CONTENT);// You
		}
		return new ResponseEntity<Slice<Tweet>>(slice, HttpStatus.OK);
	}

	@GetMapping(value = "/findByLang")
	public ResponseEntity<List<Tweet>> findByLang(@RequestParam("lang") String lang) {
		List<Tweet> slice = tweetService.findByLang(lang);
		if (slice.size() == 0) {
			return new ResponseEntity<List<Tweet>>(HttpStatus.NO_CONTENT);// You
		}
		return new ResponseEntity<List<Tweet>>(slice, HttpStatus.OK);
	}

	@GetMapping(value = "/findByLangNot")
	public ResponseEntity<List<Tweet>> findByLangNot(@RequestParam("lang") String lang) {
		List<Tweet> slice = tweetService.findByLangNot(lang);
		if (slice.size() == 0) {
			return new ResponseEntity<List<Tweet>>(HttpStatus.NO_CONTENT);// You
		}
		return new ResponseEntity<List<Tweet>>(slice, HttpStatus.OK);
	}

	@GetMapping(value = "/findByLangNotIn")
	public ResponseEntity<List<Tweet>> findByLangNotIn(@RequestParam("langs") List<String> langs) {
		List<Tweet> slice = tweetService.findByLangNotIn(langs);
		if (slice.size() == 0) {
			return new ResponseEntity<List<Tweet>>(HttpStatus.NO_CONTENT);// You
		}
		return new ResponseEntity<List<Tweet>>(slice, HttpStatus.OK);
	}

	@GetMapping(value = "/findByTruncatedTrue")
	public ResponseEntity<List<Tweet>> findByTruncatedTrue() {
		List<Tweet> slice = tweetService.findByTruncatedTrue();
		if (slice.size() == 0) {
			return new ResponseEntity<List<Tweet>>(HttpStatus.NO_CONTENT);// You
		}
		return new ResponseEntity<List<Tweet>>(slice, HttpStatus.OK);
	}

	@GetMapping(value = "/findByTruncatedFalse")
	public ResponseEntity<List<Tweet>> findByTruncatedFalse() {
		List<Tweet> slice = tweetService.findByTruncatedFalse();
		if (slice.size() == 0) {
			return new ResponseEntity<List<Tweet>>(HttpStatus.NO_CONTENT);// You
		}
		return new ResponseEntity<List<Tweet>>(slice, HttpStatus.OK);
	}

	@GetMapping(value = "/findByTruncatedTrueOrderByLangDesc")
	public ResponseEntity<List<Tweet>> findByTruncatedTrueOrderByLangDesc() {
		List<Tweet> slice = tweetService.findByTruncatedTrueOrderByLangDesc();
		if (slice.size() == 0) {
			return new ResponseEntity<List<Tweet>>(HttpStatus.NO_CONTENT);// You
		}
		return new ResponseEntity<List<Tweet>>(slice, HttpStatus.OK);
	}

	@GetMapping(value = "/findByTextContaining")
	public ResponseEntity<List<Tweet>> findByTruncatedTrueOrderByLangDesc(@RequestParam("query") String query) {
		List<Tweet> slice = tweetService.findByTextContaining(query);
		if (slice.size() == 0) {
			return new ResponseEntity<List<Tweet>>(HttpStatus.NO_CONTENT);// You
		}
		return new ResponseEntity<List<Tweet>>(slice, HttpStatus.OK);
	}
	
	@GetMapping(value = "/findByIsQuoteStatus")
	public ResponseEntity<Slice<Tweet>> findByIsQuoteStatus(@RequestParam("quoteStatus") Boolean quoteStatus, @RequestParam("page") int page,
			@RequestParam("size") int size) {
		Page<Tweet> slice = tweetService.findByIsQuoteStatus(quoteStatus, PageRequest.of(page, size));
		if (slice.getSize() == 0) {
			return new ResponseEntity<Slice<Tweet>>(HttpStatus.NO_CONTENT);// You
		}
		return new ResponseEntity<Slice<Tweet>>(slice, HttpStatus.OK);
	}
	
	@GetMapping(value = "/findByUserDescriptionContaining")
	public ResponseEntity<Slice<Tweet>> findByUserDescriptionContaining(@RequestParam("quoteString") String quoteString, @RequestParam("page") int page,
			@RequestParam("size") int size) {
		Page<Tweet> slice = tweetService.findByUserDescriptionContaining(quoteString, PageRequest.of(page, size));
		if (slice.getSize() == 0) {
			return new ResponseEntity<Slice<Tweet>>(HttpStatus.NO_CONTENT);// You
		}
		return new ResponseEntity<Slice<Tweet>>(slice, HttpStatus.OK);
	}
	
	@GetMapping(value = "/findByUserDescriptionContaining2")
	public ResponseEntity<Slice<Tweet>> findByUserDescriptionContaining2(@RequestParam("quoteString") String quoteString, @RequestParam("page") int page,
			@RequestParam("size") int size) {
		Page<Tweet> slice = tweetService.findByUserDescriptionContaining2(quoteString, PageRequest.of(page, size));
		if (slice.getSize() == 0) {
			return new ResponseEntity<Slice<Tweet>>(HttpStatus.NO_CONTENT);// You
		}
		return new ResponseEntity<Slice<Tweet>>(slice, HttpStatus.OK);
	}
	
	@GetMapping(value = "/findByUserDescriptionMatchPhrase")
	public ResponseEntity<Slice<Tweet>> findByUserDescriptionMatchPhrase(@RequestParam("quoteString") String quoteString, @RequestParam("page") int page,
			@RequestParam("size") int size) {
		Page<Tweet> slice = tweetService.findByUserDescriptionMatchPhrase(quoteString, PageRequest.of(page, size));
		if (slice.getSize() == 0) {
			return new ResponseEntity<Slice<Tweet>>(HttpStatus.NO_CONTENT);// You
		}
		return new ResponseEntity<Slice<Tweet>>(slice, HttpStatus.OK);
	}
	
	@GetMapping(value = "/findByTextAndUserDescriptionMultiMatch")
	public ResponseEntity<Slice<Tweet>> findByTextAndUserDescriptionMultiMatch(@RequestParam("quoteString") String quoteString, @RequestParam("page") int page,
			@RequestParam("size") int size) {
		Page<Tweet> slice = tweetService.findByTextAndUserDescriptionMultiMatch(quoteString, PageRequest.of(page, size));
		if (slice.getSize() == 0) {
			return new ResponseEntity<Slice<Tweet>>(HttpStatus.NO_CONTENT);// You
		}
		return new ResponseEntity<Slice<Tweet>>(slice, HttpStatus.OK);
	}


}
