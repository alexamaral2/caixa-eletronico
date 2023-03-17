package caixa;
/**
 *
 * @author Alex Jr
 */

///Bibliotecas Javas///////////
import java.util.ArrayList;
import java.util.Collections;
///////////////////////////////

public class CaixaEletrônico {

	///Declarar Variaveis/////
        private float totalSaques;
	private int qtdSaques;
	
	ArrayList qtdNotas;
	
	public CaixaEletrônico() {
		qtdNotas = new ArrayList();
	}
	/////////////////////////////////////
	public boolean sacar(float quantia) {
		if ((quantia <= 0 || quantia > consultarSaldo())) {
			return false;
		}
		else if (quantia % 5 != 0) {
			return false;
		}
		else {
			ArrayList notas = new ArrayList();
			float resto = quantia;
			float valor = 0;
			Collections.sort(qtdNotas);
			
			while (resto > 0) {
				valor = resto - ((Integer) qtdNotas.get(qtdNotas.size() - 1)).intValue();
				
				if (valor < 0) {
					notas.add(qtdNotas.get(qtdNotas.size() - 1));
					qtdNotas.remove(qtdNotas.size() - 1);
					Collections.sort(qtdNotas);
				}
				else {
					qtdNotas.remove(qtdNotas.size() - 1);
					resto = valor;
				}
			}
			
			for (int i = 0; i < notas.size(); i++) {
				qtdNotas.add(notas.get(i));
			}
			
			totalSaques = totalSaques + quantia;
			qtdSaques = qtdSaques + 1;
			
			return true;
		}
	}
	
	///abastecer o caixa com cédulas////
        public void repor(int nota, int qtdDeNotas) {
		for (int i = 0; i < qtdDeNotas; i++) {
			qtdNotas.add(nota);
		}
	}
        ////////////////////////////////////
	
	public float consultarSaldo() {
		float somaNotas = 0;
		
		if (!qtdNotas.isEmpty()) {
			for (int i = 0; i < qtdNotas.size(); i++) {
				somaNotas = somaNotas + ((Integer) qtdNotas.get(i)).intValue();
			}
		}
		return somaNotas;
	}
	
	
        ///////mostrar a quantidade de notas após o saque que restou//////
        public int mostraQtdTipoNotas(int nota) {
		int qtdDeNotas = 0;
		for (int i = 0; i < qtdNotas.size(); i++) {
			if (qtdNotas.get(i).equals(nota)) {
				qtdDeNotas = qtdDeNotas + 1;
			}
		}
		return qtdDeNotas;
	}

	///Metodos de entrada e saída/////////////////////
        
        public float getTotalSaques() {
		return totalSaques;
	}

	public void setTotalSaques(float totalSaques) {
		this.totalSaques = totalSaques;
	}

	public int getQtdSaques() {
		return qtdSaques;
	}

	public void setQtdSaques(int qtdSaques) {
		this.qtdSaques = qtdSaques;
	} 
        /////////////////////////////////////////////////////
}