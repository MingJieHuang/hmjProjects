package com.phone.erp.boss.util;

import com.phone.erp.base.Result;
import com.phone.erp.boss.vo.common.BossQueryVo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * [Boss报表工具类]
 *
 * @author HMJ
 * @version [版本, 2018-5-4]
 * @see
 */
@SuppressWarnings("all")
public class BossReportUtil {
    private static Logger logger = LoggerFactory.getLogger(BossReportUtil.class);

	/*
     * -----------------------------------直接调用------------------------------------
	 */
    /**
     * 获取当前服务器日期 yyyy-mm-dd
     * 时间的格式:YYYY/MM/dd HH:mm:ss
     */
    public static String getCurDate(String timeFormat){
        timeFormat= StringUtils.isBlank(timeFormat)?"yyyy-MM-dd":timeFormat;
        Calendar cale = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat(timeFormat);
        return format.format(cale.getTime());
    }

    /**
     * 获取rpDataRedisKey
     */
    public static String getRpDataRedisKey(BossQueryVo queryVo){
        StringBuffer sb = new StringBuffer();
        String rpDataRedisKey = sb.append(queryVo.getEmployeeVo().getId()).append("_").
                append(queryVo.getMenuCode()).append("_").append(getCurDate("YYYY/MM/dd HH:mm:ss")).toString();
        return rpDataRedisKey;
    }
    /**
     * 拼接一个集合中对象的某一个字段,已逗号分隔,如:获取公司ids
     *
     * @param List      <T> 集合
     * @param fieldCode 需要拼接字段的code
     */
    public static <T> String getFieldStr(List<T> dataList, String field) throws Exception {
        if (CollectionUtils.isEmpty(dataList)) {
            return "";
        } else {
            Class<? extends Object> clazz = dataList.get(0).getClass();
            Field field2 = null;
            for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
                try { //反射获取父类字段
                    field2 = clazz.getDeclaredField(field);
                } catch (Exception e) {
                    //这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
                    //如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了
                }
            }
            if (null == field2) {
                throw new RuntimeException("该对象以及所有父类对象中不含字段:" + field);
            }
            field2.setAccessible(true);
            StringBuilder sb = new StringBuilder();
            for (T t : dataList) {
                sb.append(field2.get(t)).append(",");
            }
            return sb.substring(0, sb.length() - 1).toString();
        }
    }

    /**
     * 报表查询成功返回result
     *
     * @param Result  需要设置的result对象
     * @param descStr 描述字符串
     */
    public static Result getSuccessResult(Result result, String descStr) {
        result.setCode("0000");
        result.setDesc(descStr + "成功!!");
        return result;
    }

    /**
     * 报表查询失败返回result
     *
     * @param Result  需要设置的result对象
     * @param descStr 描述字符串
     */
    public static Result getFailingResult(Result result, String descStr) {
        result.setCode("-999");
        result.put("dataList", new ArrayList());
        result.setDesc(descStr + "失败!!");
        return result;
    }

}
