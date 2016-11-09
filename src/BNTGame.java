import org.newdawn.slick.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by MarcR on 09.11.2016.
 */
public class BNTGame extends BasicGame {

    int posx;
    int posy;
    Image img;


    public BNTGame(String gamename) {
        super(gamename);
        setPosx(100);
        setPosy(100);
    }

    public static void main(String[] args) {
        try {
            AppGameContainer appgc;
            appgc = new AppGameContainer(new BNTGame("Simple Slick BNT Game"));
            appgc.setDisplayMode(1920, 1200, false);
            appgc.start();

        } catch (SlickException slex) {
            Logger.getLogger(BNTGame.class.getName()).log(Level.SEVERE, null, slex);
        }
    }

    public void init(GameContainer gc) throws SlickException {

        img = new Image("res/MiniMe.png");

    }

    public void update(GameContainer gc, int i) throws SlickException {
        img.rotate(0.5f);

        if (gc.getInput().isKeyPressed((Input.KEY_ESCAPE))) {
            gc.exit();
        }

        handleKeyPressed(gc);


    }

    public void render(GameContainer gc, Graphics g) throws SlickException {
        g.drawString("GO BNT!", getPosx(), getPosy());
        img.draw(getPosx() + 5, getPosy() + 15);
    }

    private void handleKeyPressed(GameContainer gc) {
        if (gc.getInput().isKeyDown(Input.KEY_A)) {
            setPosx(getPosx() - 10);
        }
        if (gc.getInput().isKeyDown(Input.KEY_W)) {
            setPosy(getPosy() - 10);
        }
        if (gc.getInput().isKeyDown(Input.KEY_D)) {
            setPosx(getPosx() + 10);
        }
        if (gc.getInput().isKeyDown(Input.KEY_S)) {
            setPosy(getPosy() + 10);
        }
    }

    public void keyPressed(int key, char c) {

        switch (key) {
            case Input.KEY_A:
                setPosx(getPosx() - 10);
                break;
            case Input.KEY_W:
                setPosy(getPosy() - 10);
                break;
            case Input.KEY_D:
                setPosx(getPosx() + 10);
                break;
            case Input.KEY_S:
                setPosy(getPosy() + 10);
                break;
            default:
                break;
        }

    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }
}
