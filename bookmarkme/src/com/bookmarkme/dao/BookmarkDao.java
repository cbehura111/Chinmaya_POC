package com.bookmarkme.dao;

import com.bookmarkme.DataStore;
import com.bookmarkme.entities.Bookmark;
import com.bookmarkme.entities.UserBookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmarks(){
		return DataStore.getBookmarks();
	}

	public void saveBookmark(UserBookmark userBookmark) {
		DataStore.add(userBookmark);
	}
}
