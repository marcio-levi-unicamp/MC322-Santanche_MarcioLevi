package pt.c02oo.s03relacionamento.s04restaum;

public class Partida {
	private Tabuleiro tabuleiro;
	
	public Partida() {
		tabuleiro = new Tabuleiro();
	}
	
	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}


	public void makeMove(Posicao origem, Posicao destino) {
		validarPosicaoOrigem(origem);
		validarPosicaoDestino(origem, destino);
		Posicao posicaoCapturada;
		
		if (destino.getLinha() == origem.getLinha() - 2) 
			posicaoCapturada = new Posicao(origem.getLinha() - 1, origem.getColuna());
		else if (destino.getLinha() == origem.getLinha() + 2) 
			posicaoCapturada = new Posicao(origem.getLinha() + 1, origem.getColuna());
		else if (destino.getColuna() == origem.getColuna() - 2) 
			posicaoCapturada = new Posicao(origem.getLinha(), origem.getColuna() - 1);
		else
			posicaoCapturada = new Posicao(origem.getLinha(), origem.getColuna() + 1);
		
		tabuleiro.removerPeca(posicaoCapturada);
		Piece aux = tabuleiro.removerPeca(origem);
		tabuleiro.colocarPeca(aux, destino);
	}
	
	private void validarPosicaoOrigem(Posicao origem) {
		if (!tabuleiro.posicaoExiste(origem))
			throw new PositionException("Posicao de origem não existe");
		if (!tabuleiro.temUmaPecaNaPosicao(origem))
			throw new TabuleiroException("Não há peça na posição inserida");
	}
	
	private void validarPosicaoDestino(Posicao origem, Posicao destino) {
		if (!tabuleiro.posicaoExiste(destino))
			throw new PositionException("Posicao de destino não existe");
		if (!tabuleiro.piece(origem).movimentoPossiveis()[destino.getLinha()][destino.getColuna()])
			throw new TabuleiroException("Movimento inválido!");
	}
}
