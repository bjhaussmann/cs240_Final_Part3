/**
 * 
 */
package part2;

import java.util.Iterator;

/**
 * @author bjhau
 *
 */
public class IteratorOfIterators<T> {

	Iterator<T> itera[];

	IteratorOfIterators(int size) {
		@SuppressWarnings("unchecked")
		Iterator<T> temp[] = (Iterator[]) new Object[size];
		itera = temp;
	}

	public Iterator<T> getIterator() {
		Iterator <T> iter = new Iterator <T>()
				{
					private int current = 0;
					@Override
					public boolean hasNext() {
						if (itera[current].hasNext())
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
						current++;
						return itera[current - 1].next();
					}
				};
		return iter;
	}
}
