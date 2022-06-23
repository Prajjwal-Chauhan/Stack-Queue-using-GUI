import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class Demo extends JFrame {

    JRadioButton stack;
    JRadioButton queue;
    JTextField t;
    JTextField res;
    JButton push;
    JButton pop;
    JButton add;
    JButton delete;
    ButtonGroup G1;
    JLabel L1;
    JLabel L2;

    public Demo() {

        Random random = new Random();
        LinkedList<Integer> ll = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            ll.add(random.nextInt(100));
        }
        String s = ll.toString();

        this.setLayout(null);

        stack = new JRadioButton();

        queue = new JRadioButton();

        push = new JButton("PUSH");
        pop = new JButton("POP");
        add = new JButton("ADD");
        delete = new JButton("DELETE");

        G1 = new ButtonGroup();

        L1 = new JLabel("Stack_Queue");
        L2 = new JLabel("Resultant list");
        t = new JTextField(s, 50);
        res = new JTextField(50);

        stack.setText("STACK");

        queue.setText("QUEUE");

        stack.setBounds(120, 90, 120, 50);

        queue.setBounds(250, 90, 80, 50);

        push.setBounds(20, 150, 80, 30);
        pop.setBounds(110, 150, 80, 30);
        add.setBounds(200, 150, 80, 30);
        delete.setBounds(290, 150, 80, 30);

        L1.setBounds(20, 30, 150, 50);
        L2.setBounds(20, 200, 150, 50);
        t.setBounds(120, 30, 400, 50);
        res.setBounds(120, 200, 400, 50);
        this.add(t);

        // int x = 0;

        this.add(stack);
        this.add(queue);

        this.add(push);
        this.add(pop);
        this.add(add);
        this.add(delete);
        this.add(L1);

        stack.addActionListener(p -> {
            cleanUp();
            if (stack.isSelected()) {

                push.setFocusable(false);
                push.addActionListener(e -> {

                    ll.add(0, random.nextInt(100));
                    res.setText(ll.toString());
                });

                pop.setFocusable(false);
                pop.addActionListener(e -> {
                    ll.remove(0);

                    res.setText(ll.toString());

                });

            }
        });

        queue.addActionListener(p -> {
            cleanUp();
            if (queue.isSelected()) {

                add.setFocusable(false);
                add.addActionListener(e -> {
                    ll.add(0, random.nextInt(100));
                    res.setText(ll.toString());
                });

                delete.setFocusable(false);
                delete.addActionListener(e -> {
                    ll.remove(ll.size() - 1);
                    res.setText(ll.toString());
                });
            }
        });

        this.add(res);
        this.add(L2);
        G1.add(stack);
        G1.add(queue);

    }

    public void cleanUp() {
        for (ActionListener al : push.getActionListeners()) {
            push.removeActionListener(al);
        }
        for (ActionListener al : pop.getActionListeners()) {
            pop.removeActionListener(al);
        }
        for (ActionListener al : add.getActionListeners()) {
            add.removeActionListener(al);
        }
        for (ActionListener al : delete.getActionListeners()) {
            delete.removeActionListener(al);
        }
    }

}

class projectjava {
    // Driver code.
    public static void main(String args[]) {
        Demo f = new Demo();

        f.setBounds(500, 600, 600, 400);

        f.setTitle("RadioButtons");

        f.setVisible(true);
    }
}
