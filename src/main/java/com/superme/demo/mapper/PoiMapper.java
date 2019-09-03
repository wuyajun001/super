package com.superme.demo.mapper;

import com.superme.demo.bean.PoiUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * description:<POI持久层>
 *
 * @author 武亚军 (wuyajun0928@aliyun.com)
 * @version 1.0
 * @date 2019/9/3 9:41
 */
@Mapper
public interface PoiMapper {

    /**
     * 创建测试数据
     */
    void creatPoiUser(PoiUser poiUser);

    /**
     * 获取总数量
     */
    long getCount();

    /**
     * 查询所有数据
     */
    List<PoiUser> getPoiUsers(@Param("pageStart") long pageStart, @Param("pageSize") long pageSize);
}
