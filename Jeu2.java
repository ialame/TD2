import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Jeu2 extends JFrame implements ActionListener {
    JButton bPapier =new JButton("Papier");
    JButton bPierre =new JButton("Pierre");
    JButton bCiseaux =new JButton("Ciseaux");
    JLabel lOrdi = new JLabel();
    JLabel lScore = new JLabel();
    public static int iScoreOrdi=0,iScoreVous=0;
    public Jeu2() {
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
        String sVous = ((JButton) e.getSource()).getText();
        int iVous=0;
        if(sVous.equals("Papier"))  iVous=0;
        if(sVous.equals("Pierre"))  iVous=1;
        if(sVous.equals("Ciseaux"))  iVous=2;
        String[] choix = {"Papier","Pierre","Ciseaux"};
        Random r = new Random();
        int iOrdi = r.nextInt(3);
        String sOrdi = choix[iOrdi];
        lOrdi.setText("Ordinateur : "+ sOrdi);
        if(iVous==0 && iOrdi==1) iScoreVous++;
        if(iVous==1 && iOrdi==0) iScoreOrdi++;

        if(iVous==1 && iOrdi==2) iScoreVous++;
        if(iVous==2 && iOrdi==1) iScoreOrdi++;

        if(iVous==2 && iOrdi==0) iScoreVous++;
        if(iVous==0 && iOrdi==2) iScoreOrdi++;

        lScore.setText("Vous : "+iScoreVous+ " ; Ordi : "+iScoreOrdi);



    }
    public static void main(String[] str){
        Jeu2 j2 = new Jeu2();
        j2.pack();
        j2.setVisible(true);

    }
}
