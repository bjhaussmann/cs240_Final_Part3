package part2;

public class IteratorTest {

	public static void main(String[] args) {
		StackVectors<Integer> L1 = new StackVectors<Integer>();
		ListLinked<Integer> L2 = new ListLinked<Integer>();
		QueueFixedSize<Integer> L3 = new QueueFixedSize<Integer>();
		
		for(int i = 0; i < 4; i++)
			L1.push(i);
		for (int i = 4; i < 8; i++)
			L2.add(i);
		for (int i = 8; i < 12; i++)
			L3.enqueue(i);
		
		IteratorOfIterators iter
	}

}
