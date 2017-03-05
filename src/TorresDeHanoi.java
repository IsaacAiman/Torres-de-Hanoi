import java.util.ArrayList;

public class TorresDeHanoi {

	Integer numeroDiscos;
	ArrayList<Disco> discos;
	Integer numeroDeMovimientos;
	Boolean debug;
	Varilla origen;
	Varilla auxiliar;
	Varilla destino;
	
	TorresDeHanoi(){
		
		setNumeroDiscos(3);
		setNumeroDeMovimientos(0);
		setDebug(false);
		setOrigen(new Varilla(1));
		setAuxiliar(new Varilla(2));
		setDestino(new Varilla(3));
		
	}
	
	TorresDeHanoi(Integer numeroDiscos){
		
		setDiscos(new ArrayList<Disco>());
		setNumeroDiscos(numeroDiscos);
		for (int i = getNumeroDiscos(); i  > 0; i--){
			getDiscos().add(new Disco(i));		
		}
		setNumeroDeMovimientos(0);
		setDebug(false);
		setOrigen(new Varilla(1));
		setAuxiliar(new Varilla(2));
		setDestino(new Varilla(3));
	}
	
	public void start(Boolean debug){
		
		getOrigen().setDiscos(getDiscos());
		mostrarMovimiento();
		Hanoi(getNumeroDiscos(), getOrigen(), getAuxiliar(), getDestino());		
		
	}
	
	public void Hanoi(Integer numeroDiscos, Varilla origen, Varilla auxiliar, Varilla destino){
		setNumeroDeMovimientos(getNumeroDeMovimientos() + 1);
		
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
	
	public void mostrarMovimiento(){
		System.out.println(getOrigen());
		System.out.println(getAuxiliar());
		System.out.println(getDestino());
		System.out.println("====================");
		
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

	public Integer getNumeroDeMovimientos() {
		return numeroDeMovimientos;
	}

	public void setNumeroDeMovimientos(Integer numeroDeMovimientos) {
		this.numeroDeMovimientos = numeroDeMovimientos;
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
	
	
	
	
	
}
