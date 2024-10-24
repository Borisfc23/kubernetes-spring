package com.synopsis.bookmarker.domain;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {

	private final BookmarkRepository repository;	
		
	@Transactional(readOnly = true) 
	public BookmarksDTO getBookmarks(Integer page) {
		int pageNro = page < 1 ? 0 : page - 1;
		Pageable pageable = PageRequest.of(pageNro, 10, Sort.Direction.DESC, "createdAt");
		Page<BookmarkDTO> bookmarkPage = repository.findBookmarks(pageable);
		return new BookmarksDTO(bookmarkPage);
	}
}
