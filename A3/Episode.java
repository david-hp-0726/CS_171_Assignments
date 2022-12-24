// Class Episode represents an individual podcast episode.
// This is the equivalent of an individual "Node" in our class examples.
class Episode {
	private String title; // episode title
	private double length; // episode length (minutes)

	public Episode next; // reference to next episode in playlist
	public Episode prev; // reference to previous episode in playlist

	public Episode(String title, double length, Episode next, Episode prev) {
		this.title = title;
		this.length = length;
		this.next = next;
		this.prev = prev;
	}

	public String getTitle() {
		return this.title;
	}

	public double getLength() {
		return this.length;
	}

	public String toString() {
		return "("+ this.title + "|" + this.length + "MIN)" ;
	}

	public static void printForward(Episode head) {
		Episode current = head;
		while (current.next != head) {
			System.out.print(current + " -> ");
			current = current.next;
		}
		System.out.println();
	}

	public static void printBackward(Episode head) {
		Episode current = head;
		System.out.print(current + " -> ");
		current = current.prev;
		while (current != head) {
			System.out.print(current + " -> ");
			current = current.prev;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		
	}
}
