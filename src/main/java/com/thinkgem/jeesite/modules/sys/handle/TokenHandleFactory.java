package com.thinkgem.jeesite.modules.sys.handle;

import com.thinkgem.jeesite.modules.sys.entity.Token;

/**
 * 描述:
 * 密匙执行器工厂类
 *
 * @author X_P
 * @create 2018-06-05 11:00
 */
public class TokenHandleFactory {

    private static final String SY = "/loseJob/unit/bindingCheckquery.json";
    private static final String GS = "GS";
    private static final String YB = "YB";

    /**
     * 利用token创建token执行器
     * @param token
     * @return
     */
    public static TokenHandler build(Token token){
        String remarks = token.getRemarks();
        if(SY.equals(remarks)){
            return new SyTokenHandler(token);
        }else if(GS.equals(remarks)){
            return new GsTokenHandler(token);
        } else if (YB.equals(remarks)) {
            return new YBTokenHandler(token);
        }
        return null;
    }

}