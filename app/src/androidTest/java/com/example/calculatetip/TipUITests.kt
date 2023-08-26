package com.example.calculatetip

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import org.junit.Test
import java.text.NumberFormat
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.calculatetip.ui.theme.CalculateTipTheme
import org.junit.Rule

class TipUITests {

  @get:Rule
  val composeTestRule = createComposeRule()

  @Test
  fun calculate_20_percent_tip() {
    composeTestRule.setContent {
      CalculateTipTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
          TipTimeLayout()
        }
      }
    }
    composeTestRule.onNodeWithText("Bill Amount")
      .performTextInput("10")
    composeTestRule.onNodeWithText("Tip Percentage").performTextInput("20")
    val expectedTip = NumberFormat.getCurrencyInstance().format(2)
    composeTestRule.onNodeWithText("Tip Amount: $expectedTip").assertExists(
      "No node with this text was found."
    )
  }
}