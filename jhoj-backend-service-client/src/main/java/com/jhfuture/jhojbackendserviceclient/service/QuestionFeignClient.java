package com.jhfuture.jhojbackendserviceclient.service;




import com.jh.jhojbackendmodel.model.entity.Question;
import com.jh.jhojbackendmodel.model.entity.QuestionSubmit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
* 
* @description 针对表【question(题目)】的数据库操作Service
* @createDate 2023-08-07 20:58:00
*/
@FeignClient(name = "jhoj-backend-question-service",path = "/api/question/inner")
public interface QuestionFeignClient  {

    @RequestMapping("/get/id")
    Question getById(@RequestParam("questionId") Long questionId);

    @RequestMapping("/questionSubmit/get/id")
    QuestionSubmit getQuestionSubmitById(@RequestParam("questionSubmitId") long questionSubmitId);


    @PostMapping("/questionSubmit/update")
    boolean updateQuestionSubmitById(@RequestBody  QuestionSubmit questionSubmitUpdate);

}
