package com.kokomusoft.panticul.utils;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

import com.kokomusoft.panticul.R;

/**
 * Created by Gabriel on 22/03/2015.
 */
public class ScreenMeasures {
    Context context;

   public ScreenMeasures(Context context){
       this.context = context;
   }

    public static int getStatusBarHeight(final Context context) {
        final Resources resources = context.getResources();
        final int resourceId = resources.getIdentifier("status_bar_height",
                "dimen", "android");

        if (resourceId > 0)
            return resources.getDimensionPixelSize(resourceId);
        else
            return (int) Math.ceil(25 * resources.getDisplayMetrics().density);
    }

    public static int getActionBarHeight(Activity activity){
        TypedValue typedValue = new TypedValue();


        if (activity.getTheme().resolveAttribute(R.attr.actionBarSize,
                typedValue, true)){
            int actionBarHeight = TypedValue.complexToDimensionPixelSize(
                    typedValue.data, activity.getResources().getDisplayMetrics());
            return actionBarHeight;
        }else{
            return 0;
        }

    }


}
