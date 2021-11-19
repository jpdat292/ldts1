import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    public Game() {
        try {
            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
            hero = new Hero();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Screen screen;
    public boolean running;
    private Hero hero;

    public void run() {
        running = true;
        while (running) {
            try {
                this.draw();
                KeyStroke key = screen.readInput();
                processKey(key);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void processKey(KeyStroke key) throws IOException{
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q')
            screen.close();
        else
            switch(key.getKeyType()) {
                case EOF:
                    running = false;
                    break;
                case ArrowUp:
                    moveHero(hero.moveUp());
                    break;
                case ArrowDown:
                    moveHero(hero.moveDown());
                    break;
                case ArrowLeft:
                    moveHero(hero.moveLeft());
                    break;
                case ArrowRight:
                    moveHero(hero.moveRight());
            }
    }

    private void draw() throws IOException {
        screen.clear();
        hero.draw(screen);
        screen.refresh();
    }

    private void moveHero(Position position) {
        hero.setPosition(position);
    }

}
