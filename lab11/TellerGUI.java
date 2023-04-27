import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class TellerGUI implements ActionListener{
    private JFrame f;
    private JPanel p1, p2;
    private JButton b1, b2, b3;
    private JLabel l1, l2;
    private TextField t1, t2;
    private double balance = 6000;
    private double num;
    
    public TellerGUI(){
        p1 = new JPanel();
        p2 = new JPanel();
        f = new JFrame("Teller GUI");
        l1 = new JLabel("  Balance");
        l2 = new JLabel("  Amount");
        b1 = new JButton("Deposit");
        b2 = new JButton("Withdraw");
        b3 = new JButton("Exit");
        t1 = new TextField(String.valueOf(balance));
        t2 = new TextField();
        
        f.setLayout(new GridLayout(2, 1));
        p1.setLayout(new GridLayout(2 ,2));
        p2.setLayout(new FlowLayout());
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);
        f.add(p1);
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        f.add(p2);
        t1.setEditable(false);
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        num = Double.parseDouble(t2.getText());
        if (source.equals(b1)){
                 if (num > 0){
                          balance += num;
                          t1.setText(String.valueOf(balance));
                 }
                 else{
                     t2.setText("ไม่ให้ใส่จำนวนเต็มลบนะ !");
                 }
        }
        else if (source.equals(b2)){
                if  (num > 0){
                        if((balance - num) >= 0){
                               balance -= num;
                               t1.setText(String.valueOf(balance));
                        }
                        else{
                               t2.setText(" เงินมีพอให้ถอนมั้ย ไหนตอบ");
                        }
                }
                  else{
                      t2.setText("ไม่ให้ใส่จำนวนเต็มลบนะ !");
            
                 }
           }
    }
    
    public static void main(String[] args) {
        new TellerGUI();
 }
}
