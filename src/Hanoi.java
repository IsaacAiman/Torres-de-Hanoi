
public class Hanoi {

	public static void main(String[] args) {
		
		TorresDeHanoi juego = new TorresDeHanoi(new Integer(args[0]));
		
		if (args[1].equals("0")){
			juego.start(false);
			juego.startCiclico();
		}
		else{
			if (args[1].equals("1")){
				juego.start(true);
				juego.startCiclico();
			}
		}
		System.out.println("Número de movimientos simples: " + juego.getNumeroDeMovimientosSimples() + ".");
		System.out.println("Número de movimientos cíclicos: " + juego.getNumeroDeMovimientosCiclico() + ".");
		System.out.println("Juego finalizado.");
	}

}
