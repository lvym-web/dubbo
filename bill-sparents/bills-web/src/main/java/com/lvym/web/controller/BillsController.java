package com.lvym.web.controller;


import com.lvym.common.DataGridView;
import com.lvym.common.ResultObj;
import com.lvym.domain.Bills;
import com.lvym.service.BillService;
import com.lvym.vo.BillsVo;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("bills")
public class BillsController {

    @Reference
    private BillService billsService;

    @GetMapping("/loadAllBills")
    @ResponseBody
    public DataGridView loadAllBills(BillsVo billsVo){
        return billsService.queryAll(billsVo);
    }

    @PostMapping("/addBills")
    public ResultObj addBills(Bills bills){
        try {
            billsService.addBills(bills);
             return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }

    }





}
