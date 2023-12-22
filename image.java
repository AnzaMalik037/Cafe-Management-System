package cafemanagement;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class image extends JFrame{
     JLabel label;
     image(){
        setSize(800,500);
        setTitle("Cafe Management System");
        setLayout(new FlowLayout());
        ImageIcon img = new ImageIcon("abc.JPEG");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        label = new JLabel("",img,JLabel.CENTER);
        add(label);
        
        setVisible(true);
    }
}
