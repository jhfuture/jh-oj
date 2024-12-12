package com.jhfuture.jhojbackendjudgeservice.judge;


import com.jh.jhojbackendmodel.model.codesandbox.JudgeInfo;
import com.jh.jhojbackendmodel.model.entity.QuestionSubmit;
import com.jhfuture.jhojbackendjudgeservice.judge.strategy.DefaultJudgeStrategy;
import com.jhfuture.jhojbackendjudgeservice.judge.strategy.JavaLanguageJudgeStrategy;
import com.jhfuture.jhojbackendjudgeservice.judge.strategy.JudgeContext;
import com.jhfuture.jhojbackendjudgeservice.judge.strategy.JudgeStrategy;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}
