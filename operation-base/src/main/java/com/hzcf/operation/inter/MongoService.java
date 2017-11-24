package com.hzcf.operation.inter;
import com.hzcf.operation.base.entity.PageInfo;
import com.hzcf.operation.base.result.ErrorLogQueryDto;
import com.hzcf.operation.base.result.InterfaceQueryEntity;
import com.hzcf.operation.base.result.LogQuery;
import com.hzcf.operation.gen.entity.ErrorLog;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface MongoService {

	public List<ErrorLog> getErrorLogs(Date start,Date end);
	Map getPv(String type, Date start, Date end);
	public Map getTimeUsed(Date start, Date end);
	public Map getState(Date start, Date end);
	public Map getError(String id);
	//InterfaceQueryEntity
	public List<LogQuery> getLogQuery(ErrorLogQueryDto params);
	public PageInfo getLogQueryCount(InterfaceQueryEntity params);
	public Map getLogDetail(String id);

}
