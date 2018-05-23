package tk.ljyuan71.task.dao;

import java.util.List;

import tk.ljyuan71.task.entity.ScheduleJob;

public interface ScheduleJobMapper {
	
	int deleteByPrimaryKey(Long jobId);

	int insert(ScheduleJob record);

	int insertSelective(ScheduleJob record);

	ScheduleJob selectByPrimaryKey(Long jobId);

	int updateByPrimaryKeySelective(ScheduleJob record);

	int updateByPrimaryKey(ScheduleJob record);

	List<ScheduleJob> getAll();
}