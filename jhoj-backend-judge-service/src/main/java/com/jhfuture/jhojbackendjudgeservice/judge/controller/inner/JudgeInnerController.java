package com.jhfuture.jhojbackendjudgeservice.judge.controller.inner;


import com.jh.jhojbackendmodel.model.entity.QuestionSubmit;
import com.jhfuture.jhojbackendjudgeservice.judge.JudgeService;
import com.jhfuture.jhojbackendserviceclient.service.JudgeFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *  feignClient 服务的 实现类，需要与 client 中定义的客户端保持一致
 */
@RestController
@RequestMapping("/inner")
public class JudgeInnerController implements JudgeFeignClient {

    @Resource
    JudgeService judgeService;

    /**
     * 判题
     * @param questionSubmitId
     * @return
     */
    @Override
    @GetMapping("/doJudge")
  public  QuestionSubmit doJudge(long questionSubmitId){
        return judgeService.doJudge(questionSubmitId);
    };
}
