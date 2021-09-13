package com.chinmay.thrillio.managers;

import com.chinmay.thrillio.dao.BookmarkDao;
import com.chinmay.thrillio.entities.Book;
import com.chinmay.thrillio.entities.Bookmark;
import com.chinmay.thrillio.entities.Movie;
import com.chinmay.thrillio.entities.Weblink;

public class BookmarkManager {
	private static BookmarkManager instance = new BookmarkManager();
	private static BookmarkDao dao = new BookmarkDao();

	private BookmarkManager() {}

	public static BookmarkManager getInstance() {
		return instance;
	}

	public Weblink createWebLink(long id, String title, String profileUrl, String url, String host) {

		Weblink weblink = new Weblink();

		weblink.setId(id);
		weblink.setTitle(title);
		weblink.setProfileUrl(profileUrl);
		weblink.setUrl(url);
		weblink.setHost(host);

		return weblink;
	}

	public Book createBook(long id, String title, String profileUrl, int publicationYear, String publisher,
			String[] authors, String genre, double amazonRating) {

		Book book = new Book();

		book.setId(id);
		book.setTitle(title);
		book.setProfileUrl(profileUrl);
		book.setPublicationYear(publicationYear);
		book.setPublisher(publisher);
		book.setAuthors(authors);
		book.setGenre(genre);
		book.setAmazonRating(amazonRating);

		return book;
	}

	public Movie createMovie(long id, String title, String profileUrl, int releaseYear, String[] cast,
			String[] directors, String genre, double imdbRatings) {

		Movie movie = new Movie();

		movie.setId(id);
		movie.setTitle(title);
		movie.setProfileUrl(profileUrl);
		movie.setReleaseYear(releaseYear);
		movie.setCast(cast);
		movie.setDirectors(directors);
		movie.setGenre(genre);
		movie.setImdbRatings(imdbRatings);

		return movie;

	}
	
	public Bookmark[][] getBookmarks(){
		return dao.getBookmarks();
	}
}