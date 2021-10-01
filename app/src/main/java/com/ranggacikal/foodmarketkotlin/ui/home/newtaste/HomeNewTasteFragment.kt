package com.ranggacikal.foodmarketkotlin.ui.home.newtaste

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ranggacikal.foodmarketkotlin.R
import com.ranggacikal.foodmarketkotlin.model.dummy.HomeModel
import com.ranggacikal.foodmarketkotlin.model.dummy.HomeVerticalModel
import com.ranggacikal.foodmarketkotlin.ui.home.HomeAdapter
import kotlinx.android.synthetic.main.fragment_home_new_taste.*

class HomeNewTasteFragment : Fragment(), HomeNewtasteAdapter.ItemAdapterCallback {

    private var foodListVertical : ArrayList<HomeVerticalModel> = ArrayList()

    val gambar1 : String = "https://awsimages.detik.net.id/community/media/visual/2021/04/22/5-makanan" +
            "-enak-dari-indonesia-dan-malaysia-yang-terkenal-enak-5.jpeg?w=700&q=90"

    val gambar2: String = "https://cdns.klimg.com/merdeka.com/i/w/news/2020/06/13/1187155/540x270/7-makanan-" +
            "terenak-di-dunia-yang-wajib-dicoba-salah-satunya-dari-indonesia.jpg"

    val gambar3: String = "https://d99i6ad9lbm5v.cloudfront.net/uploads/image/file/11675/menu_makanan.jpg"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_new_taste, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initDataDummy()
        var adapter = HomeNewtasteAdapter(foodListVertical, this)
        var  layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rcListNewTaste.layoutManager = layoutManager
        rcListNewTaste.adapter = adapter
    }

    fun initDataDummy(){

        foodListVertical = ArrayList()
        foodListVertical.add(HomeVerticalModel("Cherry Healthy", "12000", gambar1, 5f))
        foodListVertical.add(HomeVerticalModel("Burger Tamayo", "23000", gambar2, 4f))
        foodListVertical.add(HomeVerticalModel("Bakhwan Cihuy", "17000", gambar3, 3f))


    }

    override fun onClick(v: View, data: HomeVerticalModel) {

    }
}