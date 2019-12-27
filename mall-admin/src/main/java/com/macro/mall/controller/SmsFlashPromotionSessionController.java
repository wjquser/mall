package com.macro.mall.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.SmsFlashPromotionSession;
import com.macro.mall.service.SmsFlashPromotionSessionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 活动controller
 */

@Controller
@RequestMapping(value = "/flashSession")
public class SmsFlashPromotionSessionController {

    @Autowired
    private SmsFlashPromotionSessionService flashPromotionSessionService;

    @ApiOperation("秒杀时间段列表查询")
    @GetMapping("/list")
    @ResponseBody
    public CommonResult<List<SmsFlashPromotionSession>> list(){
        List<SmsFlashPromotionSession> promotionSessionList = flashPromotionSessionService.list();
        return CommonResult.success(promotionSessionList);
    }

    @ApiOperation("新增秒杀时间段")
    @PostMapping("/create")
    @ResponseBody
    public Object create(@RequestBody SmsFlashPromotionSession flashPromotionSession){
        int count = flashPromotionSessionService.create(flashPromotionSession);
        if (count > 0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除秒杀时间段")
    @PostMapping("/delete/{id}")
    @ResponseBody
    public Object ddelete(@PathVariable Long id){
        int count = flashPromotionSessionService.delete(id);
        if (count > 0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改秒杀时间段信息")
    @PostMapping("/update/{id}")
    @ResponseBody
    public Object update(@PathVariable Long id , SmsFlashPromotionSession flashPromotionSession){
        int count = flashPromotionSessionService.update(id , flashPromotionSession);
        if(count > 0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

}
