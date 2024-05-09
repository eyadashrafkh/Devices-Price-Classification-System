package com.devicepricesystem.devicepricesystem.device;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long>{

    @Query("SELECT d FROM Device d WHERE d.id = ?1")
    Optional<Device> findDeviceById(Long id);

}
