/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heap;

/**
 *
 * @author ankss
 */
public class MinHeap {
    int[] arr;
    int peak, len;
    
    public MinHeap(int N){
        this.len = N+1;
        arr = new int[N+1];
        this.arr[0] = 0;
        this.peak = 0;
        
    }
    
    public void levelOrderedTraversal(){
        if (this.peak == 0){
            System.out.println("Heap is empty !");
        }
        else{
            System.out.println("Level Order Traversal is: ");
            for (int i = 1; i<=this.peak; i++){
                System.out.print(this.arr[i] + "\t");
            }
            System.out.println("");
        }
    }
    
    public int peak(){
        if (this.peak == 0){
            System.out.println("Heap is Empty");
            return Integer.MIN_VALUE;
        }
        else{
            return this.arr[1];
        }
    }
    
    
    public int extractMin(){
        if (this.peak == 0){
            System.out.println("Heap is Empty");
            return Integer.MIN_VALUE;
        }
        else{
            int temp = this.arr[1];
            this.arr[1] = this.arr[this.peak];
            this.peak--;
            this.heapifyTopToBottom();
            
            return temp;
            
        }
    }
    
    
    public void add(int x){
        if (this.peak == this.len){
            System.out.println("Heap is Full, cannot add data!");
        }
        else if (this.peak == 0){
            System.out.println("Heap is Empty, creating first node : "+x);
            this.peak++;
            this.arr[this.peak] = x;
        }
        else{
            this.peak++;
            this.arr[this.peak] = x;
            this.heapifyBottomToTop();
            System.out.println("Element added successfully : "+x);
            
        }
    }
    
    
    public void deleteHeap(){
        if (this.peak == 0){
            System.out.println("Heap is already empty!");
        }
        else{
            this.peak = 0;
            System.out.println("Heap is deleted");
        }
    }
    
    private void heapifyTopToBottom(){
        int temppeak = 1;
        while ((2*temppeak) <= this.peak){
            int lc = 2 * temppeak;
            int rc = lc + 1;
            if (lc > this.peak){
                break;
            }
            else if (rc > this.peak){
                if (this.arr[temppeak] > this.arr[lc]){
                    int temp = this.arr[temppeak];
                    this.arr[temppeak] = this.arr[lc];
                    this.arr[lc] = temp;
                    temppeak = lc;
                }
                else{
                    break;
                }
            }
            else{
                if (this.arr[temppeak] < this.arr[lc] && this.arr[temppeak] < this.arr[rc]){
                    break;
                }  
                else{
                    if (this.arr[lc] < this.arr[rc]){
                        int temp = this.arr[temppeak];
                        this.arr[temppeak] = this.arr[lc];
                        this.arr[lc] = temp;
                        temppeak = lc;
                    }
                    else{
                        int temp = this.arr[temppeak];
                        this.arr[temppeak] = this.arr[rc];
                        this.arr[rc] = temp;
                        temppeak = rc;
                    }
                }
            }  
        }
    }
    
    
    
    private void heapifyBottomToTop(){
        int temppeak = this.peak;
        while (temppeak > 1){
            int parent = (int)Math.floor(temppeak / 2);
            if (this.arr[parent] > this.arr[temppeak]){
                int temp = this.arr[temppeak];
                this.arr[temppeak] = this.arr[parent];
                this.arr[parent] = temp;
                temppeak = parent;
            }
            else{
                break;
            }
  
        }
    }
    
    
    
    
}
