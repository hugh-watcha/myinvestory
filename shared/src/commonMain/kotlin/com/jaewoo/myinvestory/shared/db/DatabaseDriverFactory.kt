package com.jaewoo.myinvestory.shared.db

import com.squareup.sqldelight.db.SqlDriver

/**
 * created by hugh on 2/6/21
 */
expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}