package pt.c02oo.s03relacionamento.s04restaum;

public class Posicao {
	private int linha;
	private int coluna;

	public Posicao(int linha, int coluna) {
		if (linha >= 0 && linha < 7 && coluna >= 0 && coluna < 7) {
			this.linha = linha;
			this.coluna = coluna;
		}
		else
			throw new PositionException("Posição inválida!");
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	public void setValores(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}
}
