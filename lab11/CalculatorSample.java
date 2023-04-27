import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
public class CalculatorSample implements ActionListener{
    private JFrame j;
    private TextField t;
    private JPanel p;
    private JButton b1, b2, b3, b4;
    private JButton b5, b6, b7, b8;
    private JButton b9, b10, b11, b12;
    private JButton b13, b14, b15, b16;
    private ArrayList<JButton> buttons;
    
    private double num1;
    private double num2;
    private String operator;
    
    public CalculatorSample(){
        j = new JFrame("My Calculator");
        t = new TextField();
        p = new JPanel();
        b1 = new JButton("7");
        b2 = new JButton("8");
        b3 = new JButton("9");
        b4 = new JButton("+");
        b5 = new JButton("4");
        b6 = new JButton("5");
        b7 = new JButton("6");
        b8 = new JButton("-");
        b9 = new JButton("1");
        b10 = new JButton("2");
        b11 = new JButton("3");
        b12 = new JButton("x");
        b13 = new JButton("0");
        b14 = new JButton("c");
        b15 = new JButton("=");
        b16 = new JButton("/");
        
        //set Layout
        j.setLayout(new BorderLayout());
        p.setLayout(new GridLayout(4, 4));
        
        //เก็บปุ่มแบบ Arraylist
        buttons = new ArrayList<>(Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16));

        //set Button on JPanel
        for(JButton btn : buttons){
            p.add(btn);
        }
  
        //set listener
        for(JButton btn : buttons){
            btn.addActionListener(this);
        }
        
        //set JFrame
        j.add(t, BorderLayout.NORTH);
        j.add(p);
        
        //set การตั้งค่าต่าง ๆ
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setSize(300, 300);
        j.setVisible(true);
     }
    
        //add action
    @Override
        public void actionPerformed(ActionEvent e){
            Object source = e.getSource();
            
            //display the number
            if(source.equals(b1)){
                t.setText(t.getText() + "7");
            }
            else if(source.equals(b2)){
                t.setText(t.getText() + "8");
            }
            else if(source.equals(b3)){
                t.setText(t.getText() + "9");
            }
            else if(source.equals(b5)){
                t.setText(t.getText() + "4");
            }
            else if(source.equals(b6)){
                t.setText(t.getText() + "5");
            }
            else if(source.equals(b7)){
                t.setText(t.getText() + "6");
            }
            else if(source.equals(b9)){
                t.setText(t.getText() + "1");
            }
            else if(source.equals(b10)){
                t.setText(t.getText() + "2");
            }
            else if(source.equals(b11)){
                t.setText(t.getText() + "3");
            }
            else if(source.equals(b13)){
                t.setText(t.getText() + "0");
            }
           
            //ดูว่าเป็นเครื่องหมายอะไร
            if (source.equals(b4)){
                num1 = Double.parseDouble(t.getText());
                t.setText("");
                operator = "+";
            }
            else if (source.equals(b8)){
                num1 = Double.parseDouble(t.getText());
                t.setText("");
                operator = "-";
            }
            else if (source.equals(b12)){
                num1 = Double.parseDouble(t.getText());
                t.setText("");
                operator = "*";
            }
            else if (source .equals(b16)){
                num1 = Double.parseDouble(t.getText());
                t.setText("");
                operator = "/";
            }
            else if (source.equals(b14)){
                num1 = 0;
                num2 = 0;
                operator = "";
                t.setText("");
            }
            
            //เครื่องหมาย =
            else if (source.equals(b15)){
                num2 = Double.parseDouble(t.getText());
                if (operator.equals("+")){
                    t.setText(String.valueOf(num1+num2));
                }
                else if (operator.equals("-")){
                    t.setText(String.valueOf(num1-num2));
                }
                else if (operator.equals("*")){
                    t.setText(String.valueOf(num1*num2));
                }
                else if (operator.equals("/")){
                    if (num2 == 0){
                        t.setText("หารด้วย 0 ไม่ได้จ้า");
                        return;
                    }
                    t.setText(String.valueOf(num1/num2));
                }
            }
        }
            
    public static void main(String[] args) {
        new CalculatorSample();
     }
    
}