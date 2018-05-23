package tk.ljyuan71.quartz.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 官方数据库实现的定时任务job
 */
public class HelloWorldJob implements Job{
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("----jdbc开始执行定时任务 hello world---" + sdf.format(new Date()));
	}

}
