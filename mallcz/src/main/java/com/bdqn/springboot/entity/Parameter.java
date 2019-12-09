package com.bdqn.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author KazuGin
 * @since 2019-11-28
 */
@TableName("parameter")
public class Parameter implements Serializable {

private static final long serialVersionUID=1L;


    @TableId(value = "parameter_id", type = IdType.AUTO)
    private Long parameterId;

    /**
     * 关联的手机id
     */
    private Long goods_id;

    private String parameterHeight;

    private String parameterWidth;

    /**
     * 厚度
     */
    private String parameterThickness;

    /**
     * 重量
     */
    private String parameterWeight;

    /**
     * 上市时间
     */
    private String parameterShowtime;

    /**
     * CPU型号
     */
    private String parameterCpu;

    /**
     * CPU核心数
     */
    private String parameterCpunum;

    /**
     * 机身存储
     */
    private String parameterStore;//没有了

    /**
     * 电池信息
     */
    private Integer parameterCell;

    /**
     * 尺寸（英寸）
     */
    private String parameterSize;

    /**
     * 分辨率
     */
    private String parameterDistinguishability;

    /**
     * 触摸屏
     */
    private String parameterTouch;
    /*--------------------------------拍摄功能----*/

    /**
     * 前置摄像头像素
     */
    private String parameterFrontpixel;

    /**
     * 置摄像头数量
     */
    @TableField("parameter_laterNumcameras")
    private String parameterLaternumcameras;

    /**
     * 后置闪光灯 0 1
     */
    private Integer parameterLaterflashlight;

    /**
     * 自动对焦 0 1拍摄模式
     */
    private Integer parameterAutofocusing;

    /**
     * 拍摄模式
     */
    private String parameterRecmode;

    /**
     * 音乐播放器
     */
    private String parameterMusicplayer;//没有了
    /*--------------------------------音乐与音响----*/
    /**
     * MP3铃声 0 1
     */
    @TableField("parameter_MP3ringtone")
    private Integer parameterMp3ringtone;
    /*--------------------------------指纹识别----*/
    /**
     * 指纹识别
     */
    @TableField("parameter_fingerprintRecognition")
    private String parameterFingerprintrecognition;
    /*--------------------------------操作系统----*/
    /**
     * 操作系统
     */
    @TableField("parameter_OS")
    private String parameterOs;
    /*--------------------------------网络参数----*/
    /**
     * 网络类型
     */
    @TableField("parameter_networkType")
    private String parameterNetworktype;

    /**
     * 双卡使用说明
     */
    private String parameterNeworkinstructions;
    /*--------------------------------数据连接----*/
    /**
     * WLAN
     */
    @TableField("parameter_WLAN")
    private String parameterWlan;

    /**
     * 蓝牙传输 0 1
     */
    @TableField("parameter_Bluetooth")
    private Integer parameterBluetooth;

    /**
     * OTG 0 1
     */
    @TableField("parameter_OTG")
    private Integer parameterOtg;
    /*--------------------------------传感器----*/
    /**
     * 重力感应器 0 1
     */
    @TableField("parameter_GravitySensor")
    private Integer parameterGravitysensor;

    /**
     * 光敏感应器 0 1
     */
    @TableField("parameter_PhotosensitiveSensor")
    private Integer parameterPhotosensitivesensor;
    /*--------------------------------内置应用----*/
    /**
     * 社交
     */
    private String parameterSns;

    /**
     * 影视音乐
     */
    private String parameterMovieandtv;

    /**
     * 常用工具
     */
    private String parameterTools;

    /**
     * 生活
     */
    private String parameterLive;

    /**
     * 屏幕类型
     */
    private String parameter_screen;

    public String getParameter_screen() {
        return parameter_screen;
    }

    public void setParameter_screen(String parameter_screen) {
        this.parameter_screen = parameter_screen;
    }

    public Long getParameterId() {
        return parameterId;
    }

    public void setParameterId(Long parameterId) {
        this.parameterId = parameterId;
    }

