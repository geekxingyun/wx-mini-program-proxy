package com.xingyun.wxminiprogramproxy.framework.util;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/***
 * @author qingfeng.zhao
 * @date 2023/5/7
 * @apiNote
 */
public class SmartStringUtils {
    public static synchronized Long generateSnowFakeId(){
        return SnowFlakeUtils.nextId();
    }
    public static synchronized String generateSnowFakeIdStr(){
        return String.valueOf(SnowFlakeUtils.nextId());
    }
    /**
     * 获取uuid
     * @return
     */
    public static String getUuid(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
    /**
     * 获取任意位数的UUID
     * @return
     */
    public static String getCustomizedDigitsUuid(Integer digits){
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0,digits);
    }
    /**
     * 截取手机号后四位
     * @param phone
     * @return
     */
    public static String partEndFourBitPhone(String phone){
        if(null==phone){
            return null;
        }
        if(phone.length()<11){
            return null;
        }
        return phone.substring(phone.length()-4);
    }
    /**
     * 生成任意范围的随机数
     * @param min
     * @param max
     * @return
     */
    public static Integer autoAnyRandomThumbNumber(Integer min,Integer max){
        //Random random = new Random();
        //random.nextInt((max-min)+1)+min;
        //return random.nextInt(max)%(max-min+1) + min;
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    public static String trimToNull(String str) {
        String ts = trim(str);
        if(null!=ts && ts.equals("null")){
            return null;
        }
        return isEmpty(ts) ? null : ts;
    }
    private static String trim(String str) {
        return str == null ? null : str.trim();
    }
    private static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }
    /**
     * 禁用构造方法
     */
    private SmartStringUtils(){}
}
