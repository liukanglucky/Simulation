package com.platform.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.platform.model.User;
import com.platform.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/")
public class UserController extends BaseJsonAction{
	@Autowired
	private UserServiceImpl usi;
	
	@RequestMapping("welcome")
	public ModelAndView welcome(){
		return new ModelAndView("login");
	}
	
	@RequestMapping("login")
	public ModelAndView login(String name,String pwd,ModelMap modelMap){
		List <User> list=usi.findUserByName(name);
		if(list.isEmpty()){
			modelMap.addAttribute("info", "用户不存在！");
			return new ModelAndView("login");
		}else{
			if(list.get(0).getPwd().equals(pwd)){
				List<User> usersList = usi.findAllUser(); 
				modelMap.addAttribute("userDo",usersList);
				return new ModelAndView("user");
			}else{
				modelMap.addAttribute("info", "密码不正确！");
				return new ModelAndView("login");
			}
			
		}
	}
	
	@RequestMapping("userManage")
    public ModelAndView index(ModelMap modelMap){
		List<User> list = usi.findAllUser(); 
		modelMap.addAttribute("userDo",list);
        return new ModelAndView("user");
    }
	
	@RequestMapping("addUser")
    public ModelAndView addUser(String name,int auth,String pwd,ModelMap modelMap){
		User user=new User();
		user.setName(name);
		user.setAuth(auth);
		user.setPwd(pwd);
		int i = usi.insertUser(user);
		modelMap.addAttribute("info",i);
		List<User> list = usi.findAllUser(); 
		modelMap.addAttribute("userDo",list);
        return new ModelAndView("user");
    }
	
	@RequestMapping("updateUser")
    public ModelAndView updateUser(int id,String name,int auth,String pwd,ModelMap modelMap){
		User user=new User();
		user.setId(id);
		user.setName(name);
		user.setAuth(auth);
		user.setPwd(pwd);
		int i = usi.updateUser(user);
		modelMap.addAttribute("info",i);
		List<User> list = usi.findAllUser(); 
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
    public  ModelAndView deleteUsers(String idList, ModelMap modelMap){
		String id[] =idList.split(",");
        for(int i=0;i<id.length;i++){
        	usi.deleteUser(Integer.valueOf(id[i]).intValue());
        	System.out.println(id[i]);
        }
//        this.setData(1);
//        this.outPut();
        List<User> list = usi.findAllUser(); 
		modelMap.addAttribute("userDo",list);
        return new ModelAndView("user");
    }
}
