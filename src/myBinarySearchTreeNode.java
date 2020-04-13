class myBinarySearchTreeNode{
  int myValue;
  myBinarySearchTreeNode left;
  myBinarySearchTreeNode right;
    
  myBinarySearchTreeNode(int inValue){
    // created a new node with empty child pointers
    myValue = inValue;
  }
  
  myBinarySearchTreeNode(int[] A){
    // creates a new Binary Search Tree rooted at the first value in the array
    /// by inserting elements into the tree in the order they are given in A.
    
    //empty array, do nothing
    if(A.length == 0) return;
    
    // this node is the root
    myValue = A[0];
    
    // use the existing insert function on myself to add the rest of the elements
    for(int i=1; i<A.length; i++)
      insert(A[i]);
  }
  
  public void insert(int inValue){
    // This method takes a new integer as input and decides 
    // if it should be place: 
    //    * as the left child,
    if(left == null && inValue < myValue) left = new myBinarySearchTreeNode(inValue);
    //    * as the right child, 
    else if(right == null && inValue > myValue) right = new myBinarySearchTreeNode(inValue);
    //    * in the left subtree,
    else if(inValue < myValue) left.insert(inValue);
    //    * or in the right subtree.
    else if(inValue > myValue) right.insert(inValue);
    // If the value already exists in the tree, no action is taken. 
    
  }
  
  public int height(){
     // This method recursively calculates the height of the entire (sub)tree.
     // This method will take O(n) time
    
    // holds the height of the tallest child subtree
    int max = 0;
    
    // if the left subtree is not empty, check its height
    if(left != null) {
      int leftH = left.height() + 1;
      if(leftH > max) max = leftH;
    }
    
    // if the right subtree is not empty, check its height
    if(right != null) {
      int rightH = right.height() + 1;
      if(rightH > max) max = rightH;
    }
    
    // return the tallest subtree height plus my row
    return max;
  }
  
  public int depth(int search){
     // This method recursively calculates the depth of a given search value. 
     // If the given value is not in the tree, this method returns -1. 
     // Note that if the tree is a proper BST, this method should complete in O(log n) time.
    
    // if this node is the target, start the cascade of incrementors
    if(myValue == search) return 0;

    // if its not this node, but the value is smaller look on the left child (if its not null)
    else if(myValue > search) {
      if(left != null) {
        int depth = left.depth(search);
        
        // the returned value is the path length from the target to this node, 
        //   so add myself to the path length and pass it back to the caller
        if(depth!=-1) return depth+1;
      }

    // if its not this node, the value is not smaller look on the right child (if its not null)
    }else {
      if(right != null) {
        int depth = right.depth(search);

        // the returned value is the path length from the target to this node, 
        //   so add myself to the path length and pass it back to the caller
        if(depth!=-1) return depth+1;
      }
    }
    
    // it wasn't this node, and it wasn't in the correct child (or the child was null)
    return -1;
  }
  
  public void print() { print(""); }
  private void print(String prefix) {
    System.out.println(prefix + myValue);
    prefix = prefix.replace('\u251C', '\u2502');
    prefix = prefix.replace('\u2514', ' ');
    if(left != null) left.print(prefix + "\u251C ");
    if(right != null) right.print(prefix + "\u2514 ");
  }
  
} 