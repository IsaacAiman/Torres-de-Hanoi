import java.util.ArrayList;
/**
 * Clase que representa a una varilla del juego "Las Torres de Hanoi".
 * @author Isaac
 *
 */
public class Varilla {
	
	private Integer numeroVarilla;
	private ArrayList<Disco> discos;
	
	/**
	 * Constructor por defecto.
	 */
	Varilla(){
		setNumeroVarilla(0);
		setDiscos(new ArrayList<Disco>());
	}
	/**
	 * Constructor que crea un objeto de la clase Varilla con un número de varilla determinado.
	 */
	Varilla(Integer numeroVarilla){
		setNumeroVarilla(numeroVarilla);
		setDiscos(new ArrayList<Disco>());
	}
	
	/**
	 * Método que añade un disco a la varilla
	 */
	public void addDisco(Disco disco){
		
		getDiscos().add(disco);
	}
	/**
	 * Método que quita el últmo disco insertado en la varilla
	 */
	public Disco popDisco(){
		Disco disco = new Disco(getDiscos().get( getDiscos().size() - 1));
		getDiscos().remove(getDiscos().size() - 1);
		return disco;
	}
	
	/**
	 * Devuelve el conjunto de discos que hay en la varilla.
	 */
	public ArrayList<Disco> getDiscos() {
		return discos;
	}

	/**
	 * Establece el conjunto de discos que hay en la varilla.
	 */
	public void setDiscos(ArrayList<Disco> discos) {
		this.discos = discos;
	}

	/**
	 * Devuelve la posición de la varilla.
	 */
	public Integer getNumeroVarilla() {
		return numeroVarilla;
	}

	/**
	 * Establece la posición de la varilla
	 */
	public void setNumeroVarilla(Integer numeroVarilla) {
		this.numeroVarilla = numeroVarilla;
	}
	
	/**
	 * Devuelve un string representado el estado de la varilla (los discos que posee).
	 */
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
