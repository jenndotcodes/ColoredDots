package coloreddots;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


class ColorDotsPanel extends JPanel 
{
	final int dotSize = 50;
	
	
	@Override
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		
		ColorDot.setDotCount(0);
		
		
		g2d.setColor(Color.black);
		g2d.fillRect(0, 0, getWidth(), getHeight());
				
		int widthOfScreen = getWidth();
		
		int numberOfDots = widthOfScreen / dotSize;
		
		g2d.setColor(new Color(220,20,60));
		
		for(int row = 0; row < numberOfDots; row++)
		{
			g2d.fill(new ColorDot(row*dotSize,10,dotSize,dotSize));
		}
		
		g2d.setColor(new Color(64,224,208));
		g2d.drawString("There are " + ColorDot.getDotCount(), 50, 100);
		
		
		
	}
	
	@Override
	public Dimension getPreferredSize() 
	{
		return new Dimension(500, 300);
	}
}

class ColorDot extends Ellipse2D.Float
{
	private static int dotCount = 1;
	
	public ColorDot()
	{
		super();
		setDotCount(getDotCount() + 1);
	}
	
	public ColorDot(float x, float y, float width, float height)
	{
		super(x,y,width,height);
		setDotCount(getDotCount() + 1);
	}

	public static int getDotCount() {
		return dotCount;
	}

	public static void setDotCount(int dotCount) {
		ColorDot.dotCount = dotCount;
	}
	
}


public class ColoredDots {

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() 
		{
 
			public void run() 
			{
				ColorDotsFrame tsf = 
						new ColorDotsFrame();
				tsf.setTitle("Colored Dots Example");
				tsf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				tsf.setVisible(true);
				
			}
		});

	}
}

class ColorDotsFrame extends JFrame 
{
	public ColorDotsFrame() 
	{
		ColorDotsPanel tsp = new ColorDotsPanel();
		add(tsp);
		pack();
	}
}
