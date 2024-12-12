package com.jhfuture.jhojbackendquestionservice.controller.inner;




import com.jh.jhojbackendmodel.model.entity.Question;
import com.jh.jhojbackendmodel.model.entity.QuestionSubmit;
import com.jhfuture.jhojbackendquestionservice.service.QuestionService;
import com.jhfuture.jhojbackendquestionservice.service.QuestionSubmitService;
import com.jhfuture.jhojbackendserviceclient.service.QuestionFeignClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
*
*/
@RestController
@RequestMapping("/inner")
public class QuestionInnerController implements QuestionFeignClient {

    @Resource
    private QuestionService questionService;

    @Resource
    private QuestionSubmitService questionSubmitService;
    @Override
    @RequestMapping("/get/id")
    public Question getById(@RequestParam("questionId") Long questionId){
        return questionService.getById(questionId);
    }

    @Override
    @RequestMapping("/questionSubmit/get/id")
    public QuestionSubmit getQuestionSubmitById(@RequestParam("questionSubmitId") long questionSubmitId){
        return questionSubmitService.getById(questionSubmitId);
    }

    @Override
    @PostMapping("/questionSubmit/update")
    public boolean updateQuestionSubmitById(@RequestBody QuestionSubmit questionSubmitUpdate){
        return questionSubmitService.updateById(questionSubmitUpdate);
    }

}
