package com.synopsis.bookmarker.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.synopsis.bookmarker.domain.Bookmark;
import com.synopsis.bookmarker.domain.BookmarkService;
import com.synopsis.bookmarker.domain.BookmarksDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {
	
	@Autowired
	private final BookmarkService bookmarkService;
	
	@GetMapping
	public BookmarksDTO getBookmarks(@RequestParam(name="page",defaultValue = "1") Integer page){
		return bookmarkService.getBookmarks(page);
	}

}
