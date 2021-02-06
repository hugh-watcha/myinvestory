package com.jaewoo.myinvestory.shared.model.db

import android.content.Context
import com.jaewoo.myinvestory.db.InvestmentDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

/**
 * created by hugh on 2/6/21
 */
actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(InvestmentDatabase.Schema, context, "test.db")
    }
}