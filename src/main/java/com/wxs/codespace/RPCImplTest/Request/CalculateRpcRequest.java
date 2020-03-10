package com.wxs.codespace.RPCImplTest.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class CalculateRpcRequest implements Serializable {
    //当部署在两台机器时，可以试一下如果serialVersionUID设置不一样（或一方默认）会不会反序列化失败
    private static final long serialVersionUID = 7503710091945320739L;
    private int a;
    private int b;
    private String methodName;

    @Override
    public String toString() {
        return "CalculateRpcRequest{" +
                "method='" + methodName + '\'' +
                ", a=" + a +
                ", b=" + b +
                '}';
    }
}
