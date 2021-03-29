package cf.nhom5.bookre.Adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import cf.nhom5.bookre.Fragment.AccountFragment;
import cf.nhom5.bookre.Fragment.BookmarkFragment;
import cf.nhom5.bookre.Fragment.CategoryFragment;
import cf.nhom5.bookre.Fragment.HomeFragment;

public class ViewPagerMenuAdapter extends FragmentStatePagerAdapter {
    String account_id;
    public ViewPagerMenuAdapter(@NonNull FragmentManager fm, int behavior, String account_id) {
        super(fm, behavior);
        this.account_id = account_id;
    }


    @Override
    public int getCount() {
        return 4;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment v;

        switch (position) {
            case 1: v = new CategoryFragment();break;
            case 2: v = new BookmarkFragment();break;
            case 3: v = new AccountFragment();break;
            default: v = new HomeFragment();break;
        }
        Bundle bundle = new Bundle();
        bundle.putString("account_id", account_id);
        v.setArguments(bundle);
        return v;
    }


}
