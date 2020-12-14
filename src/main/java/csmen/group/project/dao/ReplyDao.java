package csmen.group.project.dao;

import csmen.group.project.entity.ReplyInfo;
import org.apache.ibatis.annotations.Param;

import javax.print.Doc;
import java.util.List;

public interface ReplyDao {
	List<ReplyInfo> selectByTopic(String topic);
	
	int addReply(ReplyInfo reply);
}
