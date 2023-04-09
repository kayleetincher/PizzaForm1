import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaGUIFrame extends JFrame implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
    JPanel mainPnl, crustPnl, comboPnl, toppingsPnl, displayPnl, controlPnl;
    JTextArea displayTA;
    JScrollPane scroller;
    JRadioButton thinCrust, regularCrust, deepDishCrust;
    JButton order, clear, quit, display;
    JComboBox<String> sizeCombo;
    JCheckBox sardines, sausage, pickles, peppers, gummies, squid;






    public PizzaGUIFrame()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new GridLayout(4, 11));

        createCrustPanel();
        mainPnl.add(crustPnl);

        createComboPanel();
        mainPnl.add(comboPnl);

        createToppingsPanel();
        mainPnl.add(toppingsPnl);



        createControlPanel();
        mainPnl.add(controlPnl);



        add(mainPnl);

        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Pizza Order Form");
        setVisible(true);


    }

    private void createControlPanel() {
        controlPnl = new JPanel();
        controlPnl.setBorder(new TitledBorder(new EtchedBorder(),"Controls"));


        clear = new JButton("Clear Current Order");
        controlPnl.add(clear);

        quit = new JButton("Quit");
        quit.addActionListener((ActionEvent ae) -> System.exit(0));
        controlPnl.add(quit);

        order = new JButton("order");
        order.addActionListener(
                (ActionEvent ae) ->
                {

                    String res ="Form Details\n";

                    res += "Crust type: ";
                    if(thinCrust.isSelected())
                        res += "Thin Crust\n";
                    else if(regularCrust.isSelected())
                        res += "Regular\n";
                    else if(deepDishCrust.isSelected())
                        res += "Deep Dish\n";

                    res += "Toppings:\n";

                    if (sardines.isSelected())
                        res += "\tSardines  + $1.00\n";

                    if (pickles.isSelected())
                        res += "\tpickles + $1.00\n";

                    if (sausage.isSelected())
                        res += "\tsausage + $1.00\n";

                    if (peppers.isSelected())
                        res += "\tpeppers + $1.00\n";

                    if (squid.isSelected())
                        res += "\tsquid + $1.00\n";

                    if (gummies.isSelected())
                        res += "\tSour gummy worms + $1.00\n";


                    JOptionPane.showMessageDialog(displayPnl,res);

                });
        controlPnl.add(order);


    }




    private void createToppingsPanel() {
        toppingsPnl = new JPanel();
        toppingsPnl.setLayout(new GridLayout(2, 8));
        toppingsPnl.setBorder(BorderFactory.createTitledBorder("Time for Toppings!"));

        sardines = new JCheckBox("Sardines");
        pickles = new JCheckBox("Pickles");
        sausage = new JCheckBox("Sausage");
        peppers = new JCheckBox(" Ghost Peppers");
        gummies = new JCheckBox("Gummy Worms");
        squid = new JCheckBox("Squid");

        toppingsPnl.add(sardines);
        toppingsPnl.add(pickles);
        toppingsPnl.add(sausage);
        toppingsPnl.add(peppers);
        toppingsPnl.add(gummies);
        toppingsPnl.add(squid);
    }

    private void createComboPanel()
    {
        comboPnl = new JPanel();
        comboPnl.setBorder(new TitledBorder(new EtchedBorder(),"Size"));

        sizeCombo = new JComboBox();
        sizeCombo.addItem("Small");
        sizeCombo.addItem("Medium");
        sizeCombo.addItem("Large");
        sizeCombo.addItem("Super Size");

        comboPnl.add(sizeCombo);

    }


    private void createCrustPanel()
    {
        crustPnl = new JPanel();
        crustPnl.setBorder(BorderFactory.createTitledBorder("Choose Your Crust: "));
        ButtonGroup crustGroup = new ButtonGroup();
        thinCrust = new JRadioButton("Thin");
        regularCrust = new JRadioButton("Regular");
        deepDishCrust = new JRadioButton("Deep-dish");
        crustGroup.add(thinCrust);
        crustGroup.add(regularCrust);
        crustGroup.add(deepDishCrust);
        crustPnl.add(thinCrust);
        crustPnl.add(regularCrust);
        crustPnl.add(deepDishCrust);

    }

}
