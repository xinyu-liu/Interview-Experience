package Chapter9Sorting;

public class Person implements Comparable {
	int height;
	int weight;
	public Person(int height,int weight){
		this.height = height;
		this.weight = weight;
	}
	@Override
	public int compareTo(Object p2) {
		int diff = this.height - ((Person)p2).height;
		if(diff!=0){
			return diff;
		}
		else{
			return ( this.weight - ((Person)p2).weight );	
		}
	}
	public String toString(){
		return "[h:"+height+" & w:"+weight+"]";
		
	}
}
