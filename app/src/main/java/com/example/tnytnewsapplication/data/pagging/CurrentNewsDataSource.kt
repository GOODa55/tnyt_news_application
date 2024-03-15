package com.example.tnytnewsapplication.data.pagging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.tnytnewsapplication.data.api.NewsApi
import com.example.tnytnewsapplication.data.model.CurrentStory


class CurrentNewsDataSource constructor(val api: NewsApi, val token: String, val source: String, val sections: String) : PagingSource<Int, CurrentStory>() {


    override fun getRefreshKey(state: PagingState<Int, CurrentStory>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CurrentStory> {
        return try{
            val pageSize = params.loadSize
            val page = params.key ?: 0
            val offset = page * 10
            val limit = 10
            val response = api.getCurrentNews(token, source, sections, limit, offset)
            val currentStory = checkNotNull(response.body()).results
            val nextKey = if (currentStory.size < pageSize) null else page + 1
            val prevKey = if (page == 0) null else page - 1
            LoadResult.Page(
                data = currentStory,
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (e: Exception){
            LoadResult.Error(e)
        }
    }
}