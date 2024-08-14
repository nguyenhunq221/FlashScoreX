package com.vnc.flashscorex.ui.dashboard.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vnc.flashscorex.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NewsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NewsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NewsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


    // using rxjava
//    fun main() {
//        val list = listOf("apple", "banana", "orange", "grape")
//
//        val observable = Observable.fromIterable(list)
//
//        observable
//            .subscribeOn(Schedulers.io())
//            .observeOn(Schedulers.single())
//            .subscribe { fruit ->
//                println("Received: $fruit")
//            }
//    }


//    mInteractor.getProvinceDistrictCommune(UserModel.loadData(getViewContext()).getToken(), code,
//    new CommonCallback<ProvinceResult>(getViewContext()){
//        @Override
//        protected void onSuccess(Call<ProvinceResult> call, Response<ProvinceResult> response) {
//            super.onSuccess(call, response);
//            Observable.fromIterable(response.body().getData())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .toSortedList(new Comparator<ProvinceModel>() {
//                    @Override
//                    public int compare(ProvinceModel o1, ProvinceModel o2) {
//                        Collator collator = Collator.getInstance(new Locale("vi"));
//                        return collator.compare(o1.getName(), o2.getName());
//                    }
//                })
//                .subscribe(new SingleObserver<List<ProvinceModel>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onSuccess(List<ProvinceModel> provinceModels) {
//                        showDataAfterSort((ArrayList<ProvinceModel>) provinceModels, typeProvincesDistrictsCommunes);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//                });
//        }
//
//        @Override
//        protected void onError(Call<ProvinceResult> call) {
//            super.onError(call);
//
//            Toast.showToast(getViewContext(), R.string.error_fail_default);
//        }
//    });
}