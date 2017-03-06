import java.util.ArrayList;

/**
 * Clase que representa al juego "Las Torres de Hanoi"
 * 
 * @author Isaac
 *
 */
public class TorresDeHanoi {

	private Integer numeroDiscos;
	private ArrayList<Disco> discos;
	private Integer numeroDeMovimientosSimples;
	private Integer numeroDeMovimientosCiclico;
	private	Boolean debug;
	private Varilla origen;
	private Varilla auxiliar;
	private Varilla destino;
	private long duration;
	
	/**
	 * Constructor por defecto. Establece el juego con 3 discos.
	 */
	TorresDeHanoi(){
		
		setNumeroDiscos(3);
		setNumeroDeMovimientosSimples(0);
		setNumeroDeMovimientosCiclico(0);
		setDebug(false);
		setOrigen(new Varilla(1));
		setAuxiliar(new Varilla(2));
		setDestino(new Varilla(3));
		
	}
	
	/**
	 * Constructor que establece el juego con un número de discos pasados por 
	 * parámetro.
	 * 
	 * @param numeroDiscos número de discos del juego.
	 */
	TorresDeHanoi(Integer numeroDiscos){
		
		setDiscos(new ArrayList<Disco>());
		setNumeroDiscos(numeroDiscos);
		setNumeroDeMovimientosSimples(0);
		setNumeroDeMovimientosCiclico(0);
		setDebug(false);

	}
	
	/**
	 * Establece todos los discos en la varilla 1.
	 * 
	 */
	public void restart(){
		setOrigen(new Varilla(1));
		setAuxiliar(new Varilla(2));
		setDestino(new Varilla(3));
		for (int i = getNumeroDiscos(); i  > 0; i--){
			getDiscos().add(new Disco(i));		
		}
		getOrigen().setDiscos(getDiscos());
		
		
	}
	
	/**
	 * Ejecuta el juego "Las Torres de Hanoi" en su modalidad simple (no cíclica).
	 * 
	 * @param debug <code>true</code> muestra el estado de las varillas en cada movimiento.
	 */
	public void start(Boolean debug){
		setDebug(debug);
		restart();
		System.out.println("\n--------------Hanoi simple--------------");
		mostrarMovimiento();
		long startTime = System.nanoTime();
		Hanoi(getNumeroDiscos(), getOrigen(), getAuxiliar(), getDestino());
		long endTime = System.nanoTime();
		setDuration(endTime - startTime);
	}
	/**
	 * Ejecuta el juego "Las Torres de Hanoi" en su modalidad cíclica.
	 */
	public void startCiclico(){
		System.out.println("\n--------------Hanoi cíclico--------------");
		restart();
		HanoiSentidoHorario(getNumeroDiscos(), getOrigen(), getAuxiliar(), getDestino());	
	}
	
	/**
	 * Método recursivo para la resolución del juego en su modalidad simple. 
	 * 
	 */
	public void Hanoi(Integer numeroDiscos, Varilla origen, Varilla auxiliar, Varilla destino){
		setNumeroDeMovimientosSimples(getNumeroDeMovimientosSimples() + 1);
		
		if (numeroDiscos  == 1){
			destino.addDisco(origen.popDisco());
			mostrarMovimiento();
		}
		else{
			Hanoi(numeroDiscos - 1, origen, destino, auxiliar);
			destino.addDisco(origen.popDisco());
			mostrarMovimiento();
			Hanoi(numeroDiscos - 1, auxiliar, origen, destino);
		}	
	}
	
	/**
	 * Método recursivo que resuleve el juego en su variante cíclica. 
	 * Mueve n discos en el sentido horario desde la varilla a hasta la b. 
	 * 
	 */
	public void HanoiSentidoHorario(Integer numeroDiscos, Varilla a, Varilla b, Varilla c){
		
		if (numeroDiscos > 0){
			HanoiSentidoAntiHorario(numeroDiscos - 1, a, c, b);
			moverSiguiente(a);
			setNumeroDeMovimientosCiclico(getNumeroDeMovimientosCiclico() + 1);
			mostrarMovimiento();
			HanoiSentidoAntiHorario(numeroDiscos - 1, c, b, a);
		}
		
	}
	
