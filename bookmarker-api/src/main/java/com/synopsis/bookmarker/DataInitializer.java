package com.synopsis.bookmarker;

import java.time.Instant;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.synopsis.bookmarker.domain.Bookmark;
import com.synopsis.bookmarker.domain.BookmarkRepository;

import lombok.RequiredArgsConstructor;

/*
 * @Component
 * 
 * @RequiredArgsConstructor public class DataInitializer implements
 * CommandLineRunner{
 * 
 * private final BookmarkRepository repository;
 * 
 * @Override public void run(String... args) throws Exception {
 * repository.save(new
 * Bookmark(null,"Sivalabs","http://sivalabs.in",Instant.now()));
 * repository.save(new Bookmark(null, "Google", "http://google.com",
 * Instant.now())); repository.save(new Bookmark(null, "StackOverflow",
 * "http://stackoverflow.com", Instant.now())); repository.save(new
 * Bookmark(null, "GitHub", "http://github.com", Instant.now()));
 * repository.save(new Bookmark(null, "YouTube", "http://youtube.com",
 * Instant.now())); repository.save(new Bookmark(null, "Reddit",
 * "http://reddit.com", Instant.now())); repository.save(new Bookmark(null,
 * "Medium", "http://medium.com", Instant.now())); repository.save(new
 * Bookmark(null, "LinkedIn", "http://linkedin.com", Instant.now()));
 * repository.save(new Bookmark(null, "Twitter", "http://twitter.com",
 * Instant.now())); repository.save(new Bookmark(null, "Facebook",
 * "http://facebook.com", Instant.now())); repository.save(new Bookmark(null,
 * "Instagram", "http://instagram.com", Instant.now())); repository.save(new
 * Bookmark(null, "Netflix", "http://netflix.com", Instant.now()));
 * repository.save(new Bookmark(null, "Amazon", "http://amazon.com",
 * Instant.now())); repository.save(new Bookmark(null, "Spotify",
 * "http://spotify.com", Instant.now())); repository.save(new Bookmark(null,
 * "Microsoft", "http://microsoft.com", Instant.now())); repository.save(new
 * Bookmark(null, "Apple", "http://apple.com", Instant.now()));
 * repository.save(new Bookmark(null, "Zoom", "http://zoom.us", Instant.now()));
 * repository.save(new Bookmark(null, "Slack", "http://slack.com",
 * Instant.now())); repository.save(new Bookmark(null, "Trello",
 * "http://trello.com", Instant.now())); repository.save(new Bookmark(null,
 * "Pinterest", "http://pinterest.com", Instant.now())); repository.save(new
 * Bookmark(null, "Quora", "http://quora.com", Instant.now()));
 * 
 * }
 * 
 * }
 */