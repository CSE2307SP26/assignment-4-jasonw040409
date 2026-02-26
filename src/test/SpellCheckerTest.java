package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SpellCheckerTest {
// Assignment 4
	@Test
	void testWordCount() {
		SpellChecker checker = new SpellChecker();
		int words = checker.getNumberOfWords();
		assertEquals(0, words);
	}

	@Test
	void testAddWord() {
		SpellChecker checker = new SpellChecker();
		checker.addWord("Helloworld");
		int words = checker.getNumberOfWords();
		assertEquals(1, words);
	}

	@Test
	void testAlreadyAddedWord() {
		SpellChecker checker = new SpellChecker();
		checker.addWord("Helloworld");
		checker.addWord("Helloworld");
		int words = checker.getNumberOfWords();
		assertEquals(1, words);
	}

	@Test
	void testProperlySpelledWord() {
		SpellChecker checker = new SpellChecker();
		checker.addWord("Helloworld");
		boolean isSpelledCorrectly = checker.isSpelledCorrectly("Helloworld");
		assertTrue(isSpelledCorrectly);
	}

	@Test
	void testMisspelledWord() {
		SpellChecker checker = new SpellChecker();
		checker.addWord("Hlloworld");
		boolean isSpelledCorrectly = checker.isSpelledCorrectly("Hlloworld");
		assertFalse(isSpelledCorrectly);
	}

	@Test
	void testIgnoreCase() {
		SpellChecker checker = new SpellChecker();
		checker.addWord("caT");
		boolean isSpelledCorrectly = checker.isSpelledCorrectly("cat");
		assertTrue(isSpelledCorrectly);
		checker.addWord("Cat");
		isSpelledCorrectly = checker.isSpelledCorrectly("cat");
		assertTrue(isSpelledCorrectly);
	}

	@Test
	void testMisspelledSuggestion() {
		SpellChecker checker = new SpellChecker();
		checker.addWord("bank");
		String suggestion = checker.getSuggestion("bamk");
		assertEquals("bank", suggestion);
	}

	@Test
	void testCorrectSuggestion() {
		SpellChecker checker = new SpellChecker();
		checker.addWord("bank");
		String suggestion = checker.getSuggestion("bank");
		assertEquals("bank", suggestion);
	}

	@Test
	void testRemoveWord(){
		SpellChecker checker = new SpellChecker();
		checker.addWord("helloworld");
		int words = checker.getNumberOfWords();
		assertEquals(1, words);
		checker.removeWord("helloworld");
		words = checker.getNumberOfWords();
		assertEquals(0, words);
	}

	@Test
	void testCapitalizeAll(){
		SpellChecker checker = new SpellChecker();
		checker.addWord("helloworld");
		String capitalized = checker.capitalizeAll();
		assertEquals("HELLOWORLD", capitalized);
	}


}
