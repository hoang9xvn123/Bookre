package cf.nhom5.bookre.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import cf.nhom5.bookre.R;


public class SigninActivity extends AppCompatActivity {
    TextView dangky;
    Button btn_sigin_dangnhap;
    RequestQueue queue;
    EditText edt_signin_name, edt_signin_password;
    String user, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        Anhxa();

        queue = Volley.newRequestQueue(this);

        Control();
    }
    private void Control() {
        dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SigninActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        btn_sigin_dangnhap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                user = edt_signin_name.getText().toString();
                password = edt_signin_password.getText().toString();
                if (user.equals("") || password.equals("")) {
                    Toast.makeText(SigninActivity.this, "Bạn phải nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    String url = "https://hochoihamhoc.000webhostapp.com/checkAccount.php?user=" + user + "&password=" + password;

                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    try {
                                        int status = response.getInt("status");
                                        if (status == 1) {
                                            Intent intent = new Intent(SigninActivity.this, MainActivity.class);
                                            intent.putExtra("account_id", response.getString("id"));
                                            startActivity(intent);
                                        } else {
                                            Toast.makeText(SigninActivity.this, "Sai Tài Khoản hoặc Mật Khẩu", Toast.LENGTH_SHORT).show();
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
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
        });


    }

    private void Anhxa() {
        dangky=(TextView)findViewById(R.id.txt_dangky);
        edt_signin_name = (EditText)findViewById(R.id.edt_signin_name) ;
        edt_signin_password = (EditText)findViewById(R.id.edt_signin_password) ;
        btn_sigin_dangnhap=(Button)findViewById(R.id.btn_sigin_dangnhap);

    }
}