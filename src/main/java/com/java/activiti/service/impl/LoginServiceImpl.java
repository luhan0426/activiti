package com.java.activiti.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.activiti.dao.LoginDao;
import com.java.activiti.dto.Group;
import com.java.activiti.dto.MemberShip;
import com.java.activiti.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
  @Autowired
  private LoginDao loginDao;

  @Override
  public List<Group> getGrouplist() {
    // TODO Auto-generated method stub
    return loginDao.getGrouplist();
  }

  @Override
  public MemberShip userLogin(Map<String, Object> map) {
    // TODO Auto-generated method stub
    return loginDao.userLogin(map);
  }
}
