package zzheads.com.smellslikebakin;

/**
 * Created by zzhea on 12.07.2016.
 */
public class DirectionsFragment extends CheckBoxesFragment {
    @Override
    public String[] getContents(int index) {
        return Recipes.directions[index].split("`");
    }
}
