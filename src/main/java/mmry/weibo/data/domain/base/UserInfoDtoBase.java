package mmry.weibo.data.domain.base;

import java.util.Date;
import java.io.Serializable;

/**
 * InnoDB free: 30720 kB
 * @author mmry
 * @version 1.0
 * @generated 2017-05-12 08:02
 * ★★★警告：本文件不允许手动修改，如表结构变更，请用工具生成替换★★★
 */
public class UserInfoDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private String userId;
    /**
     * 昵称
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 所在地
     */
    private String address;
    /**
     * 简介
     */
    private String introduce;
    /**
     * 注册时间
     */
    private Date registerDate;
    /**
     * 标签
     */
    private String tag;
    /**
     * 备注
     */
    private String remark;
    /**
     * 公司
     */
    private String company;
    /**
     * 等级
     */
    private String level;

    /**
     * @return userId
     * 用户id
     */
    public String getUserId() {
        return userId;
    }
    /**
     * @return name
     * 昵称
     */
    public String getName() {
        return name;
    }
    /**
     * @return sex
     * 性别
     */
    public String getSex() {
        return sex;
    }
    /**
     * @return address
     * 所在地
     */
    public String getAddress() {
        return address;
    }
    /**
     * @return introduce
     * 简介
     */
    public String getIntroduce() {
        return introduce;
    }
    /**
     * @return registerDate
     * 注册时间
     */
    public Date getRegisterDate() {
        return registerDate;
    }
    /**
     * @return tag
     * 标签
     */
    public String getTag() {
        return tag;
    }
    /**
     * @return remark
     * 备注
     */
    public String getRemark() {
        return remark;
    }
    /**
     * @return company
     * 公司
     */
    public String getCompany() {
        return company;
    }
    /**
     * @return level
     * 等级
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param userId
     * 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
    /**
     * @param name
     * 昵称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
    /**
     * @param sex
     * 性别
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }
    /**
     * @param address
     * 所在地
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
    /**
     * @param introduce
     * 简介
     */
    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }
    /**
     * @param registerDate
     * 注册时间
     */
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
    /**
     * @param tag
     * 标签
     */
    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }
    /**
     * @param remark
     * 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
    /**
     * @param company
     * 公司
     */
    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }
    /**
     * @param level
     * 等级
     */
    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

}