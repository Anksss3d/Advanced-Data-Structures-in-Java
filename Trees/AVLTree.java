/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author ankss
 */
public class AVLTree {
    
    AVLNode root;
    public AVLTree(){
        this.root = null;
    }
    
    
    public void inorderTraverse(){
        if (this.root == null){
            System.out.println("Tree is empty");
        }
        else{
            System.out.println("InOrder Traversal : ");
            this.inorder(root);
            System.out.println("");
        }
    }
    
    
    private void inorder(AVLNode node){
        if(node == null){
            return;
        }
        else{
            this.inorder(node.left);
            System.out.print(node.val + "\t");
            this.inorder(node.right);
        }
    }
    

    public void preorderTraverse(){
        if (this.root == null){
            System.out.println("Tree is empty");
        }
        else{
            System.out.println("PreOrder Traversal : ");
            this.preorder(root);
            System.out.println("");
        }
    }
    
    
    private void preorder(AVLNode node){
        if(node == null){
            return;
        }
        else{
            System.out.print(node.val + "\t");
            this.preorder(node.left);
            this.preorder(node.right);
        }
    }
    
    
    public void postorderTraverse(){
        if (this.root == null){
            System.out.println("Tree is empty");
        }
        else{
            System.out.println("PostOrder Traversal : ");
            this.postorder(root);
            System.out.println("");
        }
    }
    
    
    private void postorder(AVLNode node){
        if(node == null){
            return;
        }
        else{
            this.postorder(node.left);
            this.postorder(node.right);
            System.out.print(node.val + "\t");
        }
    }
    
    
    public void levelOrderedTraversal(){
        if (this.root == null){
            System.out.println("Tree is empty");
        }
        else{
            System.out.println("Level Order Traversal :");
            Queue<AVLNode> q = new LinkedList<>(); 
            q.add(this.root);
            while(q.size() > 0){
                AVLNode node = q.remove();
                if (node.left != null){
                    q.add(node.left);
                }
                if (node.right != null){
                    q.add(node.right);
                }
                System.out.print(node.val + "\t");
            }
            System.out.println();
        }
    }
    
    
    public void search(int x){
        if (this.root == null){
            System.out.println("Tree is Empty");
        }
        else{
            this.searchIt(this.root, x);
        }
    }
    
    
    public void searchIt(AVLNode root, int x){
        if (root == null){
            System.out.println("Element "+x+" is not present in the BST");
        }
        else{
            if (root.val == x){
                System.out.println("Element "+x+" is present in the BST");
            } 
            else if (x > root.val){
                this.searchIt(root.right, x);
            }
            else{
                this.searchIt(root.left, x);
            }
        }
    }
    
    
    public void add(int x){
        if (this.root == null){
            this.root = new AVLNode(x);
            System.out.println("Tree is created with first element : "+ x);
        }
        else{
            this.root = this.insert(this.root, x);
            System.out.println("Element is added to the BST : "+x);
        }
    }
      
    
    private AVLNode insert(AVLNode root, int val){
        if (root == null){
            return new AVLNode(val);
        }
        else if(val <= root.val){
            root.left = this.insert(root.left, val);
        }
        else{
            root.right = this.insert(root.right, val);
        }
        
        int balance = this.height(root.left) - this.height(root.right);
        if (balance > 1){
            if (this.height(root.left.left) >= this.height(root.left.right)){
                root = this.rightRotate(root);
                System.out.println("LL Case on :"+root.val);
            }  
            else{
                root.left = this.leftRotate(root.left);
                root = this.rightRotate(root);
                System.out.println("LR Case on :"+root.val);
            }
        }
        else if (balance < -1){
            if (this.height(root.right.right) >= this.height(root.right.left)){
                root = this.leftRotate(root);
                System.out.println("RR Case on :"+root.val);
            }  
            else{
                root.right = this.rightRotate(root.right);
                root = this.leftRotate(root);
                System.out.println("RL Case on :"+root.val);
            }
        }
        root.height = Integer.max(this.height(root.left), this.height(root.right)) + 1;  
        return root;
    }
    
    
    private AVLNode rightRotate(AVLNode node){
        AVLNode newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        this.setHeight(node, this.calculateHeight(node));
        this.setHeight(newRoot, this.calculateHeight(newRoot));
        return newRoot;
                
    }
    
    
    private AVLNode leftRotate(AVLNode node){
        AVLNode newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left  = node;
        this.setHeight(node, this.calculateHeight(node));
        this.setHeight(newRoot, this.calculateHeight(newRoot));
        return newRoot;
        
    }
    
    
    private int height(AVLNode node){
        if (node == null){
            return -1;
        }
        else{
            return node.height;
        }
    }
    
    
    public void delete(int x){
        if (this.root == null){
            System.out.println("The tree is empty, cannot delete element : "+ x);
        }
        else{
            this.root = this.deleteNode(this.root, x);
            System.out.println("Deletion Completed for element : "+ x);
        }
    }
    
    
    private AVLNode deleteNode(AVLNode root, int x){
        if (root == null){
            System.out.println("Couldn't found element : "+x);
            return null;
        }else if (x < root.val){
            root.left = this.deleteNode(root.left, x);
        }else if (x > root.val){
            root.right = this.deleteNode(root.right, x);
        }
        else{
            int child = this.children(root);
            if (child == 0){
                root = null;
                return null;
            }
            else  if (child == 1){
                if (root.left != null){
                    root = root.left;
                }
                else{
                    root = root.right;
                }
            }
            else{
                AVLNode node = root.right;
                while (node.left != null){
                    node = node.left;
                }
                root.val = node.val;
                root.right = this.deleteNode(root.right, node.val);
            }   
        }
        
        
        int balance = this.height(root.left) - this.height(root.right);
        if (balance > 1){
            if (this.height(root.left.left) >= this.height(root.left.right)){
                this.rightRotate(root);
                System.out.println("LL Case");
            }  
            else{
                this.leftRotate(root.left);
                this.rightRotate(root);
                System.out.println("LR Case");
            }
        }
        else if (balance < -1){
            if (this.height(root.right.right) >= this.height(root.right.left)){
                this.leftRotate(root);
                System.out.println("RR Case");
            }  
            else{
                this.rightRotate(root.right);
                this.leftRotate(root);
                System.out.println("RL Case");
            }
        }
        this.setHeight(root.left, this.calculateHeight(root.left));
        this.setHeight(root.right, this.calculateHeight(root.right));
        root.height = Integer.max(this.height(root.left), this.height(root.right)) + 1;  
        return root;
        
        
    }
    
    
    private void setHeight(AVLNode node, int height){
        if (node != null){
            node.height = height;
        }           
    }
    
    
    private int calculateHeight(AVLNode node){
        if (node == null){
            return -1;
        }
        else{
            return Integer.max(this.calculateHeight(node.left), this.calculateHeight(node.right)) + 1;
        }
    }
    
    
    public int children(AVLNode node){
        if (node == null){
            return 0;
        }
        else if (node.left == null && node.right == null){
            return 0;
        }
        else if (node.left == null || node.right == null){
            return 1;
        }
        else{
            return 2;
        }
    }
    
    
    public void deleteTree(){
        this.root = null;
        System.out.println("Tree Deleted Successfully");
    }
    
   
}
