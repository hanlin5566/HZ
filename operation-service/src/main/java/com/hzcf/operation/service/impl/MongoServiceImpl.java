package com.hzcf.operation.service.impl;

import com.hzcf.operation.base.entity.PageInfo;
import com.hzcf.operation.base.result.ErrorLogQueryDto;
import com.hzcf.operation.base.result.InterfaceQueryEntity;
import com.hzcf.operation.base.result.InterfaceRecordEntity;
import com.hzcf.operation.base.result.LogQuery;
import com.hzcf.operation.base.util.StringUtils;
import com.hzcf.operation.gen.entity.ErrorLog;
import com.hzcf.operation.service.MongoService;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.text.SimpleDateFormat;
import java.util.*;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 *
 */
@Service("mongoService")
public class MongoServiceImpl implements MongoService {

    @Autowired
    @Qualifier(value = "hjAPIpiMongoTemplate")
    protected MongoTemplate mongoTemplate;


    /*@Resource(name = "mongoTemplate")
    public MongoTemplate mongoTemplate;*/

    public static final String collectionErrorName = "log_error";
    public static final String collectionQueryName = "log_query";


    @Override
    public List<ErrorLog> getErrorLogs(Date start, Date end) {
        DBObject dbObject = new BasicDBObject();
        dbObject.put("level", "ERROR");
        //Calendar calendar = Calendar.getInstance();//有8小时时差
        //calendar.set(2017, 10, 20, 16, 28, 0);
        //start = calendar.getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //System.out.println("格式化之后 时间："+df.format(start));
        //System.out.println("转换之后八小时时差："+start);
        DBObject dbObjectTime = new BasicDBObject();
        dbObjectTime.put("$gte", df.format(start));
        dbObject.put("timestamp", dbObjectTime);

        DBObject fieldObject = new BasicDBObject();
        fieldObject.put("_id", true);
        fieldObject.put("timestamp", true);
        fieldObject.put("fileName", true);
        fieldObject.put("message", true);

        Query query_ = new BasicQuery(dbObject, fieldObject);
        List<ErrorLog> list = mongoTemplate.find(query_, ErrorLog.class, collectionErrorName);
        return list;
    }

    @Override
    public Map getError(String id) {
        Map log = mongoTemplate.findById(new ObjectId(id), Map.class, collectionErrorName);
        return log;
    }

    @Override
    public Map getLogDetail(String id) {
        Map log = mongoTemplate.findById(new ObjectId(id), Map.class, collectionQueryName);
        return log;
    }


