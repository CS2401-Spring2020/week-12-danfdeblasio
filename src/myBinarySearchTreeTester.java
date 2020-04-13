import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class myBinarySearchTreeTester {
  
  @Test
  public void testSingleNodeTree() {
    myBinarySearchTreeNode root = new myBinarySearchTreeNode(new int[] {10});
    assertEquals(1, root.size());
    assertEquals(0,root.height());
    assertEquals(0,root.depth(10));
    for(int i=-100; i<100; i++) {
      if(i!=10) assertEquals(-1,root.depth(i));
    }
  }
  
  @Test
  void testFindAfterInsert() {
    myBinarySearchTreeNode root = new myBinarySearchTreeNode(new int[] {10,5,15,2,7,12,17,1,3,6,8,11,13,16,18,4,9,14,19});
    assertEquals(19, root.size());
    assertEquals(-1,root.depth(0)); 
    root.insert(0);
    assertEquals(4,root.depth(0)); 
    assertEquals(20, root.size());
    assertEquals(-1,root.depth(20)); 
    root.insert(20);
    assertEquals(5,root.depth(20)); 
    assertEquals(21, root.size());
  }

  
  @Test
  public void testInsertSameInSingle() {
    myBinarySearchTreeNode root = new myBinarySearchTreeNode(new int[] {10});
    assertEquals(0,root.height());
    assertEquals(0,root.depth(10));
    assertEquals(1, root.size());
    for(int i=0; i<10; i++) {
      root.insert(10);
      assertEquals(-1,root.depth(0));
      assertEquals(0,root.height());
      assertEquals(0,root.depth(10));
      assertEquals(1, root.size());
    }
  }
  
  @Test
  void testFindAfterInsertNegs() {
    myBinarySearchTreeNode root = new myBinarySearchTreeNode(new int[] {-10,-5,-15,-2,-7,-12,-17,-1,-3,-6,-8,-11,-13,-16,-18,-4,-9,-14,-19});
    assertEquals(19, root.size());
    assertEquals(-1,root.depth(0)); 
    root.insert(0);
    assertEquals(4,root.depth(0)); 
    assertEquals(20, root.size());
    assertEquals(-1,root.depth(-20)); 
    root.insert(-20);
    assertEquals(5,root.depth(-20)); 
    assertEquals(21, root.size());
  }
  
  @Test
  void testFindAfterInsertMixed() {
    myBinarySearchTreeNode root = new myBinarySearchTreeNode(new int[] {-10,-5,-15,-2,-7,-12,-17,-1,-3,-6,-8,-11,-13,-16,-18,-4,-9,-14,-19, 10,5,15,2,7,12,17,1,3,6,8,11,13,16,18,4,9,14,19});
    assertEquals(38, root.size());
    assertEquals(-1,root.depth(0)); 
    root.insert(0);
    assertEquals(8,root.depth(0)); 
    assertEquals(39, root.size());
    assertEquals(-1,root.depth(-20)); 
    root.insert(-20);
    assertEquals(5,root.depth(-20)); 
    assertEquals(40, root.size());
    assertEquals(-1,root.depth(20)); 
    root.insert(20);
    assertEquals(9,root.depth(20)); 
    assertEquals(41, root.size());
  }
  
  @Test
  void testTotallyUnbalenced() {
    myBinarySearchTreeNode root = new myBinarySearchTreeNode(new int[] {0,1,2,3,4,5,6,7,8,9,10});
    assertEquals(10, root.height());
    assertEquals(11, root.size());
    for(int i=0; i<=10; i++) {
      assertEquals(i,root.depth(i));
    }
  }
  
  @Test
  void testTotallyUnbalenced2() {
    myBinarySearchTreeNode root = new myBinarySearchTreeNode(new int[] {10,9,8,7,6,5,4,3,2,1,0});
    assertEquals(10, root.height());
    assertEquals(11, root.size());
    for(int i=0; i<=10; i++) {
      assertEquals(10-i,root.depth(i));
    }
  }
  
  @Test
  void testSubtreeSize() {
    myBinarySearchTreeNode root = new myBinarySearchTreeNode(new int[] {10,5,15,2,7,12,17,1,3,6,8,11,13,16,18,4,9,14,19});
    assertEquals(19, root.size());
    assertEquals(9, root.left.size());
    assertEquals(9, root.right.size());
    assertEquals(4, root.left.left.size());
    assertEquals(4, root.right.left.size());
    assertEquals(4, root.left.right.size());
    assertEquals(4, root.right.right.size());
    
    assertEquals(4, root.height());
    assertEquals(3, root.left.height());
    assertEquals(3, root.right.height());
    assertEquals(2, root.left.left.height());
    assertEquals(2, root.right.left.height());
    assertEquals(2, root.left.right.height());
    assertEquals(2, root.right.right.height());
    
    
  }
  
}
