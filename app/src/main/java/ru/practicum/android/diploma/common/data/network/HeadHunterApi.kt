package ru.practicum.android.diploma.common.data.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap
import ru.practicum.android.diploma.common.data.dto.AreasDto
import ru.practicum.android.diploma.common.data.dto.IndustriesDto
import ru.practicum.android.diploma.common.data.dto.VacancyItemDto
import ru.practicum.android.diploma.common.data.network.response.SearchResponse

interface HeadHunterApi {

    @GET("vacancies")
    suspend fun getVacancies(
        @QueryMap params: Map<String, @JvmSuppressWildcards Any?>
    ): SearchResponse

    @GET("vacancies/{vacancy_id}")
    suspend fun getVacancy(
        @Path("vacancy_id") vacancyId: Int
    ): VacancyItemDto

    @GET("areas")
    suspend fun getCountries(): List<AreasDto>

    @GET("areas/{area_id}")
    suspend fun getAreaById(
        @Path("area_id") areaId: Int
    ): AreasDto

    @GET("industries")
    suspend fun getIndustries(): List<IndustriesDto>

}
