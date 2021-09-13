package com.chinmay.thrillio;

import com.chinmay.thrillio.controllers.BookmarkController;
import com.chinmay.thrillio.entities.Bookmark;
import com.chinmay.thrillio.entities.User;

public class View {
	public static void bookmark(User user,Bookmark[][] bookmarks) {
		System.out.println("\n"+user.getEmail()+" is browsing");
		for(int i=0;i<DataStore.USER_BOOKMARK_LIMIT;i++) {
			int typeOffset = (int)(Math.random() * DataStore.BOOKMARK_TYPE_COUNT);
			int bookmarkOffset = (int)(Math.random() * DataStore.BOOKMARK_COUNT_PERTYPE);
			
			Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];
			
			BookmarkController.getInstance().saveUserBookmark(user,bookmark);
			
			System.out.println(bookmark);
		}
	}
}
