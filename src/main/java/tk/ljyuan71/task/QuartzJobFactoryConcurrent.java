package tk.ljyuan71.task;

import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import tk.ljyuan71.task.entity.ScheduleJob;

/**
 * 定时任务接口
 * 若一个方法一次执行不完下次轮转时则等待改方法执行完后才执行下一次操作
 * （Concurrent=false）
 */
@DisallowConcurrentExecution
public class QuartzJobFactoryConcurrent implements Job {
	public final Logger log = Logger.getLogger(this.getClass());

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
		TaskUtils.invokMethod(scheduleJob);//利用反射执行具体类的具体方法
	}
}