package com.example.education_applet.pojo;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "t_get_prize")
public class GetPrize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "prize_id")
    private Long prizeId;

    @Column(name = "prize_num")
    private Integer prizeNum;

    @Column(name = "prize_total_integral")
    private Integer prizeTotalIntegral;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return prize_id
     */
    public Long getPrizeId() {
        return prizeId;
    }

    /**
     * @param prizeId
     */
    public void setPrizeId(Long prizeId) {
        this.prizeId = prizeId;
    }

    /**
     * @return prize_num
     */
    public Integer getPrizeNum() {
        return prizeNum;
    }

    /**
     * @param prizeNum
     */
    public void setPrizeNum(Integer prizeNum) {
        this.prizeNum = prizeNum;
    }

    /**
     * @return prize_total_integral
     */
    public Integer getPrizeTotalIntegral() {
        return prizeTotalIntegral;
    }

    /**
     * @param prizeTotalIntegral
     */
    public void setPrizeTotalIntegral(Integer prizeTotalIntegral) {
        this.prizeTotalIntegral = prizeTotalIntegral;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}