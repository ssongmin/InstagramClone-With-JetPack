package com.example.instagramclone.navigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.instagramclone.R
import com.example.instagramclone.databinding.FragmentSearchBinding
import com.example.instagramclone.utils.Constants.TAG
import com.example.instagramclone.viewmodel.SearchViewModel
import com.jakewharton.rxbinding4.widget.textChanges
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class SearchFragment : Fragment() {

    private var fragmentSearchBinding: FragmentSearchBinding? = null
    private lateinit var searchViewModel: SearchViewModel

    //옵저버블 제거를 위해서
    private var myCompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding =  FragmentSearchBinding.inflate(inflater, container, false)
        fragmentSearchBinding = binding;

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
                        Log.e(TAG, "onCreateView: onError", )
                    },
                )


        subscribeObservers()
        myCompositeDisposable.add(searchEditTextSubscription)
        return  fragmentSearchBinding!!.root
    }

    private fun subscribeObservers() {
        searchViewModel.postList.observe(viewLifecycleOwner, {
            Log.e(TAG, "subscribeObservers: ${it.toString()}", )
            Log.e(TAG, "subscribeObservers: ${it.size}",)
        })
    }

    override fun onResume() {
        super.onResume()
        searchViewModel.defaultPostList()
    }

    override fun onDestroy() {
        myCompositeDisposable.clear()
        fragmentSearchBinding = null
        super.onDestroy()
    }

    companion object {

        fun newInstance(): SearchFragment{
            return  SearchFragment()
        }

    }
}