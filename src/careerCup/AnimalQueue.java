package careerCup;

import java.util.LinkedList;

public class AnimalQueue {
	public LinkedList<Node> cats;
	public LinkedList<Node> dogs;
	public int count;

	public AnimalQueue() {
		cats = new LinkedList<Node>();
		dogs = new LinkedList<Node>();
		count = 0;
	}

	public void enQueue(String type) throws Exception {
		Node animal = new Node(type, count);
		if (type.equals("cat")) {
			// add it to the cat queue
			cats.addFirst(animal);
		} else if (type.equals("dog")) {
			// add it to the dog queue
			dogs.addFirst(animal);
		} else {
			throw new Exception("We only accept cats or dogs!");
		}
		count++;
	}

	public Node deQueueAny() throws Exception {
		Node cat = cats.peekLast();
		Node dog = dogs.peekLast();
		if (cat == null && dog == null)
			throw new Exception("No cat or dog available");
		if (cat == null && dog != null)
			return dogs.pollLast();
		if (cat != null && dog == null)
			return cats.pollLast();
		if (dog.index < cat.index)
			return dogs.pollLast();
		else
			return cats.pollLast();
	}

	public Node deQueueCat() throws Exception {
		Node n = cats.pollLast();
		if (n == null)
			throw new Exception("No cat available");
		return n;
	}

	public Node deQueueDog() throws Exception {
		Node n = dogs.pollLast();
		if (n == null)
			throw new Exception("No dog available");
		return n;
	}

	private class Node {
		public String type;
		public int index;

		public Node(String type, int index) {
			this.type = type;
			this.index = index;
		}

		public String toString() {
			return type + " " + index;
		}
	}
}
