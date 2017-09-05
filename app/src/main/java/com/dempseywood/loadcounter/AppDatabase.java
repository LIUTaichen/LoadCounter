package com.dempseywood.loadcounter;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.dempseywood.loadcounter.dao.EquipmentStatusDao;
import com.dempseywood.loadcounter.entity.EquipmentStatus;

/**
 * Created by musing on 05/09/2017.
 */


    @Database(entities = {EquipmentStatus.class}, version = 1)
    public abstract class AppDatabase extends RoomDatabase {
        public abstract EquipmentStatusDao equipmentStatusDao();
    }

