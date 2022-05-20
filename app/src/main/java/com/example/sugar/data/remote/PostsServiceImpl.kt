package com.example.sugar.data.remote

import com.example.sugar.data.remote.dto.PostRequest
import com.example.sugar.data.remote.dto.PostResponse
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlin.Exception

class PostsServiceImpl(
    private val client : HttpClient
    ) : PostsService{

    override suspend fun getPosts(): List<PostResponse> {
        return try{
            client.get { url(HttpRoutes.POSTS) }
        } catch (e : RedirectResponseException){
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e : ClientRequestException){
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e : ServerResponseException){
            println("Error: ${e.response.status.description}")
            emptyList()
        }
        catch (e : Exception){
            println("Error: ${e.message}")
            emptyList()
        } 
    }

    override suspend fun createPost(postRequest: PostRequest): PostResponse? {
        return try{
            client.post<PostResponse> {
                url(HttpRoutes.POSTS)
                contentType(ContentType.Application.Json)
                body = postRequest
            }
        } catch (e : RedirectResponseException){
            println("Error: ${e.response.status.description}")
            null
        } catch (e : ClientRequestException){
            println("Error: ${e.response.status.description}")
            null
        } catch (e : ServerResponseException){
            println("Error: ${e.response.status.description}")
            null
        }
        catch (e : Exception){
            println("Error: ${e.message}")
            null
        }
    }
}