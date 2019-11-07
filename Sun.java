import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Sun extends JPanel implements MouseListener {

    Game game;
    Image sunImage;

    int myX;
    int myY;
    int endY;

    int health = 200;

    public Sun(Game gm,int startX,int startY,int endY){
        this.game = gm;
        this.endY = endY;
        setSize(80,80);
        setOpaque(false);
        myX = startX;
        myY = startY;
        setLocation(myX,myY);
        sunImage = new ImageIcon(this.getClass().getResource("images/sun.png")).getImage();
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(sunImage,0,0,null);
    }

    public void move(){
        if(myY < endY) {
            myY+= 4;
        }else{
            health--;
            if(health<0){
                game.remove(this);
                game.activeSuns.remove(this);
            }
        }
        setLocation(myX,myY);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        game.setSunScore(game.getSunScore()+25);
        game.remove(this);
        game.activeSuns.remove(this);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
