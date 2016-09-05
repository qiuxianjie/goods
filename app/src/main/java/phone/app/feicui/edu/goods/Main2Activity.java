package phone.app.feicui.edu.goods;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    MyAdapter myAdapter;

    List<Mydata> list = new ArrayList<Mydata>();

    ViewPager viewPager;
    BasePagerAdapter leadPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        viewPager = (ViewPager) findViewById(R.id.viewPagertwo);
        leadPagerAdapter=new BasePagerAdapter(this);
        initPagerData();
        viewPager.setAdapter(leadPagerAdapter);

        listView = (ListView) findViewById(R.id.listView);

        Mydata mydata = new Mydata();
        mydata.name = "限时抢购";
        mydata.picture = R.drawable.home_classify_01;
        mydata.rightpicture = R.drawable.face3;
        list.add(mydata);

        mydata = new Mydata();
        mydata.picture = R.drawable.home_classify_02;
        mydata.name = "促销快报";
        mydata.rightpicture = R.drawable.face3;
        list.add(mydata);

        mydata = new Mydata();
        mydata.name = "新品上架";
        mydata.picture = R.drawable.home_classify_03;
        mydata.rightpicture = R.drawable.face3;
        list.add(mydata);

        mydata = new Mydata();
        mydata.picture = R.drawable.home_classify_04;
        mydata.name = "热门单品";
        mydata.rightpicture = R.drawable.face3;
        list.add(mydata);

        mydata = new Mydata();
        mydata.picture = R.drawable.home_classify_05;
        mydata.name = "推荐品牌";
        mydata.rightpicture = R.drawable.face3;
        list.add(mydata);

        myAdapter = new MyAdapter(this, list);
        listView.setAdapter(myAdapter);


    }

    private void initPagerData() {
        ImageView imageView = null;

        imageView = (ImageView) getLayoutInflater().inflate(R.layout.activity_lead_item, null);
        imageView.setImageResource(R.drawable.fengmian);
        leadPagerAdapter.addViewToAdapter(imageView);

        imageView = (ImageView) getLayoutInflater().inflate(R.layout.activity_lead_item, null);
        imageView.setImageResource(R.drawable.image1);
        leadPagerAdapter.addViewToAdapter(imageView);

        imageView = (ImageView) getLayoutInflater().inflate(R.layout.activity_lead_item, null);
        imageView.setImageResource(R.drawable.image2);
        leadPagerAdapter.addViewToAdapter(imageView);

        imageView = (ImageView) getLayoutInflater().inflate(R.layout.activity_lead_item, null);
        imageView.setImageResource(R.drawable.image3);
        leadPagerAdapter.addViewToAdapter(imageView);

        imageView = (ImageView) getLayoutInflater().inflate(R.layout.activity_lead_item, null);
        imageView.setImageResource(R.drawable.image4);
        leadPagerAdapter.addViewToAdapter(imageView);

        leadPagerAdapter.notifyDataSetChanged();

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
