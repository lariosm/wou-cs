/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author Manuel Larios, John Mozingo and Travis Johnson
 * @version CS162 Lab #6, 11/4/2016
 */

public class Game 
{
    private Room currentRoom;
    private GUI userInterface;
    
    /**
     * The main method for launching the game.
     */
    public static void main(String[] args)
    {
        Game game = new Game();
        game.printWelcome();
    }
    
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
    }

    /**
     * Create all the rooms and link their exits together and also sets the GUI's current room.
     */
    private void createRooms()
    {
        Room itc, itc1, itc2, itc3, library, mnb, rwec, wuc, campbell, hss,
            ns, nsBridge, nsEntrance, ns1, ns2, apsc, admin;
        TransporterRoom elevator; //create transport rooms
        
        // create the rooms
        elevator = new TransporterRoom("In the magic elevator", "Elevator.JPG");
        
        //ITC Rooms
        itc = new Room("Outside the ITC building", "itc.JPG");
        itc1 = new Room("In the 1st floor of the ITC building", "itc1.jpg");
        itc2 = new Room("In the 2nd floor of the ITC building", "itc2.jpg");
        itc3 = new Room("In the 3rd floor of the ITC building", "itc3.jpg");
        
        //Library
        library = new Room("At the library building", "library.jpg");
        
        //RWEC
        rwec = new Room("At the Richard Woodcock Education Center building", "rwec.jpg");
        
        //MNB
        mnb = new Room("At the Math and Nursing building", "mnb.jpg");
        
        //WUC
        wuc = new Room("At the Werner University Center", "wuc.jpg");
        
        //Campbell Hall
        campbell = new Room("At Campbell Hall", "campbell.jpg");
        
        //HSS
        hss = new Room("At the HSS building", "hss.jpg");
        
        //Natural Seience
        ns = new Room("Outside the Natural Science building", "ns.jpg");
        nsBridge = new Room("Walking on the bridge", "ns_bridge.jpg");
        nsEntrance = new Room("At the entrance of the NS building", "ns_entrance.jpg");
        ns1 = new Room("In the 1st floor of the NS building", "ns1.jpg");
        ns2 = new Room("In the 2nd floor of the NS building", "ns2.jpg");
        
        //APSC
        apsc = new Room("At the APSC building", "apsc.jpg");
        
        //Administration
        admin = new Room("At the administration building", "administration.jpg");
        
        // initialise room exits
        //--------ITC Locations----------
        itc.setExit("South", admin);
        itc.setExit("North", library);
        itc.setExit("East", itc2);
        itc.setExit("West", campbell);
        
        itc1.setExit("Up", itc2);
        
        itc2.setExit("North", elevator);
        itc2.setExit("Up", itc3);
        itc2.setExit("Down", itc1);
        
        itc3.setExit("Down", itc2);
        
        //--------Library---------
        library.setExit("South", itc);
        library.setExit("West", mnb);
        library.setExit("North", rwec);
        
        //--------RWEC--------
        rwec.setExit("South", library);
        
        //--------MNB---------
        mnb.setExit("East", library);
        mnb.setExit("South", wuc);
        
        //--------WUC---------
        wuc.setExit("North", mnb);
        wuc.setExit("South", campbell);
        
        //--------Campbell Hall--------
        campbell.setExit("North", wuc);
        campbell.setExit("South", hss);
        campbell.setExit("East", itc);
        
        //--------HSS--------
        hss.setExit("North", campbell);
        hss.setExit("South", ns);
        hss.setExit("East", admin);
        
        //--------NS Locations--------
        ns.setExit("North", hss);
        ns.setExit("West", nsBridge);
        ns.setExit("East", apsc);
        
        nsBridge.setExit("East", ns);
        nsBridge.setExit("South", nsEntrance);
        
        nsEntrance.setExit("North", nsBridge);
        nsEntrance.setExit("West", ns1);
        
        ns1.setExit("South", elevator);
        ns1.setExit("East", nsEntrance);
        ns1.setExit("Up", ns2);
        
        ns2.setExit("South", elevator);
        ns2.setExit("Down", ns1);
        
        //--------APSC--------
        apsc.setExit("West", ns);
        apsc.setExit("North", admin);
        
        //--------Administration--------
        admin.setExit("South", apsc);
        admin.setExit("West", hss);
        admin.setExit("North", itc);
        
        currentRoom = itc; //Start the game outside.
        
        userInterface = new GUI(); //Initialize the GUI
        
        //Sets up our starting location the moment the game is launched.
        userInterface.addCurrentRoom(currentRoom);
        userInterface.setImage();
    }
    
    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        userInterface.textToDisplay("Welcome to the World of Zuul - WOU Edition!");
        userInterface.textToDisplay("World of Zuul - WOU Edition is an incredibly fun adventure game.");
        userInterface.textToDisplay("Click the 'help' menu item if you need help.");
        userInterface.textToDisplay("");
        userInterface.textToDisplay(currentRoom.getLongDescription());
    }
}
