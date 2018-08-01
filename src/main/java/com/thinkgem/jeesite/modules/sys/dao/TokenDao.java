package com.thinkgem.jeesite.modules.sys.dao;

import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sys.entity.Token;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述:
 * 密匙操作Dao接口
 *
 * @author X_P
 * @create 2018-03-20 15:40
 */
@MyBatisDao
public interface TokenDao {

    /**
     * 获取密匙，通过userid
     * @param userId
     * @return
     */
     List<Token> getTokensByUserId(@Param("userId") String userId);

    /**
     *  插入新的密匙
     * @param token
     */
    void insertToken(Token token);

    /**
     * 根据id删除密匙
     * @param id
     */
    void delToken(@Param("id") String id);

    /**
     * 更新token
     * @param token
     */
    void update(Token token);
}
