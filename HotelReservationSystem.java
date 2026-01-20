package hotel;

import java.util.Scanner;

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel("CodeAlpha Hotel");
        hotel.loadRoomsFromFile();

        while (true) {
            System.out.println("\n--- Hotel Reservation System ---");
            System.out.println("1. Show Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View All Bookings");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    hotel.showAvailableRooms();
                    break;

                case 2:
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter room type (Standard/Deluxe/Suite): ");
                    String type = sc.nextLine();
                    if (hotel.bookRoom(type)) {
                        Booking booking = new Booking(name, type);
                        booking.saveBooking();
                        System.out.println("Booking Successful!");
                        System.out.println("Payment simulated successfully.");
                    } else {
                        System.out.println("Room not available!");
                    }
                    break;

                case 3:
                    System.out.print("Enter your name to cancel booking: ");
                    String cancelName = sc.nextLine();
                    if (Booking.cancelBooking(cancelName, hotel)) {
                        System.out.println("Booking cancelled successfully!");
                    } else {
                        System.out.println("No booking found for this name.");
                    }
                    break;

                case 4:
                    Booking.viewBookings();
                    break;

                case 5:
                    System.out.println("Thank you for using the system!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
