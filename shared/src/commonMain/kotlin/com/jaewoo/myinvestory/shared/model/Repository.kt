package com.jaewoo.myinvestory.shared.model

import com.jaewoo.myinvestory.shared.model.db.Database
import com.jaewoo.myinvestory.shared.model.db.DatabaseDriverFactory
import comjaewoomyinvestorydb.*

/**
 * created by hugh on 2/6/21
 */
class Repository(private val dbDriverFactory: DatabaseDriverFactory) {
    private val database = Database(dbDriverFactory)

    fun getAllItems(): List<InvestmentItem> {
        return database.getAllItems()
    }

    fun insertItem(name: String, marketId: Long, standardCurrencyId: Long) {
        database.insertItem(name, marketId, standardCurrencyId)
    }

    fun getItem(id: Long): InvestmentItem? {
        return database.getItem(id)
    }

    fun getRecords(limit: Long, offset: Long): List<InvestmentRecord> {
        return database.getRecords(limit, offset)
    }

    fun insertRecord(
        actionId: Long,
        marketId: Long,
        itemId: Long,
        date: String,
        quantity: String,
        unitPrice: String,
        currencyId: Long,
        currencyExchangeRate: String,
        commissionRate: String
    ) {
        database.insertRecord(
            actionId,
            marketId,
            itemId,
            date,
            quantity,
            unitPrice,
            currencyId,
            currencyExchangeRate,
            commissionRate
        )
    }

    fun getCurrency(currencyId: Long): Currency {
        return database.getCurrency(currencyId)
    }

    fun insertCurrency(code: String) {
        database.insertCurrency(code)
    }

    fun getMarket(marketId: Long): Market {
        return database.getMarket(marketId)
    }

    fun insertMarket(code: String) {
        database.insertMarket(code)
    }

    fun getAction(actionId: Long): Action {
        return database.getAction(actionId)
    }

    fun insertAction(code: String) {
        database.insertAction(code)
    }
}