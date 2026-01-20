package hotel;

import java.io.*;
import java.util.*;

public class Hotel 
{
    private String hotelName;
    private Map<String, Integer> rooms; 
    
    public Hotel(String hotelName)
    {
        this.hotelName = hotelName;
        rooms = new HashMap<>();
        rooms.put("Standard", 10);
        rooms.put("Deluxe", 5);
        rooms.put("Suite", 2);
    }

  
    public void showAvailableRooms() 
    {
        System.out.println("\nAvailable Rooms:");
        for (Map.Entry<String, Integer> entry : rooms.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

   
    public boolean isRoomAvailable(String type) 
    {
        return rooms.containsKey(type) && rooms.get(type) > 0;
    }

    // Book a room
    public boolean bookRoom(String type) 
    {
        if (isRoomAvailable(type)) 
        {
            rooms.put(type, rooms.get(type) - 1);
            saveRoomsToFile();
            return true;
        }
        return false;
    }

    // Cancel booking
    public void cancelRoom(String type) 
    {
        if (rooms.containsKey(type)) {
            rooms.put(type, rooms.get(type) + 1);
            saveRoomsToFile();
        }
    }

   
    public void saveRoomsToFile() 
    {
        try (PrintWriter pw = new PrintWriter(new FileWriter("rooms.txt"))) {
            for (Map.Entry<String, Integer> entry : rooms.entrySet()) {
                pw.println(entry.getKey() + "," + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("Error saving rooms: " + e.getMessage());
        }
    }

 
    public void loadRoomsFromFile()
    {
        File file = new File("rooms.txt");
        if (!file.exists()) return;
        try (Scanner sc = new Scanner(file))
        {
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(",");
                rooms.put(data[0], Integer.parseInt(data[1]));
            }
        } catch (Exception e) 
        {
            System.out.println("Error loading rooms: " + e.getMessage());
        }
    }
}
