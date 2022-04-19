package pt.c02oo.s03relacionamento.s04restaum;

public class PosicaoDeJogo {
	private int linha;
	private char coluna;
	
	public PosicaoDeJogo(int linha, char coluna) {
		if (linha < 1 || linha > 7 || coluna < 'a' || coluna > 'g')
			throw new PositionException("Posição inválida");
		this.linha = linha;
		this.coluna = coluna;
	}
	
	public Posicao toPosition() {
		return new Posicao(7- linha, (int) (coluna - 'a'));
	}
}
