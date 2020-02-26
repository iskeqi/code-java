package com.keqi.generator.plugin.domain;

import java.util.Date;

public class ManualInspection {
    private Long id;

    private String planName;

    private String planContent;

    private String periodType;

    private String peopleType;

    private Integer runPeriod;

    private String runPeriodUnit;

    private Byte runPeriodDate;

    private Date runPeriodStart;

    private String active;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName == null ? null : planName.trim();
    }

    public String getPlanContent() {
        return planContent;
    }

    public void setPlanContent(String planContent) {
        this.planContent = planContent == null ? null : planContent.trim();
    }

    public String getPeriodType() {
        return periodType;
    }

    public void setPeriodType(String periodType) {
        this.periodType = periodType == null ? null : periodType.trim();
    }

    public String getPeopleType() {
        return peopleType;
    }

    public void setPeopleType(String peopleType) {
        this.peopleType = peopleType == null ? null : peopleType.trim();
    }

    public Integer getRunPeriod() {
        return runPeriod;
    }

    public void setRunPeriod(Integer runPeriod) {
        this.runPeriod = runPeriod;
    }

    public String getRunPeriodUnit() {
        return runPeriodUnit;
    }

    public void setRunPeriodUnit(String runPeriodUnit) {
        this.runPeriodUnit = runPeriodUnit == null ? null : runPeriodUnit.trim();
    }

    public Byte getRunPeriodDate() {
        return runPeriodDate;
    }

    public void setRunPeriodDate(Byte runPeriodDate) {
        this.runPeriodDate = runPeriodDate;
    }

    public Date getRunPeriodStart() {
        return runPeriodStart;
    }

    public void setRunPeriodStart(Date runPeriodStart) {
        this.runPeriodStart = runPeriodStart;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active == null ? null : active.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}