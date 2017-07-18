package com.xseed.dx.parent.customView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import com.xseed.dx.parent.R;


/**
 * Created by Manvendra Sah on 01/05/17.
 */

public class FontEditText extends AppCompatEditText {

    public FontEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    public FontEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public FontEditText(Context context) {
        super(context);
        init(null);
    }

    private void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.FontEditText);
            String fontName = a.getString(R.styleable.FontEditText_font_et_typeface);
            boolean isBold = a.getBoolean(R.styleable.FontEditText_font_et_isBold, false);
            try {
                /*  if (fontName != null) {
                  Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/" + fontName);
                }*/

                if (isBold)
                    setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
                else
                    setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));
            } catch (Exception e) {
                e.printStackTrace();
            }
            a.recycle();
        }
    }
}
