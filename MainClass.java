
import Heap.MaxHeap;
import Heap.MinHeap;
import Trees.AVLTree;
import Trees.BST;
import Trees.BinaryTree;
import Trees.BinaryTreeArray;
import Tries.Trie;
/**
 *
 * @author ankss
 */
public class MainClass {
    public static void main(String[] args) {
        // callBST();
    }
    
    public static void callBinaryTree(){
        BinaryTree bt = new BinaryTree();
        bt.levelOrderedTraversal();
        bt.add(100);
        bt.add(105);
        bt.add(120);
        bt.levelOrderedTraversal();
        bt.add(99);
        bt.add(2673);
        bt.add(109);
        bt.levelOrderedTraversal();
        bt.inorderTraverse();
        bt.preorderTraverse();
        bt.postorderTraverse();
        bt.search(99);
        bt.search(1092);
        bt.search(100);
        bt.search(109);
        bt.delete(100);
        bt.levelOrderedTraversal();
    }
    
    
    
    public static void callBinaryTreeArray(){
        BinaryTreeArray bt = new BinaryTreeArray(10);
        bt.levelOrderedTraversal();
        bt.add(100);
        bt.add(105);
        bt.add(120);
        bt.levelOrderedTraversal();
        bt.add(99);
        bt.add(2673);
        bt.add(109);
        bt.levelOrderedTraversal();
        bt.inorderTraverse();
        bt.preorderTraverse();
        bt.postorderTraverse();
        bt.search(99);
        bt.search(1092);
        bt.search(100);
        bt.search(109);
        bt.delete(100);
        bt.levelOrderedTraversal();
    }
    
    
    public static void callBST(){
        BST bt = new BST();
        bt.levelOrderedTraversal();
        bt.add(100);
        bt.add(105);
        bt.add(120);
        bt.levelOrderedTraversal();
        bt.add(99);
        bt.add(2673);
        bt.add(109);
        bt.levelOrderedTraversal();
        bt.inorderTraverse();
        bt.preorderTraverse();
        bt.postorderTraverse();
        bt.search(99);
        bt.search(1092);
        bt.search(100);
        bt.search(109);
        bt.delete(100);
        bt.levelOrderedTraversal();
        bt.deleteTree();
        bt.levelOrderedTraversal();
    }
    
    
    public static void callAVLTree(){
        AVLTree bt = new AVLTree();
        bt.levelOrderedTraversal();
        bt.inorderTraverse();
        bt.add(30);
        bt.levelOrderedTraversal();
        bt.inorderTraverse();
        bt.add(20);
        bt.levelOrderedTraversal();
        bt.inorderTraverse();
        bt.add(40);
        bt.levelOrderedTraversal();
        bt.inorderTraverse();
        bt.add(10);
        bt.levelOrderedTraversal();
        bt.inorderTraverse();
        bt.add(5);
        bt.levelOrderedTraversal();
        bt.inorderTraverse();
        bt.add(3);
        bt.levelOrderedTraversal();
        bt.inorderTraverse();
        bt.add(4);
        bt.levelOrderedTraversal();
        bt.inorderTraverse();
        bt.add(50);
        bt.levelOrderedTraversal();
        bt.inorderTraverse();
        bt.add(60);
        bt.levelOrderedTraversal();
        bt.inorderTraverse();
        bt.add(70);
        bt.levelOrderedTraversal();
        bt.inorderTraverse();
        bt.add(65);
        bt.levelOrderedTraversal();
        bt.inorderTraverse();
        bt.preorderTraverse();
        bt.postorderTraverse();
        bt.search(99);
        bt.search(1092);
        bt.search(100);
        bt.search(109);
                
        bt.delete(100);
        bt.delete(10);
        bt.delete(40);
        bt.delete(3);
        bt.levelOrderedTraversal();
        bt.inorderTraverse();
        bt.deleteTree();
        bt.levelOrderedTraversal();
    }
    
    
    
    
    public static void callMinHeap(){
        MinHeap q = new MinHeap(10);
        q.levelOrderedTraversal();
        q.add(10);
        q.add(76);
        q.add(5);
        q.levelOrderedTraversal();
        q.add(1);
        q.levelOrderedTraversal();
        q.add(29);
        q.levelOrderedTraversal();
        q.add(10);
        q.add(22);
        q.add(5);
        q.levelOrderedTraversal();
        System.out.println("extracted : "+q.extractMin());
        System.out.println("extracted : "+q.extractMin());
        System.out.println("extracted : "+q.extractMin());
        System.out.println("extracted : "+q.extractMin());
        System.out.println("extracted : "+q.extractMin());
        System.out.println("extracted : "+q.extractMin());
        System.out.println("extracted : "+q.extractMin());
        System.out.println("extracted : "+q.extractMin());
        System.out.println("extracted : "+q.extractMin());
        q.deleteHeap();
        q.levelOrderedTraversal();
        
    }  

    public static void callMaxHeap(){
        MaxHeap q = new MaxHeap(10);
        q.levelOrderedTraversal();
        q.add(10);
        q.add(76);
        q.add(5);
        q.levelOrderedTraversal();
        q.add(1);
        q.levelOrderedTraversal();
        q.add(29);
        q.levelOrderedTraversal();
        q.add(10);
        q.add(22);
        q.add(5);
        q.levelOrderedTraversal();
        System.out.println("extracted : "+q.extractMin());
        System.out.println("extracted : "+q.extractMin());
        System.out.println("extracted : "+q.extractMin());
        System.out.println("extracted : "+q.extractMin());
        System.out.println("extracted : "+q.extractMin());
        System.out.println("extracted : "+q.extractMin());
        System.out.println("extracted : "+q.extractMin());
        System.out.println("extracted : "+q.extractMin());
        System.out.println("extracted : "+q.extractMin());
        q.deleteHeap();
        q.levelOrderedTraversal();
        
    }      
    
    
    public static void callTrie(){
        Trie t = new Trie();
        t.add("Ankur");
        t.add("Ashita");
        t.add("Ank");
        t.add("Anksss");
        t.add("lol");
        System.out.println(t.search("Ankur"));
        System.out.println(t.search("An"));
        System.out.println(t.search("Ashita"));
        System.out.println(t.search("Ashitas"));
        System.out.println(t.search("Ankss"));
        System.out.println(t.search("Anksss"));
        t.delete("Anksss");
        t.delete("Ankss");
        t.search("Anksss");
        t.deleteTrie();
    }
}
