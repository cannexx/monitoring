package dev.jihun.monitoring.dto.target;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Getter
@Setter
public class MonitoringTargetDTO {

    @Pattern(regexp = "\"^(https?):\\\\/\\\\/([^:\\\\/\\\\s]+)(:([^\\\\/]*))?((\\\\/[^\\\\s/\\\\/]+)*)?\\\\/?([^#\\\\s\\\\?]*)(\\\\?([^#\\\\s]*))?(#(\\\\w*))?$\"", message = "domain은 http://www.naver.com과 같은 형식으로 입력해주셔야 합니다.")
    private String domain;

    @Length(min = 1, max = 85, message = "별칭은 최소 1글자 최대 85글자 입니다.")
    private String name;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;
}
