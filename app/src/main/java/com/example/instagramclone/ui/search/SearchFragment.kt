package com.example.instagramclone.ui.search

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.instagramclone.R
import com.example.instagramclone.databinding.FragmentSearchBinding
import com.example.instagramclone.model.PostDTO
import com.example.instagramclone.utils.Constants.TAG
import com.example.instagramclone.viewBindings
import com.jakewharton.rxbinding4.widget.textChanges
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class SearchFragment : Fragment(R.layout.fragment_search), SearchAdapter.OnSearchViewAdapterListener {

//    private var fragmentSearchBinding: FragmentSearchBinding? = null
    private val fragmentSearchBinding by viewBindings(FragmentSearchBinding::bind)


    private lateinit var searchViewModel: SearchViewModel
    private lateinit var searchAdapter: SearchAdapter

    //옵저버블 제거를 위해서
    private var myCompositeDisposable = CompositeDisposable()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        searchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        //Rx
        val editTextChangeObservable =  fragmentSearchBinding!!.searchfragmentTestEditText.textChanges()

        val searchEditTextSubscription : Disposable =
            editTextChangeObservable.debounce(800, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .subscribeBy(
                    onNext = {
                        if(it.isNotEmpty()){
                            Log.d(TAG, "onCreateView: RXRXRX onNext: $it")
                            searchViewModel.searchPost(it.toString())
                        }
                    },
                    onComplete = {
                        Log.e(TAG, "onCreateView:  onComplete",)
                    },
                    onError = {
                        Log.e(TAG, "onCreateView: onError ${it.toString()}", )
                    },
                )

        searchAdapter = SearchAdapter(requireContext())
        searchAdapter.setAdapterListener(this)

        fragmentSearchBinding.searchMainRecycler?.apply {
            var gridLayoutManager = GridLayoutManager(context, 3)
            layoutManager = gridLayoutManager
            adapter = searchAdapter
        }


        subscribeObservers()
        myCompositeDisposable.add(searchEditTextSubscription)
    }

    private fun subscribeObservers() {
        searchViewModel.postList.observe(viewLifecycleOwner, {
            Log.e(TAG, "subscribeObservers: ${it.toString()}", )
            Log.e(TAG, "subscribeObservers: ${it.size}",)
            searchAdapter.setData(it)
        })
    }

    override fun onResume() {
        super.onResume()
        searchViewModel.defaultPostList()
    }

    override fun onSearchViewClick(view: View, data: PostDTO) {
        findNavController().navigate(R.id.action_searchMain_to_postList)
    }

    override fun onDestroy() {
        myCompositeDisposable.clear()
//        fragmentSearchBinding = null
        super.onDestroy()
    }

    companion object {

        fun newInstance(): SearchFragment {
            return  SearchFragment()
        }

    }
}