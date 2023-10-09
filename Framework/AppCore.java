package Framework;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppCore extends JFrame {

    private static AppCore instance = null;


    JTextField field;
    int counter;
    JButton button;
    public void initialise(){

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dimension = kit.getScreenSize();
        int screenHeigth = dimension.height;
        int screenWidth = dimension.width;
        this.setSize(screenWidth / 4, screenHeigth / 8);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("ClickerCounter");

        counter = 0;
        JLabel label = new JLabel("Counter: ");
        field = new JTextField(Integer.toString(counter));
        field.setPreferredSize(new Dimension(100,20));
        button = new JButton("Click me");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter++;
                field.setText(Integer.toString(counter));
                if(counter % 10 == 0 && counter != 0){
                    JOptionPane.showMessageDialog(null, "Score: " + counter);
                    field.setBackground(new Color(counter ,0,0));
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(field);
        panel.add(button);
        this.add(panel, BorderLayout.CENTER);


    }


    public JTextField getField() {
        return field;
    }

    public void setField(String field) {
        this.field.setText(field);
    }

    public int getCounter() {
        return counter;
    }

    public static AppCore getInstance(){
        if(instance == null){
            instance = new AppCore();
            instance.initialise();
        }
        return instance;
    }
}
