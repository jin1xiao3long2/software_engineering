package csmen.group.project.dao;

import csmen.group.project.entity.ForumInfo;
import org.apache.ibatis.annotations.Param;

import javax.print.Doc;
import java.util.List;

public interface ForumDao {
	List<ForumInfo> selectAll();
	
	ForumInfo selectById(Integer id);
	
	ForumInfo selectByTopic(String topic);
	
	int addForumTopic(ForumInfo foruminfo);
}
