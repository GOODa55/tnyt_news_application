package com.example.tnytnewsapplication.data.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.example.tnytnewsapplication.ui.authorization.AuthorizationViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.example.tnytnewsapplication.ui.current.CurrentNewsViewModel

internal val viewModelModule = module {
    single {
        Firebase.auth
    }
    viewModelOf(::AuthorizationViewModel)
    viewModelOf(::CurrentNewsViewModel)


}