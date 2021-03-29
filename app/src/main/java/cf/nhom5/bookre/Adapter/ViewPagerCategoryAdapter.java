package cf.nhom5.bookre.Adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import cf.nhom5.bookre.Fragment.Category.GridViewFragment;

public class ViewPagerCategoryAdapter extends FragmentStatePagerAdapter {

    public ViewPagerCategoryAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment v = new GridViewFragment();
        int pos;
        switch (position){
            case 0:
                pos=1;break;
            case 1:
                pos=2;break;
            case 2:
                pos=3;break;
            case 3:
                pos=4;break;
            default:
                pos = 1;break;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("category_id", pos);
        v.setArguments(bundle);
        return v;

    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "Tiên Hiệp";break;
            case 1:
                title = "Huyền Huyễn";break;
            case 2:
                title = "Đô Thị";break;
            case 3:
                title = "Kiếm Hiệp";break;
        }
        return title;
    }
}
