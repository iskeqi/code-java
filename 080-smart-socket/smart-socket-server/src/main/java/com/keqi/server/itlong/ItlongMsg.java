package com.keqi.server.itlong;

/**
 * 旺龙电梯协议实体类
 */
public class ItlongMsg {

    /**
     * 包头[3个字节]
     */
    private final String header = "ITL";

    /**
     * 数据长度[2个字节]
     */
    private Short len;

    /**
     * 传输方向[1个字节,0-命令请求方-REQ 1-命令应答方-ACK]
     */
    private Byte dir;

    /**
     * 流水号[用于绑定请求消息和响应消息]
     */
    private Byte snr;

    /**
     * 命令字[相当于功能码]
     */
    private Short cmd;

    /**
     * 传输数据[通讯数据内容，此部分为json格式数据]
     */
    private String info;

    /**
     * 校验字节[从[len,info]的所有自己的异或值]
     */
    private Byte chk;

    public String getHeader() {
        return header;
    }

    public Short getLen() {
        return len;
    }

    public void setLen(Short len) {
        this.len = len;
    }

    public Byte getDir() {
        return dir;
    }

    public void setDir(Byte dir) {
        this.dir = dir;
    }

    public Byte getSnr() {
        return snr;
    }

    public void setSnr(Byte snr) {
        this.snr = snr;
    }

    public Short getCmd() {
        return cmd;
    }

    public void setCmd(Short cmd) {
        this.cmd = cmd;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Byte getChk() {
        return chk;
    }

    public void setChk(Byte chk) {
        this.chk = chk;
    }

    @Override
    public String toString() {
        return "ItlongMsg{" +
                "header='" + header + '\'' +
                ", len=" + len +
                ", dir=" + dir +
                ", snr=" + snr +
                ", cmd=" + cmd +
                ", info='" + info + '\'' +
                ", chk=" + chk +
                '}';
    }
}
