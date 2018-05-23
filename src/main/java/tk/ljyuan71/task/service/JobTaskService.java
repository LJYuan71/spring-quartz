package tk.ljyuan71.task.service;

import java.util.List;

import org.quartz.SchedulerException;

import tk.ljyuan71.task.entity.ScheduleJob;

/**
 * 自定义数据库实现定时任务Service
 */
public interface JobTaskService {
	/** 获取所有任务 */
	List<ScheduleJob> getAllTask();
	/** 添加任务 */
	void addTask(ScheduleJob job);
	/** 获取单任务 */
	ScheduleJob getTaskById(Long jobId);
	/** 改变任务状态(启动/停止) */
	void changeStatus(Long jobId, String cmd) throws SchedulerException;
	/** 更新cron表达式 */
	void updateCron(Long jobId, String cron) throws SchedulerException;

}
