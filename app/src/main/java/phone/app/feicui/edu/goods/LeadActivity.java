package phone.app.feicui.edu.goods;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LeadActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView icons[] = new ImageView[5];
    TextView tv_skip;
    ViewPager viewPager;
    BasePagerAdapter leadPagerAdapter;
    private boolean isFromSetting;
    private ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            tv_skip.setVisibility(View.INVISIBLE);
            if (position >= 2) {
                tv_skip.setVisibility(View.VISIBLE);
            }
            for (int i = 0; i < icons.length; i++) {
                icons[i].setImageResource(R.drawable.adware_style_default);
            }
            icons[position].setImageResource(R.drawable.adware_style_selected);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

      private void initLeadIcon() {
        icons[0] = (ImageView) findViewById(R.id.icon1);
        icons[1] = (ImageView) findViewById(R.id.icon2);
        icons[2] = (ImageView) findViewById(R.id.icon3);
        icons[3] = (ImageView) findViewById(R.id.icon4);
        icons[4] = (ImageView) findViewById(R.id.icon5);
        icons[0].setImageResource(R.drawable.adware_style_selected);
        tv_skip = (TextView) findViewById(R.id.tv_skip);
        tv_skip.setVisibility(View.INVISIBLE);
        tv_skip.setOnClickListener(this);
    }

    private void initViewPager() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        leadPagerAdapter = new BasePagerAdapter(this);
        viewPager.setAdapter(leadPagerAdapter);
        viewPager.setOnPageChangeListener(pageChangeListener);
    }

    private void initPagerData() {
        ImageView imageView = null;

        imageView = (ImageView) getLayoutInflater().inflate(R.layout.activity_lead_item, null);
        imageView.setImageResource(R.drawable.yanjing);
        leadPagerAdapter.addViewToAdapter(imageView);

        imageView = (ImageView) getLayoutInflater().inflate(R.layout.activity_lead_item, null);
        imageView.setImageResource(R.drawable.nining);
        leadPagerAdapter.addViewToAdapter(imageView);

        imageView = (ImageView) getLayoutInflater().inflate(R.layout.activity_lead_item, null);
        imageView.setImageResource(R.drawable.fengmian);
        leadPagerAdapter.addViewToAdapter(imageView);

        imageView = (ImageView) getLayoutInflater().inflate(R.layout.activity_lead_item, null);
        imageView.setImageResource(R.drawable.welcome);
        leadPagerAdapter.addViewToAdapter(imageView);

        imageView = (ImageView) getLayoutInflater().inflate(R.layout.activity_lead_item, null);
        imageView.setImageResource(R.drawable.zhubao);
        leadPagerAdapter.addViewToAdapter(imageView);

        leadPagerAdapter.notifyDataSetChanged();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead);
        Intent intent = getIntent();
        String fromClassName = intent.getStringExtra("className");
        if (fromClassName != null && fromClassName.equals("MainActivity")) {
            isFromSetting = true;
        }
        SharedPreferences preferences = getSharedPreferences("lead_config",
                Context.MODE_PRIVATE);
        boolean isFirstRun = preferences.getBoolean("isFirst", true);
        if (!isFirstRun) {
            Intent intent1 = new Intent(this, MainActivity.class);
            startActivity(intent1);
            finish();
        } else {
            setContentView(R.layout.activity_lead);
            // 初始化引导页面小图标+skip (5个小图标 + 1个skip文字)
            initLeadIcon();
            // 初始化引导页面ViewPager视图 (给ViewPager设置Adapter)
            initViewPager();
            // 初始化引导页面ViewPager内显示的视图数据 (向ViewPager的Adapter内添加视图(图片))
            initPagerData();
        }


    }

    private void savePreferences() {
        SharedPreferences preferences = getSharedPreferences("lead_config", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isFirstRun", true);
        editor.commit();
    }


    @Override
    public void onClick(View view) {
        savePreferences();
        if (isFromSetting) {
            Intent intent = new Intent(this, Main2Activity.class);
            startActivity(intent);
            finish();
        } else {
            Intent intent = new Intent(this, Main2Activity.class);
            startActivity(intent);
        }

    }

    public void onClick45(View view) {
        Intent intent = new Intent(LeadActivity.this, Main2Activity.class);
        startActivity(intent);
        finish();
    }
}
