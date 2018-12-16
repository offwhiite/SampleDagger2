package white.off.sampledagger2

import javax.inject.Inject


class CoffeeMaker @Inject constructor(private val heater: Heater) {

    fun getTemperature() : String {
        return heater.getTemperature()
    }
}