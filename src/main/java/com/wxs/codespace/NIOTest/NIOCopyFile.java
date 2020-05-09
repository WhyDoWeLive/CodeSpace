package com.wxs.codespace.NIOTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 不使用selector实现文件复制
 */
public class NIOCopyFile {
    public static void main(String[] args) throws IOException {
        String srcFile = "src.txt";
        String destFile = "dest.txt";

        //获取数据源 和 目的地的输入输出流（以文件数据远为例）
        FileInputStream fileInputStream = new FileInputStream(srcFile);
        FileOutputStream fileOutputStream = new FileOutputStream(destFile);

        //获取数据源的输入输出通道
        FileChannel inputChannel = fileInputStream.getChannel();
        FileChannel outputChannel = fileOutputStream.getChannel();

        //创建缓冲区对象
        ByteBuffer byteBuffer = ByteBuffer.allocate(2);

        while (true){
            System.out.println("read");

            //从通道读取数据 并 写入缓冲区，若已读到末尾则返回-1。需要读多少次取决于byteBuffer的容量
            if (inputChannel.read(byteBuffer) == -1){
                break;
            }

            //将buffer改成写状态，准备传出数据
            byteBuffer.flip();

            //从buffer读取数据，传数据至通道
            outputChannel.write(byteBuffer);

            //重置缓冲区，重复利用而不是再次创建
            byteBuffer.clear();
        }
    }
}
