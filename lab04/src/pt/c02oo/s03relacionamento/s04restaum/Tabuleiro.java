package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
	private Piece pieces[][];

	public Tabuleiro() {
		pieces = new Piece[7][7];
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (!posicaoExiste(i, j) || (i == 3 && j == 3))
					pieces[i][j] = null;
				else 
					pieces[i][j] = new Piece(new Posicao(i, j), this);
			}
		}
	}

	public Piece[][] getPieces() {
		return pieces;
	}
	
	public Piece piece(int linha, int coluna) {
		if (!posicaoExiste(linha, coluna))
			throw new PositionException("Posição Inválida!");
		return pieces[linha][coluna];
	}
	
	public Piece piece(Posicao posicao) {
		if (!posicaoExiste(posicao))
			throw new PositionException("Posição Inválida!");
		return pieces[posicao.getLinha()][posicao.getColuna()];
	}

	public boolean posicaoExiste(int linha, int coluna) {
		return linha >= 0 && linha < 7 && coluna >= 0 && coluna < 7 && ((linha < 2 && coluna >= 2 && coluna < 5)
				|| (linha >= 5 && coluna >= 2 && coluna < 5) || (linha >= 2 && linha < 5));
	}
	
	public boolean posicaoExiste(Posicao posicao) {
		return posicaoExiste(posicao.getLinha(), posicao.getColuna());
	}
	
	public boolean temUmaPecaNaPosicao(int linha, int coluna) {
		if (!posicaoExiste(linha, coluna)) 
			throw new PositionException("Posição inválida");
		return pieces[linha][coluna] != null;
	}
	
	public boolean temUmaPecaNaPosicao(Posicao posicao) {
		return temUmaPecaNaPosicao(posicao.getLinha(), posicao.getColuna());
	}
	
	public void colocarPeca(Piece peca, Posicao posicao) {
		if (temUmaPecaNaPosicao(posicao))
			throw new TabuleiroException("Já existe uma peça na posição inserida");
		pieces[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.setPosicao(posicao);
	}
	
	public Piece removerPeca(Posicao posicao) {
		if (!posicaoExiste(posicao))
			throw new PositionException("Posição Inválida!");
		if (pieces[posicao.getLinha()][posicao.getColuna()] == null)
			return null;
		Piece aux = pieces[posicao.getLinha()][posicao.getColuna()];
		aux.setPosicao(null);
		pieces[posicao.getLinha()][posicao.getColuna()] = null;
		return aux;
	}
}
