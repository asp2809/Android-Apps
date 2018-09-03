package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private AudioManager audioManager;
    AudioManager.OnAudioFocusChangeListener afChangeListener=new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int i) {
            if(i==AudioManager.AUDIOFOCUS_GAIN)
            {
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
            if(i==AudioManager.AUDIOFOCUS_GAIN_TRANSIENT)
            {
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
            if(i== AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
            if(i== AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            }
            if(i== AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            }
        }
    };

    private MediaPlayer.OnCompletionListener mCompletionListener=new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mMediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        audioManager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> members = new ArrayList<>();
        members.add(new Word("father", "әpә", R.drawable.family_father, R.raw.family_father));
        members.add(new Word("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
        members.add(new Word("son", "angsi", R.drawable.family_son, R.raw.family_son));
        members.add(new Word("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        members.add(new Word("older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        members.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        members.add(new Word("older sister", "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
        members.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        members.add(new Word("grandmother", "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        members.add(new Word("grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather));
        WordAdapter adapter = new WordAdapter(this, members, R.color.category_family);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int res=audioManager.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if(res==AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
                {
                    mMediaPlayer=MediaPlayer.create(FamilyActivity.this, members.get(i).getAudioResourceID());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            audioManager.abandonAudioFocus(afChangeListener);
        }
    }
}
