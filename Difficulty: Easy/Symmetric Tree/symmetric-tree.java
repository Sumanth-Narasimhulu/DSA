/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/
class Solution {
    public boolean f(Node root1,Node root2){
        if(root1==null && root2!=null)return false;
        if(root1==null && root2==null)return true;
        return (root1.data==root2.data)&&f(root1.left,root2.right)&&f(root1.right , root2.left);
        
    }
    public boolean isSymmetric(Node root) {
        // Code here
        if(root==null)return false;
        if(root.left == null && root.right !=null)return false;
        if(root.left!=null && root.right ==null)return false;
        return f(root.left,root.right);

    }
}