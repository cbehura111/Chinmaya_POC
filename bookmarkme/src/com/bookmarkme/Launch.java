package com.bookmarkme;

import com.bookmarkme.entities.Bookmark;
import com.bookmarkme.entities.User;
import com.bookmarkme.managers.BookmarkManager;
import com.bookmarkme.managers.UserManager;

public class Launch {
	private static User[] users;
	private static Bookmark[][] bookmarks;
	
	private static void printUserData() {
		for(User user : users) {
			System.out.println(user);
		}
		
	}
	
	private static void printBookmarkData() {
		for(Bookmark[] bookmarklist : bookmarks) {
			for (Bookmark bookmark : bookmarklist) {
				System.out.println(bookmark);
			}
		}
		
	}

	private static void loadData() {
		System.out.println("1. Loading Data...");
		DataStore.loadData();
		
		users = UserManager.getInstance().getUsers();
		bookmarks = BookmarkManager.getInstance().getBookmarks();
		System.out.println("\n\nPrinting User Data...");
		printUserData();
		System.out.println("\n\nPrinting Bookmark Data...");
		printBookmarkData();
	}
	
	private static void startBookmarking() {
		System.out.println("\n2. Bookmarking");
		for (User user : users) {
			View.bookmark(user, bookmarks);
		}
		
	}
	
		public static void main(String[] args) {
		loadData();
		startBookmarking();
	}
}
