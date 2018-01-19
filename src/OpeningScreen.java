import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

public class OpeningScreen
{
    private JFrame mainFrame;
    private JButton button;
    private JLabel imageLabel, title, text;
    private ImageIcon background;
    
    public OpeningScreen()
    {
        //Set up Frame
        mainFrame = new JFrame();
        mainFrame.setSize(1280,980);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Set up ImageIcon
        background = createImageIcon("background.jpg","");
        
        //Set up Labels
        imageLabel = new JLabel("", background, JLabel.CENTER);
        imageLabel.setLayout(new BorderLayout());
        title = new JLabel("   WELCOME TO THE WORLD OF MEETMON!");
        title.setFont(new Font("SANS", Font.BOLD, 55));
        title.setForeground(Color.GREEN);
        title.setBackground(Color.gray);
        title.setOpaque(false);
        text = new JLabel("<html> <span bgcolor =\"gray\"> OBJECTIVE: Solve the maze/puzzle and catch 1 of each of the three types of MEETmon which are all hiding in different patches of grass <br><br> Bait decreases catch rate and decreases flee rate <br><br> Mud increases catch rate and flee rate <br><br> If you run out of MEETBalls, YOU LOSE! </span> <html>", SwingConstants.CENTER);
        text.setFont(new Font("SANS", Font.BOLD, 35));
        text.setForeground(Color.GREEN);
        
        //Set up Border
        Border titleborder = BorderFactory.createLineBorder(Color.GREEN, 1);
        title.setBorder(titleborder);
        text.setBorder(titleborder);
        
        //Set up Button
        button = new JButton("CONTINUE");
        button.setPreferredSize(new Dimension(100,50));
        setUpButton();
        
        //Set up Frame
        imageLabel.add(title, BorderLayout.NORTH);
        imageLabel.add(text, BorderLayout.CENTER);
        imageLabel.add(button, BorderLayout.SOUTH);
        mainFrame.add(imageLabel);
        mainFrame.setVisible(true);
        
    }
    
    public void setUpButton()
    {
        class ButtonListener implements ActionListener
        {
            public void actionPerformed( ActionEvent event )
            {
                mainFrame.setVisible(false);
            }
        }
        ActionListener buttonlistener = new ButtonListener();
        button.addActionListener(buttonlistener);
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
}