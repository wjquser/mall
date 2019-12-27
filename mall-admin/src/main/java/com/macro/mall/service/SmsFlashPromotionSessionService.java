package com.macro.mall.service;

import com.macro.mall.model.SmsFlashPromotionSession;

import java.util.List;

public interface SmsFlashPromotionSessionService {
    List<SmsFlashPromotionSession> list();

    int create(SmsFlashPromotionSession flashPromotionSession);

    int delete(Long id);

    int update(Long id, SmsFlashPromotionSession flashPromotionSession);
}
