package Chapter3_class.animalQueues;

import java.util.LinkedList;

public class AnimalQueue {
	private LinkedList<Dog> dogs = new LinkedList<Dog>();
	private LinkedList<Cat> cats = new LinkedList<Cat>();
	private int index = 0;
	
	public void enqueue(Animal a){
		a.setOrder(index);
		index++;
		if (a instanceof Dog){
			dogs.add((Dog) a);
		}
		else{
			cats.add((Cat)a);
		}
	}
	
	public Animal dequeueAny(){
		if(dogs.isEmpty() && cats.isEmpty()){
			return null;
		}
		if(dogs.isEmpty()){
			return dequeueCat();
		}
		if(cats.isEmpty()){
			return dequeueDog();
		}
		Dog d = dogs.getFirst();
		Cat c = cats.getFirst();
		if(d.isOrderAheadThan(c)){
			dogs.removeFirst();
			return d;
		}
		else{
			cats.removeFirst();
			return c;
		}
	}
	public Dog dequeueDog(){
		if(dogs.isEmpty()){
			return null;
		}
		Dog d = dogs.getFirst();
		dogs.removeFirst();
		return d;
	}
	public Cat dequeueCat(){
		if(cats.isEmpty()){
			return null;
		}
		Cat c = cats.getFirst();
		cats.removeFirst();
		return c;
	}

}
