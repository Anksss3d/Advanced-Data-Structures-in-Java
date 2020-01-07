/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trees;


/**
 *
 * @author ankss
 */


public class BinaryTreeArray {
    int[] arr;
    int size;
    int last;
    public BinaryTreeArray(int size){
        this.arr = new int[size+1];
        this.size = size+1;
        this.last = 0;
        for (int i=0;i<size+1; i++){
            arr[i] = Integer.MIN_VALUE;
        }        
    }
    
    
    public void add(int x){
        if(this.last == this.size-1){
            System.out.println("Tree is full");
        }
        else{
            this.last++;
            this.arr[this.last] = x;
            System.out.println("Element "+x+ " Added to binary tree");
        }
    }
    
    public void levelOrderedTraversal(){
        if (this.last == 0){
            System.out.println("Tree is empty !");
        }
        else{
            System.out.println("Level Order Traversal is: ");
            for (int i = 1; i<=this.last; i++){
                System.out.print(this.arr[i] + "\t");
            }
            System.out.println("");
        }
    }
    
    public void delete(int x){
        if (this.last == 0){
            System.out.println("Tree is Empty");
        }
        else{
            for(int i = 1; i <= this.last; i++){
                if (this.arr[i] == x){
                    this.arr[i] = arr[this.last];
                    arr[this.last] = Integer.MIN_VALUE;
                    this.last--;
                    System.out.println("Element "+x+" deleted successfully");
                    return;
                }
            }
            System.out.println("Element "+x+" is not present in tree! ");
        }
    }
    
    
    public void search(int x){
        if (this.last == 0){
            System.out.println("Tree is Empty");
        }
        else{
            for(int i = 1; i <= this.last; i++){
                if (this.arr[i] == x){
                    System.out.println("Element "+x+" is present in Tree!");
                    return;
                }
            }
            System.out.println("Element "+x+" is not present in tree! ");
        }
    }
    
    
    public void inorderTraverse(){
        if (this.last == 0){
            System.out.println("Tree is empty");
        }
        else{
            System.out.println("InOrder Traversal : ");
            this.inorder(1);
            System.out.println("");
        }
    }
    
    private void inorder(int ind){
        if(ind > this.last){
            return;
        }
        else{
            this.inorder(2 * ind);
            System.out.print(arr[ind] + "\t");
            this.inorder(2*ind + 1);
        }
    }
    
    public void preorderTraverse(){
        if (this.last == 0){
            System.out.println("Tree is empty");
        }
        else{
            System.out.println("PreOrder Traversal : ");
            this.preorder(1);
            System.out.println("");
        }
    }
    
    private void preorder(int ind){
        if(ind > this.last){
            return;
        }
        else{
            System.out.print(arr[ind] + "\t");
            this.preorder(2 * ind);
            this.preorder(2*ind + 1);
        }
    }
    
    
    public void postorderTraverse(){
        if (this.last == 0){
            System.out.println("Tree is empty");
        }
        else{
            System.out.println("PostOrder Traversal : ");
            this.postorder(1);
            System.out.println("");
        }
    }
    
    private void postorder(int ind){
        if (ind > this.last){
            return;
        }
        else{
            this.postorder(2 * ind);
            this.postorder(2*ind + 1);
            System.out.print(arr[ind] + "\t");
        }
    }
       
}
