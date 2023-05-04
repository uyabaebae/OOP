import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class ChatDemo implements ActionListener, WindowListener{
    private JFrame frame;
    private JTextArea ta;
    private JTextField tf;
    private JButton b1, b2;
    private JPanel panel1, panel2, panel3;
    
    private File fly;
    
    public ChatDemo(){
        frame = new JFrame();
        ta = new JTextArea(45, 20);
        tf = new JTextField(45);
        b1 = new JButton("Submit");
        b2 = new JButton("Reset");
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        
        fly = new File("ChatDEmo.dat");
        try{
            fly.createNewFile();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        
        Color color = new Color(233, 141, 159);
        Font font = new Font("Prompt", Font.BOLD, 12);
        ta.setForeground(color);
        ta.setFont(font);
        tf.setFont(font);
        
        panel1.setLayout(new FlowLayout());
        panel2.setLayout(new GridLayout(2, 1));
        
        panel3.add(b1);
        panel3.add(b2);
        panel2.add(tf);
        panel2.add(panel3);
                
        ta.setEditable(false);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        frame.addWindowListener(this);
        
        frame.setLayout(new BorderLayout());
        frame.add(ta);
        frame.add(panel2, BorderLayout.SOUTH);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        if (e.getSource().equals(b1)){
            ta.setText(ta.getText() + "\n" + dtf.format(LocalDateTime.now()) + " : " + tf.getText());
            tf.setText("");
        }
        else{
            tf.setText("");
        }
    }
    
    @Override
    public void windowClosing(WindowEvent e){
        try (FileWriter fw = new FileWriter(fly)){
            String data = ta.getText();
            for (int i = 0; i <data.length(); i++){
                fw.write(data.charAt(i));
            }
            System.out.println("Success");
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
    
    @Override
    public void windowOpened(WindowEvent e){
        if (fly.exists()){
            String data = "";
            try(FileReader fr = new FileReader(fly)){
                int chr;
                while ((chr = fr.read()) != -1){
                    data += (char) chr;
                }
                System.out.println(data);
                ta.setText(data);
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        }
        else {
            System.out.println("File not found.");
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
        new ChatDemo();
        }
}
