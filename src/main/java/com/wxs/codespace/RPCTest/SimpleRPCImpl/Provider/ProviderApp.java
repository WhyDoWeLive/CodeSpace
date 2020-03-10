package com.wxs.codespace.RPCTest.SimpleRPCImpl.Provider;

import com.wxs.codespace.RPCTest.SimpleRPCImpl.Request.CalculateRpcRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 忽略了finally中listener的关闭、socket的关闭以及各种需要判断的地方
 */
public class ProviderApp {
    private Logger log = LoggerFactory.getLogger(ProviderApp.class);
    private static int PORT = 9090;

    public static void main(String[] args) throws Exception {
        new ProviderApp().run();
    }

    private void run() throws Exception{
        ServerSocket listener = new ServerSocket(PORT);
        while (true){
            Socket socket = listener.accept();

            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object request = objectInputStream.readObject();
            log.info("request is : {}", request);

            //调用服务
            int result;
            CalculateRpcRequest rpcRequest = (CalculateRpcRequest)request;
            if ("add".equals(rpcRequest.getMethodName())){
                result = new CalculatorImpl().add(rpcRequest.getA(), rpcRequest.getB());
            }
            else {
                throw new UnsupportedOperationException();
            }

            //返回结果
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(result);
        }
    }
}
