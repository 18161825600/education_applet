package com.example.education_applet.pojo;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "t_watch_live")
public class WatchLive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "room_id")
    private Long roomId;

    /**
     * 最后一次打开直播间的时间
     */
    @Column(name = "open_time")
    private Date openTime;

    /**
     * 最后一次关闭直播间的时间
     */
    @Column(name = "close_time")
    private Date closeTime;

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
     * @return room_id
     */
    public Long getRoomId() {
        return roomId;
    }

    /**
     * @param roomId
     */
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    /**
     * 获取最后一次打开直播间的时间
     *
     * @return open_time - 最后一次打开直播间的时间
     */
    public Date getOpenTime() {
        return openTime;
    }

    /**
     * 设置最后一次打开直播间的时间
     *
     * @param openTime 最后一次打开直播间的时间
     */
    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    /**
     * 获取最后一次关闭直播间的时间
     *
     * @return close_time - 最后一次关闭直播间的时间
     */
    public Date getCloseTime() {
        return closeTime;
    }

    /**
     * 设置最后一次关闭直播间的时间
     *
     * @param closeTime 最后一次关闭直播间的时间
     */
    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }
}