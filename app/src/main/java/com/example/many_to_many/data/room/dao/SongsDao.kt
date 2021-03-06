package com.example.many_to_many.data.room.dao

import androidx.room.*
import com.example.many_to_many.data.room.entities.*
import kotlinx.coroutines.flow.Flow

@Dao
interface SongsDao {
    @Transaction
    @Query("SELECT * FROM Playlist")
    fun getPlaylistsWithSongs(): Flow<List<PlaylistWithSongs>>

    @Transaction
    @Query("SELECT * FROM Song")
    fun getSongsWithPlaylists(): Flow<List<SongWithPlaylists>>

    @Transaction
    @Query("SELECT * FROM Song")
    fun getAllSongs(): Flow<List<Song>>

    @Transaction
    @Query("SELECT * FROM Playlist")
    fun getAllPlaylists(): Flow<List<Playlist>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSong(song: Song)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlaylist(playlist: Playlist)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(playlistSongCrossRef: PlaylistSongCrossRef)

    @Query("DELETE FROM song")
    fun deleteAllSongs()

    @Query("DELETE FROM playlist")
    fun deleteAllPlaylist()


}