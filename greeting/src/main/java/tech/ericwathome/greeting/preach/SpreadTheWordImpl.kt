package tech.ericwathome.greeting.preach

import javax.inject.Inject

class SpreadTheWordImpl @Inject constructor() : SpreadTheWord {
    override fun getABibleVerse(): String {
        return "John 3:16 - In the beginning of the world!!!..."
    }
}