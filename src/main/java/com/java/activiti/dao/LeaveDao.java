package com.java.activiti.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.java.activiti.dto.Leave;

@Repository
public interface LeaveDao {

  List<Leave> getLeavelist(Map<String, Object> map);

  Integer getListCount();

  void add(Leave leave);

  void delete(Leave leave);

  Leave findById(String leaveId);

  void updateLeave(Leave leave);

}
