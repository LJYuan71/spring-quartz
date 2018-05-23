package tk.ljyuan71.task.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author ljyuan 2018年5月18日
 * @Description:  
 */
@Component
public class TaskRAMTest1 {
	public final Logger log = Logger.getLogger(this.getClass());
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public void say() throws InterruptedException {
		System.out.println(" TaskRAMTest1  开始说话......................................" + sdf.format(new Date()));
		Thread.sleep(5000);
		System.out.println(" TaskRAMTest1  结束说话......................................" + sdf.format(new Date()));
	}
	
	public void fight() {
		System.out.println(" TaskRAMTest1  fight......................................" + sdf.format(new Date()));
	}
	
}