    /**
     * 按秒统计访问量 默认最近1小时
     * @param type
     * @param start
     * @param end
     * @return
     */
    @Override
    public Map getPv(String type, Date start, Date end) {

        Long last1Hour  =new Date().getTime()-60*60*1000;
        Criteria criteria =new Criteria("timestamp");
        criteria.gte(new Date(last1Hour));
        MatchOperation matchOperation = new MatchOperation(criteria);
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "queryHis"));
        Aggregation aggregation = newAggregation(
                matchOperation,
                group( "message." + type).count().as("count"),
                sort(sort)
        );
        AggregationResults<Map> count = mongoTemplate.aggregate(aggregation, collectionQueryName, Map.class);
        List<Map> logs = count.getMappedResults();
        Map logForSort = new HashMap();
        for (Map map : logs) {
            logForSort.put(map.get("_id"), map.get("count"));
        }
        SortedMap<String, String> sorted = new TreeMap<String, String>(logForSort);
        List<String> x1 = new ArrayList();
        List<String> y1 = new ArrayList();
        Iterator<Map.Entry<String, String>> sortedIt = sorted.entrySet().iterator();
        while (sortedIt.hasNext()) {
            Map.Entry<String, String> entry = sortedIt.next();
            x1.add(entry.getKey());
            y1.add(entry.getValue());
        }
        Map pv = new HashMap();
        pv.put("xAxis", x1);
        pv.put("series", y1);
        return pv;
    }

    @Override
    public Map getTimeUsed(Date start, Date end) {
        Long timeUsed01 = mongoTemplate.count(query(where("message.timeUsed").gte(0).lt(1000)), collectionQueryName);
        Long timeUsed02 = mongoTemplate.count(query(where("message.timeUsed").gte(1000).lt(3000)), collectionQueryName);
        Long timeUsed03 = mongoTemplate.count(query(where("message.timeUsed").gte(3000).lt(5000)), collectionQueryName);
        Long timeUsed04 = mongoTemplate.count(query(where("message.timeUsed").gte(5000).lt(10000)), collectionQueryName);
        Long timeUsed05 = mongoTemplate.count(query(where("message.timeUsed").gte(10000)), collectionQueryName);
        Map<String, Object> timeUsed = new HashMap();
        timeUsed.put("[0,1s)", timeUsed01);
        timeUsed.put("[1,3s)", timeUsed02);
        timeUsed.put("[3,5s)", timeUsed03);
        timeUsed.put("[5,10s)", timeUsed04);
        timeUsed.put("[10,-∞)", timeUsed05);
        Iterator iterator = timeUsed.entrySet().iterator();
        List<Map> series = new ArrayList<Map>();
        while (iterator.hasNext()) {
            Map serie = new HashMap();
            Map.Entry entry = (Map.Entry) iterator.next();
            serie.put("name", entry.getKey());
            serie.put("value", entry.getValue());
            series.add(serie);
        }
        Map ret = new HashMap();
        ret.put("series", series);
        return ret;
    }

    @Override
    public Map getState(Date start, Date end) {
        Long state01 = mongoTemplate.count(query(where("message.state").is("1")), collectionQueryName);
        Long state02 = mongoTemplate.count(query(where("message.state").is("2")), collectionQueryName);
        Long state03 = mongoTemplate.count(query(where("message.state").is("3")), collectionQueryName);
        Long state04 = mongoTemplate.count(query(where("message.state").is("4")), collectionQueryName);
        Map<String, Object> timeUsed = new HashMap();
        timeUsed.put("异常", state01);
        timeUsed.put("有数据", state02);
        timeUsed.put("无数据", state03);
        timeUsed.put("历史数据", state04);
        Iterator iterator = timeUsed.entrySet().iterator();
        List<Map> series = new ArrayList<Map>();
        while (iterator.hasNext()) {
            Map serie = new HashMap();
            Map.Entry entry = (Map.Entry) iterator.next();
            serie.put("name", entry.getKey());
            serie.put("value", entry.getValue());
            series.add(serie);
        }
        Map ret = new HashMap();
        ret.put("series", series);
        return ret;
    }

    @Override
    public List<LogQuery> getLogQuery(InterfaceQueryEntity params) {
        Query query = getQueryForLog(params);
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "_id"));
        List<LogQuery> list = mongoTemplate.find(query.with(sort).skip((params.getPageNo()-1)*params.getPageSize()).limit(params.getPageSize()), LogQuery.class, "log_query");
        return list;
    }

    @Override
    public PageInfo getLogQueryCount(InterfaceQueryEntity params)
    {
        PageInfo page = new PageInfo(params.getPageNo(),params.getPageSize());
        Query query = getQueryForLog(params);
        long count = mongoTemplate.count(query,collectionQueryName);
        page.setTotalCount(Integer.valueOf(String.valueOf(count)));
        return page;
    }
    private Query getQueryForLog(InterfaceQueryEntity params)
    {
        DBObject dbObject = new BasicDBObject();
        if (StringUtils.isNotNull(params.getIdCard())) {
            dbObject.put("message.idCard", params.getIdCard());
        }
        if (StringUtils.isNotNull(params.getName())) {
            dbObject.put("message.name", params.getName());
        }
        if (StringUtils.isNotNull(params.getMobile())) {
            dbObject.put("message.mobile", params.getMobile());
        }
        if (StringUtils.isNotNull(params.getUserId())) {
            dbObject.put("message.userId", params.getUserId());
        }
        if (StringUtils.isNotNull(params.getState())) {
            dbObject.put("message.state", params.getState());
        }
        if (StringUtils.isNotNull(params.getInterfaceType())) {
            dbObject.put("message.interfaceType", params.getInterfaceType());
        }

        if (StringUtils.isNotNull(params.getInterfaceParentType())) {
            dbObject.put("message.interfaceParentType", params.getInterfaceParentType());
        }
        Calendar calendar = Calendar.getInstance();//有8小时时差
        calendar.set(2017, 8, 10, 16, 28, 0);
        Date start = calendar.getTime();
        calendar.set(2018, 8, 10, 16, 28, 0);
        Date end = calendar.getTime();
        DBObject dbObjectTime = new BasicDBObject();
        dbObjectTime.put("$gte", start);
        dbObjectTime.put("$lt", end);
        dbObject.put("message.queryTime", dbObjectTime);
        DBObject fieldObject = new BasicDBObject();
        fieldObject.put("_id", true);
        fieldObject.put("message.interfaceParentType", true);
        fieldObject.put("message.interfaceType", true);
        fieldObject.put("message.timeUsed", true);
        fieldObject.put("message.idCard", true);
        fieldObject.put("message.ipAddress", true);
        fieldObject.put("message.mobile", true);
        fieldObject.put("message.userName", true);
        fieldObject.put("message.queryTime", true);
        fieldObject.put("message.state", true);
        Query query= new BasicQuery(dbObject, fieldObject);
        return query;
    }


    private Query getQueryForLog2(InterfaceQueryEntity params)
    {
        DBObject dbObject = new BasicDBObject();
        if (StringUtils.isNotNull(params.getIdCard())) {
            dbObject.put("message.idCard", params.getIdCard());
        }
        if (StringUtils.isNotNull(params.getName())) {
            dbObject.put("message.name", params.getName());
        }
        if (StringUtils.isNotNull(params.getMobile())) {
            dbObject.put("message.mobile", params.getMobile());
        }
        if (StringUtils.isNotNull(params.getUserId())) {
            dbObject.put("message.userId", params.getUserId());
        }
        if (StringUtils.isNotNull(params.getState())) {
            dbObject.put("message.state", params.getState());
        }
        if (StringUtils.isNotNull(params.getInterfaceType())) {
            dbObject.put("message.interfaceType", params.getInterfaceType());
        }

        if (StringUtils.isNotNull(params.getInterfaceParentType())) {
            dbObject.put("message.interfaceParentType", params.getInterfaceParentType());
        }
       /* Calendar calendar = Calendar.getInstance();//有8小时时差
        calendar.set(2017, 8, 10, 16, 28, 0);
        Date start = calendar.getTime();
        calendar.set(2018, 8, 10, 16, 28, 0);*/
        //Date end = calendar.getTime();
       // DBObject dbObjectTime = new BasicDBObject();
       // dbObjectTime.put("$gte", start);
       // dbObjectTime.put("$lt", end);
       //dbObject.put("message.queryTime", dbObjectTime);
        DBObject fieldObject = new BasicDBObject();
        fieldObject.put("_id", true);
        fieldObject.put("message.interfaceParentType", true);
        fieldObject.put("message.interfaceType", true);
        fieldObject.put("message.timeUsed", true);
        fieldObject.put("message.idCard", true);
        fieldObject.put("message.ipAddress", true);
        fieldObject.put("message.mobile", true);
        fieldObject.put("message.userName", true);
        fieldObject.put("message.queryTime", true);
        fieldObject.put("message.state", true);
        Query query= new BasicQuery(dbObject, fieldObject);
        return query;
    }
    @Override
    public Map getRuleIntoMsg(String taskId, String interfaceParentType, String interfaceType, String releId) {

        InterfaceQueryEntity params = new InterfaceQueryEntity();
        params.setInterfaceParentType(interfaceParentType);
        params.setInterfaceType(interfaceType);
        params.setTaskId(taskId);
        //params.setRuleId(releId);
        Query query = getQueryForLog2(params);
        Map queryMap =  mongoTemplate.findOne(query, Map.class,collectionQueryName);
       // List<InterfaceRecordEntity> list = mongoTemplate.find(query, InterfaceRecordEntity.class,collectionQueryName);
        return queryMap;
    }
}

