package com.example.wechatmoments.view;

import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.wechatmoments.data.entity.Comment;

import java.util.List;

public class CommentsView extends LinearLayout {

    private static final int SIZE = 15;
    private static final int COLOR = 0xff686868;
    private static final int TOP_MARGIN = 10;
    private static final int BOTTOM_MARGIN = 10;
    private List<Comment> comments;

    public CommentsView(Context context) {
        this(context, null);
    }

    public CommentsView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommentsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(VERTICAL);
    }

    public void setList(List<Comment> list) {
        comments = list;
    }

    public void notifyDataSetChanged() {
        removeAllViews();
        if (comments == null || comments.size() <= 0) {
            return;
        }
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, TOP_MARGIN, 0, BOTTOM_MARGIN);
        for (int i = 0; i < comments.size(); i++) {
            View view = createView(i);
            addView(view, i, layoutParams);
        }
    }

    private View createView(final int position) {
        final Comment item = comments.get(position);
        TextView textView = new TextView(getContext());
        textView.setTextSize(SIZE);
        textView.setTextColor(COLOR);
        String str = item.getContent();
        textView.setText(Html.fromHtml(str));
        textView.setHighlightColor(getResources().getColor(android.R.color.holo_blue_dark));
        return textView;
    }

}
