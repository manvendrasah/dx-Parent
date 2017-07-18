package com.xseed.dx.parent.customView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.xseed.dx.parent.R;

/**
 * Created by Manvendra Sah on 28/04/17.
 */

public class FontTextView extends AppCompatTextView {

    public FontTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    public FontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public FontTextView(Context context) {
        super(context);
        init(null);
    }

    private void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.FontTextView);
            String fontName = a.getString(R.styleable.FontTextView_font_tv_typeface);
            boolean isBold = a.getBoolean(R.styleable.FontTextView_font_tv_isBold, false);
            boolean isThin = a.getBoolean(R.styleable.FontTextView_font_tv_isThin, false);
            try {
               /* Typeface mTypeface;
                if (isBold)
                    mTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/Khula-SemiBold.ttf");
                else if (isThin)
                    mTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/Khula-Light.ttf");
                else
                    mTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/Khula-Regular.ttf");
                setTypeface(mTypeface);*/

                if (isBold)
                    setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
                else if (isThin)
                    setTypeface(Typeface.create("sans-serif-light", Typeface.NORMAL));
                else
                    setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));

            } catch (Exception e) {
                e.printStackTrace();
            }
            a.recycle();
        }
    }
}
