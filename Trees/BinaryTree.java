/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trees;
import java.util.LinkedList; 
import java.util.Queue; 
/**
 *
 * @author ankss
 */
public class BinaryTree {
    
    BTNode root;

    public BinaryTree() {
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
    
    private void inorder(BTNode node){
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
    
    private void preorder(BTNode node){
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
    
    private void postorder(BTNode node){
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
            Queue<BTNode> q = new LinkedList<>(); 
            q.add(this.root);
            while(q.size() > 0){
                BTNode node = q.remove();
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
            System.out.println("Tree is empty");
        }
        else{
//            System.out.println("Level Order Traversal :");
            Queue<BTNode> q = new LinkedList<>(); 
            q.add(this.root);
            while(q.size() > 0){
                BTNode node = q.remove();
                if (node.val == x){
                    System.out.println("Element "+x+" is there in tree");
                    return;
                } 
                if (node.left != null){
                    q.add(node.left);
                }
                if (node.right != null){
                    q.add(node.right);
                }
//                System.out.println(node.val + "\t");
            }
            System.out.println("Element "+x+" is not there in tree");
            
        }
    }
    
    
    public void add(int x){
        if (this.root == null){
            System.out.println("Tree is empty, creating new tree");
            this.root = new BTNode(x);
        }
        else{
            System.out.println("Insertion of new node : "+x);
            Queue<BTNode> q = new LinkedList<>(); 
            q.add(this.root);
            while(q.size() > 0){
                BTNode node = q.remove();

                if (node.left != null){
                    q.add(node.left);
                }
                else{
                    BTNode newNode = new BTNode(x);
                    node.left = newNode;
                    return;
                }
                
                if (node.right != null){
                    q.add(node.right);
                }
                else{
                    BTNode newNode = new BTNode(x);
                    node.right = newNode;
                    return;
                }
            }
        }
    }
    
    
    public void delete(int x){
        if (this.root == null){
            System.out.println("Tree is empty");
        }
        else{
//            System.out.println("Level Order Traversal :");
            Queue<BTNode> q = new LinkedList<>(); 
            q.add(this.root);
            while(q.size() > 0){
                BTNode node = q.remove();
                if (node.val == x){
                    System.out.println("Element "+x+" is there in tree");
                    this.deleteNode(node);
                    System.out.println("Element "+x+ " Deleted from tree");
                    return;
                } 
                if (node.left != null){
                    q.add(node.left);
                }
                if (node.right != null){
                    q.add(node.right);
                }
//                System.out.println(node.val + "\t");
            }
            System.out.println("Element "+x+" is not there in tree");
            
        }
    }
    
    
    private void deleteNode(BTNode delNode){
        Queue<BTNode> q = new LinkedList<>(); 
        if (this.root.left == null && this.root.right == null){
            this.root = null;
        }
        q.add(root.left);
        if (this.root.right != null){
            q.add(this.root.right);
        }
        BTNode prevNode = this.root;
        while(q.size() > 0){
            BTNode node = q.remove();
            if (node.left == null){
                delNode.val = prevNode.right.val;
                prevNode.right = null;
                return;
            }
            else{
                q.add(node.left);
            }
            if (node.right == null){
                delNode.val = node.left.val;
                node.left = null;
                return;
            }
            else{
                q.add(node.right);
            }
            prevNode = node;
        }
    }
    
    
    public void deleteTree(){
        if (this.root == null){
            System.out.println("Tree is Already Empty");
        }
        else{
            this.root = null;
            System.out.println("Tree Deleted Succesfully");
        }
    }
    
    
}

