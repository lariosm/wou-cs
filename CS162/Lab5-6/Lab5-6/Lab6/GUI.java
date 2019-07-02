import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * This is the graphic user interface (GUI) for the text-based World-Of-Zuul
 * game, which holds all I/O methods and prepares the window for the player
 * to interact with.
 * 
 * @author Manuel Larios, John Mozingo and Travis Johnson 
 * @version CS162 Lab #6, 11/4/2016
 */
public class GUI
{
    private JFrame frame;           //The window that will be presented to the player
    private Room currentRoom;       //Used for various room-related tasks
    private JTextArea textDisplay;  //Displays text area to the player
    private JPanel contentPane;     //Where components are stored and arranged
    private JPanel gamePanel;       //Same as above, but holds JTextArea and button components
    private JLabel imageLabel;      //Used to store and display images to the player

    /**
     * Initializes the GUI
     */
    public GUI()
    {
        buildFrame();
    }

    /**
     * Prints game-related text to the text area.
     * @param Game-related text to be printed.
     */
    public void textToDisplay(String gameText)
    {
        textDisplay.append(gameText + "\n");
        textDisplay.setCaretPosition(textDisplay.getText().length());
    }

    /**
     * This will build and implement the buttoms and image field. It also sets
     * the action listener to the buttons. Currently there is only and Action
     * Listener created for the North button.
     */

    public void buildFrame()
    {
        frame = new JFrame("World of Zuul - WOU Edition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Adds the menubar to the frame.
        addMenuBar();

        //Create the container in which components will be arranged
        contentPane = (JPanel)frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        //Create an inner container which will hold JTextArea and button panel
        gamePanel = new JPanel(new BorderLayout());

        //Create text display area and add scrollbar function to it.
        textDisplay = new JTextArea(8, 40);
        textDisplay.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textDisplay);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Information"));
        gamePanel.add(scrollPane, BorderLayout.CENTER);

        //Create the button panel
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Controls"));
        JButton north = new JButton("North");
        buttonPanel.add(north, BorderLayout.NORTH);
        JButton east = new JButton("East");
        buttonPanel.add(east, BorderLayout.EAST);
        JButton south = new JButton("South");
        buttonPanel.add(south, BorderLayout.SOUTH);
        JButton west = new JButton("West");
        buttonPanel.add(west, BorderLayout.WEST);
        gamePanel.add(buttonPanel, BorderLayout.EAST);

        //Create Up/Down buttons for the button panel
        JPanel buttonPanel2 = new JPanel(new GridLayout(2, 1));
        JButton up = new JButton("Up");
        buttonPanel2.add(up);
        JButton down = new JButton("Down");
        buttonPanel2.add(down);
        buttonPanel.add(buttonPanel2);

        //Associate actionListeners with buttons.
        north.addActionListener(new MoveActionListener());
        east.addActionListener(new MoveActionListener());
        south.addActionListener(new MoveActionListener());
        west.addActionListener(new MoveActionListener());
        up.addActionListener(new MoveActionListener());
        down.addActionListener(new MoveActionListener());

        //This creates the image area we will use/change.
        contentPane.add(gamePanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * The creation of the menu bar to go along with the GUI.
     */
    public void addMenuBar()
    {
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

        //Game menu
        JMenu gameMenu = new JMenu("Game");
        JMenuItem quit = new JMenuItem("Quit");
        quit.addActionListener(new QuitActionListener());
        gameMenu.add(quit);

        //Help menu
        JMenu helpMenu = new JMenu("Help");
        JMenuItem help = new JMenuItem("Help");
        help.addActionListener(new HelpActionListener());
        helpMenu.add(help);
        JMenuItem about = new JMenuItem("About...");
        about.addActionListener(new AboutActionListener());
        helpMenu.add(about);

        menubar.add(gameMenu);
        menubar.add(helpMenu);
    }

    /**
     * Sets/changes the image that is matched with the current room
     */
    public void setImage()
    {
        //Retrieves the image file name associated with the current room
        String imageFile = currentRoom.getImageFile();

        //Where the image will be stored
        imageLabel = new JLabel(new ImageIcon());

        //Auto-scales the image so that it fits in the GUI
        ImageIcon newImage = new ImageIcon(imageFile);
        Image processedImage = newImage.getImage();
        processedImage = processedImage.getScaledInstance(700, -1, processedImage.SCALE_SMOOTH);
        newImage.setImage(processedImage);
        imageLabel.setIcon(newImage);

        contentPane.add(imageLabel, BorderLayout.NORTH);

        frame.repaint();
        frame.pack();
    }

    /**
     * This method will try and move the player in the direction they have
     * selected. 
     * @peram String the direction the player selects.
     */
    private void changeRoom(String direction)
    {
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            textToDisplay("Nothing there in that direction.");
        }
        else {
            contentPane.remove(imageLabel);
            currentRoom = nextRoom;
            setImage();
            textToDisplay(currentRoom.getLongDescription());
        }
    }

    /**
     * Adds the current room to its designated field.
     * @param Add the room the player is currently in.
     */
    public void addCurrentRoom(Room room)
    {
        currentRoom = room;
    }

    //----------Event handling code----------
    public class MoveActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String command = event.getActionCommand();
            //This event.getActionCommand is interesting. It will return the string the button started with.
            changeRoom(command);
        }
    }

    public class QuitActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            int n = JOptionPane.showConfirmDialog(
                    frame, "Are you sure you want to exit the game?",
                    "Exit Game?",
                    JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                System.exit(0); //Terminates the program
            }
        }
    }

    public class HelpActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            JOptionPane.showMessageDialog(frame, "You wander around at WOU. Use the buttons" + "\n"
                + "on the bottom-right corner of the window" + "\n" + "to navigate your way through.",
                "Help", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public class AboutActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            JOptionPane.showMessageDialog(frame, "World of Zuul - WOU Edition" + "\n" +
                "Version 1.1" + "\n" + "\n" + "Created by: Manuel Larios, John Mozingo" +
                " and Travis Johnson", "About...", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
