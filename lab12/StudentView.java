import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
public class StudentView implements ActionListener, WindowListener{
    private JFrame frame;
    private JPanel p1, p2, p3, p4;
    private JLabel l1, l2, l3;
    private TextField t1, t2, t3;
    private JButton deposit, withdraw;
    private Student std;
    
    private File fly;
    
    public StudentView(){
        std = new Student();
        frame = new JFrame();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        l1 = new JLabel("  ID :");
        l2 = new JLabel("  Name :");
        l3 = new JLabel("  Money :");
        deposit = new JButton("Deposit");
        withdraw = new JButton("Withdraw");
        t1 = new TextField();
        t2 = new TextField();
        t3 = new TextField("0");
        t3.setEditable(false);
        
        fly = new File("StudentM.dat");
        try {
            fly.createNewFile();
        }
        catch (IOException ex){
            System.out.println(ex);
        }
        
        frame.setLayout(new GridLayout(4,1));
        p1.setLayout(new GridLayout(1, 2));
        p2.setLayout(new GridLayout(1, 2));
        p3.setLayout(new GridLayout(1, 2));
        
        deposit.addActionListener(this);
        withdraw.addActionListener(this);
        frame.addWindowListener(this);
        
        p1.add(l1);
        p1.add(t1);
        p2.add(l2);
        p2.add(t2);
        p3.add(l3);
        p3.add(t3);
        p4.add(deposit);
        p4.add(withdraw);
        
        frame.add(p1);
        frame.add(p2);
        frame.add(p3);
        frame.add(p4);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        std.setID(Integer.parseInt(t1.getText()));
        std.setName(t2.getText());
        if (e.getSource().equals(deposit)){
            std.setMoney(std.getMoney() + 100);
            t3.setText(Integer.toString(std.getMoney()));
        }
        else if (e.getSource().equals(withdraw)){
             std.setMoney(std.getMoney() - 100);
             t3.setText(Integer.toString(std.getMoney()));
        }
    }
    
    @Override
    public void windowClosing(WindowEvent e){
        try {
            FileOutputStream stream = new FileOutputStream(fly);
            ObjectOutputStream opobj = new ObjectOutputStream(stream);
            opobj.writeObject(std);
        }
        catch (IOException ex){
            System.out.println(ex);
        }
    }
    @Override
    public void windowOpened(WindowEvent e){
        if (fly.exists()){
            try {
            FileInputStream stream = new FileInputStream(fly);
            ObjectInputStream ipobj = new ObjectInputStream(stream);
            std = (Student) ipobj.readObject();
            if (std == null) {
                std = new Student();
            }
            t1.setText(String.valueOf(std.getID()));
            t2.setText(std.getName());
            t3.setText(String.valueOf(std.getMoney()));
        }
        catch (IOException | ClassNotFoundException ex){
            System.out.println(ex);
        }
    }
}
    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
    
    public static void main(String[] args) {
        new StudentView();
    }
}
