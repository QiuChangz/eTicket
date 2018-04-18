package j2ee.eTicket.dao;

import j2ee.eTicket.entity.Room;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomDaoImpl extends BaseDaoImpl implements RoomDao {
    public void insert(Room room) {
        super.save(room);
    }

    public void update(Room room) {
        super.update(room);
    }

    public void delete(Room room) {
        super.delete(room);
    }

    public List<Room> find(int shopId) {
        List<Room> roomList = (List<Room>)super.load(Room.class, "shop_id", String.valueOf(shopId));
        return roomList;
    }

    public Room find(int shopId, int roomId) {
        return (Room)super.load(Room.class, String.valueOf(roomId));
    }
}
