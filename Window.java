import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;


public class Window extends JFrame{
	static Window w;
	public Window(){
		setSize(1024,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel sun = new JLabel("SUN");
        sun.setLocation(37,80);
        sun.setSize(60,20);
        
        Game game = new Game(sun);
        game.setLocation(0,0);
        getLayeredPane().add(game,new Integer(0));
        
        Card sunflower = new Card(new ImageIcon(this.getClass().getResource("images/cards/card_sunflow.gif")).getImage());
		sunflower.setLocation(110, 8);
		sunflower.setAction((ActionEvent e) -> {
			game.active = Object.Sunflower;
		});
		getLayeredPane().add(sunflower, new Integer(3));
        
		Card peashooter = new Card(new ImageIcon(this.getClass().getResource("images/cards/card_peashoot.gif")).getImage());
		peashooter.setLocation(175,8);
		peashooter.setAction((ActionEvent e) -> {
			game.active = Object.Peashooter;
		});
		getLayeredPane().add(peashooter,new Integer(3));
		
		Card freezepeashooter = new Card(new ImageIcon(this.getClass().getResource("images/cards/card_new.gif")).getImage());
		freezepeashooter.setLocation(240,8);
		freezepeashooter.setAction((ActionEvent e) -> {
			game.active = Object.FreePeashooter;
		});
		getLayeredPane().add(freezepeashooter,new Integer(3));
		
		getLayeredPane().add(sun,new Integer(2));
        setResizable(false);
        setVisible(true);
	}
	
	public Window(boolean b){
		Menu menu = new Menu();
		menu.setLocation(0,0);
        setSize(1024,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getLayeredPane().add(menu,new Integer(0));
        menu.repaint();
        setResizable(false);
        setVisible(true);
	}
	public static void begin(){
		w.dispose();
		w = new Window();
	}
	public static void main(String[] args) {
		w = new Window(true);
  }
}
