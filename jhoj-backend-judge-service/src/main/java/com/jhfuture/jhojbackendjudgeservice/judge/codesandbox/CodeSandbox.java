package com.jhfuture.jhojbackendjudgeservice.judge.codesandbox;


import com.jh.jhojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.jh.jhojbackendmodel.model.codesandbox.ExecuteCodeResponse;

/**
 * 代码沙箱接口定义
 */
public interface CodeSandbox {

    /**
     * 执行代码
     *
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
