package views;

//import java.util.Objects;
//import java.util.Scanner;

//import controllers.ExtratoController;
import models.Conta;
import models.Comprovante;
//import models.Extrato;

public class TelaExtrato {

	static Comprovante comprovante;
	
	public static void mostrarTela(Conta conta) {
		
		for(int i = 0; i < conta.getExtrato().size(); i++) {
			
			comprovante = conta.getExtrato().get(i);
			if (comprovante != null) {
				
				TelaComprovante.emitirComprovante(comprovante.getTipo(), comprovante.getValor());
				System.out.println("\n");
			}
		}
	}
	
	
/*	
	public static void mostrarTela(Conta conta) {
		System.out.println("\n-- Extrato --\n");
		
		for(Extrato ext : ExtratoController.listar()){
			if(Objects.equals(ext.getConta(), conta)) {
				System.out.println(ext.toString());				
			}
		}
	}
*/
}
