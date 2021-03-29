package cf.nhom5.bookre.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cf.nhom5.bookre.Activity.MainActivity;
import cf.nhom5.bookre.Activity.SigninActivity;
import cf.nhom5.bookre.R;

public class ChapterActivity extends AppCompatActivity {
         ListView list_id_read;
         Integer story_id = 1;
         ArrayList<String> list;
         RequestQueue queue;
     ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);
        list = new ArrayList<>();
        loadingData(story_id);
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        list_id_read.setAdapter(arrayAdapter);
    }

    void loadingData (int story_id){

        String url = "https://hochoihamhoc.000webhostapp.com/getChapters.php?story_id="+ story_id ;

        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for(int i=0; i<response.length();i++){
                            try {
                                String chapter = response.getJSONObject(i).getString("chapter");
                                list.add(chapter);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        queue.add(jsonObjectRequest);
    }
}





