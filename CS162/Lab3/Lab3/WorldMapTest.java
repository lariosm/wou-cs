

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WorldMapTest.
 *
 * @author  Manuel Larios
 * @version CS162 Lab #3, 10/17/2016
 */
public class WorldMapTest
{
    private WorldMap worldMap1;

    /**
     * Default constructor for test class WorldMapTest
     */
    public WorldMapTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        worldMap1 = new WorldMap();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Sets up a single room and makes sure that the random room it finds is the same one.
     */
    @Test
    public void testRoomSetup()
    {
        TransporterRoom transpor1 = new TransporterRoom("Some strange place");
        worldMap1.addRooms(transpor1);
        assertSame(transpor1, worldMap1.findRandomRoom());
    }

    /**
     * Sets up three rooms of different types and makes sure it finds any of the rooms.
     */
    @Test
    public void testRoomSetup2()
    {
        Room room1 = new Room("A store");
        Room room2 = new Room("A city park");
        TransporterRoom transpor1 = new TransporterRoom("A strange place");
        worldMap1.addRooms(room1);
        worldMap1.addRooms(room2);
        worldMap1.addRooms(transpor1);
        assertNotNull(worldMap1.findRandomRoom());
    }
}



