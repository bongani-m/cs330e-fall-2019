// -------------------
// DynamicBinding.java
// -------------------

class A {
    public String f1 () {
        return f2();}

    public String f2 () {
        return "A.f2";}

    public String g1 () {
        return g2();}

    protected String g2 () {
        return "A.g2";}

    public String h1 () {
        return h2();}

    private String h2 () {
        return "A.h2";}}

class B extends A {
    public String f2 () {
        return "B.f2";}

    public String g2 () {
        return "B.g2";}

    public String h2 () {
        return "B.h2";}}

final class DynamicBinding {
    public static void main (String[] args) {
        System.out.println("DynamicBinding.java");

        A x = new B();
        assert x.f1() == "B.f2";
        assert x.g1() == "B.g2";
        assert x.h1() == "A.h2";

        System.out.println("Done.");}}
