package csmen.group.project.Controller;

import csmen.group.project.dao.*;
import csmen.group.project.entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.annotation.Resources;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import java.io.*;

@Controller
public class ForumController {
	@Resource
	ForumDao fd;
	
	@Resource
	ReplyDao rd;
	
	@RequestMapping("/goForum")
	public String GoForum(Model model)
	{
		List<ForumInfo> forumInfo = fd.selectAll();
		if(forumInfo.size() != 0)
		{
		//	System.out.print("S");
		}
		model.addAttribute("foruminfo", forumInfo);
		model.addAttribute("foruminfosize", forumInfo.size());
		return "/Forum/Forum";
	}
	
	@RequestMapping("/selectTopic/{id}")
	public String SelectTopic(@PathVariable("id") Integer id, Model model)
	{
		ForumInfo topicInfo = fd.selectById(id);
		String topic =topicInfo.getTopic();
		List<ReplyInfo> replyInfo = rd.selectByTopic(topic);
		model.addAttribute("replyinfo", replyInfo);
		model.addAttribute("topic", topicInfo);
		return "/Forum/TopicInfo";
	}
	
	@RequestMapping("/Forum/gotoReply")
	public String GoReply(@RequestParam("content") String content, @ModelAttribute(value = "ReplyInfo") ReplyInfo replyinfo)
	{
		try
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("G:/SEName/name.txt"),"utf-8"));
			String name = in.readLine();
			if(name != null)
			{
				System.out.println(name + " " + name.length());
				System.out.println(replyinfo.getContent());
			}
			in.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "/Home";
	}
}
