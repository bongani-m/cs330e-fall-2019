// ---------------------------
// AbstractFactoryPattern.java
// ---------------------------

class MazeFactory {
    public Room makeRoom () {
        return new Room();}

    public Door makeDoor (Room r, Room s) {
        return new Door(r, s);}}

class EnchantedMazeFactory extends MazeFactory {
    public EnchantedRoom makeRoom () {
        return new EnchantedRoom();}

    public EnchantedDoor makeDoor (Room r, Room s) {
        return new EnchantedDoor(r, s);}}

abstract class Game {
    public static Maze createMaze (MazeFactory mf) {
        Maze m = new Maze();
        m.addRoom(mf.makeRoom());
        m.addRoom(mf.makeRoom());
        m.addRoom(mf.makeRoom());
        m.addDoor(mf.makeDoor(m.room(0), m.room(1)));
        m.addDoor(mf.makeDoor(m.room(1), m.room(2)));
        return m;}}
