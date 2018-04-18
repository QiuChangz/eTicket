package j2ee.eTicket.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "order")
public class Order implements Serializable {

    private String id;
    private Date createTime;
    private Date updateTime;
    private int num;
    private int price;
    private String state;
    private User user;
    private Shop shop;
    private Date showTime;
    private String shopLocation;
    private String seats;
    private String showContent;
    private int discount;
    private int score;
    private String evaluation;

    @Id
    public String getId(){
        return this.id;
    }

    @Column(name = "create_time", length = 19)
    public Date getCreateTime(){
        return this.createTime;
    }

    @Column(name = "update_time", length = 19)
    public Date getUpdateTime(){
        return this.updateTime;
    }

    @Column(name = "num", length = 2)
    public int getNum(){
        return this.num;
    }

    @Column(name = "price", length = 4)
    public int getPrice(){
        return this.price;
    }

    @Column(name = "state", length = 45)
    public String getState(){
        return this.state;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    public User getUser(){
        return this.user;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    public Shop getShop(){
        return this.shop;
    }

    @Column(name = "show_time", length = 19)
    public Date getShowTime(){
        return this.showTime;
    }

    @Column(name = "shop_location", nullable = false, length = 45 )
    public String getShopLocation(){
        return this.shopLocation;
    }

    @Column(name = "seats", nullable = false, length = 180)
    public String getSeats(){
        return this.seats;
    }

    @Column(name = "show_content", nullable = false, length = 45)
    public String getShowContent() {
        return this.showContent;
    }

    @Column(name = "discount", nullable = false, length = 5)
    public int getDiscount() {
        return this.discount;
    }

    @Column(name = "scole", nullable = false, length = 5)
    public int getScore() {
        return this.score;
    }

    @Column(name = "evaluation",length = 300)
    public String getEvaluation() {
        return this.evaluation;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime){
        this.updateTime = updateTime;
    }

    public void setNum(int num){
        this.num = num;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public void setState(String state){
        this.state = state;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void setShowTime(Date showTime){
        this.showTime = showTime;
    }

    public void setShopLocation(String shopLocation){
        this.shopLocation = shopLocation;
    }

    public void setSeats(String seats){
        this.seats = seats;
    }

    public void setShowContent(String showContent) {
        this.showContent = showContent;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }
}
