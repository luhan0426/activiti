package com.java.activiti.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.activiti.dto.MyTask;
import com.java.activiti.service.LeaveService;

/**
 * ��ʷ������ע����
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/task")
public class TaskController {

  // ����activiti�Դ���Service�ӿ�
  @Resource
  private TaskService taskService;

  @Resource
  private RepositoryService repositoryService;

  @Resource
  private RuntimeService runtimeService;

  @Resource
  private FormService formService;

  @Resource
  private LeaveService leaveService;

  @Resource
  private HistoryService historyService;

  /**
   * 
   * <br>Description: �������̲�ѯ
   * <br>Author:�(1156199256@qq.com)
   * <br>Date:2018��2��19��
   * @param userId
   * @return
   * @throws Exception
   */
  @RequestMapping("/daibanManager")
  public String taskPage(HttpServletRequest request, String userId) throws Exception {
    List<Task> taskList = taskService.createTaskQuery().taskCandidateGroup(userId).list();
    //�����ݷ��ڼ�����
    List<MyTask> MyTaskList = new ArrayList<MyTask>();
    for (Task t : taskList) {
      MyTask myTask = new MyTask();
      myTask.setId(t.getId());
      myTask.setName(t.getName());
      myTask.setCreateTime(t.getCreateTime());
      MyTaskList.add(myTask);
    }
    System.out.println(MyTaskList);
    request.setAttribute("MyTaskList", MyTaskList);
    return "manager/daibanManage";

  }

}
