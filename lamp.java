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

    // inputs
    int left  = 0;
    int right = 0;
    int up    = 0;
    int down  = 0;
    
    private final int FPS = 60;
    private final int SPEED = 1000/FPS;

    Game() {
	player = new Player(1,0,0,0,0,0,0);
	this.timer = new Timer(this.SPEED, this);
	this.timer.start();
    }

    public void paintComponent(Graphics g) {
	player.draw(g);
	g.drawLine(0,320,400,320);
    }

    // the action performed here is the the clock ticking
    public void actionPerformed(ActionEvent e) {
	this.player.applyForce((right - left) * 10, (down - up) * 10, .02);
	System.out.println(this.player);
	this.right = 0;
	this.left  = 0;
	this.up    = 0;
	this.down  = 0;
	if (this.isValid(player)) {
	} else this.timer.stop();
	this.repaint();
    }

    public boolean isValid(Player x) {
        if ( x.getX() < 300 && x.getX() >= 0 && x.getY() < 300 && x.getY() >= 0 ) {
	    return true;
	} else {
	    return false;
	}
    }

    // pressing one of these keys will increment a counter for that control which is evaluated when actionPerformed
    public void keyPressed(KeyEvent e) {
	int key = e.getKeyCode();
	if (key == 40) { // down
	    this.down++;
	} else if (key == 39) { // right
	    this.right++;
	} else if (key == 38) { // up
	    this.up++;
	} else if (key == 37) { // left
	    this.left++;
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
    private double mass; // mass
    private double x,y; // location
    private double vx, vy; // velocity
    private double ax, ay; // acceleration

    Player(double mass, double x, double y, double vx, double vy, double ax, double ay) {
	this.mass = mass;
	this.x  = x;
	this.y  = y;
	this.vx = vx;
	this.vy = vy;
	this.ax = ax;
	this.ay = ay;
    }

    public String toString() {
	String out = "";

	out = out + "[ mass: " + this.mass + " ; "
	    + "loc: " + "(" + this.x + "," + this.y + ") ; "
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

    public double getMass() {
	return this.mass;
    }

    public void applyForce(double fx, double fy, double time) {
	double nm;
	double nx, ny;
	double nvx, nvy;
	double nax, nay;

	nm = this.mass;
	nax = (fx / nm);
	nay = (fy / nm);
	nvx = this.vx + nax * time;
	nvy = this.vy + nay * time;
	nx = this.x + this.vx * time + (0.5) * nax * time * time;
	ny = this.y + this.vy * time + (0.5) * nay * time * time;

	this.mass = nm;
	this.x = nx;
	this.y = ny;
	this.vx = nvx;
	this.vy = nvy;
	this.ax = nax;
	this.ay = nay;
    }
    
    public void draw(Graphics g) {
	// fillRect(x,y,w,h)
	g.fillRect((int) this.x, (int) this.y,20,20);
    }
}
