package Chapter3_class.animalQueues;

public class AnimalQueueTester {
	public static void main(String[] args){
		AnimalQueue q = new AnimalQueue();
		q.enqueue( new Cat("mimi1") );
		q.enqueue( new Dog("doggy1") );
		q.enqueue( new Dog("doggy2") );
		q.enqueue( new Dog("doggy3") );
		q.enqueue( new Cat("mimi2") );
		q.enqueue( new Cat("mimi3") );
		System.out.println(q.dequeueDog().getName());
		System.out.println(q.dequeueAny().getName());
		System.out.println(q.dequeueAny().getName());
		System.out.println(q.dequeueAny().getName());
		System.out.println(q.dequeueAny().getName());
		System.out.println(q.dequeueAny().getName());

	}
	
}
