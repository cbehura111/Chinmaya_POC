package com.chinmay.thrillio;

import com.chinmay.thrillio.entities.Bookmark;
import com.chinmay.thrillio.entities.User;
import com.chinmay.thrillio.managers.BookmarkManager;
import com.chinmay.thrillio.managers.UserManager;

public class Launch {
	private static User[] users;
	private static Bookmark[][] bookmarks;

	private static void Loaddata() {
		
		System.out.println("1. Loading data...");
		DataStore.loadData();
		
		users=UserManager.getInstance().getUsers();
		bookmarks= BookmarkManager.getInstance().getBookmarks();
		
		System.out.println("Printing data ...");
		printUserData();
		printBookmarkData();
		
	}
	
	private static void printBookmarkData() {
		for(Bookmark[] bookmarklist : bookmarks) {
			for (Bookmark bookmark : bookmarklist) {
				System.out.println(bookmark);
			}
		}
	}
	
	private static void printUserData() {
		for(User user : users) {
			System.out.println(user);
		}
	}
	
		private static void startBookmarking() {
			System.out.println("\n\n2. Bookmarking");
			for(User user : users) {
			View.bookmark(user, bookmarks);
		}
		
	}
	public static void main(String[] args) {
		Loaddata();
		startBookmarking();
	}

}
