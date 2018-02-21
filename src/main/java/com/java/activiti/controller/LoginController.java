package com.java.activiti.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.java.activiti.dto.Group;
import com.java.activiti.dto.MemberShip;
import com.java.activiti.service.LoginService;
import com.java.activiti.util.ResponseUtil;

@Controller
public class LoginController {
  @Autowired
  private LoginService loginService;

  @RequestMapping("/userLogin")
  public String userLogin(HttpServletResponse response, HttpServletRequest request) throws Exception {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("userName", request.getParameter("userName"));
    map.put("password", request.getParameter("password"));
    map.put("groupId", request.getParameter("groupId"));
    MemberShip memberShip = loginService.userLogin(map);
    JSONObject result = new JSONObject();
    if (memberShip == null) {
      result.put("success", false);
      result.put("errorInfo", "用户名或者密码错误！");
    } else {
      result.put("success", true);
      request.getSession().setAttribute("currentMemberShip", memberShip);
    }
    ResponseUtil.write(response, result);
    return null;
  }

  @RequestMapping("findGroup")
  public String findGroup(HttpServletResponse response) throws Exception {
    List<Group> groupList = loginService.getGrouplist();
    Object obj = JSON.toJSON(groupList);
    ResponseUtil.write(response, obj);
    return null;

  }

  /**
   * 页面
   */
  @RequestMapping("daibanManage")
  public String daibanManage() {

    return "manager/daibanManage";

  }

  @RequestMapping("yibanManage")
  public String yibanManage() {

    return "manager/yibanManage";

  }

  @RequestMapping("lishiManage")
  public String lishiManage() {

    return "manager/lishiManage";

  }

}
