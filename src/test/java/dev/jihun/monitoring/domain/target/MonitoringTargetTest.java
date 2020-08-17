package dev.jihun.monitoring.domain.target;


import dev.jihun.monitoring.dto.target.MonitoringTargetDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


@ExtendWith(SpringExtension.class)
@DataJpaTest
class MonitoringTargetTest {

    @Autowired
    MonitoringTargetRepository monitoringTargetRepository;

    @Test
    public void 모니터링_대상_저장_테스트() {

        MonitoringTarget monitoringTarget = MonitoringTarget.builder()
                                                        .domain("http://www.yangsan.go.kr")
                                                        .name("양산시청")
                                                        .build();

        monitoringTargetRepository.save(monitoringTarget);

        List<MonitoringTarget> monitoringTargets = monitoringTargetRepository.findAll();

        ModelMapper modelMapper = new ModelMapper();
        MonitoringTargetDTO result = modelMapper.map(monitoringTargets.get(0),MonitoringTargetDTO.class);

        assertThat(result.getDomain(),equalTo("http://www.yangsan.go.kr"));
        assertThat(result.getName(),equalTo("양산시청"));
        assertThat(result.getCreatedDate(),is(notNullValue()));
    }
}