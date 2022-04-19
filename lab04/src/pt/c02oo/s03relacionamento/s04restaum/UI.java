package pt.c02oo.s03relacionamento.s04restaum;

public class UI {
	
	public static Posicao lerPosicao(String posicao) {
		PosicaoDeJogo pj = new PosicaoDeJogo(Integer.parseInt(posicao.substring(1)), posicao.charAt(0));
		return pj.toPosition();
	}
	
	public static char[][] imprimirTabuleiro(Partida partida) {
		char board[][] = new char[7][7];
		for (int i = 0; i < 7; i++) {
			for(int j = 0; j < 7; j++) {
				if (!partida.getTabuleiro().posicaoExiste(i, j))
					board[i][j] = ' ';
				else if (partida.getTabuleiro().temUmaPecaNaPosicao(i, j))
					board[i][j] = 'P';
				else
					board[i][j] = '-';
			}
		}
		return board;
	}
}
