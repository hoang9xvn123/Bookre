package cf.nhom5.bookre.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import cf.nhom5.bookre.Fragment.AccountFragment;
import cf.nhom5.bookre.Fragment.BookmarkFragment;
import cf.nhom5.bookre.Fragment.CategoryFragment;
import cf.nhom5.bookre.Fragment.HomeFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }


    @Override
    public int getCount() {
        return 4;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new HomeFragment();
            case 1: return new CategoryFragment();
            case 2: return new BookmarkFragment();
            case 3: return new AccountFragment();
            default: return new HomeFragment();
        }
    }


}
