interface Issuable {
    void issueItem();
    void returnItem();
}


abstract class LibraryItem {
    protected String title;
    protected String itemId;
    protected boolean isIssued;

    public LibraryItem(String title, String itemId) {
        this.title = title;
        this.itemId = itemId;
        this.isIssued = false;
    }

    
    public String getTitle() {
        return title;
    }

    public String getItemId() {
        return itemId;
    }

    public boolean getIssuedStatus() {
        return isIssued;
    }

    public void displayInfo() {
        System.out.println("Item ID: " + itemId + " | Title: " + title + " | Issued: " + isIssued);
    }

    
    public abstract double calculateFine(int daysLate);
}


class Book extends LibraryItem implements Issuable {
    private static final double FINE_PER_DAY = 5.0;

    public Book(String title, String itemId) {
        super(title, itemId);
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * FINE_PER_DAY;
    }

    @Override
    public void issueItem() {
        if (!isIssued) {
            isIssued = true;
            System.out.println("Book issued: " + title);
        } else {
            System.out.println("Book already issued: " + title);
        }
    }

    @Override
    public void returnItem() {
        if (isIssued) {
            isIssued = false;
            System.out.println("Book returned: " + title);
        } else {
            System.out.println("Book was not issued: " + title);
        }
    }

    @Override
    public String toString() {
        return "Book - " + title;
    }
}


class Magazine extends LibraryItem implements Issuable {
    private static final double FINE_PER_DAY = 2.0;

    public Magazine(String title, String itemId) {
        super(title, itemId);
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * FINE_PER_DAY;
    }

    @Override
    public void issueItem() {
        if (!isIssued) {
            isIssued = true;
            System.out.println("Magazine issued: " + title);
        } else {
            System.out.println("Magazine already issued: " + title);
        }
    }

    @Override
    public void returnItem() {
        if (isIssued) {
            isIssued = false;
            System.out.println("Magazine returned: " + title);
        } else {
            System.out.println("Magazine was not issued: " + title);
        }
    }

    @Override
    public String toString() {
        return "Magazine - " + title;
    }
}

public class Assignment_P5 {
    public static void main(String[] args) {
        
        LibraryItem book1 = new Book("Java Programming", "B101");
        LibraryItem mag1 = new Magazine("National Geographic", "M201");
        LibraryItem book2 = new Book("Clean Code", "B102");
        LibraryItem mag2 = new Magazine("Time Magazine", "M202");

        
        LibraryItem[] items = { book1, mag1, book2, mag2 };

        
        System.out.println("=== Issue Items ===");
        for (LibraryItem item : items) {
            ((Issuable) item).issueItem();
        }

       
        System.out.println("\n=== Fine Calculation ===");
        int[] daysLate = { 4, 4, 2, 2 };
        for (int i = 0; i < items.length; i++) {
            double fine = items[i].calculateFine(daysLate[i]);
            System.out.println(items[i] + " | Days late: " + daysLate[i] + " | Fine: Rs." + fine);
        }
    }
}