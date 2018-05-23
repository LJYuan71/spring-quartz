package tk.ljyuan71.task.controller;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tk.ljyuan71.support.RetObj;
import tk.ljyuan71.support.spring.SpringUtils;
import tk.ljyuan71.task.entity.ScheduleJob;
import tk.ljyuan71.task.service.impl.JobTaskServiceImpl;
/**
 * 自定义数据库实现的定时任务
 */
@Controller
@RequestMapping("/task")
public class JobTaskController {
	// 日志记录器
	public final Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private JobTaskServiceImpl taskService;

	@RequestMapping("/taskList")
	public String taskList(HttpServletRequest request) {
		List<ScheduleJob> taskList = taskService.getAllTask();
		request.setAttribute("taskList", taskList);
		return "task/taskList";
	}

	@RequestMapping("/add")
	@ResponseBody
	public RetObj taskList(HttpServletRequest request, ScheduleJob scheduleJob) {
		RetObj retObj = new RetObj();
		retObj.setFlag(false);
		try {
			CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression());
		} catch (Exception e) {
			retObj.setMsg("cron表达式有误，不能被解析！");
			return retObj;
		}
		Object obj = null;
		try {
			if (StringUtils.isNotBlank(scheduleJob.getSpringId())) {
				obj = SpringUtils.getBean(scheduleJob.getSpringId());
			} else {
				Class clazz = Class.forName(scheduleJob.getBeanClass());
				obj = clazz.newInstance();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (obj == null) {
			retObj.setMsg("未找到目标类！");
			return retObj;
		} else {
			Class clazz = obj.getClass();
			Method method = null;
			try {
				method = clazz.getMethod(scheduleJob.getMethodName(), null);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (method == null) {
				retObj.setMsg("未找到目标方法！");
				return retObj;
			}
		}
		try {
			taskService.addTask(scheduleJob);
		} catch (Exception e) {
			e.printStackTrace();
			retObj.setFlag(false);
			retObj.setMsg("保存失败，检查 name group 组合是否有重复！");
			return retObj;
		}

		retObj.setFlag(true);
		return retObj;
	}

	@RequestMapping("/changeJobStatus")
	@ResponseBody
	public RetObj changeJobStatus(HttpServletRequest request, Long jobId, String cmd) {
		RetObj retObj = new RetObj();
		retObj.setFlag(false);
		try {
			taskService.changeStatus(jobId, cmd);
		} catch (SchedulerException e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();
			retObj.setMsg("任务状态改变失败！");
			return retObj;
		}
		retObj.setFlag(true);
		return retObj;
	}

	@RequestMapping("/updateCron")
	@ResponseBody
	public RetObj updateCron(HttpServletRequest request, Long jobId, String cron) {
		RetObj retObj = new RetObj();
		retObj.setFlag(false);
		try {
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
		} catch (Exception e) {
			e.printStackTrace();
			retObj.setMsg("cron表达式有误，不能被解析！");
			return retObj;
		}
		try {
			taskService.updateCron(jobId, cron);
		} catch (SchedulerException e) {
			e.printStackTrace();
			retObj.setMsg("cron更新失败！");
			return retObj;
		}
		retObj.setFlag(true);
		return retObj;
	}
}
