package test.huangjian.com.internationallanguage;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Create by Summer on 2018/12/27
 */
public class PublicParameterBean implements Parcelable {
    //app版本
    public String appVersion;
    //时间差
    public String timeParam;
    //设备信息
    public DeviceBean device;
    //时区
    public String timeZone;
    //平台Android ios
    public String platform;
    //请求数据，
    public String requestData;
    //签名
    public String signData;

    public PublicParameterBean() {

    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getTimeParam() {
        return timeParam;
    }

    public void setTimeParam(String timeParam) {
        this.timeParam = timeParam;
    }

    public DeviceBean getDevice() {
        return device;
    }

    public void setDevice(DeviceBean device) {
        this.device = device;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getRequestData() {
        return requestData;
    }

    public void setRequestData(String requestData) {
        this.requestData = requestData;
    }

    public String getSignData() {
        return signData;
    }

    public void setSignData(String signData) {
        this.signData = signData;
    }

    protected PublicParameterBean(Parcel in) {
        appVersion = in.readString();
        timeParam = in.readString();
        device = in.readParcelable(DeviceBean.class.getClassLoader());
        timeZone = in.readString();
        platform = in.readString();
        requestData = in.readString();
        signData = in.readString();
    }

    public static final Creator<PublicParameterBean> CREATOR = new Creator<PublicParameterBean>() {
        @Override
        public PublicParameterBean createFromParcel(Parcel in) {
            return new PublicParameterBean(in);
        }

        @Override
        public PublicParameterBean[] newArray(int size) {
            return new PublicParameterBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(appVersion);
        parcel.writeString(timeParam);
        parcel.writeParcelable(device, i);
        parcel.writeString(timeZone);
        parcel.writeString(platform);
        parcel.writeString(requestData);
        parcel.writeString(signData);
    }
}
