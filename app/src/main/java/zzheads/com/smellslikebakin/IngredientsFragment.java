package zzheads.com.smellslikebakin;

/**
 * Created by zzhea on 12.07.2016.
 */
public class IngredientsFragment extends CheckBoxesFragment {
    @Override
    public String[] getContents(int index) {
        return Recipes.ingredients[index].split("`");
    }
}
