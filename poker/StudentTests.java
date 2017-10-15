package poker;

import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTests {

	/* Use the @Test annotation for JUnit 4 
	 * [This is just an example, please erase
	 * it and write some real tests.]    */
	@Test
	public void testDeckConstructor() {
		Card a = new Card(3,1);
		Card b = new Card(2,0);
		Card c = new Card(4,3);
		
		assertTrue(a.toString().equals("3 of h"));
		assertTrue(b.toString().equals("2 of s"));
		assertTrue(c.toString().equals("4 of d"));
	}
	
	@Test
	public void testGetCardAt() {
		Deck[] card = new Deck[52];
		
		
		assertTrue(card.toString().equals("8 of s"));
		
	}
	@Test
	public void testFourOfAKind() {
		Card[]testhand=new Card[5];
		testhand[0]=new Card(1,1);
		testhand[1]=new Card(1,2);
		testhand[2]=new Card(2,3);
		testhand[3]=new Card(1,1);
		testhand[4]=new Card(1,3);
		
		assertTrue(PokerHandEvaluator.hasFourOfAKind(testhand));
		
		
	}

}
