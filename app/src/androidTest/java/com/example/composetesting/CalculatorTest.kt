//package com.example.composetesting
//
//import androidx.compose.ui.test.junit4.createComposeRule
//import androidx.compose.ui.test.*
//import androidx.test.ext.junit.runners.AndroidJUnit4
//import org.junit.Rule
//import org.junit.Test
//import org.junit.runner.RunWith
//
//@RunWith(AndroidJUnit4::class)
//class CalculatorAppTest {
//
//    @get:Rule
//    val composeTestRule = createComposeRule()
//
//    @Test
//    fun addition_isCorrect() {
//        composeTestRule.setContent {
//            CalculatorApp()
//        }
//
//        composeTestRule.onNodeWithText("Enter number 1")
//            .performTextInput("5")
//        composeTestRule.onNodeWithText("Enter number 2")
//            .performTextInput("3")
//
//        composeTestRule.onNodeWithText("Add")
//            .performClick()
//
//        composeTestRule.onNodeWithText("Result: 8")
//            .assertExists()
//    }
//}
