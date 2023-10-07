package com.example.cs2340a;

import android.content.Context;
import android.os.Looper;

//import androidx.test.platform.app.InstrumentationRegistry;
//import androidx.test.ext.junit.runners.AndroidJUnit4;
import com.example.cs2340a.View.initialConfigurationActivity;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
public class Sprint2_Test {

    @Test // Elizabeth Grace Tuggle
    public void difficultyDefaultChosen() {
        initialConfigurationActivity iniConfig = new initialConfigurationActivity();
        assertEquals(iniConfig.getDifficulty(), 1.0);
    }

    // name can't be null
}