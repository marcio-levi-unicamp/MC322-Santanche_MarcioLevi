package pt.c02oo.s02classe.s03lombriga;

public class AquarioLombriga {
	/*Os atributos associados a essa classe ser�o os tamanhos do aqu�rio e da lombriga,
	  a posi��o da cabe�a da lombriga 
	  e o sentido o qual ser� representado pelo caractere 'e' ou 'd' (esquerda/direita)*/
	
	private int tamanhoAquario;
	private int tamanhoLombriga;
	private int posicaoLombriga;
	private char sentidoCabeca;

	public AquarioLombriga(int tamanhoAquario, int tamanhoLombriga, int posicaoLombriga) {
		this.tamanhoAquario = tamanhoAquario;
		this.tamanhoLombriga = tamanhoLombriga;
		this.posicaoLombriga = posicaoLombriga;
		sentidoCabeca = 'e'; //A lombriga sempre inicia com a cabe�a para a esquerda
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
		/*Caso a cabe�a esteja para a esquerda 
		 * e a lombriga tenha espa�o para crescer uma unidade para a direita 
		 * (a posi��o que ser� ocupada � a posi��o da cabe�a mais o tamanho atual)
		 * ou a cabe�a esteja para a direita e tenha espa�o para crescer uma unidade para a esquerda
		 * (a posi��o que ser� ocupada � a posi��o da cabe�a menos o tamanho da lombriga)*/
		if ((sentidoCabeca == 'e' && posicaoLombriga + tamanhoLombriga <= tamanhoAquario)
				|| (sentidoCabeca == 'd' && posicaoLombriga - tamanhoLombriga > 0))
			tamanhoLombriga++;
	}

	public void virar() { //A fun��o simplesmente inverte o sentido da cabe�a e troca a posi��o da cabe�a pela a da ponta da cauda
		if (sentidoCabeca == 'e') {//cabe�a virando da esquerda para a direita
			sentidoCabeca = 'd';
			posicaoLombriga += tamanhoLombriga - 1;//Para trocar cabe�a por cauda a posi��o aumenta o tamanho menos um
		} else { //cabe�a virando da direita para a esquerda.
			sentidoCabeca = 'e';
			posicaoLombriga -= tamanhoLombriga - 1;//Para trocar cabe�a por cauda a posi��o diminui o tamanho menos um
		}
	}

	public void mover() {
		if (posicaoLombriga == 1 || posicaoLombriga == tamanhoAquario)//Se a cabe�a estiver em uma das pontas do aqu�rio
			virar();
		else if (sentidoCabeca == 'e') 
			posicaoLombriga--;//Lombriga se move para a esquerda, sua posi��o reduz 1
		 else 
			posicaoLombriga++;//Lombriga se move para a direita, sua posi��o aumenta 1
	}

	public String apresenta() {
		String aquario = "";
		if (sentidoCabeca == 'e') {
			for (int i = 1; i <= tamanhoAquario; i++) {
				if (posicaoLombriga == i) {//Se for a cabe�a estiver para a esquerda
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
			for (int i = tamanhoAquario; i >= 1; i--) {//Come�a-se nesse caso do fim do aqu�rio e se adiciona de tr�s para a frente
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
