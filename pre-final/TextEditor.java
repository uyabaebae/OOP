import java.awt.event.*;
import java.io.*;
import javax.swing.*;
public class TextEditor implements ActionListener{
    private JFrame frame;
    private JMenuBar menu;
    private JMenu m;
    private JMenuItem i1, i2, i3, i4;
    private JTextArea ta;

    public TextEditor(){
        frame = new JFrame("My Text Editor");
        menu = new JMenuBar();
        m = new JMenu("File");
        i1 = new JMenuItem("New");
        i2 = new JMenuItem("Open");
        i3 = new JMenuItem("Save");
        i4 = new JMenuItem("Close");
        ta = new JTextArea();

        frame.setJMenuBar(menu);
        menu.add(m);
        m.add(i1);
        m.add(i2);
        m.add(i3);
        m.addSeparator();
        m.add(i4);
        frame.add(ta);

        i1.addActionListener(this);
        i2.addActionListener(this);
        i3.addActionListener(this);
        i4.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(i1)){
            ta.setText("");
        }
        else if (e.getSource().equals(i4)){
            frame.dispose();
        }
        else if (e.getSource().equals(i2)){
            JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(frame);
            File f = fc.getSelectedFile();
        }
        else if (e.getSource().equals(i3)){
            JFileChooser fc = new JFileChooser();
            fc.showSaveDialog(frame);
            File f = fc.getSelectedFile();
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        new TextEditor();
        }
}
