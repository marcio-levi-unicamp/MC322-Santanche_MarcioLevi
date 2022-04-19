package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {

	public static void main(String[] args) {
		AppRestaUm.executaJogo(null, null);
	}

	public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
      Toolkit tk = Toolkit.start(arquivoEntrada, arquivoSaida);
      Partida partida = new Partida();
      tk.writeBoard("Tabuleiro inicial", UI.imprimirTabuleiro(partida));
      
      String commands[] = tk.retrieveCommands();
      
      for (int l = 0; l < commands.length; l++) {
    	  try {
	    	  Posicao source = UI.lerPosicao(commands[l].substring(0, 2));
	    	  Posicao target = UI.lerPosicao(commands[l].substring(3));
	    	  partida.makeMove(source, target);
	    	  tk.writeBoard(String.format("source: %s; target: %s", commands[l].substring(0, 2), commands[l].substring(3)), UI.imprimirTabuleiro(partida));
    	  }
    	  catch (RuntimeException e) {
    		  System.out.println(e.getMessage());
    	  }
      }
      
      tk.stop();
   }

}
