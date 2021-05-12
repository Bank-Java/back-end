package views;

import models.Conta;
import models.Comprovante;

public class TelaExtrato {

	static Comprovante comprovante;
	
	public static void mostrarTela(Conta conta) {
		
		for(int i = 0; i < conta.getExtrato().size(); i++) {
			
			comprovante = conta.getExtrato().get(i);
			if (comprovante != null) {
				
				TelaComprovante.emitirComprovante(comprovante.getTipo(), comprovante.getValor(), comprovante.getData());
			}
		}
	}

}
