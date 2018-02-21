package com.java.activiti.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.activiti.dto.Leave;
import com.java.activiti.service.LeaveService;
import com.java.activiti.util.PageUtils;

/**
 * 业务处理
 * 
 * @author Administrator
 *
 */
@Controller
public class LeaveController {

  @Autowired
  private LeaveService leaveService;

  @Autowired
  private RepositoryService repositoryService;

  /**
   * 启动流程注入
   */
  @Autowired
  private RuntimeService runtimeService;

  /**
   * 启动任务注入
   */
  @Autowired
  private TaskService taskService;

  @RequestMapping("leavelist")
  public String leavelist(HttpServletRequest request) {
    String url = "/leavelist";
    Map<String, Object> map = new HashMap<String, Object>();
    Integer page = request.getParameter("page") == null ? 1 : Integer.parseInt("page");
    Integer pageSize = 6;
    Integer startIndex = (page - 1) * pageSize;
    map.put("pageSize", pageSize);
    map.put("startIndex", startIndex);
    Integer listCount = leaveService.getListCount();
    List<Leave> leavelist = leaveService.getLeavelist(map);
    PageUtils.page(request, url, pageSize, leavelist, listCount, page, map);
    request.setAttribute("leavelist", leavelist);
    return "/manager/leaveManage";

  }

  //toadd
  @RequestMapping("toadd")
  public String toadd() {
    return "/manager/add";

  }

  //add
  @RequestMapping("add")
  public String add(HttpServletResponse response, Leave leave, String name, String leaveDate,
    Integer leaveDays, String leaveReason, String state) throws IOException {
    leave.setName(name);
    leave.setLeaveDate(leaveDate);
    leave.setLeaveDays(leaveDays);
    leave.setState("0");
    leaveService.add(leave);

    response.getWriter().print(true);
    return null;

  }

  @RequestMapping("delete")
  public String delete(HttpServletResponse response, Leave leave) throws IOException {
    leaveService.delete(leave);

    response.getWriter().print(true);
    return null;

  }

  /**
   * 
   * <br>Description:提交請假流程申請
   * <br>Author:杨奔(1156199256@qq.com)
   * <br>Date:2018年2月14日
   * @param response
   * @param id
   * @return
   * @throws IOException
   */
  @RequestMapping("startApply")
  public String startApply(HttpServletResponse response, Leave leave, String id) throws IOException {

    // 1、部署流程文件
    repositoryService.createDeployment().name("myProcess")
      .addClasspathResource("activiti/activitiColgeProcess.bpmn").deploy();
    // 2、启动流程
    ProcessInstance pi = runtimeService.startProcessInstanceByKey("myProcess");
    // 根据流程实例Id查询任务
    Task task = taskService.createTaskQuery().processInstanceId(pi.getProcessInstanceId()).singleResult();
    // 完成 学生填写请假单任务
    taskService.complete(task.getId());
    //修改状态
    leave.setState("1");
    leave.setProcessInstanceId(pi.getProcessDefinitionId());
    // 修改请假单状态
    leaveService.updateLeave(leave);
    response.getWriter().print(true);
    return null;

  }
}
