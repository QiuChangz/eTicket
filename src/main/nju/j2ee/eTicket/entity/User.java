package j2ee.eTicket.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements Serializable {
    private int id;
    private Date createTime;
    private Date updateTime;
    private String name;
    private Date birthday;
    private byte[] profile;
    private String identity;
    private String remarks;
    private int credit;
    private String email;
    private String password;
    private Set<Order> orders = new HashSet<Order>();
    private int money;

//    public User(){}
//
//    public User(int id, Date createTime, Date updateTime, String name, Date birthday, byte[] profile, String identity, String remarks, int credit, String email, String password, Set<Order> orders) {
//        this.id = id;
//        this.createTime = createTime;
//        this.updateTime = updateTime;
//        this.name = name;
//        this.birthday = birthday;
//        this.profile = profile;
//        this.identity = identity;
//        this.remarks = remarks;
//        this.credit = credit;
//        this.email = email;
//        this.password = password;
//        this.orders = orders;
//    }

    @Id
    public int getId() {
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

    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return this.name;
    }

    @Column(name = "birthday", nullable = false, length = 10)
    public Date getBirthday(){
        return this.birthday;
    }

    @Column(name = "profile", length = 65535)
    public byte[] getProfile() {
        return this.profile;
    }

    @Column(name = "identity", nullable = false, length = 45)
    public String getIdentity() {
        return this.identity;
    }

    @Column(name = "remarks", length = 45)
    public String getRemarks() {
        return this.remarks;
    }

    @Column(name = "credit", nullable = false, length = 11)
    public int getCredit(){
        return this.credit;
    }

    @Column(name = "email", nullable = false, length = 45)
    public String getEmail(){
        return this.email;
    }

    @Column(name = "password", nullable = false, length = 45)
    public String getPassword() {
        return this.password;
    }

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "user")
    @OrderBy(value = "createTime desc")
    public Set<Order> getOrders() {
        return this.orders;
    }

    @Column(name = "money")
    public int getMoney() {
        return money;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }

    public void setProfile(byte[] profile) {
        this.profile = profile;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
