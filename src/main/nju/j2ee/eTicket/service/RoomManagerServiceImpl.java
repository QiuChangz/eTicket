package j2ee.eTicket.service;

import j2ee.eTicket.dao.RoomDao;
import j2ee.eTicket.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RoomManagerServiceImpl implements RoomManagerService {
    @Autowired
    private RoomDao roomDao;
    public ArrayList<Room> getShopRooms(String shopId) {
        return (ArrayList<Room>)roomDao.load(Room.class, "shop_id",shopId);
    }

    public Room getRoom(int roomId) {
        return (Room) roomDao.load(Room.class,String.valueOf(roomId));
    }

    public void save(Room room) {
        roomDao.save(room);
    }
}
