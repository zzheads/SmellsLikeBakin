package zzheads.com.smellslikebakin;

/**
 *    Created by zzhea on 11.07.2016.
 */
public class ListAdapter extends RecyclerAdapter {
    private final ListFragment.OnRecipeSelectedInterface mListener;

    public ListAdapter(ListFragment.OnRecipeSelectedInterface listener) {
        mListener = listener;
    }

    @Override
    protected void onRecipeSelected(int index) {
        mListener.onListRecipeSelected(index);
    }

    @Override
    public int getLayoutId() {
        return R.layout.list_item;
    }
}
