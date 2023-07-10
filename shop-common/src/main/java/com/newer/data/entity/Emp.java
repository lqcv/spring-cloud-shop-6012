package com.newer.data.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * EMP
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("EMP")
public class Emp implements Serializable {
    @TableId(value = "EMPNO",type = IdType.AUTO)
    private Integer empno;

    private String ename;

    private String job;

    private Short mgr;

    private Date hiredate;

    private Integer sal;

    private Integer comm;

    private Integer deptno;

    private static final long serialVersionUID = 1L;
}