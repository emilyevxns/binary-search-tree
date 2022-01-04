
/** Interface trees that are traversable
 */
public interface ITraversableTree<E> {
    /** Visits all nodes of the tree in pre-order and adds the values to a list
     *@param data the list to append values from the tree to
     */
    public void preorderTraversal(IList<E> data);
    
    /** Visits all nodes of the tree in order and adds the values to a list
     *@param data the list to append values from the tree to
     */
    public void inorderTraversal(IList<E> data);
    
    /** Visits all nodes of the tree in post-order and adds the values to a list
     *@param data the list to append values from the tree to
     */
    public void postorderTraversal(IList<E> data);
}