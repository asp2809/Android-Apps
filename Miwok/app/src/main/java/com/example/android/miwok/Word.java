package com.example.android.miwok;

public class Word {

    public boolean isValid;

    private int mimageResourceId;

    private String mmiwokTranslation;

    private String mdefaultTranslation;

    private int maudioResourceId;

    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId) {
        this.mdefaultTranslation = defaultTranslation;
        this.mmiwokTranslation = miwokTranslation;
        this.maudioResourceId = audioResourceId;
        isValid = false;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId) {
        this.mdefaultTranslation = defaultTranslation;
        this.mmiwokTranslation = miwokTranslation;
        this.mimageResourceId = imageResourceId;
        this.maudioResourceId = audioResourceId;
        isValid = true;
    }

    public String getMiwokTranslation() {
        return mmiwokTranslation;
    }

    public String getDefaultTranslation() {
        return mdefaultTranslation;
    }

    public int getImageResourceID() {
        return mimageResourceId;
    }

    public int getAudioResourceID() { return maudioResourceId; }
}
