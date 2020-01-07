/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tries;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ankss
 */
public class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfWords;
    
    public TrieNode(){
        this.endOfWords = false;
        this.children = new HashMap<>();
    }
    
}
