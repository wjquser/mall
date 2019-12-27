package com.macro.mall.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.SmsFlashPromotion;
import com.macro.mall.service.SmsFlashPromotionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 限时购活动管理controller
 */
@Controller
@RequestMapping("/flash")
@Api(tags = "SmsFlashPromotionController" , description = "限时购活动管理")
public class SmsFlashPromotionController {

    @Autowired
    private SmsFlashPromotionService flashPromotionService;

    @ApiOperation(("获取活动详情"))
    @GetMapping(value = "/{id}")
    @ResponseBody
    public Object getItem(@PathVariable Long id){
        SmsFlashPromotion flashPromotion = flashPromotionService.getItem(id);
        return CommonResult.success(flashPromotion);
    }

    @ApiOperation("根据活动名称分页")
    @GetMapping(value = "/list")
    @ResponseBody
    public Object getItem(@RequestParam(value = "keyword" , required = false) String keyword,
                          @RequestParam(value = "pageSize" , defaultValue = "5") Integer pageSize,
                          @RequestParam(value = "pageNum" , defaultValue = "1") Integer pageNum) {
        List<SmsFlashPromotion> flashPromotionList = flashPromotionService.list(keyword , pageSize , pageNum);
        return CommonResult.success(CommonPage.restPage(flashPromotionList));
    }

    @ApiOperation("添加活动")
    @PostMapping(value = "/create")
    @ResponseBody
    public CommonResult create(@RequestBody SmsFlashPromotion flashPromotion){
        int count = flashPromotionService.create(flashPromotion);
        if (count > 0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改上线下线状态")
    @PostMapping(value = "/update/status/{id}")
    @ResponseBody
    public Object update(@PathVariable Long id , Integer status){
        int count = flashPromotionService.updateStatus(id , status);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改活动信息")
    @PostMapping(value = "/update/{id}")
    @ResponseBody
    public Object Updata(@PathVariable Long id , @RequestBody SmsFlashPromotion flashPromotion){
        int count = flashPromotionService.update(id , flashPromotion);
        if (count > 0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除活动信息")
    @PostMapping(value = "/delete/{id}")
    @ResponseBody
    public Object delete(@PathVariable Long id){
        int count = flashPromotionService.delete(id);
        if(count > 0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
}
