package textgen;

import java.util.*;

/** 
 * An implementation of the MTG interface that uses a list of lists.
 * @author UC San Diego Intermediate Programming MOOC team 
 */
public class MarkovTextGeneratorLoL implements MarkovTextGenerator {

	// The list of words with their next words
	private List<ListNode> wordList; 
	
	// The starting "word"
	private String starter;
	
	// The random number generator
	private Random rnGenerator;
	
	public MarkovTextGeneratorLoL(Random generator)
	{
		wordList = new LinkedList<ListNode>();
		starter = "";
		rnGenerator = generator;
	}
	/** Train the generator by adding the sourceText */
	@Override
	public void train(String sourceText)
	{
		// The string array
		String[] words = sourceText.split("[., ]+");

		this.starter = words[0];
		String prevWord = starter;

		int prevWordIndex = 0;

		for(int i = 1; i < words.length; i++) {
			String word = words[i];

			prevWordIndex = checkWordList(prevWord);

			// Check to see if prevWord is already a node in the list
			if( prevWordIndex >= 0 ) {
				// if it is a a node in the list
				// Add w as a nextWord to the prevWord node
				wordList.get(prevWordIndex).addNextWord(word);
			}

			else {
				// else its not a node
				// Add a new node with prevWord as the node word
				wordList.add(new ListNode(prevWord));

				// Add w as nextword to prevWord node
				prevWordIndex = checkWordList(prevWord);
				wordList.get(prevWordIndex).addNextWord(word);
			}
			// Set prevWord = w
			prevWord = word;
		}

		// Adding the last word
		wordList.add(new ListNode(words[words.length - 1]));
		// Get the last word in source text (node) and set its next word to be first word so program can generate words endlessly
		wordList.get(wordList.size()-1).addNextWord(words[0]);

	}


	/**
	 * Generate the number of words requested.
	 */
	@Override
	public String generateText(int numWords) {

		// Set currWord to be the starter word
		String currword = this.starter;

		// Set output to ""
		String output = "";

		// Add currWord to oputput
		output = output.concat(currword).concat(" ");

		int i = 1;

		String randomWord = "";

		// While you need more words
		while( i < numWords ) {

			int currNodeIndex = checkWordList(currword);

			// Find the node corresponding to currWord in the list
			ListNode currNode = wordList.get(currNodeIndex);

			// Select a random word from the wordList
			randomWord = currNode.getRandomNextWord(this.rnGenerator);

			// Add randomWord to the output
			output = output.concat(randomWord).concat(" ");

			// Set currWord to be randomWord
			currword = randomWord;

			// Increment word count
			i++;
		}

		return output;
	}
	
	
	// Can be helpful for debugging
	@Override
	public String toString()
	{
		String toReturn = "";
		for (ListNode n : wordList)
		{
			toReturn += n.toString();
		}
		return toReturn;
	}
	
	/** Retrain the generator from scratch on the source text */
	@Override
	public void retrain(String sourceText)
	{
		// TODO: Implement this method.
	}

	private int checkWordList(String word) {
		int value = -1;
		int count = 0;
		for(ListNode llnode : wordList) {
			if ( llnode.getWord().equalsIgnoreCase(word) ) {
				value = count;
				return value;
			} else {
				value = -1;
			}
			count++;
		}
		return value;
	}

	/**
	 * This is a minimal set of tests.  Note that it can be difficult
	 * to test methods/classes with randomized behavior.   
	 * @param args
	 */

	public static void main(String[] args)
	{
		// feed the generator a fixed random value for repeatable behavior
		MarkovTextGeneratorLoL gen = new MarkovTextGeneratorLoL(new Random(42));

		String textString = "Hello.  Hello there.  This is a test.  Hello there.  Hello Bob.  Test again.";
//		String textString = "hi there hi Leo";
		System.out.println(textString);
		gen.train(textString);
		System.out.println(gen);
		System.out.println(gen.generateText(5));
		System.out.println(gen.generateText(20));
		String textString2 = "You say yes, I say no, "+
				"You say stop, and I say go, go, go, "+
				"Oh no. You say goodbye and I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"I say high, you say low, "+
				"You say why, and I say I don't know. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"Why, why, why, why, why, why, "+
				"Do you say goodbye. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"You say yes, I say no, "+
				"You say stop and I say go, go, go. "+
				"Oh, oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello,";
		System.out.println(textString2);
		gen.retrain(textString2);
		System.out.println(gen);
		System.out.println(gen.generateText(20));
}

/** Links a word to the next words in the list 
 * You should use this class in your implementation. */
class ListNode {
	// The word that is linking to the next words
	private String word;

	// The next words that could follow it
	private List<String> nextWords;

	ListNode(String word) {
		this.word = word;
		nextWords = new LinkedList<String>();
	}

	public String getWord() {
		return word;
	}

	public void addNextWord(String nextWord) {
		nextWords.add(nextWord);
	}

	public String getRandomNextWord(Random generator) {
		int randomNumber = generator.nextInt(nextWords.size());
		return nextWords.get(randomNumber);
	}

	public String toString() {
		String toReturn = word + ": ";
		for (String s : nextWords) {
			toReturn += s + "->";
		}
		toReturn += "\n";
		return toReturn;
	}

}

}



