/* THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING 
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES.
DAVID CHEN */

public class Playlist {
	private Episode head;
	private int size;

	public Playlist(){
		head = null;
		size = 0;
	}

	public boolean isEmpty() { 
		return head == null; 
	}

	// Ensure that "size" is updated properly in other methods, to
	// always reflect the correct number of episodes in the current playlist
	public int getSize() {
		return this.size; 
	}

	// Displays the Episodes starting from the head and moving forward
	// Example code and its expected output:
	/*   Playlist pl = new Playlist();
	/*   pl.addLast("PlanetMoney",26.0);
	/*   pl.addLast("TodayExplained",10);
	/*   pl.addLast("RadioLab",25.5);
	/*   System.out.println(pl.displayPlaylistForward());
	/* [BEGIN] (PlanetMoney|26.0MIN) -> (TodayExplained|10.0MIN) -> (RadioLab|25.5MIN) [END]
	*/
	public String displayPlaylistForward() {
		String output = "[BEGIN] ";
		Episode current = head;
		if ( current != null ) {
			while( current.next != head ) {
				output += current + " -> ";
				current = current.next;
			}
			output += current + " [END]\n";
		}
		else {
			output += " [END]\n";	
		}
		return output;
	}

	// Displays the Episodes starting from the end and moving backwards
	// Example code and its expected output:
	/*   Playlist pl = new Playlist();
	/*   pl.addLast("PlanetMoney",26.0);
	/*   pl.addLast("HowIBuiltThis",10);
	/*   pl.addLast("RadioLab",25.5);
	/*   System.out.println(pl.displayPlaylistForward());
	/* [END] (RadioLab|25.5MIN) -> (HowIBuiltThis|10.0MIN) -> (PlanetMoney|26.0MIN) [BEGIN]
	*/
	public String displayPlaylistBackward() {
		String output = "[END] ";
		Episode current = head;
		if (current != null) {
			while (current.prev != head) {
				current = current.prev;
				output += current + " -> ";
			}
			output += current.prev;
		}
		output += " [BEGIN]\n";
		return output;
	}

	// Add a new Episode at the beginning of the Playlist
	public void addFirst( String title, double length ) {
		// if the list is empty, link the head to itself
		if (head == null) {
			head = new Episode(title, length, null, null);
			head.next = head;
			head.prev = head;
		}

		// if the list is not empty, replace the old head with the new head
		else {
			Episode newHead = new Episode(title, length, head, head.prev);
			head.prev.next = newHead;
			head.prev = newHead;
			head = newHead;
		}
		size++;
	}

	// Add a new Episode at the end of the Playlist
	public void addLast( String title, double length ) {
		// if the list is empty, link the head to itself
		if (head == null) {
			head = new Episode(title, length, null, null);
			head.next = head;
			head.prev = head;
		}

		// if the list is not empty, replace the old tail with the new tail
		else {
			Episode newTail = new Episode(title, length, head, head.prev);
			head.prev.next = newTail;
			head.prev = newTail;
		}
		size++;
	}

	// Add a new Episode at the given index, assuming that index
	// zero corresponds to the first node
	public void add( String title, double length, int index ) {
		// throw an exception if the index is out of bound
		if (index > size || index < 0) {
			throw new RuntimeException("[Error] Index out of bound for a list of " + size + " Episodes.");
		}

		// call addLast() if the Episode is inserted at the tail
		if (index == size) { 
			addLast(title, length);
			return;
		}

		// call addFirst() if the Episode is inserted at the head
		if (index == 0) { 
			addFirst(title, length);
			return;
		}

		// else, move to the index and insert a new Episode;
		Episode current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}

		Episode newEpisode = new Episode(title, length, current, current.prev);
		current.prev.next = newEpisode;
		current.prev = newEpisode;
		size++;
	}

	// Delete the first Episode in the Playlist
	public Episode deleteFirst() {
		// if the list is empty, throw an exception
		if (head == null) {
			throw new RuntimeException("[Error] Cannot delete episode from an empty Playlist.");
		}

		// if the list has only one Episode, set head to null
		if (size == 1) {
			Episode oldHead = head;;
			head = null;
			size--;
			return oldHead;
		}

		// otherwise, make the old head's previous node and subsequent node directly point to each other
		// then, make the node next to head the new head
		else {
		Episode oldHead = head;
		oldHead.prev.next = oldHead.next;
		oldHead.next.prev = oldHead.prev;
		head = oldHead.next;
		size--;
		return oldHead;
		}	
	}

	// Delete the last Episode in the Playlist
	// (There is no special "last" variable in this Playlist;
	// think of alternative ways to find that last Episode)
	public Episode deleteLast() {
		// if the list is empty, throw an exception
		if (head == null) {
			throw new RuntimeException("[Error] Cannot delete episode from an empty Playlist.");
		}

		// if the list has only one Episode, set head to null
		if (size == 1) {
			head = null;
			size--;
			return null;
		}

		// otherwise, take the previous node of head as the "oldTail", and make its next node and previous
		// node directly point to each other
		else {
		Episode oldTail = head.prev;
		oldTail.prev.next = oldTail.next;
		oldTail.next.prev = oldTail.prev;
		size--;
		return oldTail;
		}
	}

	// Remove (delete) the Episode that has the given "title"
	// You can assume there will be no duplicate titles in any Playlist
	public Episode deleteEpisode(String title) {
		// if the list is empty, throw an exception
		if (head == null) {
			throw new RuntimeException("[Error] Cannot delete episode from an empty Playlist.");
		}
		
		Episode current = head;

		// if the first or last Episode is to be deleted, call deleteFirst() or deleteLast()
		if (current.getTitle().equals(title)) {
			return deleteFirst();
		}
		else if (size >= 2 && current.prev.getTitle().equals(title)){
			return deleteLast();
		}
		else { 
			// otherwise walk through the list, find the Episode and delete it
			current = current.next;
			while (current != head) {
				if (current.getTitle().equals(title)) {
					current.prev.next = current.next;
					current.next.prev = current.prev;
					size--;
					return current;
				}
				current = current.next;
			}
		}
		return null;
	}

	// Remove (delete) every m-th Episode in the user's circular Playlist,
	// until only one Episode survives. Return the survived Episode.
	public Episode deleteEveryMthEpisode(int m) {
		// throw an exception if "m" exceeds the size of the list
		if (m > size) {
			throw new RuntimeException("[Error] Index out of bound for an array of " + size + " Episodes");
		}

		// keep track of the index of current, and delete every m-th element
		int count = m;
		Episode current = head;

		while (size > 1) {
			count--;
			if (count == 0) {
				// if head or tail is to be deleted, call deleteFirst() or deleteLast()
				if (current == head) {
					deleteFirst();
				}
				else if (current.next == head) {
					deleteLast();
				}
				else {
					current.next.prev = current.prev;
					current.prev.next = current.next;
					size--;
				}
				count = m;
			}
			current = current.next;
		}
		// reset the head of the list
		head = current;
		head.next = head;
		head.prev = head;
		return head;
	}
} // End of Playlist class
