

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang.StringUtils;

public class Exercicio {

	private static String OPCAO_CONTINUAR_PROGRAMA = "";

	public static void main(String[] args) {

		Exercicio exercicio = new Exercicio();

		do {
			exercicio.calcular();
			System.out.println("Deseja continuar (s/n) ?");

			Scanner op = new Scanner(System.in);
			OPCAO_CONTINUAR_PROGRAMA = op.next();

			exercicio.fimPrograma();
		} while ("s".equalsIgnoreCase(OPCAO_CONTINUAR_PROGRAMA));
	}

	public void calcular() {
		List<String> listaOperacoes = new ArrayList<String>();
		Scanner valor = new Scanner(System.in);
		float n1 = 0, n2 = 0, n3 = 0;
		String operacao = "";

		// lista de operações - alteração 2
		listaOperacoes = popularLista(listaOperacoes);

		System.out.println("Digite uma operação:\n MULTIPLICAÇÃO(*)\n SUBTRAÇÃO    (-)\n DIVISÃO      (/)\n SOMA         (+)");
		operacao = valor.next();

		validarOperacaoAritmetica(listaOperacoes, operacao);

		System.out.println("Digite o primeiro número:");
		n1 = valor.nextFloat();

		System.out.println("Digite o segundo número:");
		n2 = valor.nextFloat();

		validarisNumero(n1, n2);

		exibirResultado(operacao, n1, n2, n3);
	}
	
	public void exibirResultado(String operacao, float n1, float n2, float n3) {
		if (StringUtils.equals("+", operacao)) {
			n3 = n1 + n2;
		} else if (StringUtils.equals("-", operacao)) {
			n3 = n1 - n2;
		} else if (StringUtils.equals("*", operacao)) {
			n3 = n1 * n2;
		} else {
			n3 = n1 / n2;
		}

		System.out.println("Resultado: " + n3 + "\n");
	}

	public void validarOperacaoAritmetica(List<String> lista, String operacao) {
		if (!lista.contains(operacao)) {
			System.out.println("Erro: Somente operações aritméticas são aceitas!");
			System.exit(1);
		}
	}

	public void validarisNumero(float numero1, float numero2) {
		if (StringUtils.isNumeric(String.valueOf(numero1)) || StringUtils.isNumeric(String.valueOf(numero2))) {
			System.out.println("Erro: Apenas números são aceitos!");
			System.exit(1);
		}
	}
	
	public static List<String> popularLista(List<String> operacoes) {
		operacoes.add("+");
		operacoes.add("-");
		operacoes.add("*");
		operacoes.add("/");

		return operacoes;
	}

	public void fimPrograma() {
		System.out.println("******** FIM DO PROGRAMA ********");
	}
}