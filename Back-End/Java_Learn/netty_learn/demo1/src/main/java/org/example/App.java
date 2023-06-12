package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
//        aaa();
        System.out.println(ByteBuffer.allocate(10).getClass());
        System.out.println(ByteBuffer.allocateDirect(10).getClass());
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(10);
    }

    private static void aa(){
        // FileChannel获取方法: 1.输入输出流 , 2.RandomAccessFile
        // 把文档内容写入到 FileChannel
        try (FileChannel channel = new FileInputStream("data.txt").getChannel()) {
            // 准备缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(10);
            // 从 channel 中读取数据 , 向 buffer 写入
            channel.read(buffer);
            // 打印 buffer 中的内容

            //切换至读模式
            buffer.flip();
            //判断buffer是否还有剩余的未读数据
            while (buffer.hasRemaining()){
                // 读一个字节
                byte b = buffer.get();
                System.out.println((char) b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void aaa() {
        try (FileChannel channel = new FileInputStream("data.txt").getChannel()) {
            // 准备缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(10);
            // 从 channel 中读取数据 , 向 buffer 写入
            while (channel.read(buffer)!=-1){
                buffer.flip();
                //判断buffer是否还有剩余的未读数据
                while (buffer.hasRemaining()){
                    // 读一个字节
                    byte b = buffer.get();
                    System.out.print((char) b);
                }
                // 切换为写模式
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
