import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

// Lamp is the frame of that holds and initializes the game
class Lamp extends JFrame {
    Lamp() {
	Game gui = new Game();
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
class Game extends JComponent implements MouseMotionListener {
    Player player;
    Block level;

    Game() {
	this.addMouseMotionListener(this);
    }

    public void paintComponent(Graphics g) {
    }

    public void mouseMoved(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {
    }
}

class Player {
    int x,y;

    Player() {

    }

    public void draw(Graphics g) {

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