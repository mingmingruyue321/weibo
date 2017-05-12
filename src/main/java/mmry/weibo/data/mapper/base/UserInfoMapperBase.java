package mmry.weibo.data.mapper.base;

import java.util.List;
import mmry.weibo.data.domain.UserInfoDto;
import org.apache.ibatis.annotations.Param;

/**
 * InnoDB free: 30720 kB
 * @author mmry
 * @version 1.0
 * @generated 2017-05-12 06:33
 * ★★★警告：本文件不允许手动修改，如要增加方法，请手动在子接口中配置★★★
 */
public interface UserInfoMapperBase {


    /**
     * 按主键删除
     * @param userId 用户id
     * @return int 删除的条数
     */
    int deleteByPrimaryKey (@Param("userId")String userId);
    /**
     * 按 UserInfoDto 不为空的字段&&
     * @param UserInfoDto userInfoDto
     * @return int 删除的条数
     */
    int deleteByUserInfoDto (UserInfoDto userInfoDto);
    /**
     * 插入一条数据
     * @param UserInfoDto userInfoDto
     * @return int 插入的条数
     */
    int insert (UserInfoDto userInfoDto);
    /**
     * 批量插入多条数据，最好分批次，sql的最大长度有限，建议500
     * @param List<UserInfoDto> userInfoDtos
     * @return int 批量插入多条数据的条数
     */
    int insertBatch (List<UserInfoDto> userInfoDtos);
    /**
     * 按主键查询
     * @param userId 用户id
     * @return UserInfoDto userInfoDto
     */
    UserInfoDto selectByPrimaryKey (@Param("userId")String userId);
    /**
     * 按 UserInfoDto 不为空的字段&&查询
     * @param UserInfoDto userInfoDto
     * @return List<UserInfoDto> userInfoDtos
     */
    List<UserInfoDto> selectByUserInfoDto (UserInfoDto userInfoDto);
    /**
     * 按主键更新 UserInfoDto 不为空的字段
     * @param UserInfoDto userInfoDto
     * @return int 更新的条数
     */
    int updateByPrimaryKeySelective (UserInfoDto userInfoDto);
    /**
     * 按主键更新 UserInfoDto 全部的字段
     * @param UserInfoDto userInfoDto
     * @return int 更新的条数
     */
    int updateByPrimaryKey (UserInfoDto userInfoDto);
    /**
     * 批量按主键更新 UserInfoDtos 全部的字段
     * @param List<UserInfoDto> userInfoDtos
     * @return int 批量更新的条数
     */
    int updateByPrimaryKeyBatch (List<UserInfoDto> userInfoDtos);
    /**
     * 批量按主键更新 UserInfoDto 不为空的字段
     * @param List<UserInfoDto> userInfoDtos
     * @return int 更新的条数
     */
    int updateByPrimaryKeySelectiveBatch (List<UserInfoDto> userInfoDtos);

}