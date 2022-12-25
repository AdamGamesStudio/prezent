import java.awt.Font;
import javax.swing.*;

public class GUI {
    Manager manager = new Manager();

    Font  font  = new Font(Font.SERIF, Font.PLAIN,  15);

    public ImageIcon icon = new ImageIcon("res/icon.png");

    public JFrame frame = new JFrame("Calculator");

    public JLabel results = new JLabel("RESULTS");

    public JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9,
        bEquals, bPlus, bMinus, bDivide, bMultiply, bClear,
        bAppInfo;

    public void setup() {
        frame.pack();
        frame.setIconImage(icon.getImage());
        frame.setLayout(null);
        frame.setSize(320, 392 + 50);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void setupGUI() {
        results.setBounds(5, 0, 398, 50);
        results.setFont(font);
        results.setText("");
        frame.add(results);

        b7 = new JButton("7");
        b7.setFont(b7.getFont().deriveFont(30f));
        b7.setBounds(5, 52, 70, 70);
        b7.addActionListener(e -> numberClicked(7));

        b8 = new JButton("8");
        b8.setFont(b8.getFont().deriveFont(30f));
        b8.setBounds(80, 52, 70, 70);
        b8.addActionListener(e -> numberClicked(8));

        b9 = new JButton("9");
        b9.setFont(b9.getFont().deriveFont(30f));
        b9.setBounds(155, 52, 70, 70);
        b9.addActionListener(e -> numberClicked(9));

        bDivide = new JButton("/");
        bDivide.setFont(bDivide.getFont().deriveFont(20f));
        bDivide.setBounds(230, 52, 70, 70);
        bDivide.addActionListener(e -> actionClicked(Manager.DIVIDE));


        b4 = new JButton("4");
        b4.setFont(b4.getFont().deriveFont(30f));
        b4.setBounds(5, 127, 70, 70);
        b4.addActionListener(e -> numberClicked(4));

        b5 = new JButton("5");
        b5.setFont(b5.getFont().deriveFont(30f));
        b5.setBounds(80, 127, 70, 70);
        b5.addActionListener(e -> numberClicked(5));

        b6 = new JButton("6");
        b6.setFont(b6.getFont().deriveFont(30f));
        b6.setBounds(155, 127, 70, 70);
        b6.addActionListener(e -> numberClicked(6));

        bMultiply = new JButton("X");
        bMultiply.setFont(bMultiply.getFont().deriveFont(20f));
        bMultiply.setBounds(230, 127, 70, 70);
        bMultiply.addActionListener(e -> actionClicked(Manager.MULTIPLY));

        b1 = new JButton("1");
        b1.setFont(b1.getFont().deriveFont(30f));
        b1.setBounds(5, 202, 70, 70);
        b1.addActionListener(e -> numberClicked(1));

        b2 = new JButton("2");
        b2.setFont(b2.getFont().deriveFont(30f));
        b2.setBounds(80, 202, 70, 70);
        b2.addActionListener(e -> numberClicked(2));

        b3 = new JButton("3");
        b3.setFont(b3.getFont().deriveFont(30f));
        b3.setBounds(155, 202, 70, 70);
        b3.addActionListener(e -> numberClicked(3));

        bMinus = new JButton("-");
        bMinus.setFont(bMinus.getFont().deriveFont(20f));
        bMinus.setBounds(230, 202, 70, 70);
        bMinus.addActionListener(e -> actionClicked(Manager.MINUS));


        bClear = new JButton("CLEAR");
        bClear.setFont(bClear.getFont().deriveFont(10f));
        bClear.setBounds(5, 277, 70, 70);
        bClear.addActionListener(e -> actionClicked(Manager.CLEAR));

        b0 = new JButton("0");
        b0.setFont(b0.getFont().deriveFont(30f));
        b0.setBounds(80, 277, 70, 70);
        b0.addActionListener(e -> numberClicked(0));

        bEquals = new JButton("=");
        bEquals.setFont(bEquals.getFont().deriveFont(30f));
        bEquals.setBounds(155, 277, 70, 70);
        bEquals.addActionListener(e -> actionClicked(Manager.EQUALS));

        bPlus = new JButton("+");
        bPlus.setFont(bPlus.getFont().deriveFont(20f));
        bPlus.setBounds(230, 277, 70, 70);
        bPlus.addActionListener(e -> actionClicked(Manager.PLUS));

        bAppInfo = new JButton("APP UPDATES & INFO");
        bAppInfo.setBounds(5, 277 + 95, 295, 25);
        bAppInfo.addActionListener(e -> {
            InfoGUI info = new InfoGUI();
            info.open();
        });

        frame.add(results);
        frame.add(bDivide);
        frame.add(bMultiply);
        frame.add(bMinus);
        frame.add(bPlus);
        frame.add(bClear);
        frame.add(bEquals);
        frame.add(bAppInfo);
        frame.add(b0);
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(b5);
        frame.add(b6);
        frame.add(b7);
        frame.add(b8);
        frame.add(b9);
    }

    public void numberClicked(int button) {
        System.out.println("] Pressed " + button);
        results.setText(results.getText() + button);
        if (manager.activeOperators == 0) {
            System.out.println("] 0 operators active");
            manager.n1 = Integer.parseInt(manager.n1 + "" + button);
        } else {
            System.out.println("] 1 (or more) operators operators active; adding to new array");
            manager.n2 = Integer.parseInt(manager.n2 + "" + button);
        }
        manager.canPressOperator = true;
    }

    public void actionClicked(int action) {
        if (manager.canPressOperator) {
            System.out.println("] Pressed action no. " + action);

            if (action == Manager.CLEAR) {
                results.setText(" ");
                manager.clear();
            } else if (action == Manager.EQUALS) {
                getResults();
            } else {
                if (!manager.operator) {
                    manager.o1 = action;
                    manager.activeOperators++;
                    switch (action) {
                        case Manager.DIVIDE -> results.setText(results.getText() + " / ");
                        case Manager.MULTIPLY -> results.setText(results.getText() + " * ");
                        case Manager.MINUS -> results.setText(results.getText() + " - ");
                        case Manager.PLUS -> results.setText(results.getText() + " + ");
                    }
                    manager.canPressOperator = false;
                    manager.operator = true;
                }
            }
        } else {
            System.out.println("] Access to action no. " + action + " haven't been completed (canDoAction = false). ");
        }
    }

    public void getResults() {
        switch (manager.o1) {
            case Manager.DIVIDE -> {
                results.setText(Integer.toString((int) (manager.n1 / manager.n2)));
                manager.n1 = manager.n1 / manager.n2;
            }
            case Manager.MULTIPLY -> {
                results.setText(Integer.toString((int) (manager.n1 * manager.n2)));
                manager.n1 = manager.n1 * manager.n2;
            }
            case Manager.MINUS -> {
                results.setText(Integer.toString((int) (manager.n1 - manager.n2)));
                manager.n1 = manager.n1 - manager.n2;
            }
            case Manager.PLUS -> {
                results.setText(Integer.toString((int) (manager.n1 + manager.n2)));
                manager.n1 = manager.n1 + manager.n2;
            }
        }
        System.out.println((int) manager.n1);
        manager.n2 = 0;
        manager.o1 = 0;
        manager.activeOperators = 0;
        manager.operator = false;
    }

    // TODO - this.results - phrase - to int <- result
}