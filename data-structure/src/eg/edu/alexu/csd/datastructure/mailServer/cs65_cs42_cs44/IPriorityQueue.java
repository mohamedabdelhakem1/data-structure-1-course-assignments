package eg.edu.alexu.csd.datastructure.mailServer.cs65_cs42_cs44;

public interface IPriorityQueue {
	
	public void insert(Object item, int key);

	public Object removeMin();

	public Object min();

	public int size();

	public boolean isEmpty();

}
