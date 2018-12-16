package white.off.sampledagger2

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import dagger.Component
import white.off.sampledagger2.databinding.MainActivityBinding
import white.off.sampledagger2.other.OtherActivity

class MainActivity : AppCompatActivity() {

    private lateinit var coffeeShop :CoffeeShop

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBinding = DataBindingUtil.setContentView<MainActivityBinding>(this, R.layout.main_activity)

        // DaggerCoffeeShopはComponent interfaceを継承したクラス。
        // Dagger2によってビルド時に自動生成される。
        coffeeShop = DaggerCoffeeShop.create()

        // ビルド時に自動生成されたクラスがDIしてくれているので、
        // maker()実行だけで、メンバにインジェクト済みのインスタンスが取得できる
        val coffeeMaker = coffeeShop.maker()

        // 38度が返ってくる
        dataBinding.textView.text = coffeeMaker.getTemperature()
    }

    fun onClick(v: View) {
        val intent = Intent(this, OtherActivity::class.java)
        startActivity(intent)
    }
}

@Component
interface CoffeeShop {
    fun maker(): CoffeeMaker
}
