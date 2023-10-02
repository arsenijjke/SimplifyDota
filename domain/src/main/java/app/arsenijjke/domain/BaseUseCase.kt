package app.arsenijjke.domain

import kotlinx.coroutines.flow.Flow

interface BaseUseCase<Result> {
    suspend operator fun invoke(params: Any): Flow<Result>
}
