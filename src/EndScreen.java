import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class EndScreen
{
    private JFrame mainFrame;
    private JLabel imageLabel, textLabel;
    private ImageIcon picture;
    private AudioStream successaudio, failureaudio;
    
    public EndScreen( String outcome )
    {
        //Set up Frame
        mainFrame = new JFrame();
        mainFrame.setSize(1280,980);
        mainFrame.setTitle("Jeffrey's Safari");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        if(outcome.equals("Success"))
        {
            //Set up ImageIcon
            picture = createImageIcon("victory.jpg","");
            
            textLabel = new JLabel("YOU CAUGHT THEM ALL!", JLabel.CENTER);
            successMusic();
        }
        else
        {
            //Set up ImageIcon
            picture = createImageIcon("defeat.jpg","");
            
            //Set up Labels
            textLabel = new JLabel("YOU FAILED TO CATCH THEM ALL :'( ", JLabel.CENTER);
            failureMusic();
        }
        
        imageLabel = new JLabel("", picture, JLabel.CENTER);
        imageLabel.setLayout(new BorderLayout());
        textLabel.setFont(new Font("SANS", Font.BOLD, 50));
        textLabel.setForeground(Color.GREEN);
        
        imageLabel.add(textLabel, BorderLayout.CENTER);
        mainFrame.add(imageLabel);
        mainFrame.setVisible(true);
        
        mainFrame.repaint();
        mainFrame.revalidate();
        
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
    
    public void successMusic()
    {
        InputStream in;
        try
        {
            in = new FileInputStream(new File("C:\\Users\\Eric Kim\\Documents\\NetBeansProjects\\JeffreysSafari\\src\\SuccessMusic.wav"));
            successaudio = new AudioStream(in);
            AudioPlayer.player.start(successaudio);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void failureMusic()
    {
        InputStream in;
        try
        {
            in = new FileInputStream(new File("C:\\Users\\Eric Kim\\Documents\\NetBeansProjects\\JeffreysSafari\\src\\FailureMusic.wav"));
            failureaudio = new AudioStream(in);
            AudioPlayer.player.start(failureaudio);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}