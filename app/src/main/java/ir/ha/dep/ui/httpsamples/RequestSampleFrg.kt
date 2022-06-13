package ir.ha.dep.ui.httpsamples

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.google.gson.JsonObject
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import ir.ha.dep.R
import ir.ha.dep.databinding.FragmentSampleRequestBinding
import ir.ha.dep.ui.BaseFragment
import ir.ha.dep.utility.extentions.showToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RequestSampleFrg : BaseFragment() {

    lateinit var binding  : FragmentSampleRequestBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = getBinding(R.layout.fragment_sample_request,container!!)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        /** sample of request by retrofit */
        val apiService = RetrofitApiService()
        apiService.apis.testRequest().enqueue(object : Callback<String>{
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful)
                showToast(requireContext(),"$response")
            }
            override fun onFailure(call: Call<String>, t: Throwable) {
                 showToast(requireContext(),t.message.toString())
            }
        })


        /** Gson Sample */
//        val s = Gson().fromJson<String>(JsonObject())

    }
}