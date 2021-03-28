package cf.nhom5.bookre.Fragment.Category;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cf.nhom5.bookre.Adapter.GridViewCategoryAdapter;
import cf.nhom5.bookre.Model.Story;
import cf.nhom5.bookre.R;

public class GridViewFragment extends Fragment {
    private List<Story> storyList;
    GridView gridView;
    RequestQueue requestQueue;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categorygridview, container, false);
        int category_id = getArguments().getInt("category_id");
        //List story
        gridView = (GridView) view.findViewById(R.id.gridView);
        storyList = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(this.getContext());
        loadingData(category_id);

        return view;
    }


    void loadingData(int category_id){

        String url = "https://hochoihamhoc.000webhostapp.com/getStoryCategory.php?category_id=" + String.valueOf(category_id);
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<response.length();i++){
                    try {
                        JSONObject story = response.getJSONObject(i);
                        int id = Integer.parseInt(story.getString("id"));
                        String name = story.getString("name");
                        String img = story.getString("img");
                        storyList.add(new Story(id, name, img));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    gridView.setAdapter(new GridViewCategoryAdapter(storyList, getContext()));
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(request);
    }
}
