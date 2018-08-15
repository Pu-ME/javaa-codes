package TCPIP编程;
/*
 * @author putengfei
 * @created 2017-12-27
*/
/*Client需要的UI和其他包*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//客户端UI类
public class ClientUI extends JFrame {
	public     JButton btStart;
    public     JButton btSend;
    public     JTextField tfSend;
    public     JTextField tfIP;
    public     JTextField tfPost;
    public     JTextArea taShow;
    public     ClientThread server;
    public static void main(String[] args) {
        ClientUI client = new ClientUI();
    }
    public ClientUI() {
        super("客户端");
        btStart = new JButton("启动连接");
        btSend = new JButton("发送信息");
        tfSend = new JTextField(10);
        tfIP = new JTextField(10);
        tfPost = new JTextField(5);
        taShow = new JTextArea();

        btStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                server = new ClientThread(ClientUI.this);
            }
        });
        btSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                server.sendMsg(tfSend.getText());
                tfSend.setText("");
            }
        });
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "确定关闭吗？", "温馨提示",
                        JOptionPane.YES_NO_OPTION);
                if (a == 1) {
                    System.exit(0); // 关闭
                }
            }
        });
        JPanel top = new JPanel(new FlowLayout());
        top.add(tfSend);
        top.add(btSend);
        top.add(btStart);
        this.add(top, BorderLayout.SOUTH);
        final JScrollPane sp = new JScrollPane();
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setViewportView(this.taShow);
        this.taShow.setEditable(false);
        this.add(sp, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setLocation(600, 200);
        this.setVisible(true);
    }

}
//客户端连接服务器类
class ClientThread extends Thread {
    ClientUI ui;
    Socket client;
    BufferedReader reader;
    PrintWriter writer;
    public ClientThread(ClientUI ui) {
        this.ui = ui;
        try {
            client = new Socket("127.0.0.1", 1228);//这里设置连接服务器端的IP的端口
            println("连接服务器成功：端口1228");
            reader = new BufferedReader(new InputStreamReader(
                    client.getInputStream()));
            writer = new PrintWriter(client.getOutputStream(), true);
            // 如果为 true，则 println、printf 或 format 方法将刷新输出缓冲区
        } catch (IOException e) {
            println("连接服务器失败：端口1228");
            println(e.toString());
            e.printStackTrace();
        }
        this.start();
    }

    public void run() {
        String msg = "";
        while (true) {
            try {
                msg = reader.readLine();
            } catch (IOException e) {
                println("服务器断开连接");

                break;
            }
            if (msg != null && msg.trim() != "") {
                println(">>" + msg);
            }
        }
    }

    public void sendMsg(String msg) {
        try {
            writer.println(msg);
        } catch (Exception e) {
            println(e.toString());
        }
    }
    public void println(String s) {
        if (s != null) {
            this.ui.taShow.setText(this.ui.taShow.getText() + s + "\n");
            System.out.println(s + "\n");
        }
    }
    
}