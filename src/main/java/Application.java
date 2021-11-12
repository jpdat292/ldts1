import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.w3c.dom.Text;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        Game puppyGame = new Game();
        puppyGame.run();
    }
}

/*  Um pouco sobre exceptions em java: em java, todos os métodos que podem ter de lidar com uma exception tem
de lidar com ela de alguma forma, essencialmente, uma de duas coisas:
Ou o método tem de ter o "throws aTalException", indicando que o método lança aquela exception "pra cima"
Ou o método tem de meter a possível exception num bloco try catch.
Agora sobre como decidir, ou seja, o que de fato faremos em cada lugar, ter em mente o seguinte:
A exception deve ser tratada num lugar onde se tenha condiçoes de trata-la. Simples né? Faz sentido.
As exceptions podem lançar objetos inteiros contendo o "estado" do que quer que tenha acontecido, e várias
coisas podem ser feitas com essa informaçao. Mas pra já ficamos com o exercicio: sua exception printa
informaçoes. Simples assim, acho q podemos deixar o próprio método draw() tomar conta de printar umas coisinhas
né.
 */
