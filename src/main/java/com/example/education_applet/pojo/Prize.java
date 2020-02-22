package com.example.education_applet.pojo;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "t_prize")
public class Prize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prize_name")
    private String prizeName;

    @Column(name = "prize_content")
    private String prizeContent;

    @Column(name = "prize_integral")
    private Integer prizeIntegral;

    @Column(name = "prize_num")
    private Integer prizeNum;

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
     * @return prize_name
     */
    public String getPrizeName() {
        return prizeName;
    }

    /**
     * @param prizeName
     */
    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName == null ? null : prizeName.trim();
    }

    /**
     * @return prize_content
     */
    public String getPrizeContent() {
        return prizeContent;
    }

    /**
     * @param prizeContent
     */
    public void setPrizeContent(String prizeContent) {
        this.prizeContent = prizeContent == null ? null : prizeContent.trim();
    }

    /**
     * @return prize_integral
     */
    public Integer getPrizeIntegral() {
        return prizeIntegral;
    }

    /**
     * @param prizeIntegral
     */
    public void setPrizeIntegral(Integer prizeIntegral) {
        this.prizeIntegral = prizeIntegral;
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