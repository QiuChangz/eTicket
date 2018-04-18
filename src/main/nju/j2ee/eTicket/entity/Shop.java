package j2ee.eTicket.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shop")
public class Shop implements Serializable {

    private int id;
    private Date createTime;
    private Date updateTime;
    private String location;
    private byte[] profile;
    private String environment;
    private String name;
    private String phone;
    private String showContent;
    private int Score;
    private int managerId;
    private Set<Order> orders = new HashSet<Order>();
    private Set<Room> rooms = new HashSet<Room>();

    @Id
    public int getId(){
        return this.id;
    }

    @Column(name = "create_time", length = 19)
    public Date getCreateTime() {
        return this.createTime;
    }

    @Column(name = "update_time", length = 19)
    public Date getUpdateTime() {
        return this.updateTime;
    }

    @Column(name = "location", nullable = false, length = 45)
    public String getLocation() {
        return this.location;
    }

    @Column(name = "profile", nullable = false, length = 45)
    public byte[] getProfile() {
        return this.profile;
    }

    @Column(name = "environment", nullable = false, length = 45)
    public String getEnvironment(){
        return this.environment;
    }

    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return this.name;
    }

    @Column(name = "phone", nullable = false, length = 11)
    public String getPhone() {
        return this.phone;
    }

    @Column(name = "show_content", nullable = false, length = 256)
    public String getShowContent() {
        return this.showContent;
    }

    @Column(name = "manager_id", nullable = false, length = 11)
    public int getManagerId() {
        return this.managerId;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "shop")
    @OrderBy(value = "createTime desc")
    public Set<Order> getOrders() {
        return this.orders;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "shop")
    @OrderBy(value = "name asc")
    public Set<Room> getRooms() {
        return this.rooms;
    }

    @Column(name = "scole", nullable = false, length = 11)
    public int getScore() {
        return Score;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setProfile(byte[] profile) {
        this.profile = profile;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setShowContent(String showContent) {
        this.showContent = showContent;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public void setScore(int score) {
        Score = score;
    }
}
