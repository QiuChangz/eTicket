package j2ee.eTicket.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "room")
public class Room implements Serializable {

    private int id;
    private Date createTime;
    private Date updateTime;
    private Shop shop;
    private String name;
    private Date showTime;
    private String showContent;
    private String seat;
    private String unavailable;
    private String content;
    private int price;

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

    @ManyToOne(cascade = CascadeType.ALL,optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    public Shop getShop() {
        return this.shop;
    }

    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return this.name;
    }

    @Column(name = "show_time")
    public Date getShowTime() {
        return this.showTime;
    }

    @Column(name = "show_content", length = 45)
    public String getShowContent() {
        return this.showContent;
    }

    @Column(name = "seat", nullable = false, length = 100)
    public String getSeat() {
        return this.seat;
    }

    @Column(name = "unavailable", length = 1000)
    public String getUnavailable() {
        return unavailable;
    }

    @Column(name = "content", length = 1000)
    public String getContent() {
        return content;
    }

    @Column(name = "price", length = 10)
    public int getPrice() {
        return price;
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

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public void setShowContent(String showContent) {
        this.showContent = showContent;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public void setUnavailable(String unavailable) {
        this.unavailable = unavailable;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
