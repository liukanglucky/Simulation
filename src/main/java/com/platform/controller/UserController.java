package com.platform.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.platform.model.PageBean;
import com.platform.model.User;
import com.platform.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/")
public class UserController extends BaseJsonAction{
	@Autowired
	private UserServiceImpl usi;
	
	@RequestMapping("login")
	public ModelAndView login(String name,String pwd,ModelMap modelMap,HttpServletRequest request, HttpServletResponse response,HttpSession session) throws IOException{
		User user =new User();
		user.setName(name);
		user.setPassword(pwd);
		List <User> list=usi.findUserByNameAndPwd(user);
		if(list.isEmpty()){
			modelMap.addAttribute("info", "用户名或密码不正确！");
			return new ModelAndView("login");
		}else{
			session.setAttribute("user", list.get(0));
			response.sendRedirect("query.do"); 
			return new ModelAndView("query");
		}
	}
	@RequestMapping("newLogin")
	public ModelAndView reLogin(ModelMap modelMap){
		return new ModelAndView("login");
	}
	@RequestMapping("userManage")
    public ModelAndView userManage(ModelMap modelMap){
		int recordCount = usi.countUser().getRecordCount();
		PageBean page =new PageBean(recordCount,5,1);
		modelMap.addAttribute("page",page);
		List<User> list = usi.findUsersByPage(page); 
		modelMap.addAttribute("userDo",list);
        return new ModelAndView("user");
    }
	
	@RequestMapping("queryUserByPage")
    public void queryUserByPage(int currentPage,int pageSize){
		int recordCount = usi.countUser().getRecordCount();
		PageBean page =new PageBean(recordCount,pageSize,currentPage);
		List<User> list = usi.findUsersByPage(page); 
        this.data=list;
        this.page=page;
        this.outPutPage();
    }
	
	
	@RequestMapping("addUser")
    public ModelAndView addUser(String name,int type,String password,ModelMap modelMap){
		User user=new User();
		user.setId(usi.findMaxId()+1);
		user.setName(name);
		user.setType(type);
		user.setPassword(password);
		int i = usi.insertUser(user);
		modelMap.addAttribute("info",i);
		int recordCount = usi.countUser().getRecordCount();
		PageBean page =new PageBean(recordCount,5,1);
		modelMap.addAttribute("page",page);
		List<User> list = usi.findUsersByPage(page); 
		modelMap.addAttribute("userDo",list);
        return new ModelAndView("user");
    }
	
	@RequestMapping("updateUser")
    public ModelAndView updateUser(int id,String name,int type,String password,ModelMap modelMap){
		User user=new User();
		user.setId(id);
		user.setName(name);
		user.setType(type);
		user.setPassword(password);
		int i = usi.updateUser(user);
		modelMap.addAttribute("info",i);
		int recordCount = usi.countUser().getRecordCount();
		PageBean page =new PageBean(recordCount,5,1);
		modelMap.addAttribute("page",page);
		List<User> list = usi.findUsersByPage(page); 
		modelMap.addAttribute("userDo",list);
        return new ModelAndView("user");
    }
	
	@RequestMapping("queryUserById")
    public  void queryUserById(HttpServletRequest request){
		int id = Integer.valueOf(request.getParameter("id")).intValue();
        this.setData(usi.findUserById(id)); 
        this.outPut();
    }
	
	@RequestMapping("deleteUsers")
    public  void deleteUsers(String idList){
		String id[] =idList.split(",");
        for(int i=0;i<id.length;i++){
        	usi.deleteUser(Integer.valueOf(id[i]).intValue());
        }
        int recordCount = usi.countUser().getRecordCount();
		PageBean page =new PageBean(recordCount,5,1);
		List<User> list = usi.findUsersByPage(page);
		this.setPage(page);
        this.setData(list);
        this.outPutPage();
    }
	

}
