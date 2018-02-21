package com.java.activiti.service;

import java.util.List;
import java.util.Map;

import com.java.activiti.dto.Group;
import com.java.activiti.dto.MemberShip;

public interface LoginService {

  List<Group> getGrouplist();

  MemberShip userLogin(Map<String, Object> map);

}
