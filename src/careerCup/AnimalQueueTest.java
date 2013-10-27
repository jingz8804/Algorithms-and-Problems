package careerCup;

public class AnimalQueueTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		AnimalQueue animalQueue = new AnimalQueue();
		animalQueue.enQueue("cat");
		animalQueue.enQueue("cat");
		animalQueue.enQueue("dog");
		animalQueue.enQueue("cat");
		animalQueue.enQueue("dog");

		System.out.println(animalQueue.deQueueAny());
		System.out.println(animalQueue.deQueueDog());
		System.out.println(animalQueue.deQueueAny());
		System.out.println(animalQueue.deQueueCat());

	}

}
