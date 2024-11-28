package smartphone.infrastructure.adapter.rest.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import smartphone.domain.entity.Smartphone;
import smartphone.infrastructure.adapter.rest.controller.model.SimilarSmartphone;

@Mapper
public interface SimilarSmartphoneMapper {
    SimilarSmartphoneMapper INSTANCE = Mappers.getMapper(SimilarSmartphoneMapper.class);

    SimilarSmartphone fromDomain(Smartphone smartphone);
}
