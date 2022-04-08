package io.summer.popin.domain.place.dao;


import io.summer.popin.domain.hosting.dto.ReservationCountResponseDTO;
import io.summer.popin.domain.place.dto.PlaceDetailResponseDTO;
import io.summer.popin.domain.place.dto.PlaceKindDTO;
import io.summer.popin.domain.place.vo.PlaceVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface PlaceMapper {

    ReservationCountResponseDTO getCountByNo(long memberNo);

    PlaceDetailResponseDTO findOneByNo(long placeNo);

    ArrayList<PlaceKindDTO> findKindMap();

    int insertOne(PlaceVO placeVO);
}
