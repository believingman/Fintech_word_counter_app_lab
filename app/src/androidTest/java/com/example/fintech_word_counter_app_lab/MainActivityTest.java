package com.example.fintech_word_counter_app_lab;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.instanceOf;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testWordCountWithSpinnerSelection() {
        // Įveda tekstą į EditText
        onView(withId(R.id.edUserInput)).perform(replaceText("Hello world"));

        // Atidaro Spinner
        onView(withId(R.id.ddSelection)).perform(click());

        // Pasirenka "zodziai" iš Spinner
        onData(allOf(is(instanceOf(String.class)), is("zodziai"))).perform(click());

        // Paspaudžia mygtuką
        onView(withId(R.id.btnCalculate)).perform(click());

        // Tikrina ar rezultatas yra "zodziai: 2"
        onView(withId(R.id.tvOutput)).check(matches(withText("zodziai: 2")));
    }
}
