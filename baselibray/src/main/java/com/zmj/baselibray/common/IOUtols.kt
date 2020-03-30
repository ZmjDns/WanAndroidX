package com.zmj.baselibray.common

import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.OutputStream

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/3/27
 * Description :
 */
/***
 * 将输入流转成ByteArray
 */
fun toByteArray(input: InputStream):ByteArray{
    val outStream: ByteArrayOutputStream = ByteArrayOutputStream()
    ioWrite(input,outStream)
    outStream.close()
    return outStream.toByteArray()
}

/**
 * 读写操作
 */
fun ioWrite(input: InputStream,outStream:OutputStream){
    var len = 0
    val buffer = ByteArray(1024)
    while ((input.read(buffer).also { len = it }) != -1){
        outStream.write(buffer,0,len)
    }
}