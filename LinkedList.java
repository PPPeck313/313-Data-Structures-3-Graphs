//need some kind of global traveler to traverse vertically otherwise you're displacing
//a head node, it has to be a vertex node

//create as many linked list all their own travelers to traverse horizontally
//which eliminates the need to work with one traveler needing to dual type node to
//travel horizontally AND vertically
/*public class LinkedList {
	private VertexNode head, verticalTraveler;
	private EdgeNode tail, horizontalTraveler;//instead of instances so searches don't reset from head every time
	private int length;
	
	LinkedList() {
		head = null;
		tail = null;
		traveler = null;
		length = 0;
	}
	
	//create all the vertex node first so that newly appended edges nodes that
	//are indistinct can be connected to them right away? Otherwise create list from vertex node first
	//and then double back to stitch every placeholder edge node determined by counting the number
	//of soon to be edges
	public void append(Object x) {
		
	EdgeNode n = new EdgeNode(c, null);
		head = n;
			traveler = head;
		}
		else {
			tail.setNext(n);
		}
		tail = n;
		length++;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public void makeEmpty() {
		head = null; 
		tail = null;
		traveler = null;
		length = 0;
	}
	
	public VertexNode getHead() {
		return head;
	}

	public EdgeNode getTail() {
		return tail;
	}
	
	public EdgeNode getTraveler() {
		return traveler;
	}
	
	public int getLength() {
		return length;
	}

	public void travel(int n) {
		for (int i = 0; i < n; i++) {
			if (traveler == tail) {
				System.out.println("Traveler cannot exceed tail. Please reset traveler.");
			}
			else {
				traveler = traveler.getNext();
			}
		}
	}

	public void reset() {
		traveler.setEdge(head);
	}
}*/