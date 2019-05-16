// ----------------------------
// AbstractFactoryPatternT.java
// ----------------------------

// http://en.wikipedia.org/wiki/Abstract_factory_pattern

import java.util.ArrayList;
import java.util.List;

class Room {}
class EnchantedRoom extends Room {}

class Door {
    private Room _r;
    private Room _s;

    public Door (Room r, Room s) {
        _r = r;
        _s = s;}}

class EnchantedDoor extends Door {
    public EnchantedDoor (Room r, Room s) {
        super(r, s);}}

final class Maze {
    private List<Room> _rooms = new ArrayList<Room>();
    private List<Door> _doors = new ArrayList<Door>();

    public void addRoom (Room r) {
        _rooms.add(r);}

    public void addDoor (Door d) {
        _doors.add(d);}

    public Room room (int i) {
        return _rooms.get(i);}

    public Door door (int i) {
        return _doors.get(i);}}

final class AbstractFactoryPatternT {
    public static void main (String[] args) {
        System.out.println("AbstractFactoryPatternT.java");

        {
        MazeFactory mf = new MazeFactory();
        Maze        m  = Game.createMaze(mf);
        assert mf.getClass()        == MazeFactory.class;
        assert m.getClass()         == Maze.class;
        assert m.room(0).getClass() == Room.class;
        assert m.door(0).getClass() == Door.class;
        }

        {
        MazeFactory mf = new EnchantedMazeFactory();
        Maze        m  = Game.createMaze(mf);
        assert mf.getClass()        == EnchantedMazeFactory.class;
        assert m.getClass()         == Maze.class;
        assert m.room(0).getClass() == EnchantedRoom.class;
        assert m.door(0).getClass() == EnchantedDoor.class;
        }

        System.out.println("Done.");}}
