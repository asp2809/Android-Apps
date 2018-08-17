package com.example.android.miwok;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mBackgroundColor;


    public WordAdapter(@NonNull Context context, ArrayList<Word> words, int BackgroundColor) {
        super(context, 0, words);
        mBackgroundColor = BackgroundColor;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View myview = convertView;

        if(myview == null) {
            myview = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView miwokWord = (TextView)myview.findViewById(R.id.miwokword);
        TextView englishWord = (TextView)myview.findViewById(R.id.englishword);
        LinearLayout layoutouter = (LinearLayout)myview.findViewById((R.id.layoutouter));

        miwokWord.setText(currentWord.getMiwokTranslation());
        englishWord.setText(currentWord.getDefaultTranslation());
        ImageView image = (ImageView)myview.findViewById(R.id.image);
        layoutouter.setBackgroundResource(mBackgroundColor);

        if(currentWord.isValid) {
            image.setImageResource(currentWord.getImageResourceID());
            image.setVisibility(View.VISIBLE);
        }

        else {
            image.setVisibility(View.GONE);
        }

        return myview;
    }
}
