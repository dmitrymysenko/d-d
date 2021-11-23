package dmitry.mysenko.clean.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dmitry.mysenko.clean.domain.categories.models.CategoryItem
import dmitry.mysenko.clean.domain.categories.usecases.GetCategoryItemsUseCase
import dmitry.mysenko.clean.domain.response.ResultWrapper
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getCategoryItemsUseCase: GetCategoryItemsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(
        SearchState(
            searchScreenState = SearchScreenState.Loading,
            searchedText = "",
            category = Categories.classes,
            data = listOf(),
            throwable = null
        )
    )
    val stateFlow: StateFlow<SearchState> = _state.asStateFlow()

    init {
        getListShortData(Categories.classes, "")
    }

    private fun getListShortData(category: Categories, searchedText: String) {
        viewModelScope.launch {
            when (val result = getCategoryItemsUseCase.execute(category.name, searchedText)) {
                is ResultWrapper.Success -> {
                    searchStore(
                        SearchAction.DataAction(
                            searchedText = searchedText,
                            category = category,
                            data = result.value.map { SearchItem(
                                index = it.index,
                                name = it.name,
                                url = it.url
                            ) }
                        )
                    )
                }
                is ResultWrapper.GenericError -> {
                    searchStore(
                        SearchAction.ErrorAction(
                            searchedText = searchedText,
                            category = category,
                            throwable = result.throwable
                        )
                    )
                }
            }
        }
    }

    private fun searchStore(action: SearchAction) {
//        Timber.e("Action = ${action} state = ${_state.value}")
        val currentState = _state.value
        when (action) {
            is SearchAction.SearchedTextAction -> {
                when (currentState.searchScreenState) {
                    SearchScreenState.Loading -> {
                        if(currentState.searchedText != action.searchedText) {
                            _state.tryEmit(currentState.copy(searchedText = action.searchedText))
                        }
                    }
                    SearchScreenState.Empty -> _state.tryEmit(
                        currentState.copy(
                            searchScreenState = SearchScreenState.Loading,
                            searchedText = action.searchedText
                        )
                    )
                    SearchScreenState.Data -> _state.tryEmit(
                        currentState.copy(
                            searchScreenState = SearchScreenState.Loading,
                            searchedText = action.searchedText,
                            data = listOf()
                        )
                    )
                    SearchScreenState.Error -> _state.tryEmit(
                        currentState.copy(
                            searchScreenState = SearchScreenState.Loading,
                            searchedText = action.searchedText,
                            throwable = null
                        )
                    )
                }
                    getListShortData(currentState.category, action.searchedText)
            }
            is SearchAction.CategoryAction -> {
                when (currentState.searchScreenState) {
                    SearchScreenState.Loading -> {
                        if(currentState.category != action.category) {
                            _state.tryEmit(currentState.copy(category = action.category))
                        }
                    }
                    SearchScreenState.Empty -> _state.tryEmit(
                        currentState.copy(
                            searchScreenState = SearchScreenState.Loading,
                            category = action.category
                        )
                    )
                    SearchScreenState.Data -> _state.tryEmit(
                        currentState.copy(
                            searchScreenState = SearchScreenState.Loading,
                            category = action.category,
                            data = listOf()
                        )
                    )
                    SearchScreenState.Error -> _state.tryEmit(
                        currentState.copy(
                            searchScreenState = SearchScreenState.Loading,
                            category = action.category,
                            throwable = null
                        )
                    )
                }
                getListShortData(action.category, currentState.searchedText)
            }
            is SearchAction.DataAction -> {
                if (currentState.searchedText == action.searchedText && currentState.category == action.category) {
                    _state.tryEmit(
                        currentState.copy(
                            searchScreenState = if(action.data.isEmpty()) SearchScreenState.Empty else SearchScreenState.Data,
                            data = action.data,
                            throwable = null
                        )
                    )
                }
            }
            is SearchAction.ErrorAction -> {
                if (currentState.searchedText == action.searchedText && currentState.category == action.category) {
                    _state.tryEmit(
                        currentState.copy(
                            searchScreenState = SearchScreenState.Error,
                            data = null,
                            throwable = action.throwable
                        )
                    )
                }
            }
        }
    }

    fun setNewCategory(category: Categories) {
        searchStore(SearchAction.CategoryAction(category = category))
    }

    @FlowPreview
    fun observeSearch(search: Flow<String>) {
        search.distinctUntilChanged()
            .debounce(500)
            .onEach { searchStore(SearchAction.SearchedTextAction(searchedText = it)) }
            .launchIn(viewModelScope)
    }
}

sealed class SearchAction {
    class SearchedTextAction(val searchedText: String) : SearchAction()
    class CategoryAction(val category: Categories) : SearchAction()
    class DataAction(
        val searchedText: String,
        val category: Categories,
        val data: List<SearchItem>
    ) : SearchAction()

    class ErrorAction(
        val searchedText: String,
        val category: Categories,
        val throwable: Throwable
    ) : SearchAction()
}

data class SearchState(
    val searchScreenState: SearchScreenState,
    val searchedText: String,
    val category: Categories,
    val data: List<SearchItem>?,
    val throwable: Throwable?
)

enum class SearchScreenState {
    Loading, Empty, Data, Error
}

//sealed class SearchState {
//    data class LoadingState(
//        val searchedText: String,
//        val category: Categories,
//        val data: List<CategoryItem>
//    ) : SearchState()
//
//    data class EmptyState(
//        val searchedText: String,
//        val category: Categories
//    ) : SearchState()
//
//    data class DataState(
//        val searchedText: String,
//        val category: Categories,
//        val data: List<CategoryItem>
//    ) : SearchState()
//
//    data class ErrorState(
//        val searchedText: String,
//        val category: Categories,
//        val throwable: Throwable
//    ) : SearchState()
//}

enum class Categories {
    classes, races, equipments, spells, feats, monsters, rules
}