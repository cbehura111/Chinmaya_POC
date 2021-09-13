package com.chinmay.thrillio.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.chinmay.thrillio.constants.MovieGenre;
import com.chinmay.thrillio.managers.BookmarkManager;

class MovieTest {

	@Test
	void testIsKidFriendlyEligible() {
		// Test1 : Genre Horror -- false
		Movie movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "Profile URL NA", 1941,
				new String[] { "Orson Welles,Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.HORROR,
				8.5);

		boolean isKidFriendlyEligible = movie.isKidFriendlyEligible();

		assertFalse("Genre Horror -- isKidFriendlyEligible() must return false", isKidFriendlyEligible);
		
		// Test2 : Genre Thriller -- false
		movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "Profile URL NA", 1941,
				new String[] { "Orson Welles,Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.THRILLERS,
				8.5);

		isKidFriendlyEligible = movie.isKidFriendlyEligible();

		assertFalse("Genre THRILLERS -- isKidFriendlyEligible() must return false", isKidFriendlyEligible);
	}

}
