// ---------------
// Reflection.java
// ---------------

abstract class A  {
    public abstract String f ();}

class B extends A {
    public String f () {
        return "B.f()";}}

class C extends A {
    public C (int i)
        {}

    public String f () {
        return "C.f()";}}

class D extends A {
    private D ()
        {}

    public String f () {
        return "D.f()";}}

abstract class E extends A {
    public String f () {
        return "E.f()";}}

interface F
    {}

class H
    {}

final class Reflection {
    public static void main (String[] args) {
        System.out.println("Reflection.java");

        try {
            A x = (A) Class.forName("B").newInstance();
            assert x.f().equals("B.f()");}
        catch (ClassCastException e) {
            assert false;}
        catch (ClassNotFoundException e) {
            assert false;}
        catch (IllegalAccessException e) {
            assert false;}
        catch (InstantiationException e) {
            assert false;}

        try {
            A x = (A) Class.forName("C").newInstance();
            assert x.f().equals("C.f()");}
        catch (ClassCastException e) {
            assert false;}
        catch (ClassNotFoundException e) {
            assert false;}
        catch (IllegalAccessException e) {
            assert false;}
        catch (InstantiationException e) {
            assert e.toString().equals("java.lang.InstantiationException: C");}

       try {
            A x = (A) Class.forName("D").newInstance();
            assert x.f().equals("D.f()");}
        catch (ClassCastException e) {
            assert false;}
        catch (ClassNotFoundException e) {
            assert false;}
        catch (IllegalAccessException e) {
            assert e.toString().equals("java.lang.IllegalAccessException: Class Reflection can not access a member of class D with modifiers \"private\"");}
        catch (InstantiationException e) {
            assert false;}

        try {
            Object x = Class.forName("E").newInstance();}
        catch (ClassCastException e) {
            assert false;}
        catch (ClassNotFoundException e) {
            assert false;}
        catch (IllegalAccessException e) {
            assert false;}
        catch (InstantiationException e) {
            assert e.toString().equals("java.lang.InstantiationException");}

        try {
            Object x = Class.forName("F").newInstance();}
        catch (ClassCastException e) {
            assert false;}
        catch (ClassNotFoundException e) {
            assert false;}
        catch (IllegalAccessException e) {
            assert false;}
        catch (InstantiationException e) {
            assert e.toString().equals("java.lang.InstantiationException: F");}

        try {
            Object x = Class.forName("G").newInstance();}
        catch (ClassCastException e) {
            assert false;}
        catch (ClassNotFoundException e) {
            assert e.toString().equals("java.lang.ClassNotFoundException: G");}
        catch (IllegalAccessException e) {
            assert false;}
        catch (InstantiationException e) {
            assert false;}

        try {
            A x = (A) Class.forName("H").newInstance();}
        catch (ClassCastException e) {
            assert e.toString().equals("java.lang.ClassCastException: H cannot be cast to A");}
        catch (ClassNotFoundException e) {
            assert false;}
        catch (IllegalAccessException e) {
            assert false;}
        catch (InstantiationException e) {
            assert false;}

        System.out.println("Done.");}}
