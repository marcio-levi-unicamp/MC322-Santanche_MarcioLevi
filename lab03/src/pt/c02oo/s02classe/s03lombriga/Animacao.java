package pt.c02oo.s02classe.s03lombriga;

import java.util.InputMismatchException;

public class Animacao {
	//Os atributos da classe são: a string de animação, a lombriga que será representada e o passo atual
	
	private String stringAnimacao;
	private AquarioLombriga lombriga;
	private int passoAtual;

	public Animacao(String stringAnimacao) {
		this.stringAnimacao = stringAnimacao;
		//A lombriga é gerada automaticamente a partir da String;
		lombriga = new AquarioLombriga(Integer.parseInt(stringAnimacao.substring(0, 2)),
				Integer.parseInt(stringAnimacao.substring(2, 4)), Integer.parseInt(stringAnimacao.substring(4, 6)));
		passoAtual = 1; //Tudo começa com um primeiro passo
	}
	
	public int getPassoAtual() {
		return passoAtual;
	}

	public String apresenta() {
		return lombriga.apresenta();
	}

	public void passo() {
		switch (stringAnimacao.charAt(passoAtual + 5)) {//O comando sempre estará na posição do passo atual mais 5, pois são 6 caracteres para gerar a lombriga e o passo começa do 1
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
				throw new InputMismatchException();//Comando inválido
		}
	}
}
