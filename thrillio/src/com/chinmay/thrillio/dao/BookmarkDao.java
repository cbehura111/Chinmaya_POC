package com.chinmay.thrillio.dao;

import com.chinmay.thrillio.DataStore;
import com.chinmay.thrillio.entities.Bookmark;
import com.chinmay.thrillio.entities.UserBookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmarks() {
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		DataStore.add(userBookmark);
		
	}
}
