// ---------------------
// PrototypePattern.java
// ---------------------

class Room implements Cloneable {
    public Object clone () {
        try {
            return super.clone();}
        catch (CloneNotSupportedException e) {
            return null;}}}

class EnchantedRoom extends Room 
    {}

class Door implements Cloneable {
    private Room _r;
    private Room _s;

    public Object clone () {
        try {
            return super.clone();}
        catch (CloneNotSupportedException e) {
            return null;}}}

class EnchantedDoor extends Door
    {}

final class MazePrototype {
    private Room _room;
    private Door _door;

    public MazePrototype (Room room, Door door) {
        _room = room;
        _door = door;}

    public Room makeRoom () {
        return (Room) _room.clone();}

    public Door makeDoor (Room r, Room s) {
        return (Door) _door.clone();}}

@SuppressWarnings("auxiliaryclass")
abstract class Game {
    public static Maze createMaze (MazePrototype mp) {
        Maze m = new Maze();
        m.addRoom(mp.makeRoom());
        m.addRoom(mp.makeRoom());
        m.addRoom(mp.makeRoom());
        m.addDoor(mp.makeDoor(m.room(0), m.room(1)));
        m.addDoor(mp.makeDoor(m.room(1), m.room(2)));
        return m;}}
