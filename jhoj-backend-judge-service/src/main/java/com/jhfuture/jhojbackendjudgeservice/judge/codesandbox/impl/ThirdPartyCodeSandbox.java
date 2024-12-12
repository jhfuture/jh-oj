package com.jhfuture.jhojbackendjudgeservice.judge.codesandbox.impl;


import com.jh.jhojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.jh.jhojbackendmodel.model.codesandbox.ExecuteCodeResponse;
import com.jhfuture.jhojbackendjudgeservice.judge.codesandbox.CodeSandbox;

/**
 * 第三方代码沙箱（调用网上现成的代码沙箱）
 */
public class ThirdPartyCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("第三方代码沙箱");
        return null;
    }
}
