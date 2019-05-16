// -------------------------
// FactoryMethodPattern.java
// -------------------------

@SuppressWarnings("auxiliaryclass")
class Game {
    public final Maze createMaze () {
        Maze m = new Maze();
        m.addRoom(makeRoom());
        m.addRoom(makeRoom());
        m.addRoom(makeRoom());
        m.addDoor(makeDoor(m.room(0), m.room(1)));
        m.addDoor(makeDoor(m.room(1), m.room(2)));
        return m;}

    public Room makeRoom () {
        return new Room();}

    public Door makeDoor (Room r, Room s) {
        return new Door(r, s);}}

@SuppressWarnings("auxiliaryclass")
class EnchantedGame extends Game {
    public EnchantedRoom makeRoom () {
        return new EnchantedRoom();}

    public EnchantedDoor makeDoor (Room r, Room s) {
        return new EnchantedDoor(r, s);}}
