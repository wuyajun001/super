package com.superme.demo.mapper;


import com.superme.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * description:<会员操作持久层>
 *
 * @author 武亚军 (wuyajun0928@aliyun.com)
 * @version 1.0
 * @date 2019/8/25 11:50
 */
@Mapper
public interface UserMapper {
    /**
     * Description: 查询所有用户
     */
    List<User> getUsers();

}