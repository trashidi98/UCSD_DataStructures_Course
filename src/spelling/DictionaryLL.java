package spelling;

import java.util.LinkedList;

/**
 * A class that implements the Dictionary interface using a LinkedList
 *
 */
public class DictionaryLL implements Dictionary 
{

	private LinkedList<String> dict;

    public DictionaryLL() {
        this.dict = new LinkedList<String>();
    }

    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
    public boolean addWord(String word) {

        // Make sure dictionary is not empty, if it is add
        if( this.dict.isEmpty() ) {
            dict.add(word.toLowerCase());
            return true;
        }

        // If that word is NOT a word in our dict, add it
        else if( !isWord(word) ) {
            dict.add(word.toLowerCase());
            return true;
        }

        // We didn't add any words
    	return false;
    }


    /** Return the number of words in the dictionary */
    public int size()
    {
        return this.dict.size();
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {

        if(this.dict.contains(s.toLowerCase())) {
            return true;
        }
        return false;
    }

    
}
