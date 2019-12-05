package com.example.modularizacao.di

import com.example.modularizacao.feature.listproducts.ProductListAdapter
import com.example.modularizacao.feature.listproducts.ProductListViewModel
import com.squareup.picasso.Picasso
import io.reactivex.android.schedulers.AndroidSchedulers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {


    single { Picasso.get() }

    factory { ProductListAdapter(picasso = get()) }

    viewModel {
        ProductListViewModel(
            useCase = get(),
            uiScheduler = AndroidSchedulers.mainThread()
        )
    }
}
