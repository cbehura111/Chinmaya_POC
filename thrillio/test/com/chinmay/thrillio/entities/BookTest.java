package com.chinmay.thrillio.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.chinmay.thrillio.constants.BookGenre;
import com.chinmay.thrillio.managers.BookmarkManager;

class BookTest {

	@Test
	void testIsKidFriendlyEligible() {
		//Test1 :Genre is PHILOSOPHY -- false;
		Book book = BookmarkManager.getInstance().createBook(4000,"Walden","Profile URL NA",1854,"Wilder Publications",new String[] {"Henry David Thoreau"},BookGenre.PHILOSOPHY,4.3);
		boolean isKidFriendlyEligible = book.isKidFriendlyEligible();
		
		assertFalse("For PHILOSOPHY genre -- isKidFriendlyEligible() must return false",isKidFriendlyEligible);
		
		//Test2 :Genre is SELF_HELP -- false;
		book = BookmarkManager.getInstance().createBook(4000,"Walden","Profile URL NA",1854,"Wilder Publications",new String[] {"Henry David Thoreau"},BookGenre.SELF_HELP,4.3);
		isKidFriendlyEligible = book.isKidFriendlyEligible();
		
		assertFalse("For PHILOSOPHY genre -- isKidFriendlyEligible() must return false",isKidFriendlyEligible);
		
	}

}
