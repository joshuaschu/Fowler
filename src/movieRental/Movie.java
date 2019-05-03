package movieRental;

class Movie {
    static final int CHILDREN = 2;
    static final int REGULAR = 0;
    static final int NEW_RELEASE = 1;
    private String title;
    private int priceCode;

    Movie(String newTitle, int newPriceCode) {
        title = newTitle;
        priceCode = newPriceCode;
    }

    int getPriceCode() {
        return priceCode;
    }

    String getTitle() {
        return title;
    }
}