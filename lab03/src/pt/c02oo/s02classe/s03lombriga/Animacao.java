package pt.c02oo.s02classe.s03lombriga;

import java.util.InputMismatchException;

public class Animacao {
	//Os atributos da classe s�o: a string de anima��o, a lombriga que ser� representada e o passo atual
	
	private String stringAnimacao;
	private AquarioLombriga lombriga;
	private int passoAtual;

	public Animacao(String stringAnimacao) {
		this.stringAnimacao = stringAnimacao;
		//A lombriga � gerada automaticamente a partir da String;
		lombriga = new AquarioLombriga(Integer.parseInt(stringAnimacao.substring(0, 2)),
				Integer.parseInt(stringAnimacao.substring(2, 4)), Integer.parseInt(stringAnimacao.substring(4, 6)));
		passoAtual = 1; //Tudo come�a com um primeiro passo
	}
	
	public int getPassoAtual() {
		return passoAtual;
	}

	public String apresenta() {
		return lombriga.apresenta();
	}

	public void passo() {
		switch (stringAnimacao.charAt(passoAtual + 5)) {//O comando sempre estar� na posi��o do passo atual mais 5, pois s�o 6 caracteres para gerar a lombriga e o passo come�a do 1
			case 'M':
				lombriga.mover();
				passoAtual++;
				break;
			case 'C':
				lombriga.crescer();
				passoAtual++;
				break;
			case 'V':
				lombriga.virar();
				passoAtual++;
				break;
			default:
				throw new InputMismatchException();//Comando inv�lido
		}
	}
}
