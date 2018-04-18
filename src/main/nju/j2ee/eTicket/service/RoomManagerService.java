package j2ee.eTicket.service;

import j2ee.eTicket.entity.Room;

import java.util.ArrayList;

public interface RoomManagerService {
    public ArrayList<Room> getShopRooms(String shopId);
    public Room getRoom(int roomId);
    public void save(Room room);
}
