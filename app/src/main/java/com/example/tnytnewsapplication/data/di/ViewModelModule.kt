package com.example.tnytnewsapplication.data.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.example.tnytnewsapplication.ui.authorization.AuthorizationViewModel

internal val viewModelModule = module {

    viewModelOf(::AuthorizationViewModel)

}