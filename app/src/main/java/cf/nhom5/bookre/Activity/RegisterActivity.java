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


public class RegisterActivity extends AppCompatActivity {
    EditText edt_name, edt_email, edt_password,edt_user;
    TextView dangnhap;
    Button btn_res_dangky;
    String name,user, password, email;
    RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Anhxa();
        queue = Volley.newRequestQueue(this);
        Control();
    }
    private void Control() {
        dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, SigninActivity.class);
                startActivity(intent);
            }
        });
        btn_res_dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = edt_name.getText().toString();
                user = edt_user.getText().toString();
                email = edt_email.getText().toString();
                password = edt_password.getText().toString();
                if (name.equals("") || user.equals("") || email.equals("") || password.equals("")) {
                    Toast.makeText(RegisterActivity.this, "Bạn phải nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    String url = "https://hochoihamhoc.000webhostapp.com/register.php?user=" + user + "&password=" + password + "&name=" + name + "&email=" + email;

                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    try {
                                        int status = response.getInt("status");
                                        if (status == 1) {
                                            Intent intent = new Intent(RegisterActivity.this, SigninActivity.class);
                                            startActivity(intent);
                                        } else {
                                            Toast.makeText(RegisterActivity.this, "Tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    });
                    queue.add(jsonObjectRequest);


                }
            }
        });

    }

    private void Anhxa() {
        dangnhap=(TextView)findViewById(R.id.txt_dangnhap);
        btn_res_dangky=(Button)findViewById(R.id.btn_res_dangky);
        edt_name=(EditText)findViewById(R.id.edt_res_name);
        edt_user=(EditText)findViewById(R.id.edt_res_user);
        edt_email=(EditText)findViewById(R.id.edt_res_email);
        edt_password=(EditText)findViewById(R.id.edt_res_password);

    }
}