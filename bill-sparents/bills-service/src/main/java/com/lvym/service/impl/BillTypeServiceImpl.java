package com.lvym.service.impl;

import com.lvym.common.DataGridView;
import com.lvym.domain.BillType;
import com.lvym.mapper.BillTypeMapper;
import com.lvym.service.BillTypeService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class BillTypeServiceImpl implements BillTypeService {

    @Autowired
    private BillTypeMapper billTypeMapper;

    @Override
    public DataGridView queryAllBillType() {

        List<BillType> billTypes = billTypeMapper.selectList(null);
        return new DataGridView(Long.valueOf(billTypes.size()),billTypes);
    }
}
