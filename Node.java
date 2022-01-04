
/**
 * Represents a node in an Integer BST
 * @author ea_ev
 * @param <E>
 *
 */
public class Node<E extends Comparable> {
	// Kids 
	private Node left;
	private Node right;
	// Value at this node
	private E value;
	
	/**
	 * Int represents value
	 */
	
	public Node(E v) {
		value = v;
		left = null;
		right = null;
	}
	
	/**
	 * Sets right child
	 * @param r node to be right kid
	 */
	public void setRight(Node r) {
		right = r;
	}
	
	/**
	 * Set left child 
	 * @param l child to set as left child
	 */
	public void setLeft(Node l) {
		left = l;
	}
	
	/**
	 * Get value of node
	 * @return value of node
	 */
	public E getValue() {
		return value;
	}
	
	/**
	 * Get right child
	 * @return right chile
	 */
	public Node getRight() {
		return right;
	}
	
	/**
	 * Get left child node
	 * @return left child
	 */
	public Node getLeft() {
		return left;
	}
	
	/**
	 * Finds value if it exists in the children 
	 * @param i the value to find 
	 * @return E value of node
	 */
	
	public boolean find (E e) {
		if(e.compareTo(this.getValue())==0) {
			return true;
		}
		if (e.compareTo(this.getValue())>0) {
			if (getRight()==null) {
				return false;
			}
			return right.find(e);
		}
		else{
			if (getLeft()==null) {
				return false;
			}
			return left.find(e);
		}
	}
}
