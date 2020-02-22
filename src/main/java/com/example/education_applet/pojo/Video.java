package com.example.education_applet.pojo;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "t_video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "video_name")
    private String videoName;

    @Column(name = "video_size")
    private Double videoSize;

    @Column(name = "video_picture")
    private String videoPicture;

    @Column(name = "video_url")
    private String videoUrl;

    /**
     * 视频类型
     */
    @Column(name = "video_type")
    private String videoType;

    @Column(name = "video_content")
    private String videoContent;

    /**
     * 0是非会员1是会员
     */
    @Column(name = "is_vip_video")
    private Short isVipVideo;

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
     * @return video_name
     */
    public String getVideoName() {
        return videoName;
    }

    /**
     * @param videoName
     */
    public void setVideoName(String videoName) {
        this.videoName = videoName == null ? null : videoName.trim();
    }

    /**
     * @return video_size
     */
    public Double getVideoSize() {
        return videoSize;
    }

    /**
     * @param videoSize
     */
    public void setVideoSize(Double videoSize) {
        this.videoSize = videoSize;
    }

    /**
     * @return video_picture
     */
    public String getVideoPicture() {
        return videoPicture;
    }

    /**
     * @param videoPicture
     */
    public void setVideoPicture(String videoPicture) {
        this.videoPicture = videoPicture == null ? null : videoPicture.trim();
    }

    /**
     * @return video_url
     */
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     * @param videoUrl
     */
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    /**
     * 获取视频类型
     *
     * @return video_type - 视频类型
     */
    public String getVideoType() {
        return videoType;
    }

    /**
     * 设置视频类型
     *
     * @param videoType 视频类型
     */
    public void setVideoType(String videoType) {
        this.videoType = videoType == null ? null : videoType.trim();
    }

    /**
     * @return video_content
     */
    public String getVideoContent() {
        return videoContent;
    }

    /**
     * @param videoContent
     */
    public void setVideoContent(String videoContent) {
        this.videoContent = videoContent == null ? null : videoContent.trim();
    }

    /**
     * @return is_vip_video
     */
    public Short getIsVipVideo() {
        return isVipVideo;
    }

    /**
     * @param isVipVideo
     */
    public void setIsVipVideo(Short isVipVideo) {
        this.isVipVideo = isVipVideo;
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