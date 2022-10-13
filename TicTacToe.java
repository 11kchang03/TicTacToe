package tictactoe;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe extends JFrame implements MouseListener, ActionListener{
    JFrame frame;
    JPanel controlsPanel;
    gamePanel gamePanel;
    JLabel title;
    JButton newGame;
    JPanel turns;
    JPanel winCount;
    JLabel turnsText;
    JLabel p1WinsText;
    JLabel p2WinsText;
    JLabel drawsText;
    boolean turn1 = true;
    boolean win1 = false;
    boolean win2 = false;
    boolean draw = false;
    boolean outOfBounds;
    int panel1 = 0;
    int panel2 = 0;
    int panel3 = 0;
    int panel4 = 0;
    int panel5 = 0;
    int panel6 = 0;
    int panel7 = 0;
    int panel8 = 0;
    int panel9 = 0;
    int winStats1 = 0;
    int winStats2 = 0;
    int drawStats = 0;

    //constructor
    public TicTacToe(){
        //create a canvas
       frame = new JFrame();
       frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
       frame.setVisible(true);
       frame.setSize(600,600);
       frame.getContentPane().setLayout(new BorderLayout());
       frame.setLocationRelativeTo(null);

       //add the controls panel
       controlsPanel = new JPanel();
       controlsPanel.setPreferredSize(new Dimension(480,75));
       controlsPanel.setLayout(new FlowLayout());
       controlsPanel.setBackground(Color.WHITE);
       frame.add(controlsPanel);
       
       //add the panel where the game will take place
       gamePanel = new gamePanel();
       gamePanel.setBackground(new Color(154, 137, 171));
       frame.add(gamePanel);

       //layout
       frame.getContentPane().add(controlsPanel, BorderLayout.PAGE_START);
       frame.getContentPane().add(gamePanel, BorderLayout.CENTER);

       //add stuff on controls panel
       //new game button
       newGame = new JButton("New Game");
       newGame.setBackground(new Color(154, 137, 171));
       newGame.setOpaque(true);
       newGame.setBorderPainted(false);
       newGame.setPreferredSize(new Dimension(150, 60));
       controlsPanel.add(newGame);
       newGame.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
        	   new TicTacToe(winStats1, winStats2, drawStats);
           }
       });
       
       //turns display
       turns = new JPanel();
       turns.setBackground(new Color(154, 137, 171));
       turns.setPreferredSize(new Dimension(150, 60));
       turns.setLayout(new GridBagLayout());
       controlsPanel.add(turns);
       turnsText = new JLabel();
       turnsText.setText("Player One's Turn");
       turns.add(turnsText);
       
       
       //winCount display
       winCount = new JPanel();
       winCount.setBackground(new Color(154, 137, 171));
       winCount.setPreferredSize(new Dimension(150, 60));
       winCount.setLayout(new FlowLayout());
       p1WinsText = new JLabel("Player 1's Wins: " + winStats1);
       p2WinsText = new JLabel("Player 2's Wins: " + winStats2);
       drawsText = new JLabel("Draws: " + drawStats);
       controlsPanel.add(winCount);
       winCount.add(p1WinsText);
       winCount.add(p2WinsText);
       winCount.add(drawsText);
       
       //add interfaces
       frame.addMouseListener(this);
    }

    //constructor
    public TicTacToe(int wins1, int wins2, int draws){
    	winStats1 = wins1;
    	winStats2 = wins2;
    	drawStats = draws;
    	//create a canvas
       frame = new JFrame();
       frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
       frame.setVisible(true);
       frame.setSize(600,600);
       frame.getContentPane().setLayout(new BorderLayout());
       frame.setLocationRelativeTo(null);

       //add the controls panel
       controlsPanel = new JPanel();
       controlsPanel.setPreferredSize(new Dimension(480,75));
       controlsPanel.setLayout(new FlowLayout());
       controlsPanel.setBackground(Color.WHITE);
       frame.add(controlsPanel);
       
       //add the panel where the game will take place
       gamePanel = new gamePanel();
       gamePanel.setBackground(new Color(154, 137, 171));
       frame.add(gamePanel);

       //layout
       frame.getContentPane().add(controlsPanel, BorderLayout.PAGE_START);
       frame.getContentPane().add(gamePanel, BorderLayout.CENTER);

       //add stuff on controls panel
       //new game button
       newGame = new JButton("New Game");
       newGame.setBackground(new Color(154, 137, 171));
       newGame.setOpaque(true);
       newGame.setBorderPainted(false);
       newGame.setPreferredSize(new Dimension(150, 60));
       controlsPanel.add(newGame);
       newGame.addActionListener(new ActionListener()
       {
           @Override
           public void actionPerformed(ActionEvent e)
           {new TicTacToe(winStats1, winStats2, drawStats);}
       });
       
       //turns display
       turns = new JPanel();
       turns.setBackground(new Color(154, 137, 171));
       turns.setPreferredSize(new Dimension(150, 60));
       turns.setLayout(new GridBagLayout());
       controlsPanel.add(turns);
       turnsText = new JLabel();
       turnsText.setText("Player One's Turn");
       turns.add(turnsText);
       
       
       //winCount display
       winCount = new JPanel();
       winCount.setBackground(new Color(154, 137, 171));
       winCount.setPreferredSize(new Dimension(150, 60));
       winCount.setLayout(new FlowLayout());
       p1WinsText = new JLabel("Player 1's Wins: " + winStats1);
       p2WinsText = new JLabel("Player 2's Wins: " + winStats2);
       drawsText = new JLabel("Draws: " + drawStats);
       controlsPanel.add(winCount);
       winCount.add(p1WinsText);
       winCount.add(p2WinsText);
       winCount.add(drawsText);
       
       //add interfaces
       frame.addMouseListener(this);
    }
    
    //helper method: check if something is in between two int
    public static boolean between(int variable, int minValue, int maxValue) {
       return variable > minValue && variable < maxValue;
    }
    
    public class gamePanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int gapX = gamePanel.getWidth()/8;
            int gapY = gamePanel.getHeight()/8;
    		g.setFont(new Font("Monospaced", Font.PLAIN, gamePanel.getWidth()/16));
            g.setColor(Color.BLACK);
            //draw the first vertical line
            g.fillRect(3*gapX, gapY, 10, gapY*6);
            //draw the second vertical line
            g.fillRect(5*gapX, gapY, 10, gapY*6);
            //draw the first horizontal line
            g.fillRect(gapX, 3*gapY, gapX*6, 10);
            //draw the second horizontal line
            g.fillRect(gapX, 5*gapY, gapX*6, 10);
            
            //deciding whether an x or an o will show up on each of 9 panels
            if(panel1 == 1) 
            	g.drawString("X", 2*gapX-5, 2*gapY);            
            if (panel1 == 2) 
            	g.drawString("O", 2*gapX-5, 2*gapY);
            if (panel2 == 1) 
    			g.drawString("X", 4*gapX-5, 2*gapY);
            if (panel2 == 2) 
    			g.drawString("O", 4*gapX-5, 2*gapY);
            if (panel3 == 1) 
    			g.drawString("X", 6*gapX-5, 2*gapY);
            if (panel3 == 2) 
    			g.drawString("O", 6*gapX-5, 2*gapY);
            if (panel4 == 1) 
    			g.drawString("X", 2*gapX-5, 4*gapY);
            if (panel4 == 2) 
    			g.drawString("O", 2*gapX-5, 4*gapY);
            if (panel5 == 1) 
    			g.drawString("X", 4*gapX-5, 4*gapY);
            if (panel5 == 2) 
    			g.drawString("O", 4*gapX-5, 4*gapY);
            if (panel6 == 1) 
    			g.drawString("X", 6*gapX-5, 4*gapY);
            if (panel6 == 2) 
    			g.drawString("O", 6*gapX-5, 4*gapY);
            if (panel7 == 1) 
    			g.drawString("X", 2*gapX-5, 6*gapY);
            if (panel7 == 2) 
    			g.drawString("O", 2*gapX-5, 6*gapY);
            if (panel8 == 1) 
    			g.drawString("X", 4*gapX-5, 6*gapY);
            if (panel8 == 2) 
    			g.drawString("O", 4*gapX-5, 6*gapY);
            if (panel9 == 1) 
    			g.drawString("X", 6*gapX-5, 6*gapY);
            if (panel9 == 2) 
    			g.drawString("O", 6*gapX-5, 6*gapY);
            }
        }
	
	@Override
	public void mouseClicked(MouseEvent e) {
        //drawing the x or the o onto the 9 different spaces
		int gapX = gamePanel.getWidth()/8;
        int gapY = gamePanel.getHeight()/8;
		Graphics g = frame.getGraphics();
		g.setFont(new Font("Monospaced", Font.PLAIN, gamePanel.getWidth()/16));
        int clickX = e.getX();
        int clickY = e.getY();
        if(win1==false && win2==false && draw==false) {
        	if(turn1 == true) {
        		outOfBounds = false; //outOfBounds prevents signs from changing even when user clicks outside the board
            	if(between(clickX, gapX, 3*gapX) && between(clickY, gapY+110, 3*gapY+110) && panel1==0) {
            		g.drawString("X", 2*gapX, 2*gapY+110);
            		panel1 = 1;
            	} else if(between(clickX, 3*gapX, 5*gapX) && between(clickY, gapY+110, 3*gapY+110) && panel2==0) {
            		g.drawString("X", 4*gapX, 2*gapY+110);
            		panel2 = 1;
            	} else if(between(clickX, 5*gapX, 7*gapX) && between(clickY, gapY+110, 3*gapY+110) && panel3==0) {
            		g.drawString("X", 6*gapX, 2*gapY+110);
            		panel3 = 1;
            	} else if(between(clickX, gapX, 3*gapX) && between(clickY, 3*gapY+110, 5*gapY+110) && panel4==0) {
            		g.drawString("X", 2*gapX, 4*gapY+110);
            		panel4 = 1;
            	} else if(between(clickX, 3*gapX, 5*gapX) && between(clickY, 3*gapY+110, 5*gapY+110) && panel5==0) {
            		g.drawString("X", 4*gapX, 4*gapY+110);
            		panel5 = 1;
            	} else if(between(clickX, 5*gapX, 7*gapX) && between(clickY, 3*gapY+110, 5*gapY+110) && panel6==0) {
            		g.drawString("X", 6*gapX, 4*gapY+110);
            		panel6 = 1;
            	} else if(between(clickX, gapX, 3*gapX) && between(clickY, 5*gapY+110, 7*gapY+110) && panel7==0) {
            		g.drawString("X", 2*gapX, 6*gapY+110);
            		panel7 = 1;
            	} else if(between(clickX, 3*gapX, 5*gapX) && between(clickY, 5*gapY+110, 7*gapY+110) && panel8==0) {
            		g.drawString("X", 4*gapX, 6*gapY+110);
            		panel8 = 1;
            	} else if(between(clickX, 5*gapX, 7*gapX) && between(clickY, 5*gapY+110, 7*gapY+110) && panel9==0) {
            		g.drawString("X", 6*gapX, 6*gapY+110);
            		panel9 = 1;
            	} else {
            		outOfBounds = true;
            	}
            	
            	//if not out of bounds, continue as usual
                if(outOfBounds == false) {
                	turn1 = false;
                }
                
                //check if player 1 won
                if((panel1 == 1 && panel2 == 1 && panel3 == 1) || (panel1 == 1 && panel4 == 1 && panel7 == 1) || (panel1 ==1 && panel5 == 1 && panel9 == 1) ||
                		(panel2 == 1 && panel5 == 1 && panel8 == 1) || (panel3 == 1 && panel6 == 1 && panel9 == 1) || (panel3==1 && panel5==1 && panel7 ==1)
                		|| (panel4==1 && panel5==1 && panel6==1) || (panel7==1 && panel8==1 && panel9==1)) {
                	win1 = true;
                	winStats1++;
                	turnsText.setText("Player One Wins");
                }
                                
            } else if(turn1 == false) {
        		outOfBounds = false;
            	if(between(clickX, gapX, 3*gapX) && between(clickY, gapY+110, 3*gapY+110) && panel1==0) {
            		g.drawString("O", 2*gapX, 2*gapY+110);
            		panel1 = 2;
            	} else if(between(clickX, 3*gapX, 5*gapX) && between(clickY, gapY+110, 3*gapY+110) && panel2==0) {
            		g.drawString("O", 4*gapX, 2*gapY+110);
            		panel2 = 2;
            	} else if(between(clickX, 5*gapX, 7*gapX) && between(clickY, gapY+110, 3*gapY+110) && panel3==0) {
            		g.drawString("O", 6*gapX, 2*gapY+110);
            		panel3 = 2;
            	} else if(between(clickX, gapX, 3*gapX) && between(clickY, 3*gapY+110, 5*gapY+110) && panel4==0) {
            		g.drawString("O", 2*gapX, 4*gapY+110);
            		panel4 = 2;
            	} else if(between(clickX, 3*gapX, 5*gapX) && between(clickY, 3*gapY+110, 5*gapY+110) && panel5==0) {
            		g.drawString("O", 4*gapX, 4*gapY+110);
            		panel5 = 2;
            	} else if(between(clickX, 5*gapX, 7*gapX) && between(clickY, 3*gapY+110, 5*gapY+110) && panel6==0) {
            		g.drawString("O", 6*gapX, 4*gapY+110);
            		panel6 = 2;
            	} else if(between(clickX, gapX, 3*gapX) && between(clickY, 5*gapY+110, 7*gapY+110) && panel7==0) {
            		g.drawString("O", 2*gapX, 6*gapY+110);
            		panel7 = 2;
            	} else if(between(clickX, 3*gapX, 5*gapX) && between(clickY, 5*gapY+110, 7*gapY+110) && panel8==0) {
            		g.drawString("O", 4*gapX, 6*gapY+110);
            		panel8 = 2;
            	} else if(between(clickX, 5*gapX, 7*gapX) && between(clickY, 5*gapY+110, 7*gapY+110) && panel9==0) {
            		g.drawString("O", 6*gapX, 6*gapY+110);
            		panel9 = 2;
            	} else {
            		outOfBounds = true;
            	}
            	
            	//if not out of bounds, continue as usual
            	if(outOfBounds == false) {
                	turn1 = true;
                }
            	
            	//check if player 2 won
            	if((panel1 == 2 && panel2 == 2 && panel3 == 2) || (panel1 == 2 && panel4 == 2 && panel7 == 2) || (panel1 ==2 && panel5 == 2 && panel9 == 2) ||
                		(panel2 == 2 && panel5 == 2 && panel8 == 2) || (panel3 == 2 && panel6 == 2 && panel9 == 2) || (panel3==2 && panel5==2 && panel7 ==2)
                		|| (panel4==2 && panel5==2 && panel6==2) || (panel7==2 && panel8==2 && panel9==2)) {
                	win2 = true;
                	winStats2++;
                	turnsText.setText("Player Two Wins");
                }  
            }
            
            //for resizing purposes
    		repaint();
    		
    		//check if draw
            if((panel1>0 && panel2>0 && panel3>0 && panel4>0 && panel5>0 && panel6>0 && panel7>0 && panel8>0 && panel9>0) && (win1==false) && (win2==false)) {
            	draw = true;
            	drawStats++;
            	turnsText.setText("It's a Draw");
            }
        }
        p1WinsText.setText("Player 1's Wins: " + winStats1);
        p2WinsText.setText("Player 2's Wins: " + winStats2);
        drawsText.setText("Draws: " + drawStats);
        
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//main method
	public static void main(String arg[]){
        TicTacToe tictactoe = new TicTacToe();
    }
}
