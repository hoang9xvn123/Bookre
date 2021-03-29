package cf.nhom5.bookre.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import cf.nhom5.bookre.Activity.InfoAppActivity;
import cf.nhom5.bookre.Activity.SigninActivity;
import cf.nhom5.bookre.Model.Story;
import cf.nhom5.bookre.R;

public class AccountFragment extends Fragment {

    LinearLayout in4,logout,rate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_account, container, false);
        in4 = v.findViewById(R.id.in4);
        logout = v.findViewById(R.id.logout);
        rate = v.findViewById(R.id.rate);

        //Thông tin ứng dụng
        in4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), InfoAppActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        //Đăng xuất
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SigninActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        //Đánh giá cho chúng tôi
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Tính năng này chưa được phát triển", Toast.LENGTH_SHORT);
            }
        });

        //
        return v;
    }



}
