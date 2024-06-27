package ar.edu.unju.fi.ejercicio06.main;

import ar.edu.unju.fi.ejercicio06.interfaces.funcionales.Converter; 
import ar.edu.unju.fi.ejercicio06.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio06.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		FelinoSalvaje gato = new FelinoSalvaje("Tanner", (byte)20, 186f);
		Converter<FelinoSalvaje,FelinoDomestico> converter = x -> new FelinoDomestico(x.getNombre(),x.getEdad(),x.getPeso());
		if(Converter.isNotNull(gato)) {
			FelinoDomestico domestico1 = converter.convert(gato);
			converter.mostrarObjeto(domestico1);
		}else {
			System.out.println("Objeto nulo");
		}
	}

}