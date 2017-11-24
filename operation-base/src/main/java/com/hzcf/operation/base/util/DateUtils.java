package com.hzcf.operation.base.util;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by hanlin on 2017年11月9日
 **/
public class DateUtils {
	public static final String ISO_DATE = "yyyy-MM-dd";
	public static final String ISO_DATE_TIME = "yyyy-MM-dd hh:mm;";
	public static Date getTomorrow(Date date){
		Calendar c = Calendar.getInstance();  
        c.setTime(date);  
        c.add(Calendar.DAY_OF_MONTH, 1);// 明天
        Date tomorrow = c.getTime();
		return tomorrow; 
	}



	//日期验证
	public static Map<String, Object> validate(HttpServletRequest request, String bTime, String eTime) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);

		Date beginTime, endTime;
			if (StringUtils.isNotNull(bTime) && StringUtils.isNotNull(eTime)) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					beginTime = sdf.parse(bTime);
					endTime = sdf.parse(eTime);
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(endTime);
					calendar.set(Calendar.HOUR_OF_DAY, 24);
					calendar.set(Calendar.MINUTE, 0);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					endTime = calendar.getTime();

					map.put("beginTime", beginTime);
					map.put("endTime", endTime);
				} catch (Exception e) {
					map.put("success", false);
					map.put("message", ReturnConst.RETMSG_300007);
					map.put("returnCode", ReturnConst.RETCODE_300007);
					return map;
				}
			} else {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			beginTime = calendar.getTime();

			calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, 24);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			endTime = calendar.getTime();
			map.put("beginTime", beginTime);
			map.put("endTime", endTime);
		}
		if (beginTime.getTime() > endTime.getTime()) {
			map.put("success", false);
			map.put("message", ReturnConst.RETMSG_300006);
			map.put("returnCode", ReturnConst.RETCODE_300006);
		}

		return map;
	}
}
