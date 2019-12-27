package com.macro.mall.service;

import com.macro.mall.model.SmsFlashPromotion;

import java.util.List;

public interface SmsFlashPromotionService {
    SmsFlashPromotion getItem(Long id);

    List<SmsFlashPromotion> list(String keyword, Integer pageSize, Integer pageNum);

    int create(SmsFlashPromotion flashPromotion);

    int updateStatus(Long id, Integer status);

    int update(Long id, SmsFlashPromotion flashPromotion);

    int delete(Long id);
}
