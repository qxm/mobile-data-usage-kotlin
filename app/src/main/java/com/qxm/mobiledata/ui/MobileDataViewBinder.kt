package com.qxm.mobiledata.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.qxm.mobiledata.databinding.ItemMobileDataUsageBinding
import com.qxm.mobiledata.model.DataUsage
import com.qxm.mobiledata.model.MobileDataUsages
import com.qxm.mobiledata.utils.databinding.BindingHolder
import com.qxm.mobiledata.viewmodel.MobileDataVM
import me.drakeet.multitype.ItemViewBinder

class MobileDataViewBinder(private val vm: MobileDataVM?) : ItemViewBinder<MobileDataUsages, BindingHolder<ItemMobileDataUsageBinding>>() {
    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): BindingHolder<ItemMobileDataUsageBinding> {
        return BindingHolder(ItemMobileDataUsageBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: BindingHolder<ItemMobileDataUsageBinding>, item: MobileDataUsages) {
        holder.binding.data = item
        //holder.binding.vm = vm
        holder.binding.executePendingBindings()
    }
}