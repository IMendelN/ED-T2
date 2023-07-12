package standard;

import domain.Vehicle;

public class Node {
	private Vehicle info; // Informação armazenada no nó
	private Node next; // Referência para o próximo nó
	private Node prev; // Referência para o nó anterior

	public Node(Vehicle info) {
		this.info = info;
		this.next = null;
		this.prev = null;
	}

    // Define a informação armazenada no nó
    public void setInfo(Vehicle info) {
		this.info = info;
	}

	// Retorna a informação armazenada no nó
	public Vehicle getInfo() {
		return info;
	}

	// Retorna o próximo nó
	public Node getNext() {
		return next;
	}

	// Define o próximo nó
	public void setNext(Node next) {
		this.next = next;
	}

	// Retorna o nó anterior
	public Node getPrev() {
		return prev;
	}

	// Define o nó anterior
	public void setPrev(Node prev) {
		this.prev = prev;
	}
}
