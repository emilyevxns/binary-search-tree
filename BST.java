
public class BST<E extends Comparable> implements IBST<E>, ITraversableTree<E> {
	private Node root;
	
	/**
	 * Generates an empty tree
	 */
	public BST() {
		// List is empty
		root = null;
	}
	
	/** Adds a new item to the binary search tree
     *  <p>Duplicate values are not supported by the IBST interface since
     *  placement in the right or left child is ambiguous. Duplicates are
     *  are detected using the compareTo, values are considered the same
     *  if the compareTo method returns 0. The results of the equals method 
     *  are ignored for determining duplication. Attempting to add a duplicate
     *  value should throw an execption and should not modify the tree.
     *@param e item to add
     *@throws DuplicatesNotSupportedException when a duplicate value is detected
     */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void add(E e) {
		// TODO Auto-generated method stub
		// Make new node
		Node newborn = new Node(e);
		// Tree is empty case
		if (root == null) {
			root = newborn;
			return;
		}
		else {
		// Take current = root
		Node current = root;
		// Begin at current and compare root.getValue() with n
		while (true) {
		// If duplicate throw exception
		if (e.compareTo(current.getValue()) == 0) {
			throw new DuplicatesNotSupportedException();
		}
		// If current > n -> go to left of the root
		else if (e.compareTo(current.getValue()) < 0) {
			// When current == null, reached leaf node & insert node here
			if (current.getLeft() == null) {
				current.setLeft(newborn);
				break;
			}
			current = current.getLeft();
		}
		else if (e.compareTo(current.getValue()) > 0) {
			if (current.getRight() == null) {
				current.setRight(newborn);
				break;
			}
			current = current.getRight();
			}
		}
	}
}

	 /** Finds an item in the binary search tree
     *  <p>An item matches if the compareTo method returns 0
     *@param e item to find
     *@returns the matching item in the tree
     *@throws ElementNotFoundException when there is no matching element
     */
	@SuppressWarnings("unchecked")
	@Override
	public E find(E e) throws ElementNotFoundException {
		// TODO Auto-generated method stub
		if (root == null) {
			throw new ElementNotFoundException();
		}
		else {
			if (root.find(e) == false) {
				throw new ElementNotFoundException();
			}
			else {
				Node c = root;
				while (true) {
					if (e.compareTo(c.getValue()) == 0) {
						break;
					}
					else {
						if (e.compareTo(c.getValue()) < 0) {
							c = c.getLeft();
						}
						else if (e.compareTo(c.getValue()) > 0 ) {
							c = c.getRight();
						}
					}
				}
				return (E) c.getValue();
			}
		}
	}
		
	/** Removes an item from the binary search tree
     *  <p>An item matches if the compareTo method returns 0
     *@param e item to remove
     *@returns the item being removed
     *@throws ElementNotFoundException when there is no matching element
     */
	@SuppressWarnings("unchecked")
	@Override
	public E remove(E e) {
		if (root.getLeft()==null&&root.getRight()==null) {
			E temp = (E) root.getValue();
			root=null;
			return temp;
		}
		else {
			if (root.find(e) == false) {
				throw new ElementNotFoundException();
			}
			else {
				Node current = root;
				Node parent = current;
				while(true) {
					if (e.compareTo(current.getValue()) == 0) {
						break;
					}

					else {
						// If value of node to be deleted is less than parent, go left
						if(e.compareTo(current.getValue())<0) {
							parent = current;
							current = current.getLeft();
						}
						// If value of current is greater than parent, go right
						else if(e.compareTo(current.getValue())>0) {
							parent = current;
							current = current.getRight();
						}
					}
				}
				Node c = current;
				
				// If trying to remove the root
				if (parent == current) {
					Node newborn = root;
					Node p = root;
					while (true) {
						if(newborn.getLeft() != null) {
							p = newborn;
							newborn = newborn.getLeft();
						}
						if(newborn.getRight() != null) {
							p = newborn;
							newborn = newborn.getRight();
							break;
						}
						else if(newborn.getLeft() == null && newborn.getRight() == null) {
							break;
						}
					}
					if (p.getRight() == newborn) {
						p.setRight(null);
						root = newborn;
						
					}
					if (p.getLeft() == newborn) {
						p.setLeft(null);
						newborn.setLeft(root.getLeft());
						newborn.setRight(root.getRight());
						root = newborn;
					}
				}
				// It removing left child 
				else if(parent.getLeft() == current) {
					if (current.getLeft() != null) {
						parent.setLeft(current.getLeft());
						if (current.getRight() != null) {
							parent.getLeft().setRight(current.getRight());
						}
					}
					else if (current.getRight() != null) {
						parent.setLeft(current.getRight());
					}
					else if(current.getLeft() == null && current.getRight() == null) {
						parent.setLeft(null);
					}
				}
				// If removing right child 
				else if(parent.getRight() == current) {
					if (current.getLeft() != null) {
						parent.setRight(current.getLeft());
					}
					else if (current.getRight() != null) {
						parent.setRight(current.getRight());
					}
					else if(current.getLeft() == null && current.getRight() == null){
						parent.setRight(null);
					}
				}
				return (E) c.getValue();
			}
		}
	}
		
	/** Visits all nodes of the tree in pre-order and adds the values to a list
     *@param data the list to append values from the tree to
     */
	@Override
	public void preorderTraversal(IList<E> data) {
		// TODO Auto-generated method stub
		if (root == null) {
			return;
		}
		else {
			preOrderT(root, data);
		}
	}
	
	/**
	 * Recursively performs pre-order traversal on tree
	 * @param n node to begin with 
	 * @param d list that holds the data 
	 */
	public void preOrderT(Node<E> n, IList<E> d) {
		if (n == null) {
			return;
		}
		else {
			d.append(n.getValue());
			preOrderT(n.getLeft(), d);
			preOrderT(n.getRight(), d);
		}
	}
	
	
	/** Visits all nodes of the tree in order and adds the values to a list
     *@param data the list to append values from the tree to
     */
	@Override
	public void inorderTraversal(IList<E> data) {
		// TODO Auto-generated method stub
		if (root == null) {
			return;
		}
		else {
			inOrderT(root, data);
		}
	}
	
	/**
	 * Recursively performs in order traversal on tree
	 * @param n node to begin with 
	 * @param d list that holds the tree
	 */
	public void inOrderT(Node<E> n, IList<E> d) {
		if (n == null) {
			return;
		}
		else {
			inOrderT(n.getLeft(), d);
			d.append(n.getValue());
			inOrderT(n.getRight(), d);
		}
	}
	
	 /** Visits all nodes of the tree in post-order and adds the values to a list
     *@param data the list to append values from the tree to
     */
	@Override
	public void postorderTraversal(IList<E> data) {
		// TODO Auto-generated method stub
		if (root == null) {
			return;
		}
		else {
			postOrderT(root, data);
		}
	}
	
	/**
	 * Recursively performs post order traversal on tree
	 * @param n node to begin with 
	 * @param d list that holds the tree
	 */
	public void postOrderT(Node<E> n, IList<E> d) {
		if (n == null) {
			return;
		}
		else {
			postOrderT(n.getLeft(), d);
			postOrderT(n.getRight(), d);
			d.append(n.getValue());
		}
	}
}

