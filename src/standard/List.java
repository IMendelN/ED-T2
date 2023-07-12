package standard;

import domain.Vehicle;

public interface List {
	public void insertAtBeginning(Vehicle info);

	public void insertEnd(Vehicle info);

	public boolean isEmpty();

	public boolean remove(int chassis);

	public int size();
	
	public void imprime();
}