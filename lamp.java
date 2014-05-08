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
    Timer timer;
    
    private final int FPS = 45;
    private final int SPEED = 1000/FPS;

    Game() {
	player = new Player(0,0,0,0,0,2);
	this.timer = new Timer(this.SPEED, this);
	this.timer.start();
    }

    public void paintComponent(Graphics g) {
	player.draw(g);
    }

    // the action performed here is the the clock ticking
    public void actionPerformed(ActionEvent e) {
	this.player.move(.25);
	System.out.println(this.player);
	if (this.isValid(player)) {
	} else this.timer.stop();
	this.repaint();
    }

    public boolean isValid(Player x) {
        if ( x.getX() < 380 && x.getX() >= 0 && x.getY() < 380 && x.getY() >= 0 ) {
	    return true;
	} else {
	    return false;
	}
    }

    //Controls below:

    public void keyPressed(KeyEvent e) {
	/*	int move = 5;
	int key = e.getKeyCode();
	if (key == 40) { // down
	    this.player = new Player(this.player.getX(),this.player.getY() + move, this.player.getVX(), player.getVY(),);
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
	    }**/
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
    private double x,y; // location
    private double vx, vy; // velocity
    private double ax, ay; // acceleration
    private double fx, fy; // force
    private double mass; // mass

    // this is a complet constructor for Player that takes an x,y,vx,vy,ax, and ay
    Player(double x, double y, double vx, double vy, double ax, double ay) {
	this.x  = x;
	this.y  = y;
	this.vx = vx;
	this.vy = vy;
	this.ax = ax;
	this.ay = ay;
    }


    public String toString() {
	String out = "";

	out = out + "[" + "loc: " + "(" + this.x + "," + this.y + ") ; "
	    + "vel: " + "(" + this.vx + "," + this.vy + ") ; "
	    + "acc: " + "(" + this.ax + "," + this.ay + ")]";

	return out;
    }

    // Get variables
    public double getX() {
	return this.x;
    }

    public double getY() {
	return this.y;
    }

    public double getVX() {
	return this.vx;
    }

    public double getVY() {
	return this.vy;
    }

    public double getAX() {
	return this.ax;
    }

    public double getAY() {
	return this.ay;
    }

    public double getFX() {
	return this.fx;
    }

    public double getFY() {
	return this.fy;
    }

    public double getMass() {
	return this.mass;
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
	g.fillRect((int) this.x, (int) this.y,20,20);
    }
}
