// -----------
// Store8.java
// -----------

/*
Use reflection.
*/

import java.util.Enumeration;
import java.util.Vector;

abstract class Price {
    abstract double getCharge    (int daysRented);
    abstract String getPriceCode ();               // not used

    public int getFrequentRenterPoints (int daysRented) { // const
        return 1;}}

class RegularPrice extends Price {
    public double getCharge (int daysRented) { // const
        double result = 2;
        if (daysRented > 2)
            result += (daysRented - 2) * 1.5;
        return result;}

    public String getPriceCode () { // const, not used
        return Movie.REGULAR;}}

class NewReleasePrice extends Price {
    public double getCharge (int daysRented) { // const
        return daysRented * 3;}

    public int getFrequentRenterPoints (int daysRented) { // const
        return (daysRented > 1) ? 2 : 1;}

    public String getPriceCode () { // const, not used
        return Movie.NEW_RELEASE;}}

class ChildrensPrice extends Price {
    public double getCharge (int daysRented) { // const
        double result = 1.5;
        if (daysRented > 3)
            result += (daysRented - 3) * 1.5;
        return result;}

    public String getPriceCode () { // const, not used
        return Movie.CHILDRENS;}}

class Movie {
    public static final String REGULAR     = "RegularPrice";
    public static final String NEW_RELEASE = "NewReleasePrice";
    public static final String CHILDRENS   = "ChildrensPrice";

    private String _title;
    private Price  _price;

    public Movie (String title, String priceCode) {
        _title = title;
        setPriceCode(priceCode);}

    /**
     * _price
     *     getCharge()
     */
    public double getCharge (int daysRented) { // const
        return _price.getCharge(daysRented);}

    /**
     * _price
     *     getFrequentRenterPoints()
     */
    public int getFrequentRenterPoints (int daysRented) { // const
        return _price.getFrequentRenterPoints(daysRented);}

    /**
     * _price
     *     getPriceCode()
     */
    public String getPriceCode () { // const
        return _price.getPriceCode();}

    public String getTitle () { // const
        return _title;}

    public void setPriceCode (String priceCode) {
        try {
            _price = (Price) Class.forName(priceCode).newInstance();}
        catch (ClassCastException e) {
            throw new IllegalArgumentException("Incorrect Price Code");}
        catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Incorrect Price Code");}
        catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Incorrect Price Code");}
        catch (InstantiationException e) {
            throw new IllegalArgumentException("Incorrect Price Code");}}}

class Rental {
    private Movie _movie;
    private int   _daysRented;

    public Rental (Movie movie, int daysRented) {
        _movie      = movie;
        _daysRented = daysRented;}

    /**
     * _movie
     *     getCharge()
     */
    public double getCharge () { // const
        return _movie.getCharge(_daysRented);}

    public int getDaysRented () { // const // no longer used
        return _daysRented;}

    /**
     * _movie
     *     getFrequentRenterPoints()
     */
    public int getFrequentRenterPoints () { // const
        return _movie.getFrequentRenterPoints(_daysRented);}

    public Movie getMovie () { // const
        return _movie;}}

class Customer {
    private String         _name;
    private Vector<Rental> _rentals = new Vector<Rental>();

    public Customer (String name) {
        _name = name;}

    public void addRental (Rental rental) {
        _rentals.addElement(rental);}

    public String getName () { // const
        return _name;}

    /**
     * _rentals.elements().nextElement()
     *     getCharge()
     */
    private double getTotalCharge () { // const, O(n)
        double              result  = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each  = rentals.nextElement();
            result      += each.getCharge();}
        return result;}

    /**
     * _rentals.elements().nextElement()
     *     getFrequentRenterPoints()
     */
    private int getTotalFrequentRenterPoints () { // const, O(n)
        int                 result  = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each  = rentals.nextElement();
            result      += each.getFrequentRenterPoints();}
        return result;}

    /**
     * _rentals.elements().nextElement()
     *     getCharge()
     *     getMovie()
     *         getTitle()
     */
    public String statement () { // O(3n)
        String              result  = "Rental Record for " + getName() + "\n";
        Enumeration<Rental> rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each  = rentals.nextElement();
            result      +=
                "\t" + each.getMovie().getTitle()       +
                "\t" + String.valueOf(each.getCharge()) + "\n";}
        result +=
            "Amount owed is "                +
            String.valueOf(getTotalCharge()) + "\n";
        result +=
            "You earned "                                  +
            String.valueOf(getTotalFrequentRenterPoints()) +
            " frequent renter points";
        return result;}}

final class Store8 {
    public static void main (String[] args) {
        System.out.println("Store8.java");

        Customer x = new Customer("Penelope");
        assert x.statement().equals(
            "Rental Record for Penelope\n" +
            "Amount owed is 0.0\n"         +
            "You earned 0 frequent renter points");

        x.addRental(new Rental(new Movie("Shane", Movie.REGULAR), 2));
        assert x.statement().equals(
            "Rental Record for Penelope\n" +
            "\tShane\t2.0\n"               +
            "Amount owed is 2.0\n"         +
            "You earned 1 frequent renter points");

        x.addRental(new Rental(new Movie("Red River", Movie.REGULAR), 5));
        assert x.statement().equals(
            "Rental Record for Penelope\n" +
            "\tShane\t2.0\n"               +
            "\tRed River\t6.5\n"           +
            "Amount owed is 8.5\n"         +
            "You earned 2 frequent renter points");

        x.addRental(new Rental(new Movie("Giant", Movie.NEW_RELEASE), 1));
        assert x.statement().equals(
            "Rental Record for Penelope\n" +
            "\tShane\t2.0\n"               +
            "\tRed River\t6.5\n"           +
            "\tGiant\t3.0\n"               +
            "Amount owed is 11.5\n"        +
            "You earned 3 frequent renter points");

        x.addRental(new Rental(new Movie("2001", Movie.NEW_RELEASE), 3));
        assert x.statement().equals(
            "Rental Record for Penelope\n" +
            "\tShane\t2.0\n"               +
            "\tRed River\t6.5\n"           +
            "\tGiant\t3.0\n"               +
            "\t2001\t9.0\n"                +
            "Amount owed is 20.5\n"        +
            "You earned 5 frequent renter points");

        x.addRental(new Rental(new Movie("Big Country", Movie.CHILDRENS), 3));
        assert x.statement().equals(
            "Rental Record for Penelope\n" +
            "\tShane\t2.0\n"               +
            "\tRed River\t6.5\n"           +
            "\tGiant\t3.0\n"               +
            "\t2001\t9.0\n"                +
            "\tBig Country\t1.5\n"         +
            "Amount owed is 22.0\n"        +
            "You earned 6 frequent renter points");

        x.addRental(new Rental(new Movie("Spartacus", Movie.CHILDRENS), 5));
        assert x.statement().equals(
            "Rental Record for Penelope\n" +
            "\tShane\t2.0\n"               +
            "\tRed River\t6.5\n"           +
            "\tGiant\t3.0\n"               +
            "\t2001\t9.0\n"                +
            "\tBig Country\t1.5\n"         +
            "\tSpartacus\t4.5\n"           +
            "Amount owed is 26.5\n"        +
            "You earned 7 frequent renter points");

        System.out.println("Done.");}}
