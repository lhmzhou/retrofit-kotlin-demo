package lhmzhou.apiExample

import io.reactivex.Observable

class SearchRepository(val apiService: GithubApiService) {

    fun searchUsers(location: String, language: String): io.reactivex.Observable<Result> {
        return apiService.search(query = "location:$location language:$language")
    }

    fun searchUsers(username: String): Observable<Result> {
        return apiService.search(query = username)
    }
}

object SearchRepositoryProvider {

    fun provideSearchRepository(): SearchRepository {
        return SearchRepository(GithubApiService.Factory.create())
    }

}