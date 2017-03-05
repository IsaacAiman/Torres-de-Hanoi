import java.util.ArrayList;

public class Varilla {
	
	private Integer numeroVarilla;
	private ArrayList<Disco> discos;
	
	Varilla(){
		setNumeroVarilla(0);
		setDiscos(new ArrayList<Disco>());
	}

	Varilla(Integer numeroVarilla){
		setNumeroVarilla(numeroVarilla);
		setDiscos(new ArrayList<Disco>());
	}
	
	public void addDisco(Disco disco){
		
		getDiscos().add(disco);
	}
	
	public Disco popDisco(){
		Disco disco = new Disco(getDiscos().get( getDiscos().size() - 1));
		getDiscos().remove(getDiscos().size() - 1);
		return disco;
	}
	
	public ArrayList<Disco> getDiscos() {
		return discos;
	}

	public void setDiscos(ArrayList<Disco> discos) {
		this.discos = discos;
	}

	public Integer getNumeroVarilla() {
		return numeroVarilla;
	}

	public void setNumeroVarilla(Integer numeroVarilla) {
		this.numeroVarilla = numeroVarilla;
	}
	
	public String toString(){
		
		String returnString = "Varilla " + getNumeroVarilla() + ":\n";
		
		if(getDiscos().isEmpty()){
			
			returnString += "Vacía.\n";
		}
		else{
			
			for (int i = getDiscos().size();  i > 0; i--){

				returnString += getDiscos().get(i - 1).getSize() + "\n";
				
			}
		}
		
		
		return returnString;
		
	}
	
	

}
