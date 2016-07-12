package zzheads.com.smellslikebakin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

/**
 * Created by zzhea on 12.07.2016.
 */
public class IngredientsFragment extends Fragment {

    private static final String KEY_CHECKBOXESARRAY = "check_boxes_array";
    CheckBox[] mCheckBoxes;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int index = getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX);
        View view = inflater.inflate(R.layout.fragment_ingredients, container, false);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ingredientsLayout);

        String[] ingredients = Recipes.ingredients[index].split("`");
        mCheckBoxes = new CheckBox[ingredients.length];
        boolean[] checkedBoxes = new boolean[mCheckBoxes.length];
        if (savedInstanceState != null  && savedInstanceState.getBooleanArray(KEY_CHECKBOXESARRAY) != null) {
            checkedBoxes = savedInstanceState.getBooleanArray(KEY_CHECKBOXESARRAY);
        }
        setUpCheckBoxes(ingredients, linearLayout, checkedBoxes);

        return view;
    }

    private void setUpCheckBoxes (String[] ingredients, ViewGroup container, boolean[] checkedBoxes) {
        int i = 0;
        for (String ingredient : ingredients) {
            mCheckBoxes[i] = new CheckBox(getActivity());
            mCheckBoxes[i].setPadding(8, 16, 8, 16);
            mCheckBoxes[i].setTextSize(20f);
            mCheckBoxes[i].setText(ingredient);
            mCheckBoxes[i].setChecked(checkedBoxes[i]);
            container.addView(mCheckBoxes[i]);
            i++;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        boolean[] stateOfCheckBoxes = new boolean[mCheckBoxes.length];
        for (int i=0; i<mCheckBoxes.length;i++) {
            stateOfCheckBoxes[i] = mCheckBoxes[i].isChecked();
        }
        outState.putBooleanArray(KEY_CHECKBOXESARRAY, stateOfCheckBoxes);
        super.onSaveInstanceState(outState);
    }



}
