package cf.nhom5.bookre.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import cf.nhom5.bookre.R;

public class InfoStoryActivity extends AppCompatActivity {

    Toolbar chaplist_infostr;
    int story_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_story);

        story_id = this.getIntent().getIntExtra("story_id",1);
        chaplist_infostr = findViewById(R.id.chaplist_infostr);


        chaplist_infostr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ChapterActivity.class);
                intent.putExtra("story_id", story_id);
                v.getContext().startActivity(intent);
            }
        });

    }
}