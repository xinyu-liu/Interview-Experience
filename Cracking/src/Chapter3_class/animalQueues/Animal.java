package Chapter3_class.animalQueues;

public class Animal {
	private String name;
	private int order;
	
	public Animal(String name){
		this.name=name;
	}
	public void setOrder(int order){
		this.order=order;
	}
	public String getName(){
		return name;
	}
	public boolean isOrderAheadThan(Animal a){
		if(this.order<a.order){
			return true;
		}
		else{
			return false;
		}
	}
}
