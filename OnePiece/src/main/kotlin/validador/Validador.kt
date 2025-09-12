package org.example.validador

import com.github.michaelbull.result.Result


interface Validador<T,E> {
    fun validate(t:T): Result<T, E >
}