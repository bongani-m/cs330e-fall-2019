// ---------------------
// SingletonPattern.java
// ---------------------

class Eager {
    private static final Eager _only = new Eager();

    private Eager ()
        {}

    public static Eager only () {
        return _only;}

    public String f () {
        return "Eager.f()";}}

class Lazy {
    private static Lazy _only;

    private Lazy ()
        {}

    public static Lazy only () {
        if (Lazy._only == null)
            Lazy._only = new Lazy();
        return Lazy._only;}

    public String f () {
        return "Lazy.f()";}}
