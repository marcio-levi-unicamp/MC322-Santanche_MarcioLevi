# Lab 03
## Animação de uma lombriga no aquário
A tarefa consiste na animação de uma lombriga em um áquario representado de forma unidimensional.
Nele a lombriga poderá poderá se mover, virar sua cabeça e crescer.
Um áquario é representado de forma geral: "...###O@@@...###..", onde o caractere '#' representa um espaço vazio no áquario, o caractere 'O' representa a cabeça da lombriga e o caractere '@' representa uma parte da cauda da lombriga.

A tarefa consiste da criação de 3 classes: as classes "AquarioLombriga", "Animacao" e "AppLombriga".

A classe "AquarioLombriga" possui 4 atributos:(**int**) o tamanho da lombriga, (**int**) o tamanho do aquário em que ela está inserida, (**int**) a posição atual da cabeça da lombriga e (**char**) o sentido para o qual ela está virada.

Já para os seus métodos estão, além do construtor recebendo o tamanho da lombriga, o tamanho do aquário e a posição como parâmetro,
 visto que por padrão sua cabeça sempre começa virada para a esquerda, logo não precisa ser informado nos parâmetros do construtor, e 
 dos *getters* para os tamanhos da lombriga e da posição atual, estão o métodos **virar()**, **mover()**, **crescer()** e **apresenta()
 **, esse último que representa graficamente a lombriga.

Já a classe "Animacao" possui 3 atributos: A ***String*** de animação com os dados da lombriga e os passos a serem executados, (**AquarioLombriga**) a lombriga a qual será animada e (**int**) o passo atual que será executado (sendo 1, o primeiro passo)

Como métodos, estão além do construtor que recebe como parâmetro a string de animação e o *getter* do passo atual, estão o método **apresenta()** que simplesmente chama o método homônimo do objeto lombriga a ele associado nos atributos e o método **passo()** que executa o passo atual da String, atualiza o valor do passo atual e caso seja um comando inválido lançará uma exceção.

A classe "AppLombriga", por sua vez, é composta apenas do método estático main() que lerá um arquivo csv com várias lombrigas e as animará.