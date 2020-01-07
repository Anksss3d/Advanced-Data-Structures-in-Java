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
public class BST {
    BTNode root;
    public BST(){
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
            System.out.println("Tree is Empty");
        }
        else{
            this.searchIt(this.root, x);
        }
    }
    
    public void searchIt(BTNode root, int x){
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
            this.root = new BTNode(x);
            System.out.println("Tree is created with first element : "+ x);
        }
        else{
            this.addIt(this.root, x);
            System.out.println("Element is added to the BST : "+x);
        }
    }
    
    
    public void addIt(BTNode root, int x){
        if (root.val < x){
            if (root.right == null){
                root.right = new BTNode(x);
            } 
            else{
                this.addIt(root.right, x);
            }
        }else{
            if (root.left == null){
                root.left = new BTNode(x);
            } 
            else{
                this.addIt(root.left, x);
            }
        }
    }
    
    
    public void delete(int x){
        if (this.root == null){
            System.out.println("Tree is Empty...!");
        }
        if (this.root.val == x){
            this.deleteNode(null, this.root);
        }
        else{
            Stack<BTNode> st = new Stack<BTNode>();
            st.push(this.root);
            while(st.size() > 0){
                BTNode node = st.pop();
                if (node.right != null){
                    if (node.right.val == x){
                        this.deleteNode(node, node.right);
                        System.out.println("Node "+x+" deleted successfully");
                        return;
                    }
                    else{
                        st.push(node.right);
                    }
                }
                
                if (node.left != null){
                    if (node.left.val == x){
                        this.deleteNode(node, node.left);
                        return;
                    }
                    else{
                        st.push(node.left);
                    }
                }
            }
            System.out.println("node "+x+" not present in the treeso cannot delete it");
        }
    }
    
    public void deleteNode(BTNode parent, BTNode node){
        int count = this.children(node);
        if (count == 0){
            if (parent == null){
                this.root = null;
            }
            else if (parent.left == node){
                parent.left = null;
            }
            else{
                parent.right = null;
            }
        }
        else if (count == 1){
            if (parent == null){
                if (node.left != null){
                    this.root = node.left;
                }
                else{
                    this.root = node.right;
                }
            }
            else if (parent.left == node){
                if (node.left == null){
                    parent.left = node.right;
                }
                else{
                    parent.left = node.left;
                }
            }
            else{
                if (node.left == null){
                    parent.right = node.right;
                }
                else{
                    parent.right = node.left;
                }
            }
        }
        else{
            if (node.right.left == null){
                node.val = node.right.val;
                this.deleteNode(node, node.right);
            }
            else{
                BTNode[] pcpair = this.getAncestor(node.right);
                node.val = pcpair[1].val;
                this.deleteNode(pcpair[0], pcpair[1]);
            }
        }
    }
    
    public int children(BTNode node){
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
    
    public BTNode[] getAncestor(BTNode node){
        if (node.left.left == null){
            BTNode pcpair[] = new BTNode[2];
            pcpair[0] = node;
            pcpair[1] = node.left;
            return pcpair;
        }
        else{
            return this.getAncestor(node.left);
        }
    }
    
    
    public void deleteTree(){
        this.root = null;
        System.out.println("Tree Deleted Successfully");
    }
    
    
    
    
   
}
