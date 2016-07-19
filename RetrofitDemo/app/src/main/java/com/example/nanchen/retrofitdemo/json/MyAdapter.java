package com.example.nanchen.retrofitdemo.json;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nanchen.retrofitdemo.R;
import com.squareup.picasso.Picasso;

import java.util.Collection;
import java.util.List;

/**
 * Created by 南尘 on 16-7-15.
 */
public class MyAdapter extends BaseAdapter {

    private Context context;
    private List<Cook> list;

    public MyAdapter(Context context, List<Cook> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        if (list != null){
            return list.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
            convertView.setTag(new ViewHolder(convertView));
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        Cook cook = list.get(position);
        holder.tv_title.setText(cook.getName());
        holder.tv_info.setText(cook.getDescription());
        //使用同样开发团队的Picasso支持包进行图片加载，由于接口中返回的img路径不是全的，所以需要加上网站前缀
        Picasso.with(context).load("http://tnfs.tngou.net/img"+cook.getImg()).into(holder.iv);
        return convertView;
    }

    public void addAll(Collection<? extends Cook> collection){
        list.addAll(collection);
        notifyDataSetChanged();
    }

    public static class ViewHolder{
        private final ImageView iv;
        private final TextView tv_title;
        private final TextView tv_info;

        public ViewHolder(View item){
            iv = ((ImageView) item.findViewById(R.id.item_iv));
            tv_title = ((TextView) item.findViewById(R.id.item_title));
            tv_info = ((TextView) item.findViewById(R.id.item_info));
        }
    }
}
