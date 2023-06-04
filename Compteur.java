import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *  Application qui affiche ”HelloWorld”
 */
public class Compteur extends JFrame {
    public Compteur() {
        super("Compteur"); // appel du super−constructeur
        setLayout(new BorderLayout()); // Choix de l’organisation du contenu
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//ce qui arrive à la fermeture
        // On ajoute le contenu
        JPanel pNord = new JPanel()  ;
        JLabel etiquette = new JLabel("0");
        Font f = new Font("Arial",Font.PLAIN,130);
        etiquette.setFont(f);
        pNord.add(etiquette);
        getContentPane().add(pNord,BorderLayout.NORTH);
        JPanel pSud = new JPanel()  ;
        JButton b = new JButton("OK");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = Integer.parseInt(etiquette.getText());
                i++;
                etiquette.setText(i+"");
            }
        });
        pSud.add(b);
        getContentPane().add(pSud,BorderLayout.SOUTH);
    }
    public static void main(String[] args) {
        JFrame app = new Compteur();

        app.setSize(250, 100);
        app.setVisible(true); // affichage effectif
    }
}

 