import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

public class bruh extends JFrame implements ActionListener{
    private JFrame frame = new JFrame();
    private JPanel mainPanel = new JPanel();
    private JLabel yourPokemon;
    private ImageIcon yourPKMNImage;
    private JButton button1;

    bruh() throws MalformedURLException {

        frame.setContentPane(mainPanel);
        //frame.setSize(556,371);
        yourPokemon = new JLabel();
        yourPokemon.setSize(556*2,371*2);
        yourPokemon.setLocation(0,0);
        button1 = new JButton("Fight");
        button1.setBounds(50,50,100,50);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        //https://soranews24.com/wp-content/uploads/sites/3/2013/11/pg-5.png?w=580
        URL url = new URL("https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/i/9ae7c1b1-1819-4726-b71a-308443ab2906/d6dug9s-dbc341f9-4390-433f-8e1a-b573ee6354e5.png/v1/fill/w_556,h_371/pokemon_battle_template_by_nostalgia_guy_d6dug9s-fullview.png");
        yourPKMNImage = new ImageIcon(url);
        Image image = yourPKMNImage.getImage();
        Image scaledIMG = image.getScaledInstance(yourPokemon.getWidth(),yourPokemon.getHeight(),Image.SCALE_SMOOTH);
        yourPKMNImage = new ImageIcon(scaledIMG);
        yourPokemon.setIcon(yourPKMNImage);

        mainPanel.add(yourPokemon);
        mainPanel.add(button1);

        frame.pack();
        frame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
