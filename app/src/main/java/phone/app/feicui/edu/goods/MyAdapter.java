package phone.app.feicui.edu.goods;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by qiuxianjie on 2016/8/31.
 */
public class MyAdapter extends BaseAdapter {
    Context context;
    List<Mydata> list;
    LayoutInflater layoutInflater;

    public MyAdapter(Context context, List<Mydata> list) {
        this.context = context;
        this.list = list;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ShowTime showTime;
        if(view==null){
            showTime=new ShowTime();
            view=layoutInflater.inflate(R.layout.lead,null);
            showTime.name= (TextView) view.findViewById(R.id.textView88);
            showTime.picture= (ImageView) view.findViewById(R.id.imageView99);
            showTime.rightpicture= (ImageView) view.findViewById(R.id.imageView77);
            view.setTag(showTime);
        }else {
            showTime= (ShowTime) view.getTag();
        }
        showTime.name.setText(list.get(i).name);
        showTime.picture.setImageResource(list.get(i).picture);
        showTime.rightpicture.setImageResource(list.get(i).rightpicture);
        return view;
    }

    public static class ShowTime {
        TextView name;
        ImageView picture;
        ImageView rightpicture;
    }
}
