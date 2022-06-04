package ir.ha.dep.feacher.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ir.ha.dep.feacher.BaseFragment
import ir.ha.dep.R
import ir.ha.dep.model.Banner
import ir.ha.dep.services.ImageLoadingService
import ir.ha.dep.utility.customViews.FrescoImageView
import org.koin.android.ext.android.inject

class BannerFragment : BaseFragment() {


    private val imageLoadingService : ImageLoadingService by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val item = inflater.inflate(R.layout.slider_item,container,false) as FrescoImageView
        val banner = requireArguments().getParcelable<Banner>("data")
        imageLoadingService.load(item,banner!!.ImageUrl)
        return item
    }


    companion object{
        fun newInstance(banner: Banner) : BannerFragment {
            return BannerFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("data" ,banner)
                }
            }
        }
    }
}