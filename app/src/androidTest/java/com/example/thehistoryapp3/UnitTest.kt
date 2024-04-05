package com.example.thehistoryapp3

import android.widget.EditText
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @Rule
    @JvmField
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testValidAge() {
        onView(withId(R.id.ageView)).perform(typeText("30"), closeSoftKeyboard())
        onView(withId(R.id.clickButton)).perform(click())
        onView(withId(R.id.textInfo)).check(matches(withText("Famous person at the Age of 30: Bob Marley one the most talented musicians to ever live")))
    }

    @Test
    fun testInvalidAgeEmpty() {
        onView(withId(R.id.ageView)).perform(clearText())
        onView(withId(R.id.clickButton)).perform(click())
        onView(withText("Please enter valid age")).check(matches(isDisplayed()))
    }

    @Test
    fun testInvalidAgeNonInteger() {
        onView(withId(R.id.ageView)).perform(typeText("abc"), closeSoftKeyboard())
        onView(withId(R.id.clickButton)).perform(click())
        onView(withText("APP only accepts whole Integers please try again")).check(matches(isDisplayed()))
    }

    @Test
    fun testInvalidAgeOutOfRange() {
        onView(withId(R.id.ageView)).perform(typeText("10"), closeSoftKeyboard())
        onView(withId(R.id.clickButton)).perform(click())
        onView(withText("Your age is out of the (20-100) range ")).check(matches(isDisplayed()))
    }

    @Test
    fun testNoFamousPersonFound() {
        onView(withId(R.id.ageView)).perform(typeText("95"), closeSoftKeyboard())
        onView(withId(R.id.clickButton)).perform(click())
        onView(withText("Sorry we couldn't find any person at this 95")).check(matches(isDisplayed()))
    }
}
