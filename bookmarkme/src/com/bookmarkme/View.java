package com.bookmarkme;

import com.bookmarkme.controllers.BookmarkController;
import com.bookmarkme.entities.Bookmark;
import com.bookmarkme.entities.User;

public class View {
	public static void bookmark(User user,Bookmark[][] bookmarks) {
		System.out.println("\n"+user.getEmail()+" is Bookmarking :");
		for (int i = 0; i <DataStore.USER_BOOKMARK_LIMIT; i++) {
			int typeOffset = (int) (Math.random()*DataStore.BOOKMARK_TYPE_COUNT);
			int bookmarkOffset = (int) (Math.random()*DataStore.BOOKMARK_COUNT_PERTYPE);
			
			Bookmark bookmark=bookmarks[typeOffset][bookmarkOffset];
			
			BookmarkController.getInstance().saveUserBookmark(user,bookmark);
			
			System.out.println(bookmark);
		}
	}
}
