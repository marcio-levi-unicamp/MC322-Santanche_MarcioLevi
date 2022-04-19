package pt.c02oo.s03relacionamento.s04restaum;

public class Piece {
	private Posicao posicao;
	private Tabuleiro tabuleiro;

	public Piece(Posicao posicao, Tabuleiro tabuleiro) {
		this.posicao = posicao;
		this.tabuleiro = tabuleiro;
	}
	
	
	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}

	public boolean[][] movimentoPossiveis(){
		boolean[][] movimentosPossiveis = new boolean[7][7];
		
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if ((i <= 1 && (j <= 1 || j >= 5)) || (i >= 5 && (j <= 1 || j >= 5)))
					movimentosPossiveis[i][j] = false;
				else if (tabuleiro.temUmaPecaNaPosicao(i, j))
					movimentosPossiveis[i][j] = false;
				else if (i == posicao.getLinha() - 2 && j == posicao.getColuna() && tabuleiro.temUmaPecaNaPosicao(i - 1, j))
					movimentosPossiveis[i][j] = true;
				else if (i == posicao.getLinha() + 2 && j == posicao.getColuna() && tabuleiro.temUmaPecaNaPosicao(i + 1, j))
					movimentosPossiveis[i][j] = true;
				else if (i == posicao.getLinha() && j == posicao.getColuna() - 2 && tabuleiro.temUmaPecaNaPosicao(i , j - 1))
					movimentosPossiveis[i][j] = true;
				else
					movimentosPossiveis[i][j] = true;
			}
		}
		
		return movimentosPossiveis;
	}
	
}
