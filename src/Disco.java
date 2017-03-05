/**
 * Clase que representa a un disco del juego "Las Torres de Hanoi".
 * 
 * @author Isaac Aimán
 *
 */
public class Disco {

	private Integer size;

	/**
	 * Constructor por defecto. Crea un disco de tamaño 0.
	 */
	Disco(){
		
		setSize(0);
		
	}
	
	/**
	 * Constructor que crea un objeto de la clase Disco con un tamaño pasado por 
	 * parámetro.
	 * 
	 * @param size indica el tamaño del disco.
	 */
	Disco(Integer size){
		
		setSize(size);
		
	}
	
	/**
	 * Constructor de copia.
	 * 
	 * @param disco objeto de la clase disco que va a ser copiado.
	 */
	Disco(Disco disco){
		
		setSize(disco.getSize());
		
	}
	
	/**
	 * Devuelve el tamaño del disco.
	 * 
	 * @return tamaño del disco.
	 * 
	 */
	public Integer getSize() {
		return size;
	}
	
	/**
	 * Establece el tamaño del disco
	 * 
	 * @param size tamaño del disco.
	 */
	public void setSize(Integer size) {
		this.size = size;
	}
}
