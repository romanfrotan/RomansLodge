package com.example.RomansLodge.convertor;

import com.example.RomansLodge.entity.RoomEntity;

import java.util.List;


public interface RoomService {

    public RoomEntity findById(long theId);
    public List<RoomEntity> findAll();

}
