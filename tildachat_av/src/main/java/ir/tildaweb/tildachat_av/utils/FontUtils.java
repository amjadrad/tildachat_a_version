package ir.tildaweb.tildachat_av.utils;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FontUtils {

    private Typeface typeface;

    public FontUtils(Typeface typeface)
    {
        this.typeface = typeface;
    }

    public FontUtils(AssetManager assets, String assetsFontFileName)
    {
        typeface = Typeface.createFromAsset(assets, assetsFontFileName);
    }

    public void replaceFonts(ViewGroup viewTree)
    {
        View child;
        for(int i = 0; i < viewTree.getChildCount(); ++i)
        {
            child = viewTree.getChildAt(i);
            if(child instanceof ViewGroup)
            {
                // recursive call
                replaceFonts((ViewGroup)child);
            }
            else if(child instanceof TextView)
            {
                // base case
                ((TextView) child).setTypeface(typeface);
            }
        }
    }
}