package hotel;

import java.io.*;
import java.util.*;

public class Booking {
    private String customerName;
    private String roomType;

    public Booking(String customerName, String roomType) {
        this.customerName = customerName;
        this.roomType = roomType;
    }

    public void saveBooking() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("bookings.txt", true))) {
            pw.println(customerName + "," + roomType);
        } catch (IOException e) {
            System.out.println("Error saving booking: " + e.getMessage());
        }
    }

    public static void viewBookings() {
        File file = new File("bookings.txt");
        if (!file.exists()) {
            System.out.println("No bookings found.");
            return;
        }
        try (Scanner sc = new Scanner(file)) {
            System.out.println("\nCurrent Bookings:");
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(",");
                System.out.println("Customer: " + data[0] + " | Room: " + data[1]);
            }
        } catch (Exception e) {
            System.out.println("Error reading bookings: " + e.getMessage());
        }
    }

    public static boolean cancelBooking(String customerName, Hotel hotel) {
        File inputFile = new File("bookings.txt");
        File tempFile = new File("temp.txt");
        boolean found = false;

        try (Scanner sc = new Scanner(inputFile);
             PrintWriter pw = new PrintWriter(new FileWriter(tempFile))) {

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(",");
                if (data[0].equalsIgnoreCase(customerName)) {
                    hotel.cancelRoom(data[1]);
                    found = true;
                } else {
                    pw.println(line);
                }
            }

        } catch (Exception e) {
            System.out.println("Error cancelling booking: " + e.getMessage());
        }

        inputFile.delete();
        tempFile.renameTo(inputFile);
        return found;
    }
}
