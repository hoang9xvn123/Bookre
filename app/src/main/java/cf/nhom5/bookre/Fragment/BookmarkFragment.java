package cf.nhom5.bookre.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cf.nhom5.bookre.Adapter.StoryBookmarkAdapter;
import cf.nhom5.bookre.Model.Story;
import cf.nhom5.bookre.R;

public class BookmarkFragment extends Fragment {

    RecyclerView list_story;
    ArrayList<Story> data_holder;
    String account_id;
    RequestQueue requestQueue;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookmark, container, false);
        account_id = getArguments().getString("account_id");
        //List story
        list_story = view.findViewById(R.id.list_story);
        list_story.setLayoutManager(new LinearLayoutManager(getContext()));
        data_holder = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(getContext());
        loadingData(account_id);



        return view;
    }

    void loadingData(String account_id){
        String url = "https://hochoihamhoc.000webhostapp.com/getStoryBookmark.php?account_id=" + account_id;
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i=0;i<response.length();i++){
                    try {
                        JSONObject story = response.getJSONObject(i);
                        int id = Integer.parseInt(story.getString("id"));
                        String name = story.getString("name");
                        String author = story.getString("author");
                        String status = story.getString("status");
                        String chapter_curr = story.getString("chapter_curr");
                        int img = Integer.parseInt(story.getString("img"));
                        data_holder.add(new Story(id,name,author,status,chapter_curr,img));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                list_story.setAdapter(new StoryBookmarkAdapter(data_holder));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "ERROR2", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(request);
    }
}
