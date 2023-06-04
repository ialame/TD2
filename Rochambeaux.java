import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Rochambeaux extends JFrame implements ActionListener {
    JButton bPapier = new JButton("Papier");
    JButton bPierre = new JButton("Pierre");
    JButton bCiseaux = new JButton("Ciseaux");
    JLabel lOrdi =new JLabel();
    JLabel lScore =new JLabel();
    public static int iScoreVous=0,iScoreOrdi=0;
    public Rochambeaux() {
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
        pSud.add(lScore);
        getContentPane().add(pSud,BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Random r = new Random();
        String[] choix = {"Papier","Pierre","Ciseaux"};
        int iOrdi = r.nextInt(3);
        String sOrdi =choix[iOrdi];
        lOrdi.setText("Ordinateur : "+ sOrdi);
        String sVous = ((JButton) e.getSource()).getText();

        if (sVous.equals("Papier") && sOrdi.equals("Pierre") ) iScoreVous++;
        if (sVous.equals("Pierre") && sOrdi.equals("Papier") ) iScoreOrdi++;

        if (sVous.equals("Pierre") && sOrdi.equals("Ciseaux") ) iScoreVous++;
        if (sVous.equals("Ciseaux") && sOrdi.equals("Pierre") ) iScoreOrdi++;

        if (sVous.equals("Ciseaux") && sOrdi.equals("Papier") ) iScoreVous++;
        if (sVous.equals("Papier") && sOrdi.equals("Ciseaux") ) iScoreOrdi++;
        if(Math.max(iScoreOrdi,iScoreVous)<5)
            lScore.setText("Vous : "+iScoreVous + " ; Ordi : "+iScoreOrdi);
        if(iScoreOrdi==5)
            lScore.setText("L'Ordi gagne !");
        if(iScoreVous==5)
            lScore.setText("Vous avez gagné bravo !");


    }
    public static void main(String[] str){
        Rochambeaux r = new Rochambeaux();
        r.pack();
        r.setVisible(true);
    }
}
