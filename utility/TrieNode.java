package utility;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    public Map<Character, TrieNode> map = new HashMap<>();
    public boolean isWord;
}