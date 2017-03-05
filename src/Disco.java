
public class Disco {

	Integer size;
	
	Disco(){
		
		setSize(0);
		
	}
	Disco(Integer size){
		
		setSize(size);
		
	}
	Disco(Disco disco){
		
		setSize(disco.getSize());
		
	}
	
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
}