	/**
	 * Método recursivo que resuleve el juego en su variante cíclica. 
	 * Mueve n discos en el sentido antihorario desde la varilla a hasta la b. 
	 * 
	 */
	public void HanoiSentidoAntiHorario(Integer numeroDiscos, Varilla a, Varilla b, Varilla c){

		if (numeroDiscos > 0){
			HanoiSentidoAntiHorario(numeroDiscos - 1, a, b, c);
			moverSiguiente(a);
			setNumeroDeMovimientosCiclico(getNumeroDeMovimientosCiclico() + 1);
			mostrarMovimiento();
			HanoiSentidoHorario(numeroDiscos - 1, b, a, c);
			moverSiguiente(c);
			setNumeroDeMovimientosCiclico(getNumeroDeMovimientosCiclico() + 1);
			mostrarMovimiento();
			HanoiSentidoAntiHorario(numeroDiscos - 1, a, b, c);
		}
		
	}
	
	/**
	 * Mueve un disco desde una varilla hasta su vecina (modo cíclico).
	 * @param varilla
	 */
	public void moverSiguiente(Varilla varilla){
		
		switch(varilla.getNumeroVarilla()){
		
			case 1:
				auxiliar.addDisco(varilla.popDisco());
				break;
			case 2:
				destino.addDisco(varilla.popDisco());
				break;
			case 3:
				origen.addDisco(varilla.popDisco());
				break;
		
		}
		
	}
	
	/**
	 * Muestra el contenido de las varillas. 
	 */
	public void mostrarMovimiento(){
		if(getDebug()){
			System.out.println(getOrigen());
			System.out.println(getAuxiliar());
			System.out.println(getDestino());
			System.out.println("====================");
		}
		
	}
	/**
	 * Devuelve el número de discos.
	 */
	public Integer getNumeroDiscos() {
		return numeroDiscos;
	}

	/**
	 * Establece el número de discos.
	 */
	public void setNumeroDiscos(Integer numeroDiscos) {
		this.numeroDiscos = numeroDiscos;
	}
	
	/**
	 * Devuelve un array con todos los discos ordenados de menor tamaño a mayor
	 * tamaño.
	 */
	public ArrayList<Disco> getDiscos() {
		return discos;
	}

	/**
	 * Establece un array con todos los discos.
	 */
	public void setDiscos(ArrayList<Disco> discos) {
		this.discos = discos;
	}

	/**
	 * Devuelve el número de movimiento efectuados a la hora de resolver el juego simple.
	 */
	public Integer getNumeroDeMovimientosSimples() {
		return numeroDeMovimientosSimples;
	}
	/**
	 * Establece el número de movimiento efectuados a la hora de resolver el juego simple.
	 */
	public void setNumeroDeMovimientosSimples(Integer numeroDeMovimientos) {
		this.numeroDeMovimientosSimples = numeroDeMovimientos;
	}

	/**
	 * Devuelve el valor de la variable debug.
	 */
	public Boolean getDebug() {
		return debug;
	}

	/**
	 * Establece el valor de la variable debug.
	 */
	public void setDebug(Boolean debug) {
		this.debug = debug;
	}

	/**
	 * Devuelve el valor de la varilla 1.
	 */
	public Varilla getOrigen() {
		return origen;
	}

	/**
	 * Establece el valor de la varilla 1.
	 */
	public void setOrigen(Varilla origen) {
		this.origen = origen;
	}

	/**
	 * Devuelve el valor de la varilla 2.
	 */
	public Varilla getAuxiliar() {
		return auxiliar;
	}
	/**
	 * Establece el valor de la varilla 2.
	 */
	public void setAuxiliar(Varilla auxiliar) {
		this.auxiliar = auxiliar;
	}

	/**
	 * Devuelve el valor de la varilla 3.
	 */
	public Varilla getDestino() {
		return destino;
	}
	
	/**
	 * Establece el valor de la varilla 3.
	 */
	public void setDestino(Varilla destino) {
		this.destino = destino;
	}

	/**
	 * Devuelve el número de movimiento efectuados a la hora de resolver el juego cíclico.
	 */
	public Integer getNumeroDeMovimientosCiclico() {
		return numeroDeMovimientosCiclico;
	}

	/**
	 * Establece el número de movimiento efectuados a la hora de resolver el juego cíclico.
	 */
	public void setNumeroDeMovimientosCiclico(Integer numeroDeMovimientosCiclico) {
		this.numeroDeMovimientosCiclico = numeroDeMovimientosCiclico;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}	
	
	
	
}
