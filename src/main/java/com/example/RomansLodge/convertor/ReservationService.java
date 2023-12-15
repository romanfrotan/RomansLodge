package com.example.RomansLodge.convertor;

import com.example.RomansLodge.entity.ReservationEntity;

import java.util.List;



public interface ReservationService {
    public ReservationEntity findLast();
    public List<ReservationEntity> findAll();
}
