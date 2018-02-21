package com.java.activiti.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public final class PageUtils {

  public static void page(HttpServletRequest request, String url, Integer pageSize, List<?> list,
    Integer listCount, Integer page) {
    // ͨ������Ҫ�����������ҳ����ʾ����������ҳ��
    int pageCount = listCount / pageSize + (listCount % pageSize == 0 ? 0 : 1);
    // �ж�url���Ƿ���?�ţ�����У�����ͨ��&���Ž������ӣ�����ͨ��?��������
    String flag = url.indexOf("?") != -1 ? "&" : "?";

    // ��ҳ����ҳ����һҳ����һҳ��ĩҳ
    String first = "";
    String prev = "";
    String next = "";
    String last = "";
    //		
    //		HttpSession session = request.getSession();
    //		
    //		User user = (User) session.getAttribute("user");

    //		String conditions = "";
    //		
    //		if(user != null){
    //			if(user.getName() != null && !"".equals(user.getName())){
    //				conditions = conditions+user.getName();
    //			}
    //			
    //			
    //		}
    //		

    if (page != 1) {
      first = "<a href='" + request.getContextPath() + url + flag + "page=1'>��ҳ</a>";
    } else {
      first = "��ҳ";
    }

    if (page > 1) {
      prev = "<a href='" + request.getContextPath() + url + flag + "page=" + (page - 1) + "'>��һҳ</a>";
    } else {
      prev = "��һҳ";
    }

    if (page < pageCount) {
      next = "<a href='" + request.getContextPath() + url + flag + "page=" + (page + 1) + "'>��һҳ</a>";
    } else {
      next = "��һҳ";
    }

    if (page != pageCount) {
      last = "<a href='" + request.getContextPath() + url + flag + "page=" + pageCount + "'>ĩҳ</a>";
    } else {
      last = "ĩҳ";
    }

    request.setAttribute("first", first); // ��ҳ
    request.setAttribute("prev", prev); // ��һҳ
    request.setAttribute("next", next); // ��һҳ
    request.setAttribute("last", last); // ĩҳ

    request.setAttribute("page", page); // ҳ��
    request.setAttribute("pageCount", pageCount); // ��ҳ��
    request.setAttribute("listCount", listCount); // ������
    request.setAttribute("pageSize", pageSize); // ҳ����ʾ����
    request.setAttribute("list", list); // ��ҳ��ʾ�ļ���
  }

  public static void page(HttpServletRequest request, String url, Integer pageSize, List<?> list,
    Integer listCount, Integer page, Map<?, ?> searchMap) {
    // ͨ������Ҫ�����������ҳ����ʾ����������ҳ��
    int pageCount = listCount / pageSize + (listCount % pageSize == 0 ? 0 : 1);

    // �ж�url���Ƿ���?�ţ�����У�����ͨ��&���Ž������ӣ�����ͨ��?��������
    String flag = url.indexOf("?") != -1 ? "&" : "?";

    // ����ѯ����ƴ�ӳ��ַ����������ѯ��ֵΪNULL���߿գ��������ַ���ƴ�ӡ�
    String term = "";
    if (!searchMap.isEmpty()) {
      Set<?> set = searchMap.keySet();
      Iterator<?> iterator = set.iterator();
      while (iterator.hasNext()) {
        Object key = iterator.next();
        Object value = searchMap.get(key);
        System.out.println(value);
        if (value != null && !value.equals("")) {
          term += "&" + key + "=" + value;
        }
      }
    }

    // ��ҳ����ҳ����һҳ����һҳ��ĩҳ
    String first = "";
    String prev = "";
    String next = "";
    String last = "";

    if (page != 1) {
      first = "<a href='" + request.getContextPath() + url + flag + "page=1" + term + "'>��ҳ</a>";
    } else {
      first = "��ҳ";
    }

    if (page > 1) {
      prev = "<a href='" + request.getContextPath() + url + flag + "page=" + (page - 1) + term + "'>��һҳ</a>";
    } else {
      prev = "��һҳ";
    }

    if (page < pageCount) {
      next = "<a href='" + request.getContextPath() + url + flag + "page=" + (page + 1) + term + "'>��һҳ</a>";
    } else {
      next = "��һҳ";
    }

    if (page != pageCount) {
      last = "<a href='" + request.getContextPath() + url + flag + "page=" + pageCount + term + "'>ĩҳ</a>";
    } else {
      last = "ĩҳ";
    }

    request.setAttribute("first", first); // ��ҳ
    request.setAttribute("prev", prev); // ��һҳ
    request.setAttribute("next", next); // ��һҳ
    request.setAttribute("last", last); // ĩҳ

    request.setAttribute("page", page); // ҳ��
    request.setAttribute("pageCount", pageCount); // ��ҳ��
    request.setAttribute("listCount", listCount); // ������
    request.setAttribute("pageSize", pageSize); // ҳ����ʾ����
    request.setAttribute("list", list); // ��ҳ��ʾ�ļ���
    request.setAttribute("map", searchMap);
  }
}
