package com.bookmarkme.dao;

import com.bookmarkme.DataStore;
import com.bookmarkme.entities.Bookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmarks(){
		return DataStore.getBookmarks();
	}
}
