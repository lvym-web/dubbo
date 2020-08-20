package com.lvym.web.controller;


import com.lvym.common.DataGridView;
import com.lvym.service.BillTypeService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("billtype")
public class BilltypeController {

    @Reference
    private BillTypeService billTypeService;


    @GetMapping("loadAllBillType")
    @ResponseBody
    public DataGridView loadAllBillType(){
        return this.billTypeService.queryAllBillType();
    }

}
