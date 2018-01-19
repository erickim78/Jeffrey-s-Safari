
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import sun.audio.*;

public class JeffreysSafari
{
    private Pokemon wildpokemon;
    private JFrame mainFrame, movementFrame;
    private JPanel walkingPanel, battlePanel, choicePanel, infoPanel, imagePanel, pokePanel;
    private JButton step, bait, mud, ball, flee;
    private JLabel imageLabel, baitLabel, mudLabel, ballLabel, text, spenceLabel, davidLabel, jamesLabel;
    private int baitcount, mudcount, time, wiggles;
    private Timer t, capture, ballflee;
    private ImageIcon pokeimage;
    private AudioStream battleaudio, captureaudio, walkaudio;
    private BattlePlayer player;
   
    
    private static int pokemoncount = 0;
    private static int ballcount = 15;
    
    public JeffreysSafari( Pokemon input, JFrame frame, BattlePlayer player, JLabel spence, JLabel david, JLabel james)
    {
        spenceLabel = spence;
        davidLabel = david;
        jamesLabel = james;
        wildpokemon = input;
        movementFrame = frame;
        this.player = player;
        
        //Initialize Variables
        baitcount = 0;
        mudcount = 0;
        time = 0;
        wiggles = 0;
        
        //Set up Frame
        mainFrame = new JFrame();
        mainFrame.setSize(1280,980);
        mainFrame.setTitle("Jeffrey's Safari");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Set up Panels
        walkingPanel = new JPanel();
        walkingPanel.setLayout( new BorderLayout());
        battlePanel = new JPanel();
        battlePanel.setLayout(new BorderLayout());
        choicePanel = new JPanel();
        choicePanel.setLayout(new BorderLayout());
        infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout( 3, 1));
        imagePanel = new JPanel();
        imagePanel.setLayout(new BorderLayout());
        
        //Set up ImageIcon
        pokeimage = createImageIcon(wildpokemon.getName()+".jpg", "");
        Image transform = pokeimage.getImage().getScaledInstance(1110, 750, Image.SCALE_SMOOTH);
        pokeimage = new ImageIcon( transform );
        
        //Set up Labels
        imageLabel = new JLabel("",pokeimage, JLabel.CENTER);
        baitLabel = new JLabel("Bait Thrown: "+baitcount, JLabel.LEFT);
        mudLabel = new JLabel("Mud Thrown: "+mudcount, JLabel.LEFT);
        ballLabel = new JLabel("MEETballs Left: "+ballcount+"  ", JLabel.LEFT);
        text = new JLabel("A Wild "+wildpokemon.getName()+ " Appeared!", JLabel.CENTER);
        text.setPreferredSize(new Dimension(1000,50));
        
        //Border
        Border textborder = BorderFactory.createLineBorder(Color.RED, 5);
        
        //Fonts
        text.setBorder(textborder);
        text.setFont(new Font("SANS", Font.BOLD, 25));
        ballLabel.setFont(new Font("SANS", Font.CENTER_BASELINE, 15 ));
        
