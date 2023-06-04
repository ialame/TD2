import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *  Application qui affiche ”HelloWorld”
 */
public class HelloWorldApp extends JFrame {
    public HelloWorldApp(String title, String msg) {
        super(title); // appel du super−constructeur
        setLayout(new BorderLayout()); // Choix de l’organisation du contenu
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//ce qui arrive à la fermeture
        // On ajoute le contenu
        JPanel pNord = new JPanel()  ;
        JLabel etiquette = new JLabel(msg);
        etiquette.setVisible(false);
        pNord.add(etiquette);
        getContentPane().add(pNord,BorderLayout.NORTH);
        JPanel pSud = new JPanel()  ;
        JButton b = new JButton("OK");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                etiquette.setVisible(true);
            }
        });
        pSud.add(b);
        getContentPane().add(pSud,BorderLayout.SOUTH);
        this.setJMenuBar(new BarreMenu());
    }
    public static void main(String[] args) {
        JFrame app = new HelloWorldApp("Premiere Application", "HelloWorld!");

        app.setSize(250, 100);
        app.setVisible(true); // affichage effectif
    }
}

 