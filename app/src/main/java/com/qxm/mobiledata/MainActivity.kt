package com.qxm.mobiledata

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.qxm.mobiledata.databinding.ActivityMainBinding
import com.qxm.mobiledata.model.DataUsage
import com.qxm.mobiledata.model.MobileDataUsages
import com.qxm.mobiledata.ui.MobileDataViewBinder
import com.qxm.mobiledata.viewmodel.MobileDataVM
import com.qxm.mobiledata.utils.funcextend.observe
import me.drakeet.multitype.MultiTypeAdapter

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            vm = ViewModelProviders.of(this@MainActivity).get(MobileDataVM::class.java)
        }
        initView()
    }

    private fun initView() {
        binding.srl.setColorSchemeResources(R.color.colorPrimary)
        binding.rv.adapter = MultiTypeAdapter(mutableListOf<Any>()).apply {
            register(MobileDataUsages::class.java, MobileDataViewBinder(binding.vm))
        }
        binding.rv.layoutManager = LinearLayoutManager(this)
    }

    private fun initListener() {
        binding.vm?.apply {

            isRefreshing.observe(this@MainActivity) {
                it ?: return@observe
                binding.srl.isRefreshing = it
            }
            /*hotCityItemEvent.observe(this@MainActivity) {
                it ?: return@observe
                Toast.makeText(this@MainActivity, "点击了:$it", Toast.LENGTH_SHORT).show()
            }*/
        }
    }

    override fun onResume() {
        super.onResume()
        binding.vm?.onFirstLoad()
    }
}