        //Set up Button
        step = new JButton("Take a Step");
        bait = new JButton("Throw Bait");
        bait.setPreferredSize(new Dimension(200,100));
        mud = new JButton("Throw Mud");
        mud.setPreferredSize(new Dimension(200,100));
        ball = new JButton("Throw MEETball");
        ball.setPreferredSize(new Dimension(200,100));
        flee = new JButton("Flee");
        flee.setPreferredSize( new Dimension(200,100));
        setUpTimer();
        setUpCaptureTimer();
        setUpBallFleeTimer();
        setUpBaitButton();
        setUpMudButton();
        setUpBallButton();
        setUpFleeButton();
        
        
        //Create battlePanel
        infoPanel.add(baitLabel);
        infoPanel.add(mudLabel);
        infoPanel.add(ballLabel, BorderLayout.LINE_START);
        choicePanel.add(bait, BorderLayout.WEST);
        choicePanel.add(mud, BorderLayout.EAST);
        choicePanel.add(ball, BorderLayout.CENTER);
        choicePanel.add(flee, BorderLayout.SOUTH);
        battlePanel.add(choicePanel, BorderLayout.SOUTH);
        imagePanel.add(imageLabel, BorderLayout.CENTER);
        imagePanel.add(text, BorderLayout.SOUTH);
        battlePanel.add(imagePanel, BorderLayout.CENTER);
        battlePanel.add(infoPanel, BorderLayout.EAST);
        
        
        //Create mainPanel
        mainFrame.add(battlePanel);
        mainFrame.setVisible(true);
        battleMusic();
        
    }
    public void setUpBaitButton()
    {
        class BaitButtonListener implements ActionListener
        {
            public void actionPerformed( ActionEvent event )
            {
                wildpokemon.receiveBait();
                baitcount++;
                baitLabel.setText("Bait Thrown: "+baitcount);
                text.setText("You threw bait at "+wildpokemon.getName()+"!");
                
                if(wildpokemon.flee() == true)
                {
                    text.setText("The Wild "+wildpokemon.getName()+" Fled!");
                    t.start();
                    bait.setEnabled(false);
                    mud.setEnabled(false);
                    flee.setEnabled(false);
                    ball.setEnabled(false);
                    
                }
            }
        }
        ActionListener baitlistener = new BaitButtonListener();
        bait.addActionListener(baitlistener);
    }
    
    public void setUpMudButton()
    {
        class MudButtonListener implements ActionListener
        {
            public void actionPerformed( ActionEvent event )
            {
                mudcount++;
                wildpokemon.receiveMud();
                mudLabel.setText("Mud Thrown: "+mudcount);
                text.setText("You threw mud at "+wildpokemon.getName()+"!");
                
                if(wildpokemon.flee() == true)
                {
                    text.setText("The Wild "+wildpokemon.getName()+" Fled!");
                    t.start();
                    bait.setEnabled(false);
                    mud.setEnabled(false);
                    flee.setEnabled(false);
                    ball.setEnabled(false);
                }
            }
        }
        ActionListener mudlistener = new MudButtonListener();
        mud.addActionListener(mudlistener);
    }
    
    public void setUpBallButton()
    {
        class BallButtonListener implements ActionListener
        {
            public void actionPerformed( ActionEvent event )
            {
                if(ballcount < 1)
                {
                    text.setText("Oh No! You are out of MEETBalls!");
                }
                else
                {
                    ballcount--;
                    ballLabel.setText("MEETballs Left: "+ballcount);
                    text.setText("GO! MEETBall!");
                    capture.start();
                    bait.setEnabled(false);
                    mud.setEnabled(false);
                    flee.setEnabled(false);
                    ball.setEnabled(false);
                }
            }
        }
        ActionListener balllistener = new BallButtonListener();
        ball.addActionListener(balllistener);
    }
    
    public void setUpFleeButton()
    {
        class FleeButtonListener implements ActionListener
        {
            public void actionPerformed( ActionEvent event )
            {
                    t.start();
                    text.setText("You Fled!");
                    bait.setEnabled(false);
                    mud.setEnabled(false);
                    flee.setEnabled(false);
                    ball.setEnabled(false);
            }
        }
        ActionListener fleelistener = new FleeButtonListener();
        flee.addActionListener(fleelistener);
    }
    
    public void setUpTimer()
    {
        class TimerListener implements ActionListener
        {
            public void actionPerformed( ActionEvent event )
            {
                time++;
                if(time == 5)
                {
                    mainFrame.dispose();
                    t.stop();
                    time = 0;
                    AudioPlayer.player.stop(captureaudio);
                    AudioPlayer.player.stop(battleaudio);

                    if( player.numberOf("JARAMBE")>=1 )
                    {
                        EndScreen end = new EndScreen("Success");
                    }
                    else if(ballcount == 0)
                    {
                        EndScreen end = new EndScreen("Failure");
                    }
                    else if(wildpokemon.getName().equals("JARAMBE"))
                    {
                        player.getHandler().getGame().getBattleState().setState(player.getHandler().getGame().getCaveGameState());
                        movementFrame.setVisible(true);
                    }
                    else
                    { 
                        player.getHandler().getGame().getBattleState().setState(player.getHandler().getGame().getGameState());
                        movementFrame.setVisible(true);
                    }
                }
            }
        }
    ActionListener listener = new TimerListener();
    t = new Timer( 800, listener);
    }
    
    public void walkMusic()
    {
        InputStream in;
        try
        {
            in = new FileInputStream(new File("D:\\Final Jeffrey's Safari\\src\\WalkMusic.wav"));
            walkaudio = new AudioStream(in);
            AudioPlayer.player.start(walkaudio);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void setUpBallFleeTimer()
    {
        class TimerListener implements ActionListener
        {
            public void actionPerformed( ActionEvent event )
            {
                time++;
                if(time == 3)
                {
                    text.setText("The Wild "+wildpokemon.getName()+" Fled!");
                    ballflee.stop();
                    time = 0;
                    t.start();
                    
                }
            }
        }
    ActionListener ballfleelistener = new TimerListener();
    ballflee = new Timer( 1000, ballfleelistener);
    }
    
    public void setUpCaptureTimer()
    {
        class TimerListener implements ActionListener
        {
            public void actionPerformed( ActionEvent event )
            {
                time++;
                if(wiggles == 3)
                {
                    pokeimage = createImageIcon(wildpokemon.getName()+"MilkTea.jpg", "milktea");
                    Image transform = pokeimage.getImage().getScaledInstance(1110,750, Image.SCALE_SMOOTH);
                    pokeimage = new ImageIcon(transform);
                    imagePanel.remove(imageLabel);
                    imageLabel = new JLabel("", pokeimage, JLabel.CENTER);
                    imagePanel.add(imageLabel);
                    imagePanel.repaint();
                    imagePanel.revalidate();
                    capture.stop();
                    AudioPlayer.player.stop(battleaudio);
                    captureMusic();
                    text.setText("CONGRATULATIONS! The wild "+wildpokemon.getName()+" was caught!");
                    player.catchPokemon(wildpokemon);
                    time = 0;
                    wiggles = 0;
                    t.start();
                    
                }
                else if (time % 2 == 0)
                {
                    if(wildpokemon.Pokeball() == true)
                    {
                        wiggles++;
                        pokeimage = createImageIcon(wildpokemon.getName()+"RedMilktea.jpg", "RedMilktea");
                        Image transform = pokeimage.getImage().getScaledInstance(1110,750, Image.SCALE_SMOOTH);
                        pokeimage = new ImageIcon(transform);
                        imagePanel.remove(imageLabel);
                        imageLabel = new JLabel("", pokeimage, JLabel.CENTER);
                        imagePanel.add(imageLabel);
                        imagePanel.repaint();
                        imagePanel.revalidate();
                    }
                    else
                    {
                        pokeimage = createImageIcon(wildpokemon.getName()+".jpg", "wildpokemonpic");
                        Image transform = pokeimage.getImage().getScaledInstance(1110,750, Image.SCALE_SMOOTH);
                        pokeimage = new ImageIcon(transform);
                        imagePanel.remove(imageLabel);
                        imageLabel = new JLabel("", pokeimage, JLabel.CENTER);
                        imagePanel.add(imageLabel);
                        imagePanel.repaint();
                        imagePanel.revalidate();
                        capture.stop();
                        text.setText("OH NO! The wild "+wildpokemon.getName()+" broke free of the MEETBall!");
                        bait.setEnabled(true);
                        mud.setEnabled(true);
                        flee.setEnabled(true);
                        ball.setEnabled(true);
                        time = 0;
                        wiggles = 0;
                        if(wildpokemon.flee() == true)
                        {
                            bait.setEnabled(false);
                            mud.setEnabled(false);
                            flee.setEnabled(false);
                            ball.setEnabled(false);
                            ballflee.start();
                        }
                    }
                }
                else
                {
                    pokeimage = createImageIcon(wildpokemon.getName()+"MilkTea.jpg", "milktea");
                    Image transform = pokeimage.getImage().getScaledInstance(1110,750, Image.SCALE_SMOOTH);
                    pokeimage = new ImageIcon(transform);
                    imagePanel.remove(imageLabel);
                    imageLabel = new JLabel("", pokeimage, JLabel.CENTER);
                    imagePanel.add(imageLabel);
                    imagePanel.repaint();
                    imagePanel.revalidate();
                }
            }
        }
    ActionListener listener = new TimerListener();
    capture = new Timer( 500, listener);
    }
    
    public ImageIcon createImageIcon(String path,String description) 
    {         
        java.net.URL imgURL = getClass().getResource(path);         
        if (imgURL != null) 
        {             
            return new ImageIcon(imgURL, description);         
        }
        else 
        {             
            System.err.println("Couldn't find file: " + path);             
            return null;         
        }     
    }
     
    public void battleMusic()
    {
        InputStream in;
        try
        {
            if(wildpokemon.getName().equals("JARAMBE"))
                in = new FileInputStream(new File("C:\\Users\\Eric Kim\\Documents\\NetBeansProjects\\JeffreysSafari\\src\\JamesBattleMusic.wav"));
            else
                in = new FileInputStream(new File("C:\\Users\\Eric Kim\\Documents\\NetBeansProjects\\JeffreysSafari\\src\\BattleMusic.wav"));
            battleaudio = new AudioStream(in);
            AudioPlayer.player.start(battleaudio);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void captureMusic()
    {
        InputStream in;
        try
        {
            in = new FileInputStream(new File("C:\\Users\\Eric Kim\\Documents\\NetBeansProjects\\JeffreysSafari\\src\\CaptureMusic.wav"));
            captureaudio = new AudioStream(in);
            AudioPlayer.player.start(captureaudio);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
}

