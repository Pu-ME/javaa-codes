package com.calculator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * @author putengfei
 * @created 2017-11-20
*/
public class Calculator extends JFrame{
	   
    private static final long serialVersionUID = 4907149509182425824L;
	private JTextField jtf;
    public Calculator(){
        Container c = getContentPane();
        setLayout(new GridLayout(2,1));
        jtf = new JTextField("0",40);
            jtf.setHorizontalAlignment(JTextField.RIGHT);
        JButton data0 = new JButton("0");
        JButton data1 = new JButton("1");
        JButton data2 = new JButton("2");
        JButton data3 = new JButton("3");
        JButton data4 = new JButton("4");
        JButton data5 = new JButton("5");
        JButton data6 = new JButton("6");
        JButton data7 = new JButton("7");
        JButton data8 = new JButton("8");
        JButton data9 = new JButton("9");
        JButton point = new JButton(".");
        JButton equ = new JButton("=");
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton mtp = new JButton("*");
        JButton dvd = new JButton("/");
        JButton sqr = new JButton("sqrt");
        JButton root = new JButton("x^2");
        JButton tg = new JButton("退格");
        JButton ql = new JButton("清零");
        JPanel jp = new JPanel();  
        jp.setLayout(new GridLayout(4,5,5,5));
        jp.add(data7);
        jp.add(data8);
        jp.add(data9);
        jp.add(plus);
        jp.add(sqr);
        jp.add(data4);
        jp.add(data5);
        jp.add(data6);
        jp.add(minus);
        jp.add(root);
        jp.add(data1);
        jp.add(data2);
        jp.add(data3);
        jp.add(mtp);
        jp.add(ql);
        jp.add(data0);
        jp.add(point);
        jp.add(equ);
        jp.add(dvd);
        jp.add(tg);
        c.add(jtf);
        c.add(jp);
       // setSize(400,300);
        this.pack();
        setTitle("计算器");
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        

        data0.addActionListener(new ActionListener(){//����0������
            public void actionPerformed(ActionEvent arg0){
                if(jtf.getText().equals("0")){
                    jtf.requestFocus();
                }
                else{
                    String str = jtf.getText();
                    jtf.setText(str+"0");  
                }
            }
        });
        data1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                if(jtf.getText().equals("0")){
                    jtf.setText("");
                    jtf.setText("1");
                    jtf.requestFocus();
                }
                else{
                   String str = jtf.getText(); 
                   jtf.setText(str+"1");   
                }
            }
        });
        data2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                if(jtf.getText().equals("0")){
                    jtf.setText("");
                    jtf.setText("2");
                    jtf.requestFocus();
                }
                else{
                    String str = jtf.getText();
                    jtf.setText(str+"2");
                }
            }
        });
        data3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                if(jtf.getText().equals("0")){
                    jtf.setText("");
                    jtf.setText("3");
                    jtf.requestFocus();
                }
                else{
                    String str = jtf.getText();
                    jtf.setText(str+"3");
                }
            }
        });
        data4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                if(jtf.getText().equals("0")){
                    jtf.setText("");
                    jtf.setText("4");
                    jtf.requestFocus();
                }
                else{
                    String str = jtf.getText();
                    jtf.setText(str+"4");
                }
            }
        });
        data5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                if(jtf.getText().equals("0")){
                    jtf.setText("");
                    jtf.setText("5");
                    jtf.requestFocus();
                }
                else{
                    String str = jtf.getText();
                    jtf.setText(str+"5");
                }
            }
        });
        data6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                if(jtf.getText().equals("0")){
                    jtf.setText("");
                    jtf.setText("6");
                    jtf.requestFocus();
                }
                else{
                    String str = jtf.getText();
                    jtf.setText(str+"6");
                }
            }
        });
        data7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                if(jtf.getText().equals("0")){
                    jtf.setText("");
                    jtf.setText("7");
                    jtf.requestFocus();
                }
                else{
                    String str = jtf.getText();
                    jtf.setText(str+"7");
                }
            }
        });
        data8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                if(jtf.getText().equals("0")){
                    jtf.setText("");
                    jtf.setText("8");
                    jtf.requestFocus();
                }
                else{
                    String str = jtf.getText();
                    jtf.setText(str+"8");
                }
            }
        });
        data9.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                if(jtf.getText().equals("0")){
                    jtf.setText("");
                    jtf.setText("9");
                    jtf.requestFocus();
                }
                else{
                    String str = jtf.getText();
                    jtf.setText(str+"9");
                }
            }
        });
        point.addActionListener(new ActionListener(){    
            public void actionPerformed(ActionEvent arg0){
                if(jtf.getText().equals("0")){
                    jtf.setText("");
                    jtf.setText(".");
                    jtf.requestFocus();
                }
                else{
                    String str = jtf.getText();
                    jtf.setText(str+".");
                }
            }
        });
        plus.addActionListener(new ActionListener(){    
            public void actionPerformed(ActionEvent arg0){
                if(jtf.getText().equals("0")){
                    jtf.setText("");
                    jtf.setText("+");
                    jtf.requestFocus();
                }
                else{
                    String str = jtf.getText();
                    jtf.setText(str+"+");
                }
            }
        });
        minus.addActionListener(new ActionListener(){    
            public void actionPerformed(ActionEvent arg0){
                if(jtf.getText().equals("0")){
                    jtf.setText("");
                    jtf.setText("-");
                    jtf.requestFocus();
                }
                else{
                    String str = jtf.getText();
                    jtf.setText(str+"-");
                }
            }
        });
        mtp.addActionListener(new ActionListener(){    
            public void actionPerformed(ActionEvent arg0){
                if(jtf.getText().equals("0")){
                    jtf.setText("");
                    jtf.setText("*");
                    jtf.requestFocus();
                }
                else{
                    String str = jtf.getText();
                    jtf.setText(str+"*");
                }
            }
        });
        dvd.addActionListener(new ActionListener(){    
            public void actionPerformed(ActionEvent arg0){
                if(jtf.getText().equals("0")){
                    jtf.setText("");
                    jtf.setText("/");
                    jtf.requestFocus();
                }
                else{
                    String str = jtf.getText();
                    jtf.setText(str+"/");
                }
            }
        });
        
        tg.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                String text = jtf.getText();
                int i = text.length();
                if(i>0){
                    text = text.substring(0,i-1);
	                if(text.length()==0) {
	                	jtf.setText("0");
	                }
	                else { 
	                        jtf.setText(text);
	                }
             }
            }
        });
       
        ql.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                jtf.setText("0");
            }

        });
        
        root.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String i = jtf.getText();
                Double j = Double.parseDouble(i);
                double ans = j*j;  
                String answer =String.valueOf(ans);
                jtf.setText(answer);
            }
        });
        
        sqr.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String i = jtf.getText();
                Double j = Double.parseDouble(i);
                double ans = (double)Math.sqrt(j);
                String answer = String.valueOf(ans);
                jtf.setText(answer);
            }
        });

       
        equ.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent arg0){
              
                if(jtf.getText().indexOf("+")!= -1){
                    
                    String[] s = jtf.getText().split("[+]");
                    Double d1 = Double.parseDouble(s[0]);
                    Double d2 = Double.parseDouble(s[1]);
                    double ans = d1 + d2;
                    String answer = String.valueOf(ans);
                    jtf.setText(answer);
                }
                
                else if(jtf.getText().indexOf("-")!= -1){
                    String[] s = jtf.getText().split("-");
                    jtf.setText("");
                    Double d1 = Double.parseDouble(s[0]);
                    Double d2 = Double.parseDouble(s[1]);
                    double ans = d1-d2;
                    String answer =String.valueOf(ans);
                    jtf.setText(answer);
                }
                
                else if(jtf.getText().indexOf("*")!= -1){
                    String[] s = jtf.getText().split("[*]");
                    jtf.setText("");
                    Double d1 = Double.parseDouble(s[0]);
                    Double d2 = Double.parseDouble(s[1]);
                    double ans = d1*d2;
                    String answer =String.valueOf(ans);
                    jtf.setText(answer);
                }
                
                else if(jtf.getText().indexOf("/")!= -1){
                    String[] s = jtf.getText().split("/");
                    jtf.setText("");
                    Double d1 = Double.parseDouble(s[0]);
                    Double d2 = Double.parseDouble(s[1]);
                    double ans = d1/d2;
                    String answer =String.valueOf(ans);
                    jtf.setText(answer);
                }
                else{
                    jtf.setText("0");
                }
            }
        });
    }
    public static void main(String[] args) {
        new Calculator();
    }
}
