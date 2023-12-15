package com.example.RomansLodge.convertor;

import com.example.RomansLodge.repository.RoomRepository;
import com.example.RomansLodge.entity.RoomEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RoomServiceImpl implements RoomService{
    private RoomRepository roomRepository;

    @Autowired
    public  RoomServiceImpl(RoomRepository roomRepository){
        this.roomRepository=roomRepository;
    }


    @Override
    public RoomEntity findById(long theId) {

    Optional<RoomEntity> result = roomRepository.findById(theId);

    RoomEntity theRoom = null;

    if (result.isPresent()) {
        theRoom = result.get();
    }
    else {

        return null;
    }

    return theRoom;

    }

    @Override
    public List<RoomEntity> findAll() {
        return (List<RoomEntity>)roomRepository.findAll();
    }


}
