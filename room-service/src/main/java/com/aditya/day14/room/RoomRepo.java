package com.aditya.day14.room; import org.springframework.data.jpa.repository.JpaRepository; import java.util.UUID; public interface RoomRepo extends JpaRepository<Room,UUID>{}
