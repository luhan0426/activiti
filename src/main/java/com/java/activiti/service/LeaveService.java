package com.java.activiti.service;

import java.util.List;
import java.util.Map;

import com.java.activiti.dto.Leave;

public interface LeaveService {

  List<Leave> getLeavelist(Map<String, Object> map);

  Integer getListCount();

  void add(Leave leave);

  void delete(Leave leave);

  Leave findById(String id);

  void updateLeave(Leave leave);

}
