package com.synopsis.bookmarker;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.synopsis.bookmarker.domain.Bookmark;
import com.synopsis.bookmarker.domain.BookmarkRepository;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class BookmarkControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	BookmarkRepository bookmarkRepository;
	
	private List<Bookmark> bookmarks;
	@BeforeEach
	void setUp() {
		bookmarkRepository.deleteAllInBatch();
		bookmarks = new ArrayList<>();
		bookmarks.add(new Bookmark(null, "Sivalabs", "http://sivalabs.in", Instant.now()));
		bookmarks.add(new Bookmark(null, "Google", "http://google.com", Instant.now()));
		bookmarks.add(new Bookmark(null, "StackOverflow", "http://stackoverflow.com", Instant.now()));
		bookmarks.add(new Bookmark(null, "GitHub", "http://github.com", Instant.now()));
		bookmarks.add(new Bookmark(null, "YouTube", "http://youtube.com", Instant.now()));	
		bookmarkRepository.saveAll(bookmarks);
	}
	
	@ParameterizedTest
	@CsvSource({
		"1,5,1,1,true,true,false,false"		
	})
	void shouldGetBookarks(int page,int totalElements,int totalPages,int currentPage,boolean isFirst,boolean isLast,boolean hasNext,boolean hasPrevious) throws Exception{
		mvc.perform(get("/api/bookmarks?page="+page))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.totalElements", CoreMatchers.equalTo(totalElements)))
			.andExpect(jsonPath("$.totalPages", CoreMatchers.equalTo(totalPages)))
			.andExpect(jsonPath("$.currentPage", CoreMatchers.equalTo(currentPage)))
			.andExpect(jsonPath("$.isFirst", CoreMatchers.equalTo(isFirst)))
			.andExpect(jsonPath("$.isLast", CoreMatchers.equalTo(isLast)))
			.andExpect(jsonPath("$.hasNext", CoreMatchers.equalTo(hasNext)))
			.andExpect(jsonPath("$.hasPrevious", CoreMatchers.equalTo(hasPrevious)));
	}
}
