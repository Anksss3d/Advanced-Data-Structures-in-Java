/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tries;

/**
 *
 * @author ankss
 */
public class Trie {
    TrieNode root;
    
    
    public Trie(){
        this.root = new TrieNode();
    }
    
    
    public void add(String str){
        
        TrieNode temp = this.root;
        for (int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            TrieNode node = temp.children.get(ch);
            if (node == null){
                node = new TrieNode();
                temp.children.put(ch, node);
            }
            temp = node;
        }
        temp.endOfWords = true;
        System.out.println("String inserted : "+str);
    }
    
    
    public boolean search(String str){
        if (this.root == null){
            System.out.println("Trie is Empty!");
            return false;
        }
        TrieNode temp= this.root;
        for (int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            TrieNode node = temp.children.get(ch);
            if (node == null){
                System.out.println("String doesnt Exists in Trie : "+str);
                return false;
            }
            temp = node;
        }
        if (temp.endOfWords){
            System.out.println("String exists in trie: "+str);
            return true;
        }
        else{
            System.out.println("String"+str+" doesnt exists in trie, but it is prefix of some another string");
            return false;
        }
    }
    
    
    public void delete(String str){
        if(this.search(str)){
            this.deleteString(this.root, str, 0);
            System.out.println("String deleted from Trie");
        }
        else{
            System.out.println("String is not available in the Trie");
        }
    }
    
    
    private boolean deleteString(TrieNode parent, String str, int ind){
        char ch = str.charAt(ind);
        TrieNode temp = parent.children.get(ch);
        if (temp.children.size() > 1){
            this.deleteString(temp, str, ind+1);
            return false;
        }
        
        if (ind == str.length()-1){
            if (temp.children.size() >= 1){
                temp.endOfWords = false;
                return false;
            }
            else{
                parent.children.remove(ch);
                return true;
            }
        }
        
        
        if (temp.endOfWords == true){
            this.deleteString(temp, str, ind+1);
            return false;
        }
        
        
        boolean check = this.deleteString(temp, str, ind+1);
        if(check){
            parent.children.remove(ch);
            return true;
        }
        else{
            return false;
        }
        
    }
    
    public void deleteTrie(){
        this.root = new TrieNode();
        System.out.println("Trie Deleted");
    }
    
}