/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package room;

/**
 *
 * @author sonika
 */
public class Room {
    private int roomId,status; 

    
    private String name,description,location,roomType;

    public Room(int roomId, String name, String location, String description, int status,String type) {
        this.roomId = roomId;
        this.status = status;
        this.name = name;
        this.description = description;
        this.location = location;
        this.roomType = type;
    }

    public Room(int roomId, String name, String location, String description, String roomType) {
        this.roomId = roomId;
        this.name = name;
        this.description = description;
        this.location = location;
        this.roomType = roomType;
    }
    
    public Room() {
    }
    
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
   
    
    

}
