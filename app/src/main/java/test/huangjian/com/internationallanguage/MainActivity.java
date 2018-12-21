package test.huangjian.com.internationallanguage;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.summer.utils.SPUtils;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    private SPUtils spUtils = null;
    private String spKeyName = "save_language";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spUtils = new SPUtils(MainActivity.this, "test");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void setLanguage(int languageId) {
        //设置系统语言
        spUtils.putInt(spKeyName, languageId);
        setConfiguration();
    }

    /**
     * 设置语言
     */
    public void setConfiguration() {
        Locale targetLocale = getLanguage();
        Configuration configuration = this.getResources().getConfiguration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            configuration.setLocale(targetLocale);
            configuration.setLocales(new LocaleList(targetLocale));
        } else {
            configuration.locale = targetLocale;
        }
        Resources resources = this.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        resources.updateConfiguration(configuration, dm);//语言更换生效的代码!
        recreate();
    }

    //获取选择的语言,默认为中文
    private Locale getLanguage() {
        int languageCode = spUtils.getInt(spKeyName, 1);
        if (languageCode == LanguageCode.Lanuage_french) {
            return Locale.FRENCH;
        } else if (languageCode == LanguageCode.Lanuage_japan) {
            return Locale.JAPANESE;
        } else if (languageCode == LanguageCode.Lanuage_kor) {
            return Locale.KOREAN;
        } else if (languageCode == LanguageCode.Lanuage_us) {
            return Locale.ENGLISH;
        }
        return Locale.SIMPLIFIED_CHINESE;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case R.id.language_zh:
                setLanguage(LanguageCode.Lanuage_zh);
                break;
            case R.id.language_english:
                setLanguage(LanguageCode.Lanuage_us);
                break;
            case R.id.language_french:
                setLanguage(LanguageCode.Lanuage_french);
                break;
            case R.id.language_jan:
                setLanguage(LanguageCode.Lanuage_japan);
                break;
            case R.id.language_kor:
                setLanguage(LanguageCode.Lanuage_kor);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
