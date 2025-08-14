import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
    protected int[] snakeXLength=new int[750];
    protected int[] snakeYLength=new int[750];
    protected static int score=0;
    protected int snakeLength=3;
    protected boolean upDirection=false;
    protected boolean downDirection=false;
    protected boolean leftDirection=false;
    protected boolean rightDirection=true;
    private int snakeMoves=0;
    private final Random random=new Random();
    private final int[] snakeFoodX=this.setSnakeFoodX();
    private final int[] snakeFoodY=this.setSnakeFoodY();
    private final ImageIcon leftMouth=new ImageIcon("leftmouth.png");
    private final ImageIcon rightMouth=new ImageIcon("rightmouth.png");
    private final ImageIcon upMouth=new ImageIcon("upmouth.png");
    private final ImageIcon downMouth=new ImageIcon("downmouth.png");
    private final ImageIcon snakeBody=new ImageIcon("snakeimage.png");
    private final ImageIcon snakeFood=new ImageIcon("enemy.png");
    private int snakeFoodXAxis;
    private int snakeFoodYAxis;
    private final int delay=100;
    protected Timer timer=new Timer(delay,this);
    protected boolean gameOver=false;
    protected int timerCount=1;

    private int[] setSnakeFoodX(){
        int[] ints=new int[10];
        int counter=25;
        int index=0;
        while(index<10){
            ints[index]=counter;
            counter+=25;
            index++;
        }
        return ints;
    }
    private int[] setSnakeFoodY(){
        int[] ints=new int[10];
        int counter=75;
        int index=0;
        while(index<10){
            ints[index]=counter;
            counter+=25;
            index++;
        }
        return ints;
    }
    private void setNewFood(){
        this.snakeFoodXAxis=snakeFoodX[this.random.nextInt(10)];
        this.snakeFoodYAxis=snakeFoodY[this.random.nextInt(8)];
    }
    public GamePanel(){
        this.setNewFood();
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(true);
        this.setSize(GameConstants.GAME_PANEL_WIDTH,GameConstants.GAME_PANEL_HEIGHT);
        this.setBackground(new Color(54,69,79));
        this.timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(new Color(173,216,230));
        g.drawRect(17,7,GameConstants.GAME_PANEL_WIDTH-10,GameConstants.GAME_PANEL_HEIGHT-50);
        if(this.snakeMoves==0){
            this.snakeXLength[0]=100;
            this.snakeXLength[1]=75;
            this.snakeXLength[2]=50;
            this.snakeYLength[0]=50;
            this.snakeYLength[1]=50;
            this.snakeYLength[2]=50;
        }
        if(leftDirection)
            leftMouth.paintIcon(this,g,snakeXLength[0],snakeYLength[0]);
        if(rightDirection)
            rightMouth.paintIcon(this,g,snakeXLength[0],snakeYLength[0]);
        if(upDirection)
            upMouth.paintIcon(this,g,snakeXLength[0],snakeYLength[0]);
        if(downDirection)
            downMouth.paintIcon(this,g,snakeXLength[0],snakeYLength[0]);
        for(int loop=1;loop<snakeLength;loop++)
            snakeBody.paintIcon(this,g,snakeXLength[loop],snakeYLength[loop]);
        this.snakeFood.paintIcon(this,g,this.snakeFoodXAxis,this.snakeFoodYAxis);
        if(this.gameOver){
            g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
            g.setColor(new Color(0,163,108));
            g.drawString("Game Over",300,250);
            g.drawString("Press space for restart",300,290);
        }
        g.dispose();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        for(int loop=this.snakeLength-1;loop>0;loop--){
            snakeXLength[loop]=snakeXLength[loop-1];
            snakeYLength[loop]=snakeYLength[loop-1];
        }
        if(this.leftDirection)
            this.snakeXLength[0]=this.snakeXLength[0]-25;
        if(this.rightDirection)
            this.snakeXLength[0]=this.snakeXLength[0]+25;
        if(this.upDirection)
            this.snakeYLength[0]=this.snakeYLength[0]-25;
        if(this.downDirection)
            this.snakeYLength[0]=this.snakeYLength[0]+25;
        if(snakeXLength[0]>730)
            this.snakeXLength[0]=25;
        if(snakeXLength[0]<25)
            this.snakeXLength[0]=730;
        if(snakeYLength[0]>490)
            this.snakeYLength[0]=25;
        if(snakeYLength[0]<25)
            this.snakeYLength[0]=490;
        this.collidesFood();
        this.collidesBody();
        this.repaint();
    }
    private void collidesFood(){
        if(snakeXLength[0]==snakeFoodXAxis&&snakeYLength[0]==snakeFoodYAxis){
            this.setNewFood();
            GamePanel.score++;
            this.snakeLength++;
        }
        if(snakeXLength[1]==snakeFoodXAxis||snakeYLength[1]==snakeFoodYAxis){
            this.setNewFood();
            GamePanel.score++;
            this.snakeLength++;
        }

    }

    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_SPACE){
            restart();
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            this.leftDirection=true;
            this.rightDirection=false;
            this.upDirection=false;
            this.downDirection=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            this.rightDirection=true;
            this.leftDirection=false;
            this.upDirection=false;
            this.downDirection=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_UP){
            this.upDirection=true;
            this.leftDirection=false;
            this.rightDirection=false;
            this.downDirection=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            this.downDirection=true;
            this.leftDirection=false;
            this.rightDirection=false;
            this.upDirection=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE&&(!gameOver)){
            if(timerCount%2==0)
                timer.start();
            else
                timer.stop();
            timerCount++;
        }
        this.snakeMoves++;
    }

    private void restart(){
        if(gameOver){
            timerCount=1;
            gameOver=false;
            snakeMoves=0;
            score=0;
            snakeLength=3;
            rightDirection=true;
            leftDirection=false;
            upDirection=false;
            downDirection=false;
            setNewFood();
            timer.start();
            repaint();
        }
    }

    private void collidesBody(){
        for(int loop=snakeLength-1;loop>2;loop--)
            if(snakeXLength[loop]==snakeXLength[0]&&snakeYLength[loop]==snakeYLength[0]){
                timer.stop();
                this.gameOver=true;
            }
    }
    @Override
    public void keyReleased(KeyEvent e){}

    @Override
    public void keyTyped(KeyEvent e){}
}
