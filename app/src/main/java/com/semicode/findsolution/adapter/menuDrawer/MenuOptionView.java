package com.semicode.findsolution.adapter.menuDrawer;


import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.semicode.findsolution.R;


public class MenuOptionView extends RelativeLayout {
    private OptionViewHolder mOptionViewHolder;

    public MenuOptionView(Context context) {
        this(context, null);
    }

    public MenuOptionView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MenuOptionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    private void initialize() {
        ViewGroup rootView = (ViewGroup) inflate(getContext(), R.layout.item_menu_option, this);

        mOptionViewHolder = new OptionViewHolder(rootView);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        setSelected(isSelected());
    }


    public void setSelected(boolean selected) {
        if (selected) {
            mOptionViewHolder.makeSelected();
            mOptionViewHolder.textViewOption.setTextColor(getResources().getColor(R.color.colorAccent));
            mOptionViewHolder.layout.setBackgroundColor(getResources().getColor(R.color.soft_blue));


        }else {
            mOptionViewHolder.makeUnSelected();
            mOptionViewHolder.textViewOption.setTextColor(getResources().getColor(R.color.gray));
            mOptionViewHolder.layout.setBackgroundColor(getResources().getColor(R.color.white));

        }
    }

    /**
     * Check if the option view is selected or not.
     *
     * @return True if the option view is selected.
     */
    public boolean isSelected() {
        return mOptionViewHolder.imageViewSelector.getVisibility() == VISIBLE;
    }

    /**
     * Binds the option view with it's content
     *
     * @param optionText           Text to show as option in the menu.
     * @param selectorDrawable     Selector to show when option is selected.
     *                             Set to "null" to use it's default.
     *                             By default it shows a white circle.
     * @param selectorSideDrawable Side selector to show when option is selected.
     *                             Set to "null" to use it's default.
     *                             By default it shows a red rectangle.
     */
    public void bind(String optionText, @Nullable Drawable selectorDrawable, @Nullable Drawable selectorSideDrawable) {
        mOptionViewHolder.textViewOption.setText(optionText);
        mOptionViewHolder.textViewOption.setTextColor(getResources().getColor(R.color.gray));
        if (selectorDrawable != null) {
            mOptionViewHolder.imageViewOption.setImageDrawable(selectorDrawable);
        }

        if (selectorSideDrawable != null) {
            mOptionViewHolder.imageViewSelector.setImageDrawable(selectorSideDrawable);
        }
        mOptionViewHolder.makeUnSelected();
    }

    /**
     * View holder that holds the views for this layout.
     */
    private class OptionViewHolder {
        private TextView textViewOption;
        private ImageView imageViewOption;
        private ImageView imageViewSelector;
        private RelativeLayout layout ;

        OptionViewHolder(ViewGroup rootView) {
            textViewOption =  rootView.findViewById(R.id.menu_option_tv);
            imageViewOption =  rootView.findViewById(R.id.menu_option_iv);
            imageViewSelector =  rootView.findViewById(R.id.menu_option_iv_selectef);
            layout =  rootView.findViewById(R.id.menu_option_layout);

            makeUnSelected();
        }

        /**
         * By default both selectors are disabled.
         */
        private void makeSelected() {
            imageViewOption.setVisibility(INVISIBLE);
            imageViewSelector.setVisibility(VISIBLE);
        }
        private void makeUnSelected() {
            imageViewOption.setVisibility(VISIBLE);
            imageViewSelector.setVisibility(GONE);
        }
    }
}
