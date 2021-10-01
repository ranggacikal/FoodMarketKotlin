package com.ranggacikal.foodmarketkotlin.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ranggacikal.foodmarketkotlin.R
import com.ranggacikal.foodmarketkotlin.databinding.FragmentHomeBinding
import com.ranggacikal.foodmarketkotlin.model.dummy.HomeModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeAdapter.ItemAdapterCallback {

    private var foodList : ArrayList<HomeModel> = ArrayList()
    private var _binding: FragmentHomeBinding? = null

    val gambar1 : String = "https://awsimages.detik.net.id/community/media/visual/2021/04/22/5-makanan" +
            "-enak-dari-indonesia-dan-malaysia-yang-terkenal-enak-5.jpeg?w=700&q=90"

    val gambar2: String = "https://cdns.klimg.com/merdeka.com/i/w/news/2020/06/13/1187155/540x270/7-makanan-" +
            "terenak-di-dunia-yang-wajib-dicoba-salah-satunya-dari-indonesia.jpg"

    val gambar3: String = "https://d99i6ad9lbm5v.cloudfront.net/uploads/image/file/11675/menu_makanan.jpg"

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initDataDummy()
        var adapter = HomeAdapter(foodList,this)
        var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rcList.layoutManager = layoutManager
        rcList.adapter = adapter

        val sectionPagerAdapter = SectionPagerAdapter(childFragmentManager)

        viewPager.adapter = sectionPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }

    fun initDataDummy(){

        foodList = ArrayList()
        foodList.add(HomeModel("Cherry Healthy", gambar1, 5f))
        foodList.add(HomeModel("Burger Tamayo", gambar2, 4f))
        foodList.add(HomeModel("Bakhwan Cihuy", gambar3, 3f))


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View, data: HomeModel) {

    }
}