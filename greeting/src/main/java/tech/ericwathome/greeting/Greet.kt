package tech.ericwathome.greeting

import javax.inject.Inject

class Greet @Inject constructor() {
    fun sayHello() = "Hello from greeting module!!!..."
}