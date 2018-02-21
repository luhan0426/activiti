package com.java.activiti.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.java.activiti.dto.Group;
import com.java.activiti.dto.MemberShip;

@Repository
public interface LoginDao {

  List<Group> getGrouplist();

  MemberShip userLogin(Map<String, Object> map);

}
