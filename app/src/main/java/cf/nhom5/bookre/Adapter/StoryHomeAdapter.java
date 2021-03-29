package cf.nhom5.bookre.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

import cf.nhom5.bookre.Activity.InfoStoryActivity;
import cf.nhom5.bookre.Activity.MainActivity;
import cf.nhom5.bookre.Model.Story;
import cf.nhom5.bookre.R;

public class StoryHomeAdapter extends RecyclerView.Adapter<StoryHomeAdapter.StoryViewHolder> {

    ArrayList<Story> data_holder;

    public StoryHomeAdapter(ArrayList<Story> data_holder) {
        this.data_holder = data_holder;
    }

    @NonNull
    @Override
    public StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_story_home, parent, false);
        return new StoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryViewHolder holder, int position) {
        holder.img.setImageResource(data_holder.get(position).getImg());
        holder.story_name.setText(data_holder.get(position).getName());
        holder.story_author.setText(data_holder.get(position).getAuthor());
        holder.story_status.setText(data_holder.get(position).getStatus());
        holder.story_amount.setText(data_holder.get(position).getAmount());
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), InfoStoryActivity.class);
                intent.putExtra("story_id",data_holder.get(position).getId());
                v.getContext().startActivity(intent );
            }
        });
    }

    @Override
    public int getItemCount() {
        return data_holder.size();
    }

    public static class StoryViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView story_name;
        TextView story_author;
        TextView story_status;
        TextView story_amount;
        RelativeLayout item;


        public StoryViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.story_img);
            story_name = itemView.findViewById(R.id.story_name);
            story_author = itemView.findViewById(R.id.story_author);
            story_status = itemView.findViewById(R.id.story_status);
            story_amount = itemView.findViewById(R.id.story_amount);
            item = itemView.findViewById(R.id.item);
        }
    }

}
