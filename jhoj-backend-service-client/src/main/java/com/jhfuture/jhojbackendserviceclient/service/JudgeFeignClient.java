package com.jhfuture.jhojbackendserviceclient.service;


import com.jh.jhojbackendmodel.model.entity.QuestionSubmit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 判题服务,当调用的 时候，feign会自动从 nacos 注册中心中获取对应的服务，
 */
@FeignClient(name = "jhoj-backend-judge-service",path = "/api/judge/inner")
public interface JudgeFeignClient {

    /**
     * 判题
     * @param questionSubmitId
     * @return
     */
    @GetMapping("/doJudge")
    QuestionSubmit doJudge(long questionSubmitId);
}
