package com.superme.demo.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * description:<POI报表测试对象>
 *
 * @author 武亚军 (wuyajun0928@aliyun.com)
 * @version 1.0
 * @date 2019/8/26 19:12
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -3754406030238565208L;

    private Long memberId;

    private String memberName;

    private String garden;

}
