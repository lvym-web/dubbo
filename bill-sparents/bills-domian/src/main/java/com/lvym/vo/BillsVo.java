package com.lvym.vo;


import com.lvym.domain.Bills;
import lombok.Data;
import lombok.EqualsAndHashCode;


import java.util.Date;

/**
 * @program: bills
 * @author: 雷哥
 * @create: 2019-12-21 10:35
 **/
@Data
@EqualsAndHashCode(callSuper=false)
public class BillsVo extends Bills {

    private Integer page;
    private Integer limit;
    private Date startTime;
    private Date endTime;
}
