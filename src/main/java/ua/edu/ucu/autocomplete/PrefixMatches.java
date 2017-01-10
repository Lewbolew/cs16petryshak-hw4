package ua.edu.ucu.autocomplete;

import ua.edu.ucu.tries.Trie;
import ua.edu.ucu.tries.Tuple;

import java.util.LinkedList;

/**
 *
 * @author andrii
 */
public class PrefixMatches {

    private Trie trie;

    public PrefixMatches(Trie trie) {
        this.trie = trie;
    }

    public int load(String... strings) {
        int result = 0;
        for(int i = 0; i < strings.length; i++) {
            for(String element: strings[i].split(" ")) {
                if(element.length() > 2) {
                    result += 1;
                    trie.add(new Tuple(element, element.length()));
                }
            }
        }
        return result;
    }

    public boolean contains(String word) {
        return trie.contains(word);
    }

    public boolean delete(String word) {
        if(contains(word)) {
            trie.delete(word);
            return true;
        }
        return false;
    }

    public Iterable<String> wordsWithPrefix(String pref) {
        if(pref.length() >= 2) {
            return  trie.wordsWithPrefix(pref);
        }
        return null;
    }

    public Iterable<String> wordsWithPrefix(String pref, int k) {
        Iterable<String> wordsWiPref = trie.wordsWithPrefix(pref);
        LinkedList<String> result = new LinkedList<>();
        for(String word: wordsWiPref) {
            if(word.length() < pref.length() + k) {
                result.add(word);
            }
        }
        return result;
    }

    public int size() {
        return trie.size();
    }
}
