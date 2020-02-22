package com.example.education_applet.pojo;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "t_room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "room_name")
    private String roomName;

    /**
     * 推流地址
     */
    @Column(name = "push_url")
    private String pushUrl;

    /**
     * 拉流地址
     */
    @Column(name = "pull_url")
    private String pullUrl;

    /**
     * 0是未开播1是正在直播
     */
    @Column(name = "room_state")
    private Short roomState;

    /**
     * 最后一次开播时间
     */
    @Column(name = "begin_show_time")
    private Date beginShowTime;

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
     * @return room_name
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * @param roomName
     */
    public void setRoomName(String roomName) {
        this.roomName = roomName == null ? null : roomName.trim();
    }

    /**
     * 获取推流地址
     *
     * @return push_url - 推流地址
     */
    public String getPushUrl() {
        return pushUrl;
    }

    /**
     * 设置推流地址
     *
     * @param pushUrl 推流地址
     */
    public void setPushUrl(String pushUrl) {
        this.pushUrl = pushUrl == null ? null : pushUrl.trim();
    }

    /**
     * 获取拉流地址
     *
     * @return pull_url - 拉流地址
     */
    public String getPullUrl() {
        return pullUrl;
    }

    /**
     * 设置拉流地址
     *
     * @param pullUrl 拉流地址
     */
    public void setPullUrl(String pullUrl) {
        this.pullUrl = pullUrl == null ? null : pullUrl.trim();
    }

    /**
     * 获取0是未开播1是正在直播
     *
     * @return room_state - 0是未开播1是正在直播
     */
    public Short getRoomState() {
        return roomState;
    }

    /**
     * 设置0是未开播1是正在直播
     *
     * @param roomState 0是未开播1是正在直播
     */
    public void setRoomState(Short roomState) {
        this.roomState = roomState;
    }

    /**
     * 获取最后一次开播时间
     *
     * @return begin_show_time - 最后一次开播时间
     */
    public Date getBeginShowTime() {
        return beginShowTime;
    }

    /**
     * 设置最后一次开播时间
     *
     * @param beginShowTime 最后一次开播时间
     */
    public void setBeginShowTime(Date beginShowTime) {
        this.beginShowTime = beginShowTime;
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