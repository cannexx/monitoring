package dev.jihun.monitoring.domain.target;

import dev.jihun.monitoring.domain.common.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MonitoringTarget extends BaseTimeEntity {

    @Id
    private String domain;

    private String name;

    @Builder
    public MonitoringTarget(String domain,
                            String name) {
        this.domain=domain;
        this.name=name;
    }
}
