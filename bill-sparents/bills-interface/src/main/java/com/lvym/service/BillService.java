package com.lvym.service;

import com.lvym.common.DataGridView;
import com.lvym.domain.Bills;
import com.lvym.vo.BillsVo;

public interface BillService {
    /**
     * 全查询
     * @param billsVo
     * @return
     */
    DataGridView queryAll(BillsVo billsVo);

    /**
     * 添加
     * @param bills
     */
    void addBills(Bills bills);

}
