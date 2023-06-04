import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 *  Application qui affiche ”HelloWorld”
 */
public class Jeu extends JFrame implements ActionListener{
    public JButton bPapier = new JButton("Papier");
    public JButton bPierre = new JButton("Pierre");
    public JButton bCiseaux = new JButton("Ciseaux");
    public JLabel lOrdi = new JLabel("Ordinateur: ");
    public JLabel score = new JLabel();
    public static int scoreOrdi = 0, scoreVous = 0;
    public Jeu() {
        super("Rochambeaux");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // le contenu
        JPanel pNord = new JPanel()  ;
        JLabel etiquette = new JLabel("Votre choix:");
        pNord.add(etiquette);
        bPapier.addActionListener(this);
        bPierre.addActionListener(this);
        bCiseaux.addActionListener(this);
        pNord.add(bPapier);pNord.add(bPierre);pNord.add(bCiseaux);
        getContentPane().add(pNord,BorderLayout.NORTH);

        JPanel pCentre = new JPanel();
        pCentre.add(lOrdi);
        getContentPane().add(pCentre,BorderLayout.CENTER);

        JPanel pSud = new JPanel()  ;
        pSud.add(score);
        getContentPane().add(pSud,BorderLayout.SOUTH);
    }
    public static void main(String[] args) {
        JFrame app = new Jeu();
        app.setSize(400, 150);
        //app.pack();
        app.setVisible(true); // affichage effectif
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sVous = ((JButton) e.getSource()).getText();
        int iVous;
        String[] strings = {"Papier","Pierre","Ciseaux"};
        if(sVous.equals("Papier"))
            iVous=0;
        else if(sVous.equals("Pierre"))
            iVous=1;
        else
            iVous=2;
        Random r = new Random();
        int iOrdi = r.nextInt(3);
        while (iOrdi==iVous)
            iOrdi = r.nextInt(3);

        String sOrdi = strings[iOrdi];
        lOrdi.setText("Ordinateur : " + sOrdi);


        if (sVous.equals("Papier") && sOrdi.equals("Pierre") ) scoreVous++;
        if (sVous.equals("Pierre") && sOrdi.equals("Papier") ) scoreOrdi++;

        if (sVous.equals("Pierre") && sOrdi.equals("Ciseaux") ) scoreVous++;
        if (sVous.equals("Ciseaux") && sOrdi.equals("Pierre") ) scoreOrdi++;

        if (sVous.equals("Ciseaux") && sOrdi.equals("Papier") ) scoreVous++;
        if (sVous.equals("Papier") && sOrdi.equals("Ciseaux") ) scoreOrdi++;

        if(Math.max(scoreVous,scoreOrdi)<5)
            score.setText("Vous: "+scoreVous+ " ; Ordi: "+scoreOrdi);
        else if(scoreVous==5)
            score.setText("Vous avez gagné bravo !! ");
        else
            score.setText("L'ordi gagne !! ");
        System.out.println(sVous);
        // toto
    }
}

 