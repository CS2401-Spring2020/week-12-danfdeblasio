
public class myBinarySearchTreeTester {

  public static void main(String[] args) {
    myBinarySearchTreeNode root = new myBinarySearchTreeNode(new int[] {10,5,15,2,7,12,17,1,3,6,8,11,13,16,18,4,9,14,19});
    root.print();
    System.out.println("Height at root: " + root.height());
    System.out.println("Height at 1: " + root.left.left.left.height());
    System.out.println("Height at 3: " + root.left.left.right.height());
    for(int i=0; i<=20; i++) {
      System.out.println("Depth of " + i + ": " + root.depth(i));
    }

  }

}
