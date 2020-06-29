package textgen;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

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
public void train(String sourceText) {
		
		// should not run train() on a generator that has already been trained 
		if (!wordList.isEmpty())
			return;
		
		String words[] = sourceText.split("\\s+");
		starter = words[0];
		String prevWord = starter;
		String currentWord;

		for (int i = 1; i < words.length; i++) {
			currentWord = words[i];
			// create a new node for the previous word if it does not exist
			// in the wordList
			if (!wordList.contains(new ListNode(prevWord))) {
				createNewWordNode(prevWord, currentWord);
			}
			// the previous word exists in the wordList
			// do not create a new node
			// add the currentWord as its next word
			else {
				addNextWord(prevWord, currentWord);
			}
			prevWord = currentWord;
		}

		// set the last word to point to the starter word
		prevWord = words[words.length - 1];
		if (!wordList.contains(new ListNode(prevWord))) {
			createNewWordNode(prevWord, starter);
		} else {
			addNextWord(prevWord, starter);
		}
	}
	
	/** 
	 * Generate the number of words requested.
	 */
	@Override
	public String generateText(int numWords) {
		// generator has not been trained
		// or zero words are requested
		if (wordList.isEmpty() || numWords == 0) {
			return "";
		}

		String currWord = starter;
		StringBuilder output = new StringBuilder();
		output.append(currWord + " ");
		for (int i = 0; i < numWords-1; i++) {
			for (ListNode node : wordList) {
				if (node.getWord().equals(currWord)) {
					String newWord = node.getRandomNextWord(rnGenerator);
					output.append(newWord + " ");
					currWord = newWord;
					break;
				}
			}
		}
		return output.toString();
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
		starter = "";
		wordList.clear();
		train(sourceText);
		
	}
	
	// TODO: Add any private helper methods you need here.
	private void createNewWordNode(String prevWord, String currentWord) {
		ListNode wordNode = new ListNode(prevWord);
		wordNode.addNextWord(currentWord);
		wordList.add(wordNode);
	}

	private void addNextWord(String prevWord, String currentWord) {
		for (ListNode node : wordList) {
			if (node.getWord().equals(prevWord)) {
				node.addNextWord(currentWord);
			}
		}
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
		System.out.println(textString);
		gen.train(textString);
		System.out.println(gen);
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

}

/** Links a word to the next words in the list 
 * You should use this class in your implementation. */
class ListNode
{
    // The word that is linking to the next words
	private String word;
	
	// The next words that could follow it
	private List<String> nextWords;
	
	ListNode(String word)
	{
		this.word = word;
		nextWords = new LinkedList<String>();
	}
	
	public String getWord()
	{
		return word;
	}

	public void addNextWord(String nextWord)
	{
		nextWords.add(nextWord);
	}
	
	public String getRandomNextWord(Random generator)
	{
		// TODO: Implement this method
	    // The random number generator should be passed from 
	    // the MarkovTextGeneratorLoL class
	    int index = generator.nextInt(nextWords.size());
	    return nextWords.get(index);
	}

	public String toString()
	{
		String toReturn = word + ": ";
		for (String s : nextWords) {
			toReturn += s + "->";
		}
		toReturn += "\n";
		return toReturn;
	}
	
}


