package j2ee.eTicket.dao;

import j2ee.eTicket.entity.Room;

import java.util.List;

public interface RoomDao extends BaseDao {

    public void insert(Room room);
    public void update(Room room);
    public void delete(Room room);
    public List<Room> find(int shopId);
    public Room find(int shopId, int roomId);
}
