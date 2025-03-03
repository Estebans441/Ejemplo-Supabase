package com.example.ejemplosupabase.services

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

/**
 * Singleton object to manage Supabase instance.
 */
object SupabaseService {
    private const val SUPABASE_URL = "..."
    private const val SUPABASE_KEY = "..."

    /**
     * Lazily initialized Supabase client.
     */
    val client: SupabaseClient by lazy {
        try {
            createSupabaseClient(
                supabaseUrl = SUPABASE_URL,
                supabaseKey = SUPABASE_KEY
            ) {
                install(Postgrest)
            }
        } catch (e: Exception) {
            throw RuntimeException("Failed to initialize Supabase client", e)
        }
    }
}

