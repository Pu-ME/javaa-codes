package TCPIP编程;
/*
 * @author putengfei
 * @created 2017-12-27
*/
/*Server端所需要的包*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//服务器端UI类
public class ServerUI extends JFrame {
    public static void main(String[] args) {
        ServerUI serverUI = new ServerUI();
    }
    public JButton btStart;//启动服务器
    public JButton btSend;//发送信息按钮
    public JTextField tfSend;//需要发送的文本信息
    public JTextArea taShow;//信息展示
    public Server server;//用来监听客户端连接
    static List<Socket> clients;//保存连接到服务器的客户端
    public ServerUI() {
        super("服务器端");
        btStart = new JButton("启动服务");
        btSend = new JButton("发送信息");
        tfSend = new JTextField(10);
        taShow = new JTextArea();

        btStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                server = new Server(ServerUI.this);
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
                    server.closeServer();
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
        this.setLocation(100, 200);
        this.setVisible(true);
    }
}
//服务器端等待客户端连接类
class Server extends Thread {
    ServerUI ui;
    ServerSocket ss;
    BufferedReader reader;
    PrintWriter writer;
    public Server(ServerUI ui) {
        this.ui = ui;
        this.start();
    }
    public void run() {
        try {
            ss = new ServerSocket(1228);
            ui.clients=new ArrayList<Socket>();
            println("启动服务器成功：端口1228");
            while (true) {
                println("等待客户端");
                Socket client = ss.accept();
                ui.clients.add(client);
                println("连接成功" + client.toString());
                new ListenerClient(ui, client);
            }
        } catch (IOException e) {
            println("启动服务器失败：端口1228");
            println(e.toString());
            e.printStackTrace();
        }

    }
    public synchronized void sendMsg(String msg) {
        try {
            for (int i = 0; i < ui.clients.size(); i++) {
                Socket client = ui.clients.get(i);
                writer = new PrintWriter(client.getOutputStream(), true);
                writer.println(msg);
            }

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

    public void closeServer() {
        try {
            if (ss != null)
                ss.close();
            if (reader != null)
                reader.close();
            if (writer != null)
                writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
//服务器端等待客户端发送信息
class ListenerClient extends Thread {
    BufferedReader reader;
    PrintWriter writer;
    ServerUI ui;
    Socket client;
    public ListenerClient(ServerUI ui, Socket client) {
        this.ui = ui;
        this.client=client;
        this.start();
    }
    //为每一个客户端创建线程等待接收信息，然后把信息广播出去
    public void run() {
        String msg = "";
        while (true) {
            try {
                reader = new BufferedReader(new InputStreamReader(
                        client.getInputStream()));
                writer = new PrintWriter(client.getOutputStream(), true);
                msg = reader.readLine();
                sendMsg(msg);
                
            } catch (IOException e) {
                println(e.toString());
                // e.printStackTrace();
                break;
            }
            if (msg != null && msg.trim() != "") {
                println(">>" + msg);
            }
        }
    }
    //把信息广播到所有用户
    public synchronized void sendMsg(String msg) {
        try {
            for (int i = 0; i < ui.clients.size(); i++) {
                Socket client = ui.clients.get(i);
                writer = new PrintWriter(client.getOutputStream(), true);
                writer.println(msg);
            }
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