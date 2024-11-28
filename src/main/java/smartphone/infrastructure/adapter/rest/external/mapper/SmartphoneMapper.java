package smartphone.infrastructure.adapter.rest.external.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import smartphone.domain.entity.Smartphone;
import smartphone.infrastructure.adapter.rest.external.model.SmartphoneModel;

@Mapper
public interface SmartphoneMapper {
    SmartphoneMapper INSTANCE = Mappers.getMapper(SmartphoneMapper.class);

    Smartphone toDomain(SmartphoneModel source);
}
