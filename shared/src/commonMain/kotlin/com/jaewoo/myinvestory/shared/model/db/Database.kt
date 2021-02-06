package com.jaewoo.myinvestory.shared.model.db

import com.jaewoo.myinvestory.db.InvestmentDatabase
import comjaewoomyinvestorydb.*

/**
 * created by hugh on 2/6/21
 */
internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = InvestmentDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.investmentDatabaseQueries

    internal fun getAllItems(): List<InvestmentItem> {
        return dbQuery.getAllItems().executeAsList()
    }

    internal fun insertItem(name: String, marketId: Long, standardCurrencyId: Long) {
        dbQuery.transaction {
            dbQuery.insertItem(name, marketId, standardCurrencyId)
        }
    }

    internal fun getItem(id: Long): InvestmentItem? {
        return dbQuery.getItem(id).executeAsOneOrNull()
    }

    internal fun getRecords(limit: Long, offset: Long): List<InvestmentRecord> {
        return dbQuery.getRecords(limit, offset).executeAsList()
    }

    internal fun insertRecord(
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
        dbQuery.transaction {
            dbQuery.insertRecord(
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
    }

    internal fun getCurrency(currencyId: Long): Currency {
        return dbQuery.getCurrency(currencyId).executeAsOne()
    }

    internal fun insertCurrency(code: String) {
        dbQuery.transaction {
            dbQuery.insertCurrency(code)
        }
    }

    internal fun getMarket(marketId: Long): Market {
        return dbQuery.getMarket(marketId).executeAsOne()
    }

    internal fun insertMarket(code: String) {
        dbQuery.transaction {
            dbQuery.insertMarket(code)
        }
    }

    internal fun getAction(actionId: Long): Action {
        return dbQuery.getAction(actionId).executeAsOne()
    }

    internal fun insertAction(code: String) {
        dbQuery.transaction {
            dbQuery.insertAction(code)
        }
    }
}