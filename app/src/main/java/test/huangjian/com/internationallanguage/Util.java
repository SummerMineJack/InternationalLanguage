package test.huangjian.com.internationallanguage;

import android.util.Log;

import com.blankj.utilcode.util.DeviceUtils;
import com.blankj.utilcode.util.EncryptUtils;

import org.json.JSONObject;

public class Util {
    public static DeviceBean deviceBean() {
        DeviceBean deviceBean = new DeviceBean();
        deviceBean.setDeviceName(DeviceUtils.getModel());
        deviceBean.setIccid("1635464654654");
        deviceBean.setIdfa("wsdw6516546s5d1649qw542");
        deviceBean.setImei(DeviceUtils.getAndroidID());
        deviceBean.setImsi("");
        deviceBean.setMacAddress(DeviceUtils.getMacAddress());
        deviceBean.setMnc("4554646");
        deviceBean.setSeid("12356d74a65d46879c");
        return deviceBean;
    }

    public static PublicParameterBean publicParameterBean(JSONObject jsonObject) {
        PublicParameterBean publicParameterBean = new PublicParameterBean();
        publicParameterBean.setAppVersion("V1");
        publicParameterBean.setDevice(deviceBean());
        publicParameterBean.setPlatform("android");
        publicParameterBean.setRequestData(jsonObject.toString());
        publicParameterBean.setTimeParam("+8");
        publicParameterBean.setTimeZone("+12");
        publicParameterBean.setSignData(sign(publicParameterBean));
        return publicParameterBean;
    }

    private static String sign(PublicParameterBean publicParameterBean) {
        com.alibaba.fastjson.JSONObject jsonObject = (com.alibaba.fastjson.JSONObject) com
                .alibaba.fastjson.JSONObject.toJSON(publicParameterBean);
        Log.e("~~~~~~~~~~~~", EncryptUtils.encryptSHA256ToString(jsonObject.toString()));
        return "";
    }

}
