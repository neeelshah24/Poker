package poker;

public class Deck {

	private Card[] cards;

	/*This constructor initializes the Deck with 52 card objects, 
	 * representing the 52 cards that are in a standard deck. */
	public Deck() {
		cards = new Card[52];
		for (int value = 0; value < 13; value++) {
			cards[value] = new Card(value + 1, 0);
		}
		for (int value = 13; value < 26; value++) {
			cards[value] = new Card(value - 12, 1);
		}
		for (int value = 26; value < 39; value++) {
			cards[value] = new Card(value - 25, 2);
		}
		for (int value = 39; value < 52; value++) {
			cards[value] = new Card(value - 38, 3);
		}
	}

	//Standard copy constructor
	public Deck(Deck other) {
		cards = new Card[other.cards.length];
		for (int i = 0; i < other.cards.length; i++) {
			cards[i] = other.cards[i];
		}
	}
	

	//Returns the card that is at the specified position in the array. 
	public Card getCardAt(int position) {
		if (cards.length < position || position < 0) {
			throw new IndexOutOfBoundsException();	
			}
			return cards[position];
	}

	//this method will return the size of the array of Cards
	public int getNumCards() {
		return this.cards.length;
	}

	/*This method will re-arrange the cards that are in the deck.
	 *   The idea is that the deck will be divided into two "packets"
	 *    the top half and the bottom half. The new array of cards 
	 *    will consist of:  the first card from the top packet, followed 
	 *    by the first card from the bottom packet, followed by the second 
	 *    card from the top packet, followed by the second card from the 
	 *    bottom packet */
	public void shuffle() {
		Card[] temporary = new Card[cards.length];
		if (cards.length % 2 == 0) {
			for (int value = 0; value < cards.length / 2; value++) {
				temporary[value * 2] = cards[value]; 
			}
			for (int value1 = cards.length / 2; value1 < cards.length; value1++) {
				temporary[2 * (value1 - (cards.length / 2)) + 1] = cards[value1];
			}
			cards = temporary;
			
		} else {
			for (int value = 0; value < (cards.length / 2) + 1; value++) {
				temporary[value * 2] = cards[value];
			}
			for (int value1 = (cards.length / 2) + 1; value1 < cards.length; value1++) {
				temporary[2 * (value1 - ((cards.length / 2) + 1)) + 1] = cards[value1]; 
			}
			cards = temporary;
		}
	}
	
	/* this method will take the position given by the user and then cut 
	 * the deck at this point, all the cards that were present before the 
	 * position will be sent to the back of the deck of cards and the cards
	 * after the cut will move their position towards the beginning of the 
	 * array  */
	public void cut(int position) {
		 Card[] temporary = new Card[cards.length];
		 for ( int value = 0; value < position; value++) {
			 temporary[value + cards.length - position] = cards[value];
		 }
		 for (int value2 = position; value2 < cards.length; value2++) {
			 temporary[value2 - position] = cards[value2];
		 }
		 cards = temporary;
	 }

	/* This method will remove the specified number of cards from
	 *  the top of the deck and return them as an array. The 
	 * 
	 */
	public Card[] deal(int numCards) {
		/* this will make the array that is left after the 
		 * specific number of cards have been dealt */
		Card[] smaller = new Card[cards.length - numCards];
		/* this will make a new array that will be as big as 
		 * the specified number of cards that will be dealt */
		Card[] dealt = new Card[numCards];
		/* this for loop will start at the first position and will keep
		 * on going until the specified number of cards that are being 
		 * dealt. along with this it will assign the dealt array with 
		 * the respective cards */
		for (int i = 0; i < numCards; i++) {
			dealt[i] = cards[i];
		}
		/* this for loop will pick up at the card being dealt and will keep
		 * on going until the end of the array.along with this it will assign
		 *  the cards array with the respective cards */
		for (int i = 0; i < smaller.length; i++) {
			smaller[i] = cards[numCards + i];
		}
		
		cards = smaller;
		return dealt;
	}
		
}
