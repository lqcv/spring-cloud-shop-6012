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
 * DEPT
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("DEPT")
public class Dept implements Serializable {
    @TableId(value = "DEPTNO",type = IdType.AUTO)
    private Integer deptno;

    private String dname;

    private String loc;

    private static final long serialVersionUID = 1L;
}