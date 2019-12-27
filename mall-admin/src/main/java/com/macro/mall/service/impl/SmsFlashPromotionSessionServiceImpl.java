package com.macro.mall.service.impl;

import com.macro.mall.mapper.SmsFlashPromotionSessionMapper;
import com.macro.mall.model.SmsCouponExample;
import com.macro.mall.model.SmsFlashPromotionSession;
import com.macro.mall.model.SmsFlashPromotionSessionExample;
import com.macro.mall.service.SmsFlashPromotionSessionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SmsFlashPromotionSessionServiceImpl implements SmsFlashPromotionSessionService {

    @Resource
    private SmsFlashPromotionSessionMapper flashPromotionSessionMapper;

    @Override
    public List<SmsFlashPromotionSession> list() {
        SmsFlashPromotionSessionExample smsFlashPromotionSessionExample = new SmsFlashPromotionSessionExample();
        return flashPromotionSessionMapper.selectByExample(smsFlashPromotionSessionExample);
    }

    @Override
    public int create(SmsFlashPromotionSession flashPromotionSession) {
        flashPromotionSession.setCreateTime(new Date());
        return flashPromotionSessionMapper.insert(flashPromotionSession);
    }

    @Override
    public int delete(Long id) {
        return flashPromotionSessionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Long id, SmsFlashPromotionSession flashPromotionSession) {
        SmsFlashPromotionSession promotionSession = new SmsFlashPromotionSession();
        return 0;
    }
}
