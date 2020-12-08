package csmen.group.project.dao;


import csmen.group.project.entity.HospitalInfo;
import org.apache.ibatis.annotations.Param;
import javax.print.Doc;
import java.util.List;

public interface HospitalDao {
	List<HospitalInfo> querybynameAndinfo(@Param("text") String text);
}
