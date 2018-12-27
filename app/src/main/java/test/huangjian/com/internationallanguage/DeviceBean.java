package test.huangjian.com.internationallanguage;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Create by Summer on 2018/12/27
 * 手机设备信息实体类
 */

public class DeviceBean implements Parcelable {
    //IMEI
    public String imei;
    //移动客户识别码
    public String imsi;
    //ICCID
    public String iccid;
    //MAC地址
    public String macAddress;
    //移动设备网络代码
    public String mnc;
    //设备型号
    public String deviceName;
    //广告标志位
    public String idfa;
    //SEID
    public String seid;

    public DeviceBean(){

    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getMnc() {
        return mnc;
    }

    public void setMnc(String mnc) {
        this.mnc = mnc;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getIdfa() {
        return idfa;
    }

    public void setIdfa(String idfa) {
        this.idfa = idfa;
    }

    public String getSeid() {
        return seid;
    }

    public void setSeid(String seid) {
        this.seid = seid;
    }

    protected DeviceBean(Parcel in) {
        imei = in.readString();
        imsi = in.readString();
        iccid = in.readString();
        macAddress = in.readString();
        mnc = in.readString();
        deviceName = in.readString();
        idfa = in.readString();
        seid = in.readString();
    }

    public static final Creator<DeviceBean> CREATOR = new Creator<DeviceBean>() {
        @Override
        public DeviceBean createFromParcel(Parcel in) {
            return new DeviceBean(in);
        }

        @Override
        public DeviceBean[] newArray(int size) {
            return new DeviceBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(imei);
        parcel.writeString(imsi);
        parcel.writeString(iccid);
        parcel.writeString(macAddress);
        parcel.writeString(mnc);
        parcel.writeString(deviceName);
        parcel.writeString(idfa);
        parcel.writeString(seid);
    }
}
