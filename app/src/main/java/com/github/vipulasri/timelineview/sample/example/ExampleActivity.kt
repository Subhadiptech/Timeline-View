package com.github.vipulasri.timelineview.sample.example

import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.vipulasri.timelineview.sample.BaseActivity
import com.github.vipulasri.timelineview.sample.databinding.ActivityExampleBinding
import com.github.vipulasri.timelineview.sample.model.OrderStatus
import com.github.vipulasri.timelineview.sample.model.TimeLineModel
import java.util.ArrayList

/**
 * Created by Vipul Asri on 13-12-2018.
 */
class ExampleActivity : BaseActivity<ActivityExampleBinding>() {

  override val bindingInflater: (LayoutInflater) -> ActivityExampleBinding
    get() = ActivityExampleBinding::inflate

  private val dataList = ArrayList<TimeLineModel>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setToolbar(binding.toolbar, isHomeButtonEnabled = true)

    setDataListItems()
    initRecyclerView()
  }

  private fun setDataListItems() {
    dataList.add(TimeLineModel("Item successfully delivered", "", OrderStatus.INACTIVE))
    dataList.add(
      TimeLineModel(
        "Courier is out to delivery your order",
        "2017-02-12 08:00",
        OrderStatus.ACTIVE
      )
    )
    dataList.add(
      TimeLineModel(
        "Item has reached courier facility at New Delhi",
        "2017-02-11 21:00",
        OrderStatus.COMPLETED
      )
    )
    dataList.add(
      TimeLineModel(
        "Item has been given to the courier",
        "2017-02-11 18:00",
        OrderStatus.COMPLETED
      )
    )
    dataList.add(
      TimeLineModel(
        "Item is packed and will dispatch soon",
        "2017-02-11 09:30",
        OrderStatus.COMPLETED
      )
    )
    dataList.add(
      TimeLineModel(
        "Order is being readied for dispatch",
        "2017-02-11 08:00",
        OrderStatus.COMPLETED
      )
    )
    dataList.add(
      TimeLineModel(
        "Order processing initiated",
        "2017-02-10 15:00",
        OrderStatus.COMPLETED
      )
    )
    dataList.add(
      TimeLineModel(
        "Order confirmed by seller",
        "2017-02-10 14:30",
        OrderStatus.COMPLETED
      )
    )
    dataList.add(
      TimeLineModel(
        "Order placed successfully",
        "2017-02-10 14:00",
        OrderStatus.COMPLETED
      )
    )
  }

  private fun initRecyclerView() {
    binding.recyclerView.run {
      layoutManager = LinearLayoutManager(this@ExampleActivity, RecyclerView.VERTICAL, false)
      adapter = ExampleTimeLineAdapter(dataList)

    }
  }

}
