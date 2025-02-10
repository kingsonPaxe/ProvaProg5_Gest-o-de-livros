package com.example.gesto_livro.consumindoAPI

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface WebService {
    @GET("livros/")
    suspend fun getLivros(): Response<LivrosResponse>

    @POST("livros/create")
    suspend fun addLivros(
        @Body Dados: Livros,
    ): Response<LivrosResponse>

    @PUT("livros/atualizar/{livro_id}")
    suspend fun updateLivros(
        @Path("id") id_livros: String,
        @Body Dados: Livros,
    ): Response<LivrosResponse>

    @DELETE("/livros/apagar/{livro_id}")
    suspend fun deleteLivros(
        @Path("id") id_livros: String,
    ): Response<LivrosResponse>
}