package com.chinmay.thrillio.controllers;

import com.chinmay.thrillio.entities.Bookmark;
import com.chinmay.thrillio.entities.User;
import com.chinmay.thrillio.managers.BookmarkManager;

public class BookmarkController {
	private static BookmarkController instance = new BookmarkController();
	private BookmarkController () {}
	public static BookmarkController getInstance() {
		return instance;
	}
	public void saveUserBookmark(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().saveUserBookmark(user,bookmark);
		
	}
	
}
