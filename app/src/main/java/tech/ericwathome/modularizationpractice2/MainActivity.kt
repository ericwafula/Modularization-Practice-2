package tech.ericwathome.modularizationpractice2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import tech.ericwathome.data.preferences.AppPreferences
import tech.ericwathome.greeting.Greet
import tech.ericwathome.greeting.preach.SpreadTheWord
import tech.ericwathome.modularizationpractice2.ui.theme.ModularizationPractice2Theme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var greet: Greet

    @Inject
    lateinit var spreadTheWord: SpreadTheWord

    @Inject
    lateinit var preferences: AppPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModularizationPractice2Theme {
                // A surface container using the 'background' color from the theme
                var onboardingStatus by remember { mutableStateOf(false) }
                val context = LocalContext.current
                val viewModel: MainActivityViewModel = hiltViewModel()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        Greeting(greet.sayHello())
                        PrintBibleVerse(verse = spreadTheWord.getABibleVerse())
                        Button(onClick = {
                            onboardingStatus = !onboardingStatus
                            viewModel.updateOnboardingStatus(onboardingStatus)
                        }) {
                            Text(text = "Update Onboarding status")
                        }
                        Button(onClick = {
                            Toast.makeText(
                                context,
                                "showOnboarding status: ${viewModel.onboardingStatus.value}",
                                Toast.LENGTH_LONG
                            ).show()

                        }) {
                            Text(text = "Check onboarding status")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(text: String) {
    Text(text = text)
}

@Composable
fun PrintBibleVerse(verse: String) {
    Text(text = verse)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ModularizationPractice2Theme {
        Greeting("Android")
    }
}