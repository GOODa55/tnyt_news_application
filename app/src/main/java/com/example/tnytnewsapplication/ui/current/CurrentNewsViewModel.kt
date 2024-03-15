package com.example.tnytnewsapplication.ui.current

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.tnytnewsapplication.Constance
import com.example.tnytnewsapplication.data.api.NewsApi
import com.example.tnytnewsapplication.data.model.CurrentStory
import com.example.tnytnewsapplication.data.pagging.CurrentNewsDataSource
import kotlinx.coroutines.flow.Flow
class CurrentNewsViewModel constructor(val api: NewsApi) : ViewModel() {
    fun getAllCurrentNews(token: String): Flow<PagingData<CurrentStory>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                initialLoadSize = 10,
                prefetchDistance = 3,
                maxSize = 30
            ),
            pagingSourceFactory = {
                CurrentNewsDataSource(api, token, Constance.SOURCE_INYT, Constance.SECTION_ALL)
            }, initialKey = 0
        ).flow.cachedIn(viewModelScope)
    }


}