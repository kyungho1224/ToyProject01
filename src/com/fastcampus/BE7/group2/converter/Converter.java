package com.fastcampus.BE7.group2.converter;

import com.fastcampus.BE7.group2.model.ItineraryDto;
import com.fastcampus.BE7.group2.model.ItineraryEntity;
import com.fastcampus.BE7.group2.model.TravelDto;
import com.fastcampus.BE7.group2.model.TravelEntity;
import com.fastcampus.BE7.group2.utils.Utils;

import java.util.List;

/**
 * Created by KimKyungHo on 2023-12-22(022)
 */
public class Converter {

    public TravelDto travelEntityToDto(TravelEntity entity) {
        return new TravelDto(
                entity.getTripName(),
                Utils.localDateTimeToString(entity.getStartDate(), false),
                Utils.localDateTimeToString(entity.getEndDate(), false),
                List.of());
    }

    public ItineraryDto itineraryEntityToDto(ItineraryEntity entity) {
        return new ItineraryDto(
                entity.getDeparturePlace(),
                entity.getDestination(),
                Utils.localDateTimeToString(entity.getDepartureTime(), true),
                Utils.localDateTimeToString(entity.getArrivalTime(), true),
                Utils.localDateTimeToString(entity.getCheckIn(), true),
                Utils.localDateTimeToString(entity.getCheckOut(), true)
        );
    }

}
