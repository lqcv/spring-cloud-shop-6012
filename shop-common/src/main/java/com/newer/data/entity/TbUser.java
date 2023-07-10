package com.newer.data.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * TB_USER
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("TB_USER")
public class TbUser implements Serializable {
    @TableId(value = "USER_ID",type = IdType.AUTO)
    private Long userId;
    private String userName;

    private String chName;

    private String password;

    private static final long serialVersionUID = 1L;
}