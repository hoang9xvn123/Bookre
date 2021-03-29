package cf.nhom5.bookre.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import cf.nhom5.bookre.Activity.InfoStoryActivity;
import cf.nhom5.bookre.Model.Story;
import cf.nhom5.bookre.R;

public class GridViewCategoryAdapter extends BaseAdapter {

    List<Story> story_list;
    LayoutInflater layoutInflater;
    Context context;

    public GridViewCategoryAdapter(List<Story> story_list, Context context) {
        this.story_list = story_list;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return story_list.size();
    }

    @Override
    public Story getItem(int position) {
        return story_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.item_story_category, null);
            holder = new ViewHolder();
            holder.story_img = convertView.findViewById(R.id.story_img);
            holder.story_name = convertView.findViewById(R.id.story_name);
            holder.item = convertView.findViewById(R.id.item);
            convertView.setTag(holder);
        } else{
            holder = (ViewHolder) convertView.getTag();
        }

        Story story = getItem(position);
        holder.story_name.setText(story.getName());
        holder.story_img.setImageResource(story.getImg());
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), InfoStoryActivity.class);
                intent.putExtra("story_id", story.getId());
                v.getContext().startActivity(intent);
            }
        });
        return convertView;
    }

    static class ViewHolder {
        ImageView story_img;
        TextView story_name;
        RelativeLayout item;
    }
}
