import java.util.ArrayList;

public class TorresDeHanoi {

	private Integer numeroDiscos;
	private ArrayList<Disco> discos;
	private Integer numeroDeMovimientosSimples;
	private Integer numeroDeMovimientosCiclico;
	private	Boolean debug;
	private Varilla origen;
	private Varilla auxiliar;
	private Varilla destino;
	
	TorresDeHanoi(){
		
		setNumeroDiscos(3);
		setNumeroDeMovimientosSimples(0);
		setNumeroDeMovimientosCiclico(0);
		setDebug(false);
		setOrigen(new Varilla(1));
		setAuxiliar(new Varilla(2));
		setDestino(new Varilla(3));
		
	}
	
	TorresDeHanoi(Integer numeroDiscos){
		
		setDiscos(new ArrayList<Disco>());
		setNumeroDiscos(numeroDiscos);
		setNumeroDeMovimientosSimples(0);
		setNumeroDeMovimientosCiclico(0);
		setDebug(false);

	}
	public void restart(){
		setOrigen(new Varilla(1));
		setAuxiliar(new Varilla(2));
		setDestino(new Varilla(3));
		for (int i = getNumeroDiscos(); i  > 0; i--){
			getDiscos().add(new Disco(i));		
		}
		getOrigen().setDiscos(getDiscos());
		
		
	}
	public void start(Boolean debug){
		setDebug(debug);
		restart();
		System.out.println("\n--------------Hanoi simple--------------");
		mostrarMovimiento();
		Hanoi(getNumeroDiscos(), getOrigen(), getAuxiliar(), getDestino());
	}
	
	public void startCiclico(){
		System.out.println("\n--------------Hanoi cíclico--------------");
		restart();
		HanoiSentidoHorario(getNumeroDiscos(), getOrigen(), getAuxiliar(), getDestino());	
	}
	
	public void Hanoi(Integer numeroDiscos, Varilla origen, Varilla auxiliar, Varilla destino){
		setNumeroDeMovimientosSimples(getNumeroDeMovimientosSimples() + 1);
		
		if (numeroDiscos == 1){
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
	
	public void HanoiSentidoHorario(Integer numeroDiscos, Varilla a, Varilla b, Varilla c){
		
		if (numeroDiscos > 0){
			HanoiSentidoAntiHorario(numeroDiscos - 1, a, c, b);
			moverSiguiente(a);
			setNumeroDeMovimientosCiclico(getNumeroDeMovimientosCiclico() + 1);
			mostrarMovimiento();
			HanoiSentidoAntiHorario(numeroDiscos - 1, c, b, a);
		}
		
	}
	
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
	
	public void mostrarMovimiento(){
		if(getDebug()){
			System.out.println(getOrigen());
			System.out.println(getAuxiliar());
			System.out.println(getDestino());
			System.out.println("====================");
		}
		
	}

	public Integer getNumeroDiscos() {
		return numeroDiscos;
	}

	public void setNumeroDiscos(Integer numeroDiscos) {
		this.numeroDiscos = numeroDiscos;
	}

	public ArrayList<Disco> getDiscos() {
		return discos;
	}

	public void setDiscos(ArrayList<Disco> discos) {
		this.discos = discos;
	}

	public Integer getNumeroDeMovimientosSimples() {
		return numeroDeMovimientosSimples;
	}

	public void setNumeroDeMovimientosSimples(Integer numeroDeMovimientos) {
		this.numeroDeMovimientosSimples = numeroDeMovimientos;
	}

	public Boolean getDebug() {
		return debug;
	}

	public void setDebug(Boolean debug) {
		this.debug = debug;
	}

	public Varilla getOrigen() {
		return origen;
	}

	public void setOrigen(Varilla origen) {
		this.origen = origen;
	}

	public Varilla getAuxiliar() {
		return auxiliar;
	}

	public void setAuxiliar(Varilla auxiliar) {
		this.auxiliar = auxiliar;
	}

	public Varilla getDestino() {
		return destino;
	}

	public void setDestino(Varilla destino) {
		this.destino = destino;
	}

	public Integer getNumeroDeMovimientosCiclico() {
		return numeroDeMovimientosCiclico;
	}

	public void setNumeroDeMovimientosCiclico(Integer numeroDeMovimientosCiclico) {
		this.numeroDeMovimientosCiclico = numeroDeMovimientosCiclico;
	}	
	
}
