import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HeadingPanel extends JPanel{
    public HeadingPanel(){
        this.setSize(GameConstants.HEADING_WIDTH,GameConstants.HEADING_HEIGHT);
        this.setBackground(new Color(54,69,79));
        JLabel headingLabel=new JLabel("Snake Game");
        headingLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
        headingLabel.setForeground(new Color(0,163,108));
        this.add(headingLabel);
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(new Color(173,216,230));
        g.drawRect(17,7,GameConstants.HEADING_WIDTH-10,GameConstants.HEADING_HEIGHT-10);
        g.setColor(new Color(0,163,108));
        g.setFont(new Font("Consolas",Font.PLAIN,20));
        String scoreString="Score is: "+GamePanel.score;
        g.drawString(scoreString,600,35);
        g.dispose();
        repaint();
    }
}
