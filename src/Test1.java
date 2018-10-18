import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test1 extends JFrame implements ActionListener{
  static   JTextArea area1;

    JButton button1, button2, button3,button4,buttonx,buttony,buttonv,buttonz,buttona;
    int i,x;
    int k;
    int value1,value2,result;

    public Test1() {
        BorderLayout lay1 = new BorderLayout();
        setLayout(lay1);
        area1 = new JTextArea(10, 5);

        JPanel pan1 = new JPanel();
        button1 = new JButton("CapsLook");
        button2 = new JButton("Shift");
        button3 = new JButton("Tap");
        button4 = new JButton("Delete");
        buttonx = new JButton("+");
        buttony = new JButton("-");
        buttonz = new JButton("*");
        buttonv= new JButton("/");
        buttona=new JButton("=");

       for (k=0;k<=9;k++){
           String d=String.valueOf(k);
           pan1.add(new JButton(new AbstractAction(d) {
               @Override
               public void actionPerformed(ActionEvent actionEvent) {
                   area1.append(d);
               }
           }));

       }

        pan1.add(buttonx);
        pan1.add(buttony);
        pan1.add(buttonz);
        pan1.add(buttonv);
        pan1.add(buttona);

        for ( i = 65; i <= 90; i++) {
            char c = (char) i;

       pan1.add(new JButton(new AbstractAction(String.valueOf(c)) {
           @Override
           public void actionPerformed(ActionEvent actionEvent) {
               area1.append(String.valueOf(c));
           }
       }));


        }

        pan1.add(button1);
        button1.addActionListener(this);
        pan1.add(button2);
        pan1.add(button3);
        pan1.add(button4);
        button3.addActionListener(this);
        button4.addActionListener(this);


        buttonx.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                value1=Integer.valueOf(area1.getText());

                String j=JOptionPane.showInputDialog("inter number");
                area1.setText(String.valueOf(value1)+"+"+j);
              value2=Integer.valueOf(j);
              result=value1+value2;
            }
        });


        buttony.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                value1=Integer.valueOf(area1.getText());
                String j=JOptionPane.showInputDialog("inter number");
                area1.setText(String.valueOf(value1)+"-"+j);

                value2=Integer.valueOf(j);

                result=value1-value2;
            }
        });
        buttonz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                value1=Integer.valueOf(area1.getText());
                String j=JOptionPane.showInputDialog("inter number");
                area1.setText(String.valueOf(value1)+"*"+j);

                value2=Integer.valueOf(j);

                result=value1*value2;
            }
        });
        buttonv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                value1=Integer.valueOf(area1.getText());
                String j=JOptionPane.showInputDialog("inter number");
                area1.setText(String.valueOf(value1)+"/"+j);

                value2=Integer.valueOf(j);

                result=value1/value2;
            }
        });
        buttona.addActionListener(this);
        add(area1, BorderLayout.NORTH);
        add(pan1, BorderLayout.CENTER);
        setTitle("Hallo");
        setSize(700, 350);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        Test1 one = new Test1();
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
    if(actionEvent.getSource()==button4){
        area1.setText(null);

    }else if(actionEvent.getSource()==button3){

        area1.append("      ");

    }
     else  if (actionEvent.getSource()==buttona){

        area1.append("="+result);

    }


    }
    }



