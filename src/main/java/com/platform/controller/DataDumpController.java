package com.platform.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.platform.model.Backup;
import com.platform.model.User;
import com.platform.service.impl.ModelDataServiceImpl;

@Controller
@RequestMapping("/")
public class DataDumpController extends BaseJsonAction{
	
	@Autowired
	ModelDataServiceImpl mdsi = new ModelDataServiceImpl();
	
	@RequestMapping("dumpData") 
	public ModelAndView dumpData(ModelMap modelMap){
		List<String> list=mdsi.getTableList();
		List<Backup> backupList = new ArrayList<Backup>();
		for (int i = 0; i < list.size(); i++) {
			Backup back = new Backup();
			
			String [] split=list.get(i).split("_");
			back.setName(list.get(i));
			back.setId(i+1);
			back.setDate(split[1]);
			back.setOperater(split[2]);
			backupList.add(back);
		}
		modelMap.addAttribute("backupList",backupList);
        return new ModelAndView("datadump");
    }
	
	
	@RequestMapping("backup")
	public ModelAndView backup(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap,HttpSession session){
		User user=(User) request.getSession().getAttribute("user");
		String tableName = "MD_";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		tableName+=dateFormat.format(new Date());
		tableName+="_"+user.getName().toUpperCase();
		mdsi.backupModelData(tableName);
		mdsi.addPrimaryKey(tableName);
		List<String> list=mdsi.getTableList();
		List<Backup> backupList = new ArrayList<Backup>();
		for (int i = 0; i < list.size(); i++) {
			Backup back = new Backup();
			
			String [] split=list.get(i).split("_");
			back.setName(list.get(i));
			back.setId(i+1);
			back.setDate(split[1]);
			back.setOperater(split[2]);
			backupList.add(back);
		}
		modelMap.addAttribute("backupList",backupList);
        return new ModelAndView("datadump");
	}
	
	@RequestMapping("deleteBackups")
		public ModelAndView deleteBackups(String nameList, ModelMap modelMap){
			String names[] =nameList.split(",");
			for (int i = 0; i < names.length; i++) {
				mdsi.dropBackupTable(names[i]);
			}
			List<String> list=mdsi.getTableList();
			List<Backup> backupList = new ArrayList<Backup>();
			for (int i = 0; i < list.size(); i++) {
				Backup back = new Backup();
				
				String [] split=list.get(i).split("_");
				back.setName(list.get(i));
				back.setId(i+1);
				back.setDate(split[1]);
				back.setOperater(split[2]);
				backupList.add(back);
			}
			System.out.println("执行删除＋＋＋＋＋＋＋＋＋");
			modelMap.addAttribute("backupList",backupList);
			this.setData(backupList);
			this.outPut();
	        return new ModelAndView("datadump");
		}
	
	@RequestMapping("resume")
	public void resume(String backName){
		String tableName="MODELDATA";
		mdsi.deleteCurTableContent(tableName);
		mdsi.importBackupTable(backName);
		String [] name= backName.split("_");
		this.setData("数据恢复成功，为"+name[1]+"时数据！");
		this.outPut();
	}
}