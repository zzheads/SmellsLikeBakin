package zzheads.com.smellslikebakin;

/**
 * Created by zzhea on 13.07.2016.
 */
public class GridAdapter extends RecyclerAdapter {
    private final GridFragment.OnRecipeSelectedInterface mListener;

    public GridAdapter(GridFragment.OnRecipeSelectedInterface listener) {
        mListener = listener;
    }

    @Override
    protected void onRecipeSelected(int index) {
        mListener.onGridRecipeSelected(index);
    }

    @Override
    public int getLayoutId() {
        return R.layout.grid_item;
    }
}
