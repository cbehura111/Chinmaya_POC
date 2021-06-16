package com.bookmarkme.managers;

import com.bookmarkme.dao.BookmarkDao;
import com.bookmarkme.entities.Book;
import com.bookmarkme.entities.Bookmark;
import com.bookmarkme.entities.Movie;
import com.bookmarkme.entities.User;
import com.bookmarkme.entities.UserBookmark;
import com.bookmarkme.entities.WebLink;

public class BookmarkManager {
	private static BookmarkManager instance = new BookmarkManager(); 
	private static BookmarkDao dao= new BookmarkDao();
	
	private BookmarkManager() {}
	
	public static BookmarkManager getInstance(){
		return instance;
	}
	public WebLink createWebLink(long id,String title,/*String profileUrl,*/String url,String host) {
		
		WebLink weblink = new WebLink();
		
		weblink.setId(id);
		weblink.setTitle(title);
		//weblink.setProfileUrl(profileUrl);
		weblink.setUrl(url);
		weblink.setHost(host);
		
		return weblink;
	}
	
	
	public Movie createMovie(long id,String title,/* String profileUrl*/int releaseYear, String[] cast, String[] directors, String genre, double imdbRatings) {
		
		Movie movie=new Movie();
		
		movie.setId(id);
		movie.setTitle(title);
		//movie.setProfileUrl(profileUrl);
		movie.setReleaseyear(releaseYear);
		movie.setCast(cast);
		movie.setDirectors(directors);
		movie.setGenre(genre);
		movie.setImdbRating(imdbRatings);
		
		return movie;
		
	}
	
	public Book createBook(long id,String title,/*String profileUrl,*/int publicationYear,String publisher,
			String[] authors, String genre,double amazonRating) {
		
		Book book=new Book();
		
		book.setId(id);
		book.setTitle(title);
		//book.setProfileUrl(profileUrl);
		book.setPublicationYear(publicationYear);
		book.setPublisher(publisher);
		book.setAuthors(authors);
		book.setGenre(genre);
		book.setAmazonRating(amazonRating);
		
		return book;
	}
	public Bookmark[][] getBookmarks(){
		return dao.getBookmarks();
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		UserBookmark userBookmark = new UserBookmark();
		userBookmark.setUser(user);
		userBookmark.setBookmark(bookmark);
		
		dao.saveBookmark(userBookmark);
	}
}
