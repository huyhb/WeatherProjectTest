package demo.com.weatherapp.screen.main.login

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProviders
import demo.com.weatherapp.BR
import demo.com.weatherapp.R
import demo.com.weatherapp.databinding.ActivityLoginBinding
import demo.com.weatherapp.screen.base.activity.BaseBindingActivity
import demo.com.weatherapp.screen.main.demo.DemoActivity
import demo.com.weatherapp.screen.main.inventoryList.InventoryListActivity

class LoginActivity: BaseBindingActivity<ActivityLoginBinding, LoginViewModel>(){

    private val TAG = "LoginActivity"

    override val bindingVariable: Int
        get() = BR.viewModel

    override val viewModel: LoginViewModel
        get() = ViewModelProviders.of(this).get(LoginViewModel::class.java)

    override val layoutResource: Int
        get() = R.layout.activity_login

    override fun initVariable(savedInstanceState: Bundle?) {
        viewDataBinding?.btnLogin?.setOnClickListener(this)

    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun initData(savedInstanceState: Bundle?) {
        changeColorStatusBar()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_login -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    // Apply activity transition
                    val intent = Intent(this, DemoActivity::class.java)
                    startActivity(intent)
                } else {
                    // Swap without transition
                    val intent = Intent(this, DemoActivity::class.java)
                    startActivity(intent)
                }

            }
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (event?.getAction() == KeyEvent.ACTION_DOWN) {
            //do something here
            when(keyCode){
                KeyEvent.KEYCODE_BUTTON_R1 ->{
                    Log.d("onKeyDown", "scan code")
                    viewDataBinding?.edtEmail?.clearFocus()
                    viewDataBinding?.edtPw?.clearFocus()
                }
            }

        }
        return false;

    }


}