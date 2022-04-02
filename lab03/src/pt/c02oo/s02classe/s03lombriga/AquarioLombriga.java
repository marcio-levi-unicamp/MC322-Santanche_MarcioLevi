package pt.c02oo.s02classe.s03lombriga;

public class AquarioLombriga {
	/*Os atributos associados a essa classe serão os tamanhos do aquário e da lombriga,
	  a posição da cabeça da lombriga 
	  e o sentido o qual será representado pelo caractere 'e' ou 'd' (esquerda/direita)*/
	
	private int tamanhoAquario;
	private int tamanhoLombriga;
	private int posicaoLombriga;
	private char sentidoCabeca;

	public AquarioLombriga(int tamanhoAquario, int tamanhoLombriga, int posicaoLombriga) {
		this.tamanhoAquario = tamanhoAquario;
		this.tamanhoLombriga = tamanhoLombriga;
		this.posicaoLombriga = posicaoLombriga;
		sentidoCabeca = 'e'; //A lombriga sempre inicia com a cabeça para a esquerda
	}

	public int getTamanhoLombriga() {
		return tamanhoLombriga;
	}

	public int getTamanhoAquario() {
		return tamanhoAquario;
	}

	public int getPosicaoLombriga() {
		return posicaoLombriga;
	}

	public void crescer() {
		/*Caso a cabeça esteja para a esquerda 
		 * e a lombriga tenha espaço para crescer uma unidade para a direita 
		 * (a posição que será ocupada é a posição da cabeça mais o tamanho atual)
		 * ou a cabeça esteja para a direita e tenha espaço para crescer uma unidade para a esquerda
		 * (a posição que será ocupada é a posição da cabeça menos o tamanho da lombriga)*/
		if ((sentidoCabeca == 'e' && posicaoLombriga + tamanhoLombriga <= tamanhoAquario)
				|| (sentidoCabeca == 'd' && posicaoLombriga - tamanhoLombriga > 0))
			tamanhoLombriga++;
	}

	public void virar() { //A função simplesmente inverte o sentido da cabeça e troca a posição da cabeça pela a da ponta da cauda
		if (sentidoCabeca == 'e') {//cabeça virando da esquerda para a direita
			sentidoCabeca = 'd';
			posicaoLombriga += tamanhoLombriga - 1;//Para trocar cabeça por cauda a posição aumenta o tamanho menos um
		} else { //cabeça virando da direita para a esquerda.
			sentidoCabeca = 'e';
			posicaoLombriga -= tamanhoLombriga - 1;//Para trocar cabeça por cauda a posição diminui o tamanho menos um
		}
	}

	public void mover() {
		if (posicaoLombriga == 1 || posicaoLombriga == tamanhoAquario)//Se a cabeça estiver em uma das pontas do aquário
			virar();
		else if (sentidoCabeca == 'e') 
			posicaoLombriga--;//Lombriga se move para a esquerda, sua posição reduz 1
		 else 
			posicaoLombriga++;//Lombriga se move para a direita, sua posição aumenta 1
	}

	public String apresenta() {
		String aquario = "";
		if (sentidoCabeca == 'e') {
			for (int i = 1; i <= tamanhoAquario; i++) {
				if (posicaoLombriga == i) {//Se for a cabeça estiver para a esquerda
					aquario += "O";
					while (i < posicaoLombriga + tamanhoLombriga - 1) {//Adiciona os '@' restantes
						aquario += "@";
						i++;
					}
				} else {
					aquario += "#";
				}
			}
		} else {//Caso esteja para a direita
			for (int i = tamanhoAquario; i >= 1; i--) {//Começa-se nesse caso do fim do aquário e se adiciona de trás para a frente
				if (posicaoLombriga == i) {
					aquario = "O" + aquario;
 					while (i > posicaoLombriga - tamanhoLombriga + 1) {
						aquario = "@" + aquario; 
						i--;
					}
				} else {
					aquario = "#" + aquario;//adiciona-se sempre os elementos no inicio da String
				}
			}
		}
		return aquario;
	}
}
