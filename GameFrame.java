import javax.swing.JFrame;
import java.awt.BorderLayout;

public class GameFrame{
    public GameFrame(){
        this.init();
    }
    private void init(){
        JFrame gameFrame=this.setGameFrame();
        gameFrame.add(new HeadingPanel(),BorderLayout.PAGE_START);
        gameFrame.add(new GamePanel(),BorderLayout.CENTER);
        gameFrame.setVisible(true);
    }
    private JFrame setGameFrame(){
        JFrame gameFrame=new JFrame("Snake Game");
        gameFrame.setSize(GameConstants.FRAME_WIDTH,GameConstants.FRAME_HEIGHT);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setLocationRelativeTo(null);
        //gameFrame.setResizable(false);
        return gameFrame;
    }
}
