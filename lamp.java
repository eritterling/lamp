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
    
    private final int FPS = 10;
    private final int SPEED = 1000/FPS;

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
	this.player.move(0.25);
	System.out.println(this.player);
	this.repaint();
    }

    public boolean isValid(Player x) {
        if ( x.getX() < 400 && x.getX() >= 0 && x.getY() < 400 && x.getY() >= 0 ) {
	    return true;
	} else {
	    return false;
	}
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
    // location with respect to two dimensions
    private int x,y;
    // velocity with respect to x and y
    private double vx, vy;
    // acceleration with respect to x and y
    private double ax, ay;

    // Constructors for Player

    // the no args constructor for player puts a player at the origin and sets ay equal to gravity
    Player() {
	this.x = 0;
	this.y = 0;
	this.vx = 0;
	this.vy = 0;
	this.ax = 0;
	this.ay = 9.81;
    }

    // if you create a player and only give it an x and y it will start with no velocity in any direction
    // it will also start with ay = -9.81 as gravity, with no ax acceleration
    Player(int x, int y) {
	this.x  = x;
	this.y  = y;
	this.vx = 0;
	this.vy = 0;
	this.ax = 0;
	this.ay = 9.81;
    }

    // this constructor sets the velocities and the location by what you give it
    // acceleration in x is set to 0 and in y it is equal to gravity: -9.81
    Player(int x, int y, double vx, double vy) {
	this.x  = x;
	this.y  = y;
	this.vx = vx;
	this.vy = vy;
	this.ax = 0;
	this.ay = 9.81;
    }

    // this is a complet constructor for Player that takes an x,y,vx,vy,ax, and ay
    Player(int x, int y, double vx, double vy, double ax, double ay) {
	this.x  = x;
	this.y  = y;
	this.vx = vx;
	this.vy = vy;
	this.ax = ax;
	this.ay = ay;
    }


    public String toString() {
	String out = "";

	out = out + "(" + this.x + "," + this.y + "," + this.vx + "," + this.vy + ")";

	return out;
    }

    public int getX() {
	return this.x;
    }

    public int getY() {
	return this.y;
    }
    
    public void move(double time) {
	// set new x
	this.x = (int) (this.x
			+ (this.vx*time) 
			+ ((0.5)*this.ax*time*time) );

	// set new y
	this.y = (int) (this.y
			+ (this.vy*time)
			+ ((0.5)*this.ay*time*time) );

	// set new vx
	this.vx = this.vx + (this.ax*time);

	// set new vy
	this.vy = this.vy + (this.ay*time);
	
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