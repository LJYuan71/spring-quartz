package tk.ljyuan71.task.test;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class TaskJDBCTest1 {
	public final Logger log = Logger.getLogger(this.getClass());
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 
	public void run() {
		for (int i = 0; i < 5; i++) {
			log.debug(i+" run......................................" + sdf.format(new Date()));
		}

	}

	public void run1() {
		for (int i = 0; i < 1; i++) {
			log.debug(i+" run1......................................" + sdf.format(new Date()));
		}
	}
	
	public static void main(String[] args) {
		String c=null;
	    Map<String, Charset> charsets = Charset.availableCharsets();
	    for (Map.Entry<String, Charset> entry : charsets.entrySet()) {
	       System.out.println(entry.getKey());
	    }

	}
}
