package com.bookmarkme;

import com.bookmarkme.constants.BookGenre;
import com.bookmarkme.constants.Gender;
import com.bookmarkme.constants.MovieGenre;
import com.bookmarkme.constants.UserType;
import com.bookmarkme.entities.Bookmark;
import com.bookmarkme.entities.User;
import com.bookmarkme.entities.UserBookmark;
import com.bookmarkme.managers.BookmarkManager;
import com.bookmarkme.managers.UserManager;

public class DataStore {
	private static final int USER_BOOKMARK_LIMIT = 5;
	private static final int BOOKMARK_COUNT_PERTYPE = 5;
	private static final int BOOKMARK_TYPE_COUNT = 3;
	private static final int TOTAL_USER_COUNT = 5;
	private static User[] users = new User[TOTAL_USER_COUNT];

	public static User[] getUsers() {
		return users;
	}

	private static Bookmark[][] bookmarks = new Bookmark[BOOKMARK_TYPE_COUNT][BOOKMARK_COUNT_PERTYPE];

	public static Bookmark[][] getBookmarks() {
		return bookmarks;
	}

	private static UserBookmark[] userBookmarks = new UserBookmark[TOTAL_USER_COUNT * USER_BOOKMARK_LIMIT];

	public static void loadData() {
		loadUsers();
		loadWebLinks();
		loadMovies();
		loadBooks();
	}


	private static void loadUsers() {
		users[0] = UserManager.getInstance().createUser(1000, "user0@semanticsquare.com", "test0", "John", "M",
				Gender.MALE, UserType.USER);
		users[1] = UserManager.getInstance().createUser(1001, "user1@semanticsquare.com", "test1", "Sam", "M",
				Gender.MALE, UserType.USER);
		users[2] = UserManager.getInstance().createUser(1002, "user2@semanticsquare.com", "test2", "Anita", "M",
				Gender.FEMALE, UserType.EDITOR);
		users[3] = UserManager.getInstance().createUser(1003, "user3@semanticsquare.com", "test3", "Sara", "M",
				Gender.FEMALE, UserType.EDITOR);
		users[4] = UserManager.getInstance().createUser(1004, "user4@semanticsquare.com", "test4", "Chinmay", "B",
				Gender.MALE, UserType.CHIEF_EDITOR);
	}

	private static void loadWebLinks() {
		bookmarks[0][0] = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger,Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		bookmarks[0][1] = BookmarkManager.getInstance().createWebLink(2001,"How do I import a pre-existing Java project into Eclipse and get up and running?",
				"http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running",
				"http://www.stackoverflow.com");
		bookmarks[0][2] = BookmarkManager.getInstance().createWebLink(2002,"Interface vs Abstract Class","http://mindprod.com/jgloss/interfacevsabstract.html",
				"http://mindprod.com");
		bookmarks[0][3] = BookmarkManager.getInstance().createWebLink(2003,"NIO tutorial by Greg Travis","http://cs.brown.edu/courses/cs161/papers/j-nio-ltr.pdf",
				"http://cs.brown.edu");
		bookmarks[0][4] =BookmarkManager.getInstance().createWebLink(2004,"Virtual Hosting and Tomcat","http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html",
				"http://tomcat.apache.org");
	}
	
	private static void loadMovies() {
		bookmarks[1][0] = BookmarkManager.getInstance().createMovie(3000,"Citizen Kane",1941,new String[] {"Orson Welles,Joseph Cotten"},new String[] {"Orson Welles"},MovieGenre.CLASSICS,8.5);
		bookmarks[1][1] = BookmarkManager.getInstance().createMovie(3001,"The Grapes of Wrath",1940,new String[] {"Henry Fonda,Jane Darwell"},new String[] {"John Ford"},MovieGenre.CLASSICS,8.2);
		bookmarks[1][2] = BookmarkManager.getInstance().createMovie(3002,"A Touch of Greatness",2004,new String[] {"Albert Cullum"},new String[] {"Leslie Sullivan"},MovieGenre.DOCUMENTARIES,7.3);
		bookmarks[1][3] = BookmarkManager.getInstance().createMovie(3003,"The Big Bang Theory",2007, new String[] {"Kaley Cuoco,Jim Parsons"},new String[] {"Chuck Lorre,Bill Prady"}, MovieGenre.TV_SHOWS,8.7);
		bookmarks[1][4] = BookmarkManager.getInstance().createMovie(3004,"Ikiru",1952,new String[] {"Takashi Shimura,Minoru Chiaki"},new String[] {"Akira Kurosawa"},BookGenre.TECHNICAL,8.4);
		
	}
	
	private static void loadBooks() {
		bookmarks[2][0] = BookmarkManager.getInstance().createBook(4000,"Walden",1854,"Wilder Publications",new String[] {"Henry David Thoreau"},BookGenre.PHILOSOPHY,4.3);
				
		
	}
}
