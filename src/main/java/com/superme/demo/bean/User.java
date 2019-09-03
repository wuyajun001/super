package com.superme.demo.bean;

import lombok.Data;

import java.io.Serializable;


@Data
public class User implements Serializable {

    private static final long serialVersionUID = -3754406030238565208L;

    private Long memberId;

    private String memberName;

    private String garden;

}
