package hr.dbab.todokotlin.koinDI

import hr.dbab.todokotlin.database.ToDoDatabase
import hr.dbab.todokotlin.repository.ToDoRepository
import hr.dbab.todokotlin.ui.ToDoViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { ToDoDatabase.getInstance(androidContext()) }

    single { ToDoRepository(get()) }
}

val viewModelModule = module {
    viewModel { ToDoViewModel(get()) }
}