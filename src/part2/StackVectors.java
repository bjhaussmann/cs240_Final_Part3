/**
 * 
 */
package part2;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Vector;


/**
 * @author bjhau
 *
 */
public class StackVectors<T> implements StackInterface<T>{

	protected Vector<T> stack;
	protected static int defaultSize = 30;	//default vector size
	protected static int defaultIncrement = 5;	//default vector incrementor
	
	public StackVectors () 
	{
		this(defaultSize, defaultIncrement);
	}
	
	public StackVectors (int size)
	{
		stack = new Vector<T> (size, defaultIncrement);
	}
	
	public Iterator<T> getIterator() {
		Iterator <T> iter = new Iterator <T>()
				{
					private int current = 0;
					@Override
					public boolean hasNext() {
						if (current < stack.size())
						{
							return true;
						}
						else
						{
							return false;
						}
					}

					@Override
					public T next() {
						return stack.elementAt(current);
					}
				};
		return iter;
	}
	
	public StackVectors (int size, int increment)
	{
		stack = new Vector<T> (size, increment);
	}
	
	/**
	 * Adds new entry to the top of this stack.
	 * @param	newEntry	An object to be added to the stack.
	 */
	@Override
	public void push(T newEntry) {
		stack.add(newEntry);
	}

	/**
	 * Removes and returns this stack's top entry.
	 * @return	The Object at the top of the stack.
	 * @throws	EmptyStackException if the stack is empty before the operation.
	 */
	@Override
	public T pop() throws EmptyStackException{
		if (stack.isEmpty())
		{
			throw new EmptyStackException();
		}
		
		return stack.remove(stack.size());	//remove top element of stack and return the removed item
	}

	/**
	 * Retrieves this stack's top entry.
	 * @return	The Object at the top of the stack.
	 * @throws	EmptyStackException if the stack is empty.
	 */
	@Override
	public T peek() {
		if (stack.isEmpty())
		{
			throw new EmptyStackException();
		}
		return stack.lastElement();	//return the top item in the stack
	}

	/**
	 * Detects whether this stack is empty.
	 * @return	True if the stack is empty.
	 */
	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	/**
	 * Removes all entries from this stack.
	 */
	@Override
	public void clear() {
		stack.clear();
	}
}
