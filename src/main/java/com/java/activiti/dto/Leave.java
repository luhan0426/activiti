package com.java.activiti.dto;


/**
 * 请假单实体
 * @author user
 *
 */
public class Leave {

  private Integer id; // 编号

  private String name; // 请假人

  private String leaveDate;// 请假日期

  private Integer leaveDays; // 请假天数

  private String leaveReason; // 请假原因

  private String state; // 审核状态  未提交  审核中 审核通过 审核未通过

  private String processInstanceId; // 流程实例Id

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLeaveDate() {
    return leaveDate;
  }

  public void setLeaveDate(String leaveDate) {
    this.leaveDate = leaveDate;
  }

  public Integer getLeaveDays() {
    return leaveDays;
  }

  public void setLeaveDays(Integer leaveDays) {
    this.leaveDays = leaveDays;
  }

  public String getLeaveReason() {
    return leaveReason;
  }

  public void setLeaveReason(String leaveReason) {
    this.leaveReason = leaveReason;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getProcessInstanceId() {
    return processInstanceId;
  }

  public void setProcessInstanceId(String processInstanceId) {
    this.processInstanceId = processInstanceId;
  }

}
