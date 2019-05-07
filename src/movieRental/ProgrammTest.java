package movieRental;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ProgrammTest {
    private static Customer customer;
    private static Rental firstRental;
    private static Rental secondRental;

    @BeforeAll
    public static void initializeTests(){
        firstRental = new Rental(new Movie("movie1", 1), 10);
        secondRental = new Rental(new Movie("movie2", 2), 5);
        customer = new Customer("joe");
        customer.addRental(firstRental);
        customer.addRental(secondRental);
    }


    @Test
    public void testGetFrequentRenterPoints(){
        Assertions.assertEquals(10, firstRental.getDaysRented());
        Assertions.assertEquals(5, secondRental.getDaysRented());
    }

    @Test
    public void testGetTotalCharge(){
        Assertions.assertEquals(17.0, customer.amountFor(new Rental(new Movie("Test",Movie.REGULAR),12)));
    }

    @Test
    public void testGetTotalFrequentRenterPoints(){
        Assertions.assertEquals("movieRental.Rental Record for joe\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tmovie1\t\t10\t30.0\n" +
                "\tmovie2\t\t5\t4.5\n" +
                "Amount owed is 34.5\n" +
                "You earned 3 frequent renter points", customer.statement());
    }
}
