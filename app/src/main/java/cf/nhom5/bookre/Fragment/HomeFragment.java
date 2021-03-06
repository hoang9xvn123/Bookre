
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
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import cf.nhom5.bookre.Adapter.StoryHomeAdapter;
import cf.nhom5.bookre.Model.Story;
import cf.nhom5.bookre.R;

public class HomeFragment extends Fragment {

    RecyclerView list_story;
    ArrayList<Story> data_holder;
    ImageSlider imageSlider;
    String url = "https://hochoihamhoc.000webhostapp.com/getStoryHome.php";
    RequestQueue requestQueue;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //Slider
        imageSlider =  view.findViewById(R.id.imageSlider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://s1.dmcdn.net/v/Riggk1T-yRnLH1URc/x1080"));
        slideModels.add(new SlideModel("https://s1.dmcdn.net/v/RmX0a1T-9rs6H5q2M/x1080"));
        slideModels.add(new SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ2kl-rhkHhOcLCihouyr8rbTAhVIZLnjmxOQ&usqp=CAU"));
        imageSlider.setImageList(slideModels, true);

        //List story
        data_holder = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(getContext());
        list_story = view.findViewById(R.id.list_story);
        jsonParse();

        return view;
    }

    void jsonParse(){
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<response.length();i++){
                    try {
                        JSONObject story = response.getJSONObject(i);
                        int id = Integer.parseInt(story.getString("id"));
                        String name = story.getString("name");
                        String author = story.getString("author");
                        String status = story.getString("status");
                        String amount = story.getString("amount");
                        int img = Integer.parseInt(story.getString("img"));
                        data_holder.add(new Story(id, name, author, status, amount, img));
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(getContext(), "ERROR", Toast.LENGTH_LONG).show();
                    }
                    list_story.setLayoutManager(new LinearLayoutManager(getContext()));
                    list_story.setAdapter(new StoryHomeAdapter(data_holder));
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "ERROR", Toast.LENGTH_LONG).show();
            }
        });

        requestQueue.add(request);
    }





}
