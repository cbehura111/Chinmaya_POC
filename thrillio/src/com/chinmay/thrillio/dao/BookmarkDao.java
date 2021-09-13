package com.chinmay.thrillio.dao;

import com.chinmay.thrillio.DataStore;
import com.chinmay.thrillio.entities.Bookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmarks() {
		return DataStore.getBookmarks();
	}
}
