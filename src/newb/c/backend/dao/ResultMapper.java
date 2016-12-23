package newb.c.backend.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import newb.c.model.RepList;
import newb.c.model.Result;
import newb.c.service.common.MyMapper;

/*@Repository*/
public interface ResultMapper extends MyMapper<Result> {
	@Select("SELECT F_1 result ,count(F_1) count FROM RESULT GROUP BY F_1")
	List<RepList> getRepList();
	
	
}