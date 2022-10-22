package com.example.timeconverter

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.containsString
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ConverterTests {
    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun convertToSeconds() {
        onView(withId(R.id.minutes_to_convert_edit_text)).perform(typeText("20"))
        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.convert_result)).check(matches(withText(containsString("1200"))))
    }

    @Test
    fun convertToHours() {
        onView(withId(R.id.minutes_to_convert_edit_text)).perform(typeText("20"))
        onView(withId(R.id.option_hours)).perform(click())
        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.convert_result)).check(matches(withText(containsString("0.333"))))
    }

    @Test
    fun convertToDays() {
        onView(withId(R.id.minutes_to_convert_edit_text)).perform(typeText("20"))
        onView(withId(R.id.option_days)).perform(click())
        onView(withId(R.id.round_up_switch)).perform(click())
        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.convert_result)).check(matches(withText(containsString("0.013"))))
    }
}