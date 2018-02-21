package com.java.activiti.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.activiti.dao.LeaveDao;
import com.java.activiti.dto.Leave;
import com.java.activiti.service.LeaveService;

@Service
public class LeaveServiceImpl implements LeaveService {
  @Autowired
  private LeaveDao leaveDao;

  @Override
  public List<Leave> getLeavelist(Map<String, Object> map) {
    // TODO Auto-generated method stub
    return leaveDao.getLeavelist(map);
  }

  @Override
  public Integer getListCount() {
    // TODO Auto-generated method stub
    return leaveDao.getListCount();
  }

  @Override
  public void add(Leave leave) {
    // TODO Auto-generated method stub
    leaveDao.add(leave);
  }

  @Override
  public void delete(Leave leave) {
    // TODO Auto-generated method stub
    leaveDao.delete(leave);
  }

  @Override
  public Leave findById(String leaveId) {
    // TODO Auto-generated method stub
    return leaveDao.findById(leaveId);
  }

  @Override
  public void updateLeave(Leave leave) {
    // TODO Auto-generated method stub
    leaveDao.updateLeave(leave);
  }
}
