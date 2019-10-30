package com.example.kiiskin

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import kotlinx.android.synthetic.main.activity_signup.*

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runners.JUnit4

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(JUnit4::class)
class ExampleInstrumentedTest {

    @Rule
    @JvmField
    val rule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.kiiskin", appContext.packageName)
    }

    @Test
    fun userMessageTest(){
        onView(withId(R.id.UserMessage)).perform(typeText("anki"))
    }

    @Test
    fun mainRegTest(){
        onView(withId(R.id.MainRegButton)).perform(click())
    }

}
