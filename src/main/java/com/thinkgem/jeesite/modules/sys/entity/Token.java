package com.thinkgem.jeesite.modules.sys.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * 描述:
 * 用户权限密匙类（核心库密匙）
 *
 * @author X_P
 * @create 2018-03-20 15:27
 */
public class Token implements Serializable{
    private static final long serialVersionUID = 8793930810455344702L;
    /**
     * 主键
     */
    private String id;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 密匙账户
     */
    private String tokenName;
    /**
     * 密匙密码
     */
    private String password;
    /**
     * 密匙对应的角色id
     */
    private String roleId;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 删除标记 0为存在，其余为已删除

     */
    private String delFlag;

    /**
     * 密匙状态，0为正常，1为失效
     * @return
     */
    private String state;

    @Override
    public String toString() {
        return "Token{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", tokenName='" + tokenName + '\'' +
                ", password='" + password + '\'' +
                ", roleId='" + roleId + '\'' +
                ", remarks='" + remarks + '\'' +
                ", delFlag='" + delFlag + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTokenName() {
        return tokenName;
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return Objects.equals(id, token.id) &&
                Objects.equals(userId, token.userId) &&
                Objects.equals(tokenName, token.tokenName) &&
                Objects.equals(password, token.password) &&
                Objects.equals(roleId, token.roleId) &&
                Objects.equals(remarks, token.remarks) &&
                Objects.equals(delFlag, token.delFlag);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, tokenName, password, roleId, remarks, delFlag);
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

}