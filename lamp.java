import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Lamp is the frame of that holds and initializes the game
class Lamp extends JFrame {
    Lamp() {
	Game gui = new Game();
	this.addKeyListener(gui);
	this.addMouseMotionListener(gui);
	this.add(gui);
    }

    public static void main(String[] args) {
	Lamp game = new Lamp();
	game.setVisible(true);
	game.setSize(400,400);
	game.setTitle("a game about a lamp");
	game.setDefaultCloseOperation(3);
    }
}

// View holds the game
class Game extends JComponent implements KeyListener,  MouseMotionListener, ActionListener {
    Player player;
    Block level;
    Timer timer;
    
    private final int SPEED = 1000;

    Game() {
	player = new Player(0,0);
	this.timer = new Timer(this.SPEED, this);
	this.timer.start();
    }

    public void paintComponent(Graphics g) {
	player.draw(g);
    }

    // the action performed here is the the clock ticking
    public void actionPerformed(ActionEvent e) {
	this.player = new Player(this.player.getX(), this.player.getY() + 2);
	this.repaint();
    }

    //Controls below:


    public void keyPressed(KeyEvent e) {
	int move = 5;
	int key = e.getKeyCode();
	if (key == 40) { // down
	    this.player = new Player(this.player.getX(),this.player.getY() + move);
	    this.repaint();
	} else if (key == 39) { // right
	    this.player = new Player(this.player.getX() + move,this.player.getY());
	    this.repaint();
	} else if (key == 38) { // up
	    this.player = new Player(this.player.getX(), this.player.getY() - move );
	    this.repaint();
	} else if (key == 37) { // left
	    this.player = new Player(this.player.getX() - move , this.player.getY());
	    this.repaint();
	}
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }

    public void mouseMoved(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {

    }
}

class Player {
    private int x,y;
    // velocity with respect to x and y
    private double vx, vy;

    Player(int x, int y) {
	this.x = x;
	this.y = y;
    }

    public String toString() {
	String out = "";

	out = out + "(" + this.x + "," + this.y + ")";

	return out;
    }

    public int getX() {
	return this.x;
    }

    public int getY() {
	return this.y;
    }

    public void draw(Graphics g) {
	// fillRect(x,y,w,h)
	g.fillRect(this.x,this.y,20,20);
    }
}

// a torch is the players weapon and sits in the Player's hand
class Torch extends JComponent {
    // pos relative to Player
    private int x, y;
    
    // takes an init pos
    Torch() {
    }
    
    public void draw(Graphics g) {
	g.fillOval(this.x,this.x+10,this.y,this.y+10);
    }
}

// a block is a standard piece in the game
class Block {
    int x,y;
    Color color;

    Block() {

    }

    public void draw(Graphics g) {
    }
}