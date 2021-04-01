package spelling;

import java.util.TreeSet;

/**
 * @author UC San Diego Intermediate MOOC team
 *
 */
public class DictionaryBST implements Dictionary 
{
   private TreeSet<String> dict;
	
    public DictionaryBST() {
        this.dict = new TreeSet<String>();
    }
	
    
    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
    public boolean addWord(String word) {

        // If empty, add word
        if(this.dict.isEmpty()) {
            this.dict.add(word.toLowerCase());
        }

        // If word is NOT in dictionary, add word
        else if(!isWord(word)){
            dict.add(word.toLowerCase());
        }

        // Otherwise it is in the dictionary, return false
        return false;
    }


    /** Return the number of words in the dictionary */
    public int size() { return this.dict.size(); }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {

        // If this dict contains word, return true
        if(this.dict.contains(s.toLowerCase())) {
            return true;
        }

        // Otherwise it doesn't, return false 
        return false;
    }

}
