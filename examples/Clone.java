// ----------
// Clone.java
// ----------

/*
interface Cloneable {}

class Object {
    protected Object clone () throws CloneNotSupportedException {
        if (!(this instanceof Cloneable))
            throw new CloneNotSupportedException();
        // ...magic...
        }
*/

import java.util.Arrays;

class A implements Cloneable {
    public int[] a;

    public A () {
        a = new int[10];
        Arrays.fill(a, 2);}

    public Object clone () {
        try {
            final A that = (A) super.clone();
            that.a = new int[a.length];
            System.arraycopy(a, 0, that.a, 0, a.length);
            return that;}
        catch (CloneNotSupportedException e) {
            return null;}}}

final class B extends A
    {}

final class Clone {
    public static void main (String[] args) {
        System.out.println("Clone.java");

        {
        final A x = new A();
        final A y = (A) x.clone();
        assert x   != y;
        assert x.a != y.a;
        assert Arrays.equals(x.a, y.a);
        }

        {
        final B x = new B();
        final B y = (B) x.clone();
        assert x   != y;
        assert x.a != y.a;
        assert Arrays.equals(x.a, y.a);
        }

        System.out.println("Done.");}}
