package com.example.education_applet.pojo;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "open_id")
    private String openId;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "phone_num")
    private String phoneNum;

    @Column(name = "head_url")
    private String headUrl;

    private Integer integral;

    /**
     * 0是非会员1是会员
     */
    @Column(name = "is_vip")
    private Short isVip;

    @Column(name = "vip_due_time")
    private Date vipDueTime;

    /**
     * 0是普通用户1是讲师2是管理员
     */
    @Column(name = "user_power")
    private Short userPower;

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
     * @return open_id
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * @param openId
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * @return nick_name
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * @return phone_num
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * @param phoneNum
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    /**
     * @return head_url
     */
    public String getHeadUrl() {
        return headUrl;
    }

    /**
     * @param headUrl
     */
    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl == null ? null : headUrl.trim();
    }

    /**
     * @return integral
     */
    public Integer getIntegral() {
        return integral;
    }

    /**
     * @param integral
     */
    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    /**
     * 获取0是非会员1是会员
     *
     * @return is_vip - 0是非会员1是会员
     */
    public Short getIsVip() {
        return isVip;
    }

    /**
     * 设置0是非会员1是会员
     *
     * @param isVip 0是非会员1是会员
     */
    public void setIsVip(Short isVip) {
        this.isVip = isVip;
    }

    /**
     * @return vip_due_time
     */
    public Date getVipDueTime() {
        return vipDueTime;
    }

    /**
     * @param vipDueTime
     */
    public void setVipDueTime(Date vipDueTime) {
        this.vipDueTime = vipDueTime;
    }

    /**
     * 获取0是普通用户1是讲师2是管理员
     *
     * @return user_power - 0是普通用户1是讲师2是管理员
     */
    public Short getUserPower() {
        return userPower;
    }

    /**
     * 设置0是普通用户1是讲师2是管理员
     *
     * @param userPower 0是普通用户1是讲师2是管理员
     */
    public void setUserPower(Short userPower) {
        this.userPower = userPower;
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