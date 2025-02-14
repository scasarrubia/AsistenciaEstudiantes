package com.example.asistenciaestudiante.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StudentDao {
    @Query("SELECT * FROM students WHERE groupId = :groupId")
    suspend fun getStudentsByGroup(groupId: String): List<StudentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudents(students: List<StudentEntity>)

    @Query("DELETE FROM students WHERE groupId = :groupId")
    suspend fun deleteStudentsByGroup(groupId: String)
}
