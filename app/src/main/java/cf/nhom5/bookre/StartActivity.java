package cf.nhom5.bookre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cf.nhom5.bookre.Activity.RegisterActivity;
import cf.nhom5.bookre.Activity.SigninActivity;



public class StartActivity extends AppCompatActivity {
    EditText edt_sigin_name,edt_sigin_password;
    Button btn_sigin_dangnhap,btn_dangnhap,btn_dangky;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Anhxa();
        Control();
    }
    private void Control() {
        btn_dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btn_dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, SigninActivity.class);
                startActivity(intent);

            }
        });
    }

    private void Anhxa() {
        edt_sigin_name=(EditText)findViewById(R.id.edt_signin_name);
        edt_sigin_password=(EditText)findViewById(R.id.edt_signin_password);
        btn_sigin_dangnhap=(Button)findViewById(R.id.btn_sigin_dangnhap);
        btn_dangky=(Button)findViewById(R.id.btn_dangky);
        btn_dangnhap=(Button)findViewById(R.id.btn_dangnhap);
    }

}