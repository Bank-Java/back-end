package views;

import java.util.Date;

public class TelaComprovante {
	public static void emitirComprovante(String titulo, Double valor, Date data) {
		StringBuilder messageComprovante = new StringBuilder();
		
		messageComprovante.append("***********************************************\n");
		messageComprovante.append("        <COMPROVANTE DE TRANSAÇÃO>             \n");
		messageComprovante.append("***********************************************\n");
		messageComprovante.append("   Título do comprovante                       \n");
		messageComprovante.append("   " + titulo + "                              \n");
		messageComprovante.append("   Valor                                       \n");
		messageComprovante.append("   " + valor + "                               \n");
		messageComprovante.append("***********************************************\n");
		messageComprovante.append("        " + data.toString() + "                \n");
		messageComprovante.append("***********************************************\n");
		
		System.out.println(messageComprovante.toString());

	}
}
