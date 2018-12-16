package white.off.sampledagger2

import javax.inject.Inject


class Heater @Inject constructor() {

    fun getTemperature() : String {
        return "38度"
    }
}