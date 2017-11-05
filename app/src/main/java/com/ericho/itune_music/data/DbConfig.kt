package com.ericho.itune_music.data

import org.xutils.DbManager

/**
 * Created by steve_000 on 5/11/2017.
 * for project iTunemusic
 * package name com.ericho.itune_music.data
 */
object DbConfig {
    val daoConfig: DbManager.DaoConfig = DbManager.DaoConfig()
            .setDbName("xUtil3.db")
            // 不设置dbDir时, 默认存储在app的私有目录.
            .setDbVersion(2)
            .setDbOpenListener(object : DbManager.DbOpenListener {
                override fun onDbOpened(db: DbManager) {
                    // 开启WAL, 对写入加速提升巨大
                    db.getDatabase().enableWriteAheadLogging();
                }
            })
}