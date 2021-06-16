package com.bookmarkme.controllers;

import com.bookmarkme.entities.Bookmark;
import com.bookmarkme.entities.User;
import com.bookmarkme.managers.BookmarkManager;

public class BookmarkController {
	private static BookmarkController instance= new BookmarkController();
	private BookmarkController() {}
	public static BookmarkController getInstance() {
		return instance;
	}
	
	public void saveUserBookmark(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().saveUserBookmark(user,bookmark);
		
	}
}
