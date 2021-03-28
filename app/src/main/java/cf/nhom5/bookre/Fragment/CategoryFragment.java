package cf.nhom5.bookre.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import cf.nhom5.bookre.Adapter.ViewPagerCategoryAdapter;
import cf.nhom5.bookre.R;

public class CategoryFragment extends Fragment {

    TabLayout tab_layout;
    ViewPager view_pager;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        //Tablayout and Viewpager
        tab_layout = (TabLayout) view.findViewById(R.id.tab_layout);
        view_pager = (ViewPager) view.findViewById(R.id.view_pager);
        ViewPagerCategoryAdapter adapter = new ViewPagerCategoryAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        view_pager.setAdapter(adapter);
        tab_layout.setupWithViewPager(view_pager);




        return view;
    }
}
