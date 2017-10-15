package poker;

import java.util.Arrays;

public class PokerHandEvaluator {

	/* this method is used to see if there is any two of the
	 * same number pairs in the hand of 5 cards. If the hand does 
	 * have a pair of cards which have the same number the method 
	 * will return true */
	public static boolean hasPair(Card[] cards) {
		boolean hasPair = false;
		for (int value1 = 0; value1 < cards.length - 1; value1++) {
			for (int value2 = value1 + 1; value2 < cards.length; value2++) {
				if (cards[value1].getValue() == cards[value2].getValue()) {
					hasPair = true;
				}
			}
		}
		return hasPair;
	}

	/* this method will also look at the poker hand to see if the 
	 * hand has two different pairs. This means two pairs of cards
	 * which have different values. */
	public static boolean hasTwoPair(Card[] cards) {
		boolean hasTwoPair = false;
		boolean hasOnePair = false;
		int pairOne = 0;
		int pairTwo = 0;
		for (int value1 = 0; value1 < cards.length - 1; value1++) {
			for (int value2 = value1 + 1; value2 < cards.length; value2++) {
				if (cards[value1].getValue() == cards[value2].getValue()) {
					pairOne = cards[value1].getValue();
					hasOnePair = true;
				}
			}
		}
		//this section will run if there is once pair in the hand so far
		if (hasOnePair) {
			for (int value3 = 0; value3 < cards.length - 1; value3++) {
				for (int value4 = value3 + 1; value4 < cards.length; value4++) {
					if (cards[value3].getValue() == cards[value4].getValue()
							&& !(cards[value3].getValue() == pairOne)) {
						pairTwo = cards[value3].getValue();
						hasTwoPair = true;
					}
				}
			}
		}
		// this statement is to clarify that the two pairs that were found
		// did in fact have different values
		if (!(pairOne == pairTwo) && hasTwoPair) {
			return true;
		} else {
			return false;
		}

	}

	/* this method will look at three out of the five cards in the deck.
	 * it will see if the values of any three cards are equal to each 
	 * other. If this is the case the method will return true else return
	 * false. */
	public static boolean hasThreeOfAKind(Card[] cards) {
		boolean hasThreeOfAKind = false;
		boolean hasPair = false;
		for (int value1 = 0; value1 < cards.length; value1++) {
			for (int value2 = value1 + 1; value2 < cards.length; value2++) {
				if (cards[value1].getValue() == cards[value2].getValue()) {
					hasPair = true;
				}
				if (hasPair) {
					for (int value3 = value2 + 1; value3 < cards.length; value3++) {
						if (cards[value3].getValue() == cards[value2].getValue()) {
							hasThreeOfAKind = true;
						}
					}
				}
			}
		}
		return hasThreeOfAKind;
	}

	/* this method will find the cards in the hand and see if the values 
	 * of the card are incrementing by one each time regardless of the 
	 * type of suit  */
	public static boolean hasStraight(Card [] cards) {
		int[] value = {cards[0].getValue(), cards[1].getValue(),
		cards[2].getValue(), cards[3].getValue(), cards[4].getValue()};
		Arrays.sort(value);

		int firstValue = value[0];
		int secondValue = value[1];
		int thirdValue = value[2];
		int fourthValue = value[3];
		int fifthValue = value[4];

		if ((firstValue == (secondValue - 1) && firstValue == (thirdValue - 2) &&
			firstValue == (fourthValue - 3) && firstValue == (fifthValue - 4)) ||
			(firstValue == (secondValue - 9) && firstValue == (thirdValue - 10) &&
			firstValue == (fourthValue - 11) && firstValue == (fifthValue - 12))) {
			return true;
			
			} else {
				
			return false;
			}
	}

	/* this method will look at the suits of all the cards in the 
	 * hand, if all the suits of the hand are the same the method 
	 * will return true, else it will return false  */
	public static boolean hasFlush(Card[] cards) {
		boolean hasFlush = false;
		// all these integers are obtaining the suit of the cards in array
		int suitOne = cards[0].getSuit();
		int suitTwo = cards[1].getSuit();
		int suitThree = cards[2].getSuit();
		int suitFour = cards[3].getSuit();
		int suitFive = cards[4].getSuit();
		// statement which compares all the integer values to one another
		if (suitOne == suitTwo && suitThree == suitFour && suitFive == suitOne && suitOne == suitThree
				&& suitThree == suitFive) {
			hasFlush = true;
		} else {
			hasFlush = false;
		}
		return hasFlush;
	}

	/* this method will find a pair of two cards in the hand that are the same
	 * and the other three cards in the hand which are the same, this is done
	 * by implementing the hasTwoPair and the hasThreeOfAKind method */
	public static boolean hasFullHouse(Card[] cards) {
		if (hasTwoPair(cards) && hasThreeOfAKind(cards)) {
			return true;
		} else {
			return false;
		}
	}
	
	/* this method will look at 4 out of the 5 cards in the hand,
	 * if four out of the five cards in the hand have the same value 
	 * the method will return true, else return false */
	public static boolean hasFourOfAKind(Card[] cards) {
		boolean hasFourOfAKind = false;

		for (int value1 = 0; value1 < cards.length - 1; value1++) {
			for (int value2 = value1 + 1; value2 < cards.length; value2++) {
				for (int value3 = value2 + 1; value3 < cards.length; value3++) {
					for (int value4 = value3 + 1; value4 < cards.length; value4++) {
						if (cards[value1].getValue() == cards[value2].getValue()
								&& cards[value3].getValue() == cards[value4].getValue()
								&& cards[value1].getValue() == cards[value3].getValue()
								&& cards[value2].getValue() == cards[value4].getValue()
								&& cards[value2].getValue() == cards[value3].getValue()
								&& cards[value1].getValue() == cards[value4].getValue()) {

							hasFourOfAKind = true;

						}
					}
				}
			}
		}
		return hasFourOfAKind;
	}

	/* this method will find the cards in the hand and see if the values 
	 * of the card are incrementing by one while each of the cards are 
	 * the same suit  */
	public static boolean hasStraightFlush(Card[] cards) {
		if (hasStraight(cards) && hasFlush(cards)) {
			return true;
		} else {
			return false;
		}
	}
}
