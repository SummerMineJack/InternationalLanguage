package test.huangjian.com.internationallanguage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.blankj.utilcode.util.DeviceUtils;
import com.lzy.okgo.OkGo;

import org.json.JSONObject;

import java.util.HashMap;

public class SignActivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_activty);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signPareams();
            }
        });
    }

    private void signPareams() {
        Log.e("~~~~~~~",DeviceUtils.getModel());
        HashMap<String, String> params = new HashMap<>();
        params.put("key1", "value1");
        params.put("key2", "这里是需要提交的json格式数据");
        params.put("key3", "也可以使用三方工具将对象转成json字符串");
        params.put("key4", "其实你怎么高兴怎么写都行");
        JSONObject jsonObject = new JSONObject(params);
        PublicParameterBean publicParameterBean = Util.publicParameterBean(jsonObject);
        OkGo.get("").tag(this).params("",publicParameterBean.getAppVersion());

    }




}
