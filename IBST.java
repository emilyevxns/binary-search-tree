
/** Interface for binary search tree implementations
 *  <p>Data inserted into a binary search tree should support a total order
 *  since placement in the right or left child is based on value's relation
 *  to the parent. Where to place a value equivelant to the parent is not
 *  clear and storing duplicate values in data structures implementing the 
 *  IBST interface should not be supported.
 *  <p>To increase the chance that the data type actually has a total order, 
 *  the binary search tree only accepts types that implement the Comparable 
 *  interface.
 */
@SuppressWarnings("rawtypes")
public interface IBST<E extends Comparable> {
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
    public void add(E e);
    
    /** Finds an item in the binary search tree
     *  <p>An item matches if the compareTo method returns 0
     *@param e item to find
     *@returns the matching item in the tree
     *@throws ElementNotFoundException when there is no matching element
     */
    public E find(E e) throws ElementNotFoundException;
    
    /** Removes an item from the binary search tree
     *  <p>An item matches if the compareTo method returns 0
     *@param e item to remove
     *@returns the item being removed
     *@throws ElementNotFoundException when there is no matching element
     */
    public E remove(E e);
}
