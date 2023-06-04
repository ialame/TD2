import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BarreMenu extends JMenuBar implements ActionListener {
    BarreMenu(){
        JMenu menuFichier = new JMenu("Fichier");
        JMenuItem itemNouveau = new JMenuItem("Nouveau");
        JMenuItem itemOuvrir = new JMenuItem("Ouvrir");
        JMenuItem itemSauvegarder = new JMenuItem("Sauvegarder");
        JMenuItem itemQuitter = new JMenuItem("Quitter");
        menuFichier.add(itemNouveau);
        menuFichier.add(itemOuvrir);
        menuFichier.add(itemSauvegarder);
        menuFichier.add(new JSeparator());
        menuFichier.add(itemQuitter);
        this.add(menuFichier);
        itemQuitter.addActionListener(this);
        itemNouveau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(null,"Cliquer sur OK");
            }
        });
    }


    public static void main(String[] str){
        JFrame f = new JFrame();
        f.setJMenuBar(new BarreMenu());
        f.setSize(400,300);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
