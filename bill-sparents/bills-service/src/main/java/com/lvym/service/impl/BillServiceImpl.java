package com.lvym.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lvym.common.DataGridView;
import com.lvym.domain.BillType;
import com.lvym.domain.Bills;
import com.lvym.mapper.BillTypeMapper;
import com.lvym.mapper.BillsMapper;
import com.lvym.service.BillService;
import com.lvym.vo.BillsVo;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillsMapper billsMapper;

    @Autowired
    private BillTypeMapper billTypeMapper;


    @Override
    public DataGridView queryAll(BillsVo billsVo) {

        Page<Bills> billsPage=new Page<>(billsVo.getPage(),billsVo.getLimit());
        QueryWrapper<Bills> wrapper = new QueryWrapper<>();
        wrapper.eq(billsVo.getTypeid()!=null,"typeid",billsVo.getTypeid());
        wrapper.ge(billsVo.getStartTime()!=null,"billtime",billsVo.getStartTime());
        wrapper.le(billsVo.getEndTime()!=null,"billtime",billsVo.getEndTime());
        wrapper.orderByDesc("billtime");
        billsMapper.selectPage(billsPage,wrapper);

        List<Bills> records = billsPage.getRecords();
        for (Bills record : records) {
            BillType billType = billTypeMapper.selectById(record.getTypeid());
            billsVo.setTypename(billType.getName());
        }
        return new DataGridView(billsPage.getTotal(), billsVo);
    }

    @Override
    public void addBills(Bills bills) {
        bills.setBilltime(new Date());
          billsMapper.insert(bills);
    }
}
