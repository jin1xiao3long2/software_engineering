package csmen.group.project.dao;

import csmen.group.project.entity.DiseaseInfo;
import org.apache.ibatis.annotations.Param;
import javax.print.Doc;
import java.util.List;

public interface DiseaseDao {
	List<DiseaseInfo> querybynameandinfo(@Param("text") String text);
}
