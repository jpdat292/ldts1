import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

public class Arena {
    public Arena(int width, int height) {
        this.height = height;
        this.width = width;
    }

    int width;
    int height;
    Hero hero = new Hero();

    public boolean processKey(KeyStroke key) {
        switch(key.getKeyType()) {
            case EOF:
                return false;
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
                break;
        }
        return true;
    }

    private void moveHero(Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
    }

    public void draw(Screen screen) {
        hero.draw(screen);
    }

    public boolean canHeroMove(Position position) {
        if (position.getX() > width || position.getX() < 0 || position.getY() > height || position.getY() < 0)
            return false;
        else return true;
    }

}
