package white.off.sampledagger2.other

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.Component
import white.off.sampledagger2.CoffeeMaker
import white.off.sampledagger2.DaggerCoffeeShop
import white.off.sampledagger2.R
import white.off.sampledagger2.databinding.OtherActivityBinding
import javax.inject.Inject

class OtherActivity : AppCompatActivity() {

    @Inject lateinit var coffeeMaker : CoffeeMaker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<OtherActivityBinding>(this,R.layout.other_activity)

        DaggerActivityComponent.create().inject(this)

        binding.textView.text = coffeeMaker.getTemperature()
    }
}

@Component
interface ActivityComponent {
    fun inject(activity:OtherActivity)
}