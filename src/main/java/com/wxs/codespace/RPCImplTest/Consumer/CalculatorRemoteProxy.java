package com.wxs.codespace.RPCImplTest.Consumer;

import com.wxs.codespace.RPCImplTest.Provider.Calculator;
import com.wxs.codespace.RPCImplTest.Request.CalculateRpcRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 创建远程对象的代理对象并实现对应的方法，这里我们是自己创建的代理对象。
 * Dubbo会通过扫描带有@Reference的bean，为其创建代理对象并注入到需要的地方
 */
public class CalculatorRemoteProxy implements Calculator {
    private static String IP = "127.0.0.1";
    private static int PORT = 9090;
    private static Logger log = LoggerFactory.getLogger(CalculatorRemoteProxy.class);

    public int add(int a, int b) {
        try {
            //创建Socket
            List<String> providerAddressList = lookupProviders("Calculator.add");
            String choossedProviderAdress = chooseProvider(providerAddressList);
            Socket socket = new Socket(choossedProviderAdress, PORT);

            //将请求参数序列化
            CalculateRpcRequest rpcRequest = genCalcRpcRequest(a, b, "add");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            //请求发送给服务端
            objectOutputStream.writeObject(rpcRequest);

            //将响应反序列化
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object response = objectInputStream.readObject();
            return (Integer)response;
        }catch (Exception e){
            log.error("Exception :{}", e);
            //没有适合返回值的时候返回一个异常
            throw new InternalError();
        }
    }

    private CalculateRpcRequest genCalcRpcRequest(int a, int b, String methodName){
        return new CalculateRpcRequest(a, b , methodName);
    }

    /**
     * 模拟注册发现，Dubbo使用的是zookeeper
     * @param name
     * @return
     */
    private static List<String> lookupProviders(String name){
        List<String> providerAddressList = new ArrayList<>();
        providerAddressList.add(IP);
        log.info("find provider address list for method: " + name);
        return providerAddressList;
    }

    /**
     * 模拟负载均衡：当有多个服务器可选时，选择哪个服务器执行calculate
     * @param providerAddressList
     * @return
     */
    private static String chooseProvider(List<String> providerAddressList){
        return providerAddressList.get(0);
    }
}
