package com.example.education_applet.pojo;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "t_integral")
public class Integral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "get_integral_num")
    private Integer getIntegralNum;

    @Column(name = "get_integral_way")
    private String getIntegralWay;

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
     * @return get_integral_num
     */
    public Integer getGetIntegralNum() {
        return getIntegralNum;
    }

    /**
     * @param getIntegralNum
     */
    public void setGetIntegralNum(Integer getIntegralNum) {
        this.getIntegralNum = getIntegralNum;
    }

    /**
     * @return get_integral_way
     */
    public String getGetIntegralWay() {
        return getIntegralWay;
    }

    /**
     * @param getIntegralWay
     */
    public void setGetIntegralWay(String getIntegralWay) {
        this.getIntegralWay = getIntegralWay == null ? null : getIntegralWay.trim();
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