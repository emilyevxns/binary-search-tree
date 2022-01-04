
public class ArrayList<E> implements IList<E> {

	E[] data;
	int current;
	int prev;
	int size;
	
	/** 
	 * Initializes the instance variables
	 */
	public ArrayList() {
		data = (E[]) new Object[10];
		current = -1;
		size = 0;
	}
	
	/**
	 * Tests if the list is empty or not
	 * @return boolean
	 */
	 private boolean isEmpty() {
		// TODO Auto-generated method stub
		 if (size == 0) {
			 return true;
		 }
		 else {
			 return false;
		 }
	}
	 /** Insert a new list item just before the current item
     *  <p>If the list is empty, the new element becomes the first item in the list
     *  and the current item is set to the new item. In all other cases, the current item
     *  will be the same before and after the insert call.
     *@param e element to add to the list
     */
	@Override
	public void insert(E e) {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			// Increase current, next, and previous
			current++;
			size++;
			// Set current to newly inserted item
			data[current] = e;
		}
		else {
			// Set index before current to e
			for (int i = current; i < size; i++) {
				data[i + 1] = data[i];
			}
			data[current] = e;
			// Increase current, next, and previous
			current++;
			size++;
			
		}
	}

	/** Appends a new list item just after the current item
     *  <p>If the list is empty, the new element becomes the first item in the list. In 
     * all cases, the current element will be the element added by the append call.
     *@param e element to add to the list
     */
	@Override
	public void append(E e) {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			data[0] = e;
			current++;
			size++;
		}
		else {
			for (int i = current; i < data.length - 1; i++) {
				if (data[i+1] != null) {
					data[i] = data[i+1];
				}
			}
			current++;
			size++;
			data[current] = e;
		}
	}

	/** Removes the current element from the list
     *  <p>If the element being removed is the first element in the list, after removal 
     *  the current element will be the new first element in the list. For any other 
     *  element in the list, after removal the current item will be the item just 
     *  before the one removed.
     *@return the element being deleted
     *@throws InvalidLocationException when delete is called on an empty list
     */
	@Override
	public E delete() {
		// TODO Auto-generated method stub
		E temp = data[current];
		if (data[current] == null) {
			throw new InvalidLocationException();
		}
		else {
			if (size == 1) {
				data[0] = null;
				size--;
			}
			// If element being removed is first in the list
			else if (current == 0) {
				// Current is first, remove it and shift elements down
				data[0] = null;
				for (int i = 0; i < size; i++) {
					data[i] = data[i+1];
				}
				current = 0;
				size--;
				}
				else {
					// If current is last in list
					if (current == (size - 1)) {
						int idx = indexOf(temp);
						// If current is last, remove it
						data[idx] = null; 
						idx--;
						current = idx;
						size--;
					}
					else {
						// Current is located in the middle 
						int idx = current;
						// Delete data at current index
						data[current] = null;
						// Move up the elements after current
						for (int i = idx + 1; i <= size; i++) {
							data[i-1] = data[i];
						}
						// Change index of current to the element before it
						idx --;
						current = idx;
						size--;
					}
				}
				return temp;
			}
		}

	/** Retrieves the current list item without removing it
     *@return the current element
     *@throws InvalidLocationException when get is called on an empty list
     */
	@Override
	public E get() {
		// TODO Auto-generated method stub
		if (data[current] == null) {
			throw new InvalidLocationException();
		}
		else {
			return data[current];
		}
	}

	/** Rewinds to the beginning of the list
     *  <p>After this method executes, the current element will be first element in the
     *  list.
     *@return the first element in the list
     *@throws InvalidLocationException when head is called on an empty list
     */
	@Override
	public E head() {
		// TODO Auto-generated method stub
		if (size <= 0) {
			throw new InvalidLocationException();
		}
		current = size;
		for (int i = 0; i < size; i++) {
			 current--;
		}
		return data[current];
	}

	/** Fast forwards to the end of the list
     *  <p>After this method executes, the current element will be first element in the
     *  list.
     *@return the last element in the list
     *@throws InvalidLocationException when tail is called on an empty list
     */
	@Override
	public E tail() {
		// TODO Auto-generated method stub
		if (size <= 0) {
			throw new InvalidLocationException();
		}
		else {
			current = 0;
		}
		return data[current];
	}

	/** Advances to the next element of the list.
     *  <p>Also returns the element in the next list position.
     *  <p>If advancing would escape the list, the InvalidLocationException should
     *  be thrown and the current position should not be changed.
     *@return the next element in the list
     *@throws InvalidLocationException when next is past the end of the list
     */
	@Override
	public E next() {
		// TODO Auto-generated method stub
		if (current >= size) {
			throw new InvalidLocationException();
		}
		else {
			current++;
			return data[current];
		}
	}

	 /** Steps to the previous element of the list.
     *  <p>Also returns the element in the previous list position.
     *  <p>If rewinding would escape the list, the InvalidLocationException should
     *  be thrown and the current position should not be changed.
     *@return the previous element in the list
     *@throws InvalidLocationException when prev is past the beginning of the list
     */
	@Override
	public E prev() {
		// TODO Auto-generated method stub
		if (current - 1 < 0) {
			throw new InvalidLocationException();
		}
		else {
			current--;
			return data[current];
		}
	}

	 /***** Absolute List Functions *****/
    /** Insert a new list item just before the element at index idx
     *  <p>Regardless of where the new element is placed within the list, the current
     *  element should be the same before and after the absolute insert is called.
     *  <p>If the requested index is not in the list, the BadIndexException will be 
     *  thrown.
     *@param idx where to insert at
     *@param e element to add to the list
     *@throws BadIndexException when idx is outside the list
     */
	@Override
	public void insert(int idx, E e) {
		// TODO Auto-generated method stub
		if (idx < 0 || idx > data.length - 1) {
			throw new BadIndexException(idx);
		}
		else {
			for (int i = size; i >= idx; i--) {
				data[i+1] = data[i];
			}
			data[idx] = e;
			size++;
		}
	}

	/** Append a new list item just after the element at index idx
     *  <p>Regardless of where the new element is placed within the list, the current
     *  element should be the same before and after the absolute append is called.
     *  <p>If the requested index is not in the list, the BadIndexException will be 
     *  thrown.
     *@param idx where to append at
     *@param e element to add to the list
     *@throws BadIndexException when idx is outside the list
     */
	@Override
	public void append(int idx, E e) {
		// TODO Auto-generated method stub
		if (idx < 0 || idx > data.length) {
			throw new BadIndexException(idx);
		}
		else {
			for (int i = size; i > idx; i--) {
				data[i + 1] = data[i];
			}
			data[idx + 1] = e;
			size++;
		}
	}

	 /** Remove the element at index idx
     *  <p>If the current element is the element being deleted, the behavior should be 
     *  consistent with the relative delete method. For all other elements, use of the
     *  absolute delete should not change which element the current element is.
     *  <p>If the requested index is not in the list, the BadIndexException will be 
     *  thrown.
     *@param idx which element to remove
     *@return element being removed
     *@throws BadIndexException when idx is outside the list
     */

	@Override
	public E delete(int idx) {
		// TODO Auto-generated method stub
		if (idx > data.length || idx < 0) {
			throw new BadIndexException(idx);
		}
		for (int i = 0; i < data.length; i++) {
			if (i == idx) {
				for (int j = i; j < data.length - 1; j++) {
					data[j] = data[j+1];
				}
			}
		}
		size--;
		return data[idx];
	}

	 /** Retrieves the element at index idx without removing it
     *  <p>The absolute get will update the current element to be the one retrieved using
     *  the absolute get.
     *  <p>If the requested index is not in the list, the BadIndexException will be 
     *  thrown. If the BadIndexException is thrown, the current element should not be 
     *  changed by the call to absolute get.
     *@param idx which element to remove
     *@return the current element
     *@throws BadIndexException when idx is outside the list
     */
	@Override
	public E get(int idx) {
		// TODO Auto-generated method stub
		if (idx > size || idx < 0) {
			throw new BadIndexException(idx);
		}
		return data[idx];
	}

	/** Number of elements currently in the list
     *@return the number of elements in the list
     */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	/** Finds a matching element in the list
     *  <p>If a matching element existis in the list, return the index of that element
     *  and update the current element to the found element. "Matching" is determined
     *  using the equals method of the element to match.
     *  <p>If there is no matching element, throw an ElementNotFound exception.
     *@param e which element to find
     *@return the index of element in the list
     *@throws ElementNotFoundException when there is no matching element
     */
	@Override
	public int indexOf(E e) {
		int count = 0;
		// TODO Auto-generated method stub
		for (int i = 0; i < data.length; i++) {
			if (data[i] == e) {
				return i;
			}
			count++;
		}
		
		return count;
	}

}