    public Long getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Long goods_id) {
        this.goods_id = goods_id;
    }

    public String getParameterHeight() {
        return parameterHeight;
    }

    public void setParameterHeight(String parameterHeight) {
        this.parameterHeight = parameterHeight;
    }

    public String getParameterWidth() {
        return parameterWidth;
    }

    public void setParameterWidth(String parameterWidth) {
        this.parameterWidth = parameterWidth;
    }

    public String getParameterThickness() {
        return parameterThickness;
    }

    public void setParameterThickness(String parameterThickness) {
        this.parameterThickness = parameterThickness;
    }

    public String getParameterWeight() {
        return parameterWeight;
    }

    public void setParameterWeight(String parameterWeight) {
        this.parameterWeight = parameterWeight;
    }

    public String getParameterShowtime() {
        return parameterShowtime;
    }

    public void setParameterShowtime(String parameterShowtime) {
        this.parameterShowtime = parameterShowtime;
    }

    public String getParameterCpu() {
        return parameterCpu;
    }

    public void setParameterCpu(String parameterCpu) {
        this.parameterCpu = parameterCpu;
    }

    public String getParameterCpunum() {
        return parameterCpunum;
    }

    public void setParameterCpunum(String parameterCpunum) {
        this.parameterCpunum = parameterCpunum;
    }

    public String getParameterStore() {
        return parameterStore;
    }

    public void setParameterStore(String parameterStore) {
        this.parameterStore = parameterStore;
    }


    public Integer getParameterCell() {
        return parameterCell;
    }

    public void setParameterCell(Integer parameterCell) {
        this.parameterCell = parameterCell;
    }

    public String getParameterSize() {
        return parameterSize;
    }

    public void setParameterSize(String parameterSize) {
        this.parameterSize = parameterSize;
    }

    public String getParameterDistinguishability() {
        return parameterDistinguishability;
    }

    public void setParameterDistinguishability(String parameterDistinguishability) {
        this.parameterDistinguishability = parameterDistinguishability;
    }

    public String getParameterTouch() {
        return parameterTouch;
    }

    public void setParameterTouch(String parameterTouch) {
        this.parameterTouch = parameterTouch;
    }

    public String getParameterFrontpixel() {
        return parameterFrontpixel;
    }

    public void setParameterFrontpixel(String parameterFrontpixel) {
        this.parameterFrontpixel = parameterFrontpixel;
    }

    public String getParameterLaternumcameras() {
        return parameterLaternumcameras;
    }

    public void setParameterLaternumcameras(String parameterLaternumcameras) {
        this.parameterLaternumcameras = parameterLaternumcameras;
    }

    public Integer getParameterLaterflashlight() {
        return parameterLaterflashlight;
    }

    public void setParameterLaterflashlight(Integer parameterLaterflashlight) {
        this.parameterLaterflashlight = parameterLaterflashlight;
    }

    public Integer getParameterAutofocusing() {
        return parameterAutofocusing;
    }

    public void setParameterAutofocusing(Integer parameterAutofocusing) {
        this.parameterAutofocusing = parameterAutofocusing;
    }

    public String getParameterRecmode() {
        return parameterRecmode;
    }

    public void setParameterRecmode(String parameterRecmode) {
        this.parameterRecmode = parameterRecmode;
    }

    public String getParameterMusicplayer() {
        return parameterMusicplayer;
    }

    public void setParameterMusicplayer(String parameterMusicplayer) {
        this.parameterMusicplayer = parameterMusicplayer;
    }

    public Integer getParameterMp3ringtone() {
        return parameterMp3ringtone;
    }

    public void setParameterMp3ringtone(Integer parameterMp3ringtone) {
        this.parameterMp3ringtone = parameterMp3ringtone;
    }

    public String getParameterFingerprintrecognition() {
        return parameterFingerprintrecognition;
    }

    public void setParameterFingerprintrecognition(String parameterFingerprintrecognition) {
        this.parameterFingerprintrecognition = parameterFingerprintrecognition;
    }

    public String getParameterOs() {
        return parameterOs;
    }

    public void setParameterOs(String parameterOs) {
        this.parameterOs = parameterOs;
    }

    public String getParameterNetworktype() {
        return parameterNetworktype;
    }

    public void setParameterNetworktype(String parameterNetworktype) {
        this.parameterNetworktype = parameterNetworktype;
    }

    public String getParameterNeworkinstructions() {
        return parameterNeworkinstructions;
    }

    public void setParameterNeworkinstructions(String parameterNeworkinstructions) {
        this.parameterNeworkinstructions = parameterNeworkinstructions;
    }

    public String getParameterWlan() {
        return parameterWlan;
    }

    public void setParameterWlan(String parameterWlan) {
        this.parameterWlan = parameterWlan;
    }

    public Integer getParameterBluetooth() {
        return parameterBluetooth;
    }

    public void setParameterBluetooth(Integer parameterBluetooth) {
        this.parameterBluetooth = parameterBluetooth;
    }

    public Integer getParameterOtg() {
        return parameterOtg;
    }

    public void setParameterOtg(Integer parameterOtg) {
        this.parameterOtg = parameterOtg;
    }

    public Integer getParameterGravitysensor() {
        return parameterGravitysensor;
    }

    public void setParameterGravitysensor(Integer parameterGravitysensor) {
        this.parameterGravitysensor = parameterGravitysensor;
    }

    public Integer getParameterPhotosensitivesensor() {
        return parameterPhotosensitivesensor;
    }

    public void setParameterPhotosensitivesensor(Integer parameterPhotosensitivesensor) {
        this.parameterPhotosensitivesensor = parameterPhotosensitivesensor;
    }

    public String getParameterSns() {
        return parameterSns;
    }

    public void setParameterSns(String parameterSns) {
        this.parameterSns = parameterSns;
    }

    public String getParameterMovieandtv() {
        return parameterMovieandtv;
    }

    public void setParameterMovieandtv(String parameterMovieandtv) {
        this.parameterMovieandtv = parameterMovieandtv;
    }

    public String getParameterTools() {
        return parameterTools;
    }

    public void setParameterTools(String parameterTools) {
        this.parameterTools = parameterTools;
    }

    public String getParameterLive() {
        return parameterLive;
    }

    public void setParameterLive(String parameterLive) {
        this.parameterLive = parameterLive;
    }

    @Override
    public String toString() {
        return "Parameter{" +
        "parameterId=" + parameterId +
        ", phoneId=" + goods_id +
        ", parameterHeight=" + parameterHeight +
        ", parameterWidth=" + parameterWidth +
        ", parameterThickness=" + parameterThickness +
        ", parameterWeight=" + parameterWeight +
        ", parameterShowtime=" + parameterShowtime +
        ", parameterCpu=" + parameterCpu +
        ", parameterCpunum=" + parameterCpunum +
        ", parameterStore=" + parameterStore +
        ", parameterCell=" + parameterCell +
        ", parameterSize=" + parameterSize +
        ", parameterDistinguishability=" + parameterDistinguishability +
        ", parameterTouch=" + parameterTouch +
        ", parameterFrontpixel=" + parameterFrontpixel +
        ", parameterLaternumcameras=" + parameterLaternumcameras +
        ", parameterLaterflashlight=" + parameterLaterflashlight +
        ", parameterAutofocusing=" + parameterAutofocusing +
        ", parameterRecmode=" + parameterRecmode +
        ", parameterMusicplayer=" + parameterMusicplayer +
        ", parameterMp3ringtone=" + parameterMp3ringtone +
        ", parameterFingerprintrecognition=" + parameterFingerprintrecognition +
        ", parameterOs=" + parameterOs +
        ", parameterNetworktype=" + parameterNetworktype +
        ", parameterNeworkinstructions=" + parameterNeworkinstructions +
        ", parameterWlan=" + parameterWlan +
        ", parameterBluetooth=" + parameterBluetooth +
        ", parameterOtg=" + parameterOtg +
        ", parameterGravitysensor=" + parameterGravitysensor +
        ", parameterPhotosensitivesensor=" + parameterPhotosensitivesensor +
        ", parameterSns=" + parameterSns +
        ", parameterMovieandtv=" + parameterMovieandtv +
        ", parameterTools=" + parameterTools +
        ", parameterLive=" + parameterLive +
        "}";
    }
}
