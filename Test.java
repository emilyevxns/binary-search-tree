
import java.util.Random;

/**
 * Simple, non-exhaustive, test program to check that binary search trees can be
 * constructed. This test does not attempt to test the bst methods in any meaningful 
 * way.
 */
public class Test {
    /**
     * Instantiates a binary search tree, adds some data, and executes an inorder
     * traversal. This should display the values in order.
     *@param args ignored
     */
    @SuppressWarnings("unchecked")
	public static void main(String[] args) {
        Random rand = new Random();
        BST<Integer> tree = new BST<Integer>();
        for(int i=0; i<10; i++) {
            try {
                tree.find(i);
                i++;
            } catch(ElementNotFoundException e) {
                tree.add(rand.nextInt());
            }
        }
        IList<Integer> lst = (IList<Integer>) new ArrayList<Integer>();
        tree.inorderTraversal(lst);
        for(int i=0; i<lst.size(); i++) {
            System.out.println(lst.get(i));
        }
    }
}

