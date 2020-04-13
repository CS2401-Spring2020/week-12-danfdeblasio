import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class myBinarySearchTreeTester {
  
  @Test
  public void testSingleNodeTree() {
    myBinarySearchTreeNode root = new myBinarySearchTreeNode(new int[] {10});
    assertEquals(0,root.height());
    assertEquals(0,root.depth(10));
    for(int i=-100; i<100; i++) {
      if(i!=10) assertEquals(-1,root.depth(i));
    }
  }
  
  @Test
  void testFindAfterInsert() {
    myBinarySearchTreeNode root = new myBinarySearchTreeNode(new int[] {10,5,15,2,7,12,17,1,3,6,8,11,13,16,18,4,9,14,19});
    assertEquals(-1,root.depth(0)); 
    root.insert(0);
    assertEquals(4,root.depth(0)); 
    assertEquals(-1,root.depth(20)); 
    root.insert(20);
    assertEquals(5,root.depth(20)); 
  }

  
  @Test
  public void testInsertSameInSingle() {
    myBinarySearchTreeNode root = new myBinarySearchTreeNode(new int[] {10});
    assertEquals(0,root.height());
    assertEquals(0,root.depth(10));
    for(int i=0; i<10; i++) {
      root.insert(10);
      assertEquals(-1,root.depth(0));
      assertEquals(0,root.height());
      assertEquals(0,root.depth(10));
    }
  }
  
  @Test
  void testFindAfterInsertNegs() {
    myBinarySearchTreeNode root = new myBinarySearchTreeNode(new int[] {-10,-5,-15,-2,-7,-12,-17,-1,-3,-6,-8,-11,-13,-16,-18,-4,-9,-14,-19});
    assertEquals(-1,root.depth(0)); 
    root.insert(0);
    assertEquals(4,root.depth(0)); 
    assertEquals(-1,root.depth(-20)); 
    root.insert(-20);
    assertEquals(5,root.depth(-20)); 
  }
  
  @Test
  void testFindAfterInsertMixed() {
    myBinarySearchTreeNode root = new myBinarySearchTreeNode(new int[] {-10,-5,-15,-2,-7,-12,-17,-1,-3,-6,-8,-11,-13,-16,-18,-4,-9,-14,-19, 10,5,15,2,7,12,17,1,3,6,8,11,13,16,18,4,9,14,19});
    assertEquals(-1,root.depth(0)); 
    root.insert(0);
    assertEquals(8,root.depth(0)); 
    assertEquals(-1,root.depth(-20)); 
    root.insert(-20);
    assertEquals(5,root.depth(-20)); 
    assertEquals(-1,root.depth(20)); 
    root.insert(20);
    assertEquals(9,root.depth(20)); 
  }
  
  @Test
  void testTotallyUnbalenced() {
    myBinarySearchTreeNode root = new myBinarySearchTreeNode(new int[] {0,1,2,3,4,5,6,7,8,9,10});
    assertEquals(10, root.height());
    for(int i=0; i<=10; i++) {
      assertEquals(i,root.depth(i));
    }
  }
  
}
