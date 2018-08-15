import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * @author putengfei
 * @created 2017-11-21
*/
public class Demo_javaFX extends JFrame{
	public Demo_javaFX(){
		this.setTitle("Title");
		this.setResizable(false); 
	    
		JButton b0 = new JButton("0");
		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton b4 = new JButton("4");
		JButton b5 = new JButton("5");
		JButton b6 = new JButton("6");
		JButton b7 = new JButton("7");
		JButton b8 = new JButton("8");
		JButton b9 = new JButton("9");
		JButton b_mul = new JButton("*");
		JButton b_div = new JButton("/");
		JButton b_sub = new JButton("-");
		JButton b_add = new JButton("+");
		JButton b_dy = new JButton("=");
		JButton b_point = new JButton(".");
		JPanel sourth =new JPanel();
		sourth.setLayout(new GridLayout(4, 4,5,5));
		sourth.add(b7);
		sourth.add(b8);
		sourth.add(b9);
		sourth.add(b_div);
		sourth.add(b4);
		sourth.add(b5);
		sourth.add(b6);
		sourth.add(b_mul);
		sourth.add(b1);
		sourth.add(b2);
		sourth.add(b3);
		sourth.add(b_sub);
		sourth.add(b0);
		sourth.add(b_point);
		sourth.add(b_dy);
		sourth.add(b_add);
		sourth.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		this.add(sourth);
		JPanel center =new JPanel();
		center.setLayout(new BorderLayout());
		JTextField jt = new JTextField(20);
		JButton b_clear = new JButton("C");
		center.add(jt, BorderLayout.WEST);
		center.add(b_clear,BorderLayout.EAST);
		this.add(center);
		jt.setHorizontalAlignment(JTextField.RIGHT);
		this.setLayout(new BorderLayout());
	    this.add(center, BorderLayout.NORTH);
	    this.add(sourth, BorderLayout.CENTER);
	    this.pack();
	    this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		Demo_javaFX jf = new Demo_javaFX();
	}
}
