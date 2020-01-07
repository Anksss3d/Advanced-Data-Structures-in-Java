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
public class AVLNode {
    int val, height;
    AVLNode left;
    AVLNode right;
        
    public AVLNode(int x) {
        this.val = x;
        this.height = 0;
        this.left = this.right = null;
    }
    
    
}
