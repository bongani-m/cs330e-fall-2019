// ----------------------
// PrototypePatternT.java
// ----------------------

// http://en.wikipedia.org/wiki/Prototype_pattern

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("auxiliaryclass")
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

@SuppressWarnings("auxiliaryclass")
final class PrototypePatternT {
    public static void main (String[] args) {
        System.out.println("PrototypePatternT.java");

        {
        MazePrototype mp = new MazePrototype(new Room(), new Door());
        Maze          m  = Game.createMaze(mp);
        assert mp.getClass()        == MazePrototype.class;
        assert m.getClass()         == Maze.class;
        assert m.room(0).getClass() == Room.class;
        assert m.door(0).getClass() == Door.class;
        }

        {
        MazePrototype mp = new MazePrototype(new EnchantedRoom(), new EnchantedDoor());
        Maze          m  = Game.createMaze(mp);
        assert mp.getClass()        == MazePrototype.class;
        assert m.getClass()         == Maze.class;
        assert m.room(0).getClass() == EnchantedRoom.class;
        assert m.door(0).getClass() == EnchantedDoor.class;
        }

        System.out.println("Done.");}}
